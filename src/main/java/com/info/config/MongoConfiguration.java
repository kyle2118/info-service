package com.info.config;

import com.info.repository.PlayerInfo;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = PlayerInfo.class)
public class MongoConfiguration {

}
