package io.github.revelationgame.realtime.sse.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MultiCastTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "someOtherId"})
    void isReceiver(String receiver) {
        MultiCast multiCast = new MultiCast(List.of("1", "2", "3", "someOtherId"), "", "");

        assertThat(multiCast.isReceiver(receiver)).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"otherUser", "alsoOtherUser"})
    void isReceiver_shouldNotReceive(String receiver) {
        MultiCast multiCast = new MultiCast(List.of("1", "2", "3", "someOtherId"), "", "");

        assertThat(multiCast.isReceiver(receiver)).isFalse();
    }
}