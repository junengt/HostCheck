package com.example.hostcheck.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class HostAliveMonitorDto {

    private String name;
    private String ip;
    private boolean isAlive;
    private LocalDateTime isLastAliveDate;
}
