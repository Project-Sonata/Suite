package com.odeyalo.sonata.suite.brokers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.GeneratedPlaylistType;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.PlaylistMetaGeneratedEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.PlaylistTracksGeneratedEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.GeneratedTrack;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.GenerativePlaylistEvent;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.PlaylistMetaGeneratedPayload;
import com.odeyalo.sonata.suite.brokers.events.playlist.gen.payload.PlaylistTracksGeneratedPayload;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerativePlaylistEventTest {
    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new ParameterNamesModule());

    @Test
    void shouldProperlySerializeDeserializeEvent() throws JsonProcessingException {
        final PlaylistTracksGeneratedEvent event = new PlaylistTracksGeneratedEvent(
                new PlaylistTracksGeneratedPayload("123", List.of(
                        new GeneratedTrack("1", 0),
                        new GeneratedTrack("2", 1),
                        new GeneratedTrack("3", 2)
                )), GeneratedPlaylistType.ON_REPEAT
        );

        final String json = mapper.writeValueAsString(event);

        final GenerativePlaylistEvent<?> actual = mapper.readValue(json, GenerativePlaylistEvent.class);

        assertEquals(event, actual);
    }

    @Test
    void shouldProperlySerializeDeserializeEvent0() throws JsonProcessingException {
        final PlaylistMetaGeneratedEvent event = new PlaylistMetaGeneratedEvent(
                new PlaylistMetaGeneratedPayload(
                        new PlaylistTracksGeneratedPayload("123", List.of(
                                new GeneratedTrack("1", 0),
                                new GeneratedTrack("2", 1),
                                new GeneratedTrack("3", 2)
                        )),
                        new PlaylistMetaGeneratedPayload.Meta("On Repeat", "Songs you love the most")
                ), GeneratedPlaylistType.ON_REPEAT);

        final String json = mapper.writeValueAsString(event);

        final GenerativePlaylistEvent<?> actual = mapper.readValue(json, GenerativePlaylistEvent.class);

        assertEquals(event, actual);
    }
}
