package com.example.hostcheck.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HostController {

    //HostService 선언

    /**
     * 호스트 등록 관리 API
     * 호스트 조회, 등록, 수정, 삭제 API
     * 호스트 등록 필드는 name, ip
     * name과 ip는 중복X
     * 조회 결과 필드는 등록/수정 시간 포함
     * 서버가 재시작 되어도 등록된 호스트는 유지
     * 호스트 등록은 100개로 제한
     */

    /**
     * 특정 호스트의 현재 Alive 상태 조회 REST API
     * 조회의 단위는 한 호스트만(단일 조회)
     * Alive 상태 확인은 InetAddress.isReachable()사용
     */

    /**
     * 호스트들의 Alive 모니터링 결과 조회 REST API
     * 조회 결과 필드에는 Alive 상태와 마지막 Alive 시간 포함
     * 조회의 단위는 한 호스트, 전체 호스트 제공(단일, 전체)
     * 전체 조회시 100개의 호스트가 모두 Unreachable 상태여도 조회는 1초 이내에 응답
     */

//    //호스트 전체 조회
//    @GetMapping("/host")
//
//    //호스트 단일 조회
//    @GetMapping("/host/{id}")
//
//    //호스트 등록
//    @PostMapping("/host")
//
//    //호스트 수정
//    @PutMapping("/host/{id}")
//
//    //호스트 삭제
//    @DeleteMapping("/host/{id}")
//
//    //특정 호스트 현재 Alive 상태 조회
//    @GetMapping("/host/alive/{id}")
//
//    //특정 호스트 Alive 모니터링 결과 조회
//    @GetMapping("/host/monitor/{id}")
//
//    //전체 호스트 Alive 모니터링 결과 조회
//    @GetMapping("/host/monitor")
}
