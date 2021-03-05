package com.test.task.mapper;

/**
 * BaseMapper.
 *
 * @author Viktoryia Zhak
 */
public interface BaseMapper<E, D> {
    D entityToDto(E entity);
}

