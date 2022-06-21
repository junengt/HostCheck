package com.example.hostcheck.service;

import com.example.hostcheck.domain.*;
import com.example.hostcheck.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HostService {

    private final HostRepository hostRepository;

    //호스트 단건 조회
    public HostDto getHostOne(Long hostId) {
        Host findHost = hostRepository.findById(hostId).get();
        HostDto hostDto = new HostDto();
        hostDto.setName(findHost.getName());
        hostDto.setIp(findHost.getIp());
        hostDto.setCreateDate(findHost.getCreateDate());
        hostDto.setUpdateDate(findHost.getUpdateDate());
        return hostDto;
    }

    //호스트 전체 조회
    public List<HostListDto> getHostAll() {
        return hostRepository.findAll().stream()
                .map(h -> new HostListDto(h.getName(),h.getIp(), h.getCreateDate(), h.getUpdateDate())).toList();
    }

    //호스트 등록
    @Transactional
    public Long saveHost(HostReqDto hostReqDto) {
        Host host = new Host();
        host.setName(hostReqDto.getName());
        host.setIp(hostReqDto.getIp());
        host.setCreateDate(LocalDateTime.now());
        host.setUpdateDate(LocalDateTime.now());
        host.setIsLastAliveDate(LocalDateTime.now());
        hostRepository.save(host);
        return host.getId();
    }

    //호스트 수정
    @Transactional
    public Long updateHost(Long hostId, HostUpDto hostUpDto) {
        Host findHost = hostRepository.findById(hostId).get();
        if (findHost.getName() != hostUpDto.getName()) {
            findHost.setName(hostUpDto.getName());
        } else {
            return findHost.getId();
        } if (findHost.getIp() != hostUpDto.getIp()) {
            findHost.setIp(hostUpDto.getIp());
        } else {
            return findHost.getId();
        }
        findHost.setUpdateDate(LocalDateTime.now());
        return findHost.getId();
    }

    //호스트 삭제
    @Transactional
    public void deleteHost(Long hostId) {
        hostRepository.deleteById(hostId);
    }

    //호스트 현재 Alive 상태 조회
    @Transactional
    public void aliveNow(Long hostId) {
        Host host = hostRepository.findById(hostId).get();
        String ip = host.getIp();
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }
        try {
            if (inetAddress.isReachable(1000)) {
                host.setAlive(true);
                System.out.println("Reachable");
            } else {
                host.setAlive(false);
                host.setIsLastAliveDate(LocalDateTime.now());
                System.out.println("UnReachable");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //전체 호스트 Alive 모니터링 결과 조회
    public List<HostAliveMonitorListDto> aliveMonitorList() {
        long start = System.currentTimeMillis();
        System.out.println("전체조회시작..");
        List<HostAliveMonitorListDto> hostAliveMonitorListDtos = hostRepository.findAll().stream()
                .map(h -> new HostAliveMonitorListDto(h.getName(), h.getIp(), h.isAlive(), h.getIsLastAliveDate())).toList();
        long end = System.currentTimeMillis();
        System.out.println("조회끝..");
        System.out.println("조회 시간 : " + (end - start)/1000.0 + "초");
        return hostAliveMonitorListDtos;
    }

    //단일 호스트 Alive 모니터링 결과 조회
    public HostAliveMonitorDto aliveMonitorOne(Long hostId) {
        Host findHost = hostRepository.findById(hostId).get();
        return HostAliveMonitorDto.builder()
                .name(findHost.getName())
                .ip(findHost.getIp())
                .isAlive(findHost.isAlive())
                .isLastAliveDate(findHost.getIsLastAliveDate())
                .build();
    }

}
