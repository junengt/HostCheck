package com.example.hostcheck.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "HOST", uniqueConstraints = {@UniqueConstraint(name = "NAME_IP_UNIQUE",columnNames={"NAME", "ID"})})
@Getter @Setter
public class Host {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IP")
    private String ip;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @Column(name = "IS_ALIVE")
    private boolean isAlive = true;

    @Column(name = "IS_LAST_ALIVE_DATE")
    private LocalDateTime isLastAliveDate;

}
