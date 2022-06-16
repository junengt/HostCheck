package com.example.hostcheck.repository;

import com.example.hostcheck.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {

}
