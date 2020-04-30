package ch.course223.advanced.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class RabbitMqService {

    public final static String ARTICLE_QUEUE = "artistore_articles";

    private ConnectionFactory connectionFactory;


    public RabbitMqService() {
        connectionFactory = new ConnectionFactory();
        try {
            connectionFactory.setUri("amqp://guest:guest@localhost"); //host noch ersetzen
            Connection connection = getConnection();
            if (connection != null) {
                Channel channel = connection.createChannel();
                /* queueDeclare ist eine idempotente Funktion. Daher kann dises Funktion immer aufgerufen werden */
                channel.queueDeclare(ARTICLE_QUEUE, false, false, false, null);
            }
        } catch (URISyntaxException | NoSuchAlgorithmException | KeyManagementException | TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }


    public void publishToQueue(String queueName, String payload) {
        try {
            Connection connection = this.getConnection();
            if (connection != null) {
                Channel channel = connection.createChannel();
                channel.basicPublish("", queueName,
                        MessageProperties.PERSISTENT_BASIC,
                        payload.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }


    private Connection getConnection() throws IOException, TimeoutException {
        if (connectionFactory != null) {
            return connectionFactory.newConnection();
        }
        return null;
    }
}
