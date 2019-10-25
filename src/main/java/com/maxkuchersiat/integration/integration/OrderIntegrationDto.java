package com.maxkuchersiat.integration.integration;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/***
 *   Dto used in spring integration email flow to
 *   get email and order from the email
 * */
@Data
public class OrderIntegrationDto {
    private final String email;
    private List<TacoDto> tacos = new ArrayList<>();

    public void addTaco(TacoDto taco) {
        this.tacos.add(taco);
    }
}
