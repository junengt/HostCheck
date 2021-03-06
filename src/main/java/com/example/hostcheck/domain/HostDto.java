package com.example.hostcheck.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HostDto {

    private String name;
    private String ip;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
