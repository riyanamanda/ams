package com.ran.server.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * @author Riyan Amanda
 * @linkedin <a href="https://linkedin.com/in/riyan-amanda">...</a>
 * @since 06/12/2024, Friday
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreateRequest {
    @NotEmpty(message = "Category name is required")
    @NotNull(message = "Category name is required")
    @Size(min = 3, max = 50)
    private String name;
}