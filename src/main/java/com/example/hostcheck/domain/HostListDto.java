package com.example.hostcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HostListDto {

    private String name;
    private String ip;
}
