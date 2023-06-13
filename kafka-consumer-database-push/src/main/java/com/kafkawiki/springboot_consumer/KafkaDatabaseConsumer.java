package com.kafkawiki.springboot_consumer;

import com.kafkawiki.springboot_consumer.entity.WikimediaData;
import com.kafkawiki.springboot_consumer.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private WikimediaDataRepository dataRepository;
    @KafkaListener(topics="wikimedia_recentchange",
            groupId = "consumergroup1"
    )
    public void consume(String eventMessage){
        LOGGER.info(String.format("eventMessage Received -> %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);

        dataRepository.save(wikimediaData);

    }

}
