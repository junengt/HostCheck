package com.example.hostcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HostListDto {

    private String name;
    private String ip;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
