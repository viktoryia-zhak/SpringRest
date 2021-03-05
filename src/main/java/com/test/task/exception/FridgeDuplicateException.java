package com.test.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * FridgeDuplicateException.
 *
 * @author Viktoryia Zhak
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class FridgeDuplicateException extends RuntimeException {
}
