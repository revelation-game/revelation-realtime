package io.github.revelationgame.realtime.util;

import java.util.List;
import java.util.stream.Collectors;

public interface FromDtoMapper<E, T> {

    E fromDto(T dto);

    default List<E> fromDtoList(List<T> dtoList) {
        return dtoList.stream()
                .map(this::fromDto)
                .collect(Collectors.toList());
    }

}
