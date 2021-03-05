package com.test.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * CreateFridgeRequest.
 *
 * @author Viktoryia Zhak
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateFridgeRequest {
    @NotBlank
    private String model;

    @NotBlank
    private String color;
}
