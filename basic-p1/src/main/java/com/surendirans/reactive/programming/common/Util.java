package com.surendirans.reactive.programming.common;

import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Util {

    public static <T> Subscriber<T> subscriber(String name) {
        return new DefaultSubscriber<>(name);
    }

    public static <T> Subscriber<T> subscriber() {
        return subscriber("<No Name>");
    }

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(subscriber());
    }
}
