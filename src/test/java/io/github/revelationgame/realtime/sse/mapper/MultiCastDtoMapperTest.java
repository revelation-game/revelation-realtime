package io.github.revelationgame.realtime.sse.mapper;

import io.github.revelationgame.realtime.sse.dto.MultiCastDto;
import io.github.revelationgame.realtime.sse.model.MultiCast;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MultiCastDtoMapperTest {

    @InjectMocks
    private MultiCastDtoMapper multiCastDtoMapper;

    @Test
    void fromDto() {
        MultiCastDto dto = new MultiCastDto(List.of("1", "2"), "eventType", "SomeMessage");

        MultiCast actual = multiCastDtoMapper.fromDto(dto);

        MultiCast expected = new MultiCast(List.of("1", "2"), "eventType", "SomeMessage");
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}