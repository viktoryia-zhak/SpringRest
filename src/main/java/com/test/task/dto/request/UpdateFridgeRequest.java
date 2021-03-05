package com.test.task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * UpdateFridgeResponse.
 *
 * @author Viktoryia Zhak
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFridgeRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String model;

    @NotBlank
    private String color;
}
