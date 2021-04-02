package io.github.revelationgame.realtime.sse;

import io.github.revelationgame.realtime.sse.model.Message;
import io.github.revelationgame.realtime.sse.model.MultiCast;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
@Slf4j
public class PushService {

    private final Sinks.Many<Message> sink = Sinks.many().multicast().directBestEffort();

    public void sendMultiCast(MultiCast multiCast) {
        Sinks.EmitResult result = sink.tryEmitNext(multiCast);

        if (result.isSuccess()) {
            log.debug("EmitMessage with MultiCastMsg successful: {}", multiCast);
        } else {
            log.warn("EmitMessage with MultiCastMsg failed: {}", multiCast);
        }
    }

    public Flux<ServerSentEvent<Object>> getUserSpecificMessage(String secretUID) {
        return sink.asFlux()
                .filter(message -> message.isReceiver(secretUID))
                .map(message -> ServerSentEvent.builder().event(message.getEventType()).data(message.getMessage()).build());
    }
}
