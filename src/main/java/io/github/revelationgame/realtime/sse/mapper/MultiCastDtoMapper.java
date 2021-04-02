package io.github.revelationgame.realtime.sse.mapper;

import io.github.revelationgame.realtime.sse.dto.MultiCastDto;
import io.github.revelationgame.realtime.sse.model.MultiCast;
import io.github.revelationgame.realtime.util.FromDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class MultiCastDtoMapper implements FromDtoMapper<MultiCast, MultiCastDto> {

    @Override
    public MultiCast fromDto(MultiCastDto dto) {
        return new MultiCast(
                dto.getReceiverSecretUIDs(),
                dto.getEventType(),
                dto.getMessage()
        );
    }
}
