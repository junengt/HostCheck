package com.example.hostcheck.service;

import com.example.hostcheck.domain.Host;
import com.example.hostcheck.domain.HostReqDto;
import com.example.hostcheck.repository.HostRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostService {

    private final HostRepository hostRepository;

    public HostDto getHost(Long hostId) {
        Host host = hostRepository.findById(hostId).get();
        HostDto hostDto = new HostDto();
        hostDto.setName(host.getName());
        hostDto.setIp(host.getIp());
        return hostDto;
    }

    public List<HostListDto> getHostAll() {
        return hostRepository.findAll().stream()
                .map(h -> new HostListDto(h.getId(), h.getName(), h.getIp())).toList();
    }

    public Long saveHost(HostReqDto hostReqDto) {
        Host host = new Host();
        host.setName(hostReqDto.getName());
        host.setIp(hostReqDto.getIp());
        hostRepository.save(host);
        return host.getId();
    }

//    public Long updateHost() {
//
//    }
//
//    public void deleteHost() {
//
//    }


    @Data
    @AllArgsConstructor
    public class HostListDto {
        private Long id;
        private String name;
        private String ip;
    }

    @Data
    public class HostDto {
        private Long id;
        private String name;
        private String ip;
    }
}
