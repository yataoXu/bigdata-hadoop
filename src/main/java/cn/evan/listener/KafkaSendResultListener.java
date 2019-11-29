package cn.evan.listener;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @ClassName KafkaSendResultHandler
 * @Author Evan
 * @date 2019.11.07 17:12
 */
@Component
@Slf4j
public class KafkaSendResultListener implements ProducerListener {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Message send success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info("Message send error : " + producerRecord.toString());
    }
}
