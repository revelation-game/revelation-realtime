package io.github.revelationgame.realtime.sse;

import io.github.revelationgame.realtime.IntegrationTest;
import io.github.revelationgame.realtime.sse.dto.MultiCastDto;
import io.github.revelationgame.realtime.sse.global.GlobalMessages;
import io.github.revelationgame.realtime.sse.i18n.I18nErrorMessageDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PushControllerIT extends IntegrationTest {

    @Test
    public void sendMultiCast() {
        String actualMessage = readAndNormalize("sseMessage.json");
        MultiCastDto dto = new MultiCastDto(List.of("1", "2"), "someEvent", actualMessage);

        ResponseEntity<Void> actual = restService.post("/push/v1/sec/multicast", dto, Void.class);

        assertThat(actual.getStatusCode().is2xxSuccessful()).isTrue();
    }

    @Test
    public void sendMultiCast_EmptyListException() {
        MultiCastDto dto = new MultiCastDto(Collections.emptyList(), "someEvent", "SomeMessage");

        ResponseEntity<I18nErrorMessageDto> actual = restService.post("/push/v1/sec/multicast", dto, I18nErrorMessageDto.class);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(actual.getBody().getTranslationKey()).isEqualTo(GlobalMessages.REALTIME_PARAMETER_BODY_FAILED.getKey());
    }

    @Test
    public void sendMultiCast_LongEventName() {
        MultiCastDto dto = new MultiCastDto(List.of("1"), "a".repeat(51), "SomeMessage");

        ResponseEntity<I18nErrorMessageDto> actual = restService.post("/push/v1/sec/multicast", dto, I18nErrorMessageDto.class);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(actual.getBody().getTranslationKey()).isEqualTo(GlobalMessages.REALTIME_PARAMETER_BODY_FAILED.getKey());
    }

    @Test
    public void sendMultiCast_NullMessage() {
        MultiCastDto dto = new MultiCastDto(List.of("1"), "a".repeat(51), null);

        ResponseEntity<I18nErrorMessageDto> actual = restService.post("/push/v1/sec/multicast", dto, I18nErrorMessageDto.class);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(actual.getBody().getTranslationKey()).isEqualTo(GlobalMessages.REALTIME_PARAMETER_BODY_FAILED.getKey());
    }

}
