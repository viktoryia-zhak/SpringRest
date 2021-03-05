package com.test.task.repository;

import com.test.task.model.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * FridgeRepository.
 *
 * @author Viktoryia Zhak
 */
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
    Optional<Fridge> findByModelAndColor(String model, String color);
}
