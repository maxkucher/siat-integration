package com.maxkuchersiat.integration.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoDto {

    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min = 5, message = "Must be at least 5 chars long")
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientDto> ingredients = new ArrayList<>();
}
