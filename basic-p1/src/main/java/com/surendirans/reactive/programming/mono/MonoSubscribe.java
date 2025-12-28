package com.surendirans.reactive.programming.mono;

import com.surendirans.reactive.programming.basic.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoSubscribe {


    private static final Logger log = LoggerFactory.getLogger(MonoSubscribe.class);

    public  static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1)
                .map(i -> i / 0);
        mono.subscribe(
                i -> log.info("Received: {}", i),
                err -> log.error("Error Info: ", err),
                () -> log.info("completed"),
                subscription -> subscription.request(10) // If this line give, the subscription will happen only based on this line. Otherwise default calling of subscription
        );
    }
}
