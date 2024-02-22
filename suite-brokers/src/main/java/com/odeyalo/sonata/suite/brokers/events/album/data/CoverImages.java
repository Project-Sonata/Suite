package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoverImages implements Iterable<CoverImage> {
    List<CoverImage> items;

    public int size() {
        return getItems().size();
    }

    public boolean isEmpty() {
        return getItems().isEmpty();
    }

    public boolean contains(Object o) {
        return getItems().contains(o);
    }

    public CoverImage get(int index) {
        return getItems().get(index);
    }

    public Stream<CoverImage> stream() {
        return getItems().stream();
    }

    @NotNull
    @Override
    public Iterator<CoverImage> iterator() {
        return getItems().iterator();
    }
}
