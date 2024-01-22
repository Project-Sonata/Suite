package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Value
@AllArgsConstructor(staticName = "of")
@Builder
public class UploadedTrackSimplifiedInfoContainerDto implements Iterable<UploadedTrackSimplifiedInfoDto> {
    @Getter(value = AccessLevel.PRIVATE)
    List<UploadedTrackSimplifiedInfoDto> items;

    public static UploadedTrackSimplifiedInfoContainerDto fromCollection(Collection<UploadedTrackSimplifiedInfoDto> items) {
        return builder().items(new ArrayList<>(items)).build();
    }

    public static UploadedTrackSimplifiedInfoContainerDto fromArray(UploadedTrackSimplifiedInfoDto... items) {
        List<UploadedTrackSimplifiedInfoDto> list = List.of(items);

        return builder().items(list).build();
    }

    public int size() {
        return getItems().size();
    }

    public boolean isEmpty() {
        return getItems().isEmpty();
    }

    @Nullable
    public UploadedTrackSimplifiedInfoDto get(int index) {
        return getItems().get(index);
    }

    public boolean contains(Object o) {
        return getItems().contains(o);
    }

    @NotNull
    public Stream<UploadedTrackSimplifiedInfoDto> stream() {
        return getItems().stream();
    }

    @NotNull
    @Override
    public Iterator<UploadedTrackSimplifiedInfoDto> iterator() {
        return items.iterator();
    }
}
