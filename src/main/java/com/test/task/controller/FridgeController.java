package com.test.task.controller;

import com.test.task.dto.request.CreateFridgeRequest;
import com.test.task.dto.request.UpdateFridgeRequest;
import com.test.task.dto.response.FridgeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.task.service.FridgeService;

import javax.validation.Valid;
import java.util.List;

/**
 * FridgeController.
 *
 * @author Viktoryia Zhak
 */
@RestController
@RequestMapping("/fridges")
@RequiredArgsConstructor
public class FridgeController {
    private final FridgeService fridgeService;

    @GetMapping
    public ResponseEntity<List<FridgeResponse>> findAll() {
        return ResponseEntity.ok().body(fridgeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FridgeResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(fridgeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FridgeResponse> save(@RequestBody @Valid CreateFridgeRequest createFridgeRequest) {
        return ResponseEntity.ok().body(fridgeService.save(createFridgeRequest));
    }

    @PutMapping
    public ResponseEntity<FridgeResponse> update(@RequestBody UpdateFridgeRequest updateFridgeRequest) {
        return ResponseEntity.ok().body(fridgeService.update(updateFridgeRequest));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        fridgeService.delete(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
