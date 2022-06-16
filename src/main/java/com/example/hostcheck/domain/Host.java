package com.example.hostcheck.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "host", uniqueConstraints = {@UniqueConstraint(name = "name_ip_unique",columnNames={"name", "ip"})})
@Getter @Setter
public class Host {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "host_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ip")
    private String ip;

}
