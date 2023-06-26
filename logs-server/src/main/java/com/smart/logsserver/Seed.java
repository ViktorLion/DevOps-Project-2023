package com.smart.logsserver;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Seed {
    @Autowired
    private LogRepository logRepository;

    @PostConstruct
    public void init() {
        // this function is automatically invoked when server starts
        // a new log entry is added for server start here
        LocalDateTime timestamp = LocalDateTime.now();
        String logEntry = "Server started: | Timestamp: " + timestamp;

        Log log = new Log(logEntry);
        logRepository.save(log);
    }
}
