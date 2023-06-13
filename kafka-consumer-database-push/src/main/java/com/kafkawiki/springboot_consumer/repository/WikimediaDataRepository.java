package com.kafkawiki.springboot_consumer.repository;

import com.kafkawiki.springboot_consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {

}
