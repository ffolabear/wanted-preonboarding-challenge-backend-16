package com.wanted.preonboarding.ticket.service;

import com.wanted.preonboarding.core.domain.response.ResponseListDto;
import com.wanted.preonboarding.ticket.dto.request.PerformanceUpdateRequestDto;
import com.wanted.preonboarding.ticket.dto.response.PerformanceResponseDto;
import com.wanted.preonboarding.ticket.entity.Performance;
import com.wanted.preonboarding.ticket.entity.PerformanceEventDto;
import com.wanted.preonboarding.ticket.mapper.PerformanceMapper;
import com.wanted.preonboarding.ticket.repository.PerformanceRepository;
import com.wanted.preonboarding.ticket.service.event.UpdatePerformanceEvent;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final PerformanceMapper performanceMapper;
    private final ApplicationEventPublisher eventPublisher;

    public ResponseListDto<PerformanceResponseDto> findAllPerformances() {
        List<Performance> performances = performanceRepository.findAll();
        List<PerformanceResponseDto> performanceResponseDtos = performances.stream()
                .map(performanceMapper::of)
                .toList();

        eventPublisher.publishEvent(PerformanceEventDto.builder()
                .selectSize(performanceResponseDtos.size())
                .build());
        return ResponseListDto.<PerformanceResponseDto>builder()
                .data(performanceResponseDtos)
                .build();
    }

    @Transactional
    public UUID updatePerformance(PerformanceUpdateRequestDto performanceUpdateRequestDto) {
        UUID performanceId = UUID.fromString(performanceUpdateRequestDto.getId());
        Performance performance = performanceRepository
                .findById(performanceId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 공연입니다."));
        performance.updatePerformance(performanceUpdateRequestDto);
        eventPublisher.publishEvent(
                UpdatePerformanceEvent.builder()
                        .updatePerformanceId(performanceId)
                        .performanceName(performance.getName())
                        .build());
        return performanceId;
    }

}
