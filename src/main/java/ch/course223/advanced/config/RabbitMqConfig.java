package ch.course223.advanced.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitMqConfig {
    @Bean("rabbitMqService")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public RabbitMqService getRabbitMq() {
        return new RabbitMqService();
    }
}
