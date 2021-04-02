package io.github.revelationgame.realtime.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FromDtoMapperTest {

    @Test
    void fromDtoList() {
        ExampleMapper exampleMapper = new ExampleMapper();

        List<String> actual = exampleMapper.fromDtoList(List.of(1, 2, 3));

        Assertions.assertThat(actual).containsExactly("1", "2", "3");
    }

    private static class ExampleMapper implements FromDtoMapper<String, Integer> {

        @Override
        public String fromDto(Integer dto) {
            return dto.toString();
        }
    }


}