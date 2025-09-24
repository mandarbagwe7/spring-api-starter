package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCartItemRequest {
    @NotNull(message = "Quantity must be provided.")
    @Min(value = 1, message = "Quantity must be greater then zero.")
    @Max(value = 100, message = "Quantity must be less than or equal to 100.")
    private Integer quantity;
}
