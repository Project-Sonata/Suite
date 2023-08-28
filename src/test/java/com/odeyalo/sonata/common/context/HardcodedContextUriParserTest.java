package com.odeyalo.sonata.common.context;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardcodedContextUriParserTest {
    HardcodedContextUriParser contextUriParser = new HardcodedContextUriParser();

    @Test
    void parse() throws MalformedContextUriException {
        ContextUri expected = ContextUri.of(ContextEntityType.TRACK, "mikunakano");

        ContextUri actual = contextUriParser.parse("sonata:track:mikunakano");

        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionIfLessThan3Elements() {
        String uriString = "sonata:mikunakano";
        MalformedContextUriException thrownException = assertThrows(MalformedContextUriException.class, () -> contextUriParser.parse(uriString));

        assertEquals(uriString, thrownException.getUriString());
        assertEquals("The URI does not pass the REGEX!\n More or less than 3 parts was received", thrownException.getMessage());
    }

    @Test
    void shouldThrowExceptionIfPrefixIsWrong() {
        String uriString = "soundcloud:track:mikunakano";
        MalformedContextUriException thrownException = assertThrows(MalformedContextUriException.class, () -> contextUriParser.parse(uriString));

        assertEquals(uriString, thrownException.getUriString());
        assertEquals("URI must start with 'sonata'", thrownException.getMessage());
    }

    @Test
    void shouldThrowExceptionIfNoLowerCaseUsedForEntity() {
        String uriString = "sonata:TrAck:mikunakano";
        MalformedContextUriException thrownException = assertThrows(MalformedContextUriException.class, () -> contextUriParser.parse(uriString));

        assertEquals(uriString, thrownException.getUriString());
        assertEquals("URI must contain entity type in lower case!", thrownException.getMessage());
    }
}