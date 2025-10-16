package com.odeyalo.sonata.suite.brokers.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
public abstract class AbstractEvent<T> implements SonataEvent, EventTypeProvider {
    protected String id;
    protected long creationTime;
    protected T body;

    public AbstractEvent(T body) {
        this.id = UUID.randomUUID().toString();
        this.creationTime = System.currentTimeMillis();
        this.body = body;
    }

    @JsonCreator
    public AbstractEvent(String id, long creationTime, T body) {
        this.id = id;
        this.creationTime = creationTime;
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
}
