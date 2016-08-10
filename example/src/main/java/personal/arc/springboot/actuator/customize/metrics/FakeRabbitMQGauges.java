package personal.arc.springboot.actuator.customize.metrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * Created by Arc on 27/7/2016.
 */
@Component
public class FakeRabbitMQGauges {

    private static Logger logger = LoggerFactory.getLogger(FakeRabbitMQGauges.class);

    @Autowired
    private GaugeService gaugeService;

    @PostConstruct
    public void collectMQGauges() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while(true) {
//                        AMQP.Queue.DeclareOk declareOk = connectionFactory.newConnection().createChannel().queueDeclarePassive(DaRabbitMQConst.QUEUE_DASERVER_TRACE);
//                        String queue = declareOk.getQueue();
//                        int msgCount = declareOk.getMessageCount();
//                        int consumerCount = declareOk.getConsumerCount();
                        // 每15秒更新一次gauge
                        Thread.sleep(15000L);
                        gaugeService.submit("fakeQueueName" + ".msg.count", getMsgCount());
                        gaugeService.submit("fakeQueueName" + ".consumer.count", getCounsumerCount());
                    }
                } catch (Exception e) {
                    logger.info("collectMQGauges error...", e);
                }
            }
        }.start();
    }

    private Random random = new Random();

    private int getMsgCount() {
        return Math.abs(random.nextInt()%997);
    }

    private int getCounsumerCount() {
        return Math.abs(random.nextInt()%53);
    }

}
