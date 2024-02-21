package com.xipengyuan.demo.amqp;

import com.xipengyuan.demo.amqp.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static com.xipengyuan.demo.amqp.config.RabbitConfig.Q_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VeryQuickTest {

    @Test
    void testVeryVeryQuick() {
        ConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");

        AmqpAdmin admin = new RabbitAdmin(connectionFactory);
        admin.declareQueue(new Queue(Q_NAME));

        AmqpTemplate template = new RabbitTemplate(connectionFactory);
        template.convertAndSend(Q_NAME, "foo");
        String foo = (String) template.receiveAndConvert(Q_NAME);
        assertEquals("foo", foo);
    }

    @Test
    void testWithXmlConfiguration() {
        ApplicationContext context = new GenericXmlApplicationContext("classpath:/rabbit-context.xml");
        AmqpTemplate template = context.getBean(AmqpTemplate.class);
        template.convertAndSend(Q_NAME, "foo");
        String foo = (String) template.receiveAndConvert(Q_NAME);
        assertEquals("foo", foo);
    }

    @Test
    void testWithJavaConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
        AmqpTemplate template = context.getBean(AmqpTemplate.class);
        template.convertAndSend(Q_NAME, "foo");
        String foo = (String) template.receiveAndConvert(Q_NAME);
        assertEquals("foo", foo);
    }
}
