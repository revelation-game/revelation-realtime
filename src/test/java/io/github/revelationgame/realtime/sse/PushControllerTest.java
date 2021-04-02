package io.github.revelationgame.realtime.sse;

import io.github.revelationgame.realtime.sse.dto.MultiCastDto;
import io.github.revelationgame.realtime.sse.mapper.MultiCastDtoMapper;
import io.github.revelationgame.realtime.sse.model.MultiCast;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PushControllerTest {

    @InjectMocks
    private PushController pushController;

    @Mock
    private PushService pushService;

    @Mock
    private MultiCastDtoMapper multiCastDtoMapper;

    @Test
    void sendMultiCast(@Mock MultiCastDto multiCastDto, @Mock MultiCast multiCast) {
        when(multiCastDtoMapper.fromDto(multiCastDto)).thenReturn(multiCast);

        pushController.sendMultiCast(multiCastDto);

        verify(pushService).sendMultiCast(multiCast);
    }

    @Test
    void getSseUpdates(@Mock Flux<ServerSentEvent<Object>> response) {
        when(pushService.getUserSpecificMessage("someID")).thenReturn(response);

        Flux<ServerSentEvent<Object>> actual = pushController.getSseUpdates("someID");

        assertThat(actual).isSameAs(response);
    }
}