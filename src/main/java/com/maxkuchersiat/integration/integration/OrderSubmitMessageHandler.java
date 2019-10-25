package com.maxkuchersiat.integration.integration;


import com.maxkuchersiat.integration.configs.ApiProperties;
import com.maxkuchersiat.integration.dto.OrderIntegrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *  Handler that upon receiving order dto
 *  submits this order to the taco orders api.
 * */
@Component
@RequiredArgsConstructor
public class OrderSubmitMessageHandler implements GenericHandler<OrderIntegrationDto> {


    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;
    @Override
    public Object handle(OrderIntegrationDto orderIntegrationDto, MessageHeaders messageHeaders) {
        restTemplate.postForObject(apiProperties.getUrl(),orderIntegrationDto, String.class);
        return null;
    }
}
