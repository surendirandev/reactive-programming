package com.surendirans.reactive.programming.basic;

import com.surendirans.reactive.programming.basic.publisher.PublisherImpl;
import com.surendirans.reactive.programming.basic.subscriber.SubscriberImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        error();
    }

    // No output is required
    private static void simple() {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    // Multiple requests with series of delay
    private static void noError() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }

    // Cancelling the request middle of requests
    private static void cancel() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }

    // Erroring out the Subscriber
    private static void error() throws InterruptedException {
        PublisherImpl publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(15);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
    }
}