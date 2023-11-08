package com.odeyalo.sonata.suite.brokers.events.album.data;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimplifiedTrackDtoContainer implements Iterable<SimplifiedTrackDto> {
    List<SimplifiedTrackDto> items;

    public static SimplifiedTrackDtoContainer multiple(List<SimplifiedTrackDto> tracks) {
        return of(tracks);
    }

    public int size() {
        return items.size();
    }

    public boolean contains(SimplifiedTrackDto o) {
        return items.contains(o);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public SimplifiedTrackDto get(int index) {
        return items.get(index);
    }

    @Override
    public Iterator<SimplifiedTrackDto> iterator() {
        return items.iterator();
    }
}
