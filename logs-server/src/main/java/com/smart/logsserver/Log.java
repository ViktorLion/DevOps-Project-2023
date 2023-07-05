package com.smart.logsserver;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String logEntry;

    public Log(String logEntry) {
        this.logEntry = logEntry;
    }

    public Log() {

    }

    public Long getId() {
        return id;
    }

    public String getLogEntry() {
        return logEntry;
    }
}
