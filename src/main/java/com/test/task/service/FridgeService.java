package com.test.task.service;

import com.test.task.dto.request.CreateFridgeRequest;
import com.test.task.dto.request.UpdateFridgeRequest;
import com.test.task.dto.response.FridgeResponse;
import com.test.task.exception.FridgeDuplicateException;
import com.test.task.exception.FridgeNotFoundException;
import com.test.task.model.Fridge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.test.task.mapper.FridgeMapper;
import org.springframework.stereotype.Service;
import com.test.task.repository.FridgeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * FridgeService.
 *
 * @author Viktoryia Zhak
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class FridgeService {
    private final FridgeRepository fridgeRepository;
    private final FridgeMapper fridgeMapper;

    public List<FridgeResponse> findAll() {
        log.info("---------FIND ALL FRIDGES--------");

        return fridgeRepository.findAll().stream()
                .map(fridgeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public FridgeResponse findById(Long id) {
        log.info("--------FIND BY ID--------- {}", id);

        return fridgeRepository.findById(id)
                .map(fridgeMapper::entityToDto)
                .orElseThrow(FridgeNotFoundException::new);
    }

    public FridgeResponse save(CreateFridgeRequest createFridgeRequest) {
        Optional<Fridge> fridge = fridgeRepository.findByModelAndColor(
                createFridgeRequest.getModel(), createFridgeRequest.getColor());

        if (fridge.isPresent()) {
            throw new FridgeDuplicateException();
        }

        Fridge newFridge = fridgeRepository.save(Fridge.builder()
                .color(createFridgeRequest.getColor())
                .model(createFridgeRequest.getModel())
                .build());

        log.info("---------CREATED NEW FRIDGE--------{}", newFridge.getId());
        return fridgeMapper.entityToDto(newFridge);
    }

    public FridgeResponse update(UpdateFridgeRequest updateFridgeRequest) {
        Fridge oldFridge = fridgeRepository.findById(updateFridgeRequest.getId()).orElseThrow(FridgeNotFoundException::new);
        oldFridge.setColor(updateFridgeRequest.getColor());
        oldFridge.setModel(updateFridgeRequest.getModel());
        Fridge newFridge = fridgeRepository.save(oldFridge);

        log.info("---------UPDATED FRIDGE-------- {}", updateFridgeRequest.getId());
        return fridgeMapper.entityToDto(newFridge);
    }

    public void delete(Long id) {
        fridgeRepository.deleteById(id);

        log.info("---------DELETED FRIDGE-------- {}", id);
    }
}
