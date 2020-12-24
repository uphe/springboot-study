package com.hzy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
@RestController
public class MyController {

    /**
     * 传统的 spring mvc 开发方式
     */
    @GetMapping("/mvc")
    public String mvc() {
        long timeMillis = System.currentTimeMillis();
        log.info("mvc() start");
        String result = createStr();
        log.info("mvc() end use time {}/ms", System.currentTimeMillis() - timeMillis);

        return result;
    }

    /**
     * spring webflux 的开发方式
     */
    @GetMapping("/mono")
    public Mono<String> mono() {
        Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

        long timeMillis = System.currentTimeMillis();
        log.info("webflux() start");
        Mono<String> result = Mono.fromSupplier(this::createStr);
        log.info("webflux() end use time {}/ms", System.currentTimeMillis() - timeMillis);

        return result;
    }

    /**
     * 使用flux，像流一样返回0-N个元素
     */
    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flux() {

        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 10).subscribe(System.out::println);
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);

        long timeMillis = System.currentTimeMillis();
        log.info("webflux() start");
        Flux<String> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "flux data--" + i;
        }));
        log.info("webflux() end use time {}/ms", System.currentTimeMillis() - timeMillis);

        return result;
    }

    private String createStr() {
        // 模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "some string";
    }
}
