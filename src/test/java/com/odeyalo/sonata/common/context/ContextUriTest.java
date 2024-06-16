package com.odeyalo.sonata.common.context;

import org.junit.jupiter.api.Test;

import static com.odeyalo.sonata.common.context.ContextEntityType.TRACK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ContextUriTest {

    @Test
    void shouldReturnTrueIfContextUriStringIsValid() {
        assertThat(ContextUri.isValid("sonata:track:miku")).isTrue();
    }

    @Test
    void shouldReturnFalseIfContextUriStringIsLessThan3Elements() {
        assertThat(ContextUri.isValid("sonata:invalid")).isFalse();
    }

    @Test
    void shouldReturnFalseIfContextUriStringStartsWithWrongPrefix() {
        assertThat(ContextUri.isValid("soundcloud:track:123")).isFalse();
    }

    @Test
    void shouldReturnFalseIfContextUriHasNoLowerCaseForEntityType() {
        assertThat(ContextUri.isValid("sonata:TrAck:mikunakano")).isFalse();
    }

    @Test
    void shouldParseContextUriStringToValidContextUriObject() {
        final var contextUri = ContextUri.fromString("sonata:track:123");

        assertThat(contextUri.getType()).isEqualTo(TRACK);
        assertThat(contextUri.getEntityId()).isEqualTo("123");
    }

    @Test
    void shouldThrowExceptionIfContextUriIsNotValid() {
        assertThatThrownBy(() -> ContextUri.fromString("sonata:123"))
                .isInstanceOf(InvalidContextUriLengthException.class);
    }
}