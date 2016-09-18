package com.herenow;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

	@Value("${mongoDb.host}")
	private String mongoDbHost;

	@Value("${mongoDb.port}")
	private int mongoDbPort;

	@Value("${mongoDb.database}")
	private String mongoDbDatabase;
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public Jongo jongo() throws UnknownHostException {
        DB db;
        db = new MongoClient(mongoDbHost, mongoDbPort).getDB(mongoDbDatabase);
        return new Jongo(db);
    }

    @Bean
    public MongoCollection profiles() throws UnknownHostException {
        return jongo().getCollection("profiles");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
