package com.wanted.preonboarding.ticket.controller;

import com.wanted.preonboarding.core.domain.response.ResponseHandler;
import com.wanted.preonboarding.core.domain.response.ResponseListDto;
import com.wanted.preonboarding.ticket.dto.request.PerformanceUpdateRequestDto;
import com.wanted.preonboarding.ticket.dto.response.PerformanceResponseDto;
import com.wanted.preonboarding.ticket.service.PerformanceService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/performance")
@RequiredArgsConstructor
@RestController
public class PerformanceController {

    private final PerformanceService performanceService;

    @GetMapping
    public ResponseHandler<Object> getPerformances() {
        ResponseListDto<PerformanceResponseDto> allPerformances = performanceService.findAllPerformances();
        return ResponseHandler.builder()
                .statusCode(HttpStatus.OK)
                .message("공연 목록을 성공적으로 조회했습니다.")
                .data(allPerformances)
                .build();
    }

    @PutMapping
    public ResponseHandler<Object> putPerformances(
            @RequestBody PerformanceUpdateRequestDto performanceUpdateRequestDto) {
        UUID uuid = performanceService.updatePerformance(performanceUpdateRequestDto);
        return ResponseHandler.builder()
                .statusCode(HttpStatus.OK)
                .message("공연 목록을 성공적으로 조회했습니다.")
                .data(uuid)
                .build();
    }

}