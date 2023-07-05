package com.smart.logsserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class LogController {

    @Autowired
    private LogRepository logRepository;

    @GetMapping("/logs")
    public ResponseEntity<List<Log>> getAllLogs() {
        LocalDateTime timestamp = LocalDateTime.now();
        String logEntry = "Route: GET | Timestamp: " + timestamp;

        Log log = new Log(logEntry);
        logRepository.save(log);

        // Return a response with the list of logs
        return ResponseEntity.ok(logRepository.findAll());
    }

    @PostMapping("/createLog")
    public ResponseEntity<Log> createLog() {
        LocalDateTime timestamp = LocalDateTime.now();
        String logEntry = "Route: createLog | Timestamp: " + timestamp;

        Log log = new Log(logEntry);
        // Save the new log entry and return the newly added log
        return ResponseEntity.ok(logRepository.save(log));
    }
}
