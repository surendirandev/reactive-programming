package com.surendirans.reactive.programming.mono;

import com.surendirans.reactive.programming.basic.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

public class MonoJust {


    private static final Logger logger = LoggerFactory.getLogger(MonoJust.class);

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("mono");
        SubscriberImpl subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
    }
}
