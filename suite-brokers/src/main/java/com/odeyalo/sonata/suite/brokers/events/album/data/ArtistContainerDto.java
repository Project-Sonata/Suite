package com.odeyalo.sonata.suite.brokers.events.album.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistContainerDto implements Iterable<ArtistDto> {
    List<ArtistDto> artists;

    public static ArtistContainerDto empty() {
        return new ArtistContainerDto(Collections.emptyList());
    }

    public static ArtistContainerDto single(ArtistDto artistDto) {
        return new ArtistContainerDto(List.of(artistDto));
    }

    public int size() {
        return artists.size();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return artists.isEmpty();
    }

    public ArtistDto get(int index) {
        return artists.get(index);
    }

    @Override
    public Iterator<ArtistDto> iterator() {
        return artists.iterator();
    }
}
