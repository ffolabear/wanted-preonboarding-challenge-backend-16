package com.wanted.preonboarding.ticket.controller;

import com.wanted.preonboarding.core.domain.response.ResponseHandler;
import com.wanted.preonboarding.core.domain.response.ResponseListDto;
import com.wanted.preonboarding.ticket.dto.request.ReservationUpdateRequestDto;
import com.wanted.preonboarding.ticket.dto.response.ReservationResponseDto;
import com.wanted.preonboarding.ticket.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reservation")
@RequiredArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseHandler<Object> getReservation() {
        ResponseListDto<ReservationResponseDto> allPerformances = reservationService.findAllReservations();
        return ResponseHandler.builder()
                .statusCode(HttpStatus.OK)
                .message("예약 목록을 성공적으로 조회했습니다.")
                .data(allPerformances)
                .build();
    }

    @PutMapping
    public ResponseHandler<Object> putReservation(
            @RequestBody ReservationUpdateRequestDto reservationUpdateRequestDto) {
        ReservationResponseDto reservationResponseDto = reservationService.updateReservations(
                reservationUpdateRequestDto);
        return ResponseHandler.builder()
                .statusCode(HttpStatus.OK)
                .data(reservationResponseDto)
                .message("예약을 성공적으로 수정했습니다.")
                .build();
    }

}