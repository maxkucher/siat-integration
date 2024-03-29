package com.maxkuchersiat.integration.configs;

import com.maxkuchersiat.integration.integration.EmailToOrderTransformer;
import com.maxkuchersiat.integration.integration.OrderSubmitMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.mail.dsl.Mail;

@Configuration
public class TacoOrderEmailIntegrationConfig {
    @Bean
    public IntegrationFlow tacoEmailIntegrationFlow(
            EmailProperties properties,
            EmailToOrderTransformer emailToOrderTransformer,
            OrderSubmitMessageHandler orderSubmitMessageHandler
    ) {
        return IntegrationFlows
                .from(Mail.imapInboundAdapter(properties.getImapUrl()),
                        e -> e.poller(Pollers.fixedDelay(properties.getPollRate())))
                .transform(emailToOrderTransformer)
                .handle(orderSubmitMessageHandler)
                .get();
    }
}
