package io.github.revelationgame.realtime.sse;

import io.github.revelationgame.realtime.sse.dto.MultiCastDto;
import io.github.revelationgame.realtime.sse.mapper.MultiCastDtoMapper;
import io.github.revelationgame.realtime.sse.model.MultiCast;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@RestController
@RequestMapping("/push/v1")
@AllArgsConstructor
@Slf4j
public class PushController {

    private final MultiCastDtoMapper multiCastDtoMapper;
    private final PushService pushService;

    @SecurityRequirement(name = "basicAuth")
    @PostMapping(value = "/sec/multicast", name = "Send a multicast to subscribed users")
    public void sendMultiCast(@Valid @RequestBody MultiCastDto multiCastDto) {
        MultiCast multiCast = multiCastDtoMapper.fromDto(multiCastDto);

        pushService.sendMultiCast(multiCast);
    }

    @GetMapping(path = "/sse/{secretUID}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Object>> getSseUpdates(@PathVariable String secretUID) {
        return pushService.getUserSpecificMessage(secretUID);
    }
}
