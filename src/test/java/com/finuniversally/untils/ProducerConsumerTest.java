package com.finuniversally.untils;

import com.finuniversally.service.IProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.jms.Destination;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-startup.xml")
@WebAppConfiguration("src/main/resources")
public class ProducerConsumerTest {

    @Autowired
    private IProducerService IProducerService;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Test
    public void testSend() {
       for (int i=0; i<2; i++) {
            IProducerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
        }

    }
}
