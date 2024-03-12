package com.wanted.preonboarding.ticket.service;

import com.wanted.preonboarding.ticket.dto.request.PerformanceRequestDto;
import com.wanted.preonboarding.ticket.dto.response.PerformanceResponseDto;
import com.wanted.preonboarding.ticket.entity.Performance;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapper {

    public PerformanceResponseDto of(Performance performance) {
        return PerformanceResponseDto.builder()
                .id(performance.getId())
                .name(performance.getName())
                .price(performance.getPrice())
                .round(performance.getRound())
                .type(performance.getType())
                .start_date(performance.getStart_date())
                .isReserve(performance.getIsReserve())
                .build();
    }

    public Performance of(PerformanceRequestDto performanceRequestDto) {
        return Performance.builder()
                .name(performanceRequestDto.getName())
                .price(performanceRequestDto.getPrice())
                .round(performanceRequestDto.getRound())
                .type(performanceRequestDto.getType())
                .start_date(performanceRequestDto.getStart_date())
                .isReserve(performanceRequestDto.getIsReserve())
                .build();
    }

}
