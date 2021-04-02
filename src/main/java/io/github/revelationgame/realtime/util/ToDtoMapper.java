package io.github.revelationgame.realtime.util;

import java.util.List;
import java.util.stream.Collectors;

public interface ToDtoMapper<E, T> {

    T fromEntity(E entity);

    default List<T> fromEntityList(List<E> entityList) {
        return entityList.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }
}