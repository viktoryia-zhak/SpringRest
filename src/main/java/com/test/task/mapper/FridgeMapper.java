package com.test.task.mapper;

import com.test.task.dto.response.FridgeResponse;
import com.test.task.model.Fridge;
import org.mapstruct.Mapper;

/**
 * FridgeMapper.
 *
 * @author Viktoryia Zhak
 */
@Mapper(componentModel = "spring")
public interface FridgeMapper extends BaseMapper<Fridge, FridgeResponse> {
    FridgeResponse entityToDto(Fridge entity);
}
