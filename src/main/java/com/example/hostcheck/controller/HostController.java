package com.example.hostcheck.controller;

import com.example.hostcheck.domain.*;
import com.example.hostcheck.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HostController {

    private final HostService hostService;

    //호스트 전체 조회
    @GetMapping("/host")
    public List<HostListDto> getHostAll() {
        return hostService.getHostAll();
    }

    //호스트 단일 조회
    @GetMapping("/host/{id}")
    public HostDto getHostOne(@PathVariable(name = "id") Long hostId) {
        return hostService.getHostOne(hostId);
    }

    //호스트 등록
    @PostMapping("/host")
    public String saveHost(@RequestBody HostReqDto hostReqDto) {
        hostService.saveHost(hostReqDto);
        return "호스트 등록 완료";
    }

    //호스트 수정
    @PutMapping("/host/{id}")
    public String updateHost(@PathVariable(name = "id") Long hostId,
                             @RequestBody HostUpDto hostUpDto) {
        hostService.updateHost(hostId, hostUpDto);
        return "호스트 변경 완료";
    }

    //호스트 삭제
    @DeleteMapping("/host/{id}")
    public String deleteHost(@PathVariable(name = "id") Long hostId) {
        hostService.deleteHost(hostId);
        return "호스트 삭제 완료";
    }

    //특정 호스트 현재 Alive 상태 조회
    @GetMapping("/host/alive/{id}")
    public String getHostAlive(@PathVariable(name = "id") Long hostId) {
        hostService.aliveNow(hostId);
        return "조회 완료";
    }

    //전체 호스트 Alive 모니터링 결과 조회
    @GetMapping("/host/alive/monitor")
    public List<HostAliveMonitorListDto> getHostAliveMonitorAll() {
        return hostService.aliveMonitorList();
    }

    //특정 호스트 Alive 모니터링 결과 조회
    @GetMapping("/host/alive/monitor/{id}")
    public HostAliveMonitorDto getHostAliveMonitorOne(@PathVariable(name = "id") Long hostId) {
        return hostService.aliveMonitorOne(hostId);
    }


}
