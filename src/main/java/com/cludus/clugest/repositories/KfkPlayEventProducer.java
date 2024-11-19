package com.cludus.clugest.repositories;

import com.cludus.clugest.model.KfkPlayEvent;
import com.cludus.clugest.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@Profile("kafka")
public class KfkPlayEventProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(KfkPlayEvent msg) {
        try {
            var result = kafkaTemplate.send(msg.getId(), Utils.GSON.toJson(msg))
                    .get();
            log.info("Sent message: " + result.getRecordMetadata().offset());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
