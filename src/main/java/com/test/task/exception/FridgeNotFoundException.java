package com.test.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * FridgeNotFoundException.
 *
 * @author Viktoryia Zhak
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FridgeNotFoundException extends RuntimeException {
}
