package cn.evan.comment;

import cn.evan.listener.KafkaSendResultListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @Description
 * @ClassName KafkaTemplateTemplates
 * @Author Evan
 * @date 2019.11.07 17:31
 */

@Component
@Slf4j
public class KafkaTemplateTemplates {
    @Autowired
    private KafkaTemplate template;

    @Autowired
    private KafkaSendResultListener producerListener;

    /**
     * 单条发送
     * <p>
     * 三种方式
     *
     * @param topic
     * @param msg
     */
    public void send(String topic, String msg) {
        template.setProducerListener(producerListener);
        //发送带有时间戳的消息
        template.send(topic, 0, System.currentTimeMillis(), "0", msg);

        //使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord(topic, 0, System.currentTimeMillis(), "0", msg);
        template.send(record);

        //使用Message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, topic);
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, "0");
        map.put(KafkaHeaders.ACKNOWLEDGMENT, "all");
        GenericMessage message = new GenericMessage(msg, new MessageHeaders(map));
        template.send(message);
    }

    /**
     * 发送同步消息
     *
     * @param topic
     * @param msg
     */
    public void syncMsg(String topic, String msg) {

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, "0", msg);
        try {
            Future<RecordMetadata> future = template.send(record);
            RecordMetadata metadata = future.get();
            log.info(metadata.topic() + "-" + metadata.partition() + ":" + metadata.offset());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
