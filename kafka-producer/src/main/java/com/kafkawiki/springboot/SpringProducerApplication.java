package com.kafkawiki.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProducerApplication implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(SpringProducerApplication.class);
    }
    @Autowired
    private WikiMediaProducer wikiMediaProducer;
    @Override
    public void run(String... args) throws Exception {
        wikiMediaProducer.sendMessage();
    }
}
