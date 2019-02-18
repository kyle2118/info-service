package com.info.config;

import com.info.repository.PlayerRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = PlayerRepository.class)
public class MongoConfiguration {

}
