package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Value
@Builder
public class TrackDurationContainer implements Iterable<TrackDuration> {
    @JsonIgnore
    List<TrackDuration> items;

    @JsonCreator
    public TrackDurationContainer(Collection<TrackDuration> items) {
        this.items = new ArrayList<>(items);
    }

    public static TrackDurationContainer fromCollection(Collection<TrackDuration> items) {
        return new TrackDurationContainer(items);
    }


    @NotNull
    @Override
    public Iterator<TrackDuration> iterator() {
        return items.iterator();
    }

    public Stream<TrackDuration> stream() {
        return getItems().stream();
    }
}
