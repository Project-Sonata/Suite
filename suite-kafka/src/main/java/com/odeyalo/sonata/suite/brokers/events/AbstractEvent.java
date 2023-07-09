package com.odeyalo.sonata.suite.brokers.events;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public abstract class AbstractEvent<T> implements SonataEvent {
    protected String id;
    protected long creationTime;
    protected T body;

    public AbstractEvent(T body) {
        this.id = UUID.randomUUID().toString();
        this.creationTime = System.currentTimeMillis();
        this.body = body;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public long creationTime() {
        return creationTime;
    }

    public T getBody() {
        return body;
    }
}
