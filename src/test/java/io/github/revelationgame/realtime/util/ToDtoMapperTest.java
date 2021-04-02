package io.github.revelationgame.realtime.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ToDtoMapperTest {

    @Test
    void fromEntityList() {
        ExampleMapper exampleMapper = new ExampleMapper();

        List<String> actual = exampleMapper.fromEntityList(List.of(1, 2, 3));

        Assertions.assertThat(actual).containsExactly("1", "2", "3");
    }

    private static class ExampleMapper implements ToDtoMapper<Integer, String> {

        @Override
        public String fromEntity(Integer entity) {
            return entity.toString();
        }
    }
}