package com.example.hostcheck.service;

import com.example.hostcheck.domain.*;
import com.example.hostcheck.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HostService {

    private final HostRepository hostRepository;

    public HostDto getHostOne(Long hostId) {
        Host host = hostRepository.findById(hostId).get();
        HostDto hostDto = new HostDto();
        hostDto.setName(host.getName());
        hostDto.setIp(host.getIp());
        return hostDto;
    }

    public List<HostListDto> getHostAll() {
        return hostRepository.findAll().stream()
                .map(h -> new HostListDto(h.getName(), h.getIp())).toList();
    }

    @Transactional
    public Long saveHost(HostReqDto hostReqDto) {
        Host host = new Host();
        host.setName(hostReqDto.getName());
        host.setIp(hostReqDto.getIp());
        hostRepository.save(host);
        return host.getId();
    }

    @Transactional
    public Long updateHost(Long hostId, HostUpDto hostUpDto) {
        Host findHost = hostRepository.findById(hostId).get();
        findHost.setName(hostUpDto.getName());
        findHost.setIp(hostUpDto.getIp());
        return findHost.getId();
    }

    @Transactional
    public void deleteHost(Long hostId) {
        hostRepository.deleteById(hostId);
    }

}
