package com.example.hostcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HostAliveMonitorListDto {

    private String name;
    private String ip;
    private boolean isAlive;
    private LocalDateTime isLastAliveDate;
}
