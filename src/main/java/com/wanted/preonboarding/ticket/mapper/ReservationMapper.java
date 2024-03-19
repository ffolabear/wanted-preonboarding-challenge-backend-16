package com.wanted.preonboarding.ticket.mapper;

import com.wanted.preonboarding.ticket.dto.response.ReservationResponseDto;
import com.wanted.preonboarding.ticket.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationResponseDto of(Reservation reservation) {
        return ReservationResponseDto.builder()
                .id(reservation.getId())
                .performanceId(reservation.getPerformanceId())
                .name(reservation.getName())
                .phoneNumber(reservation.getPhoneNumber())
                .round(reservation.getRound())
                .gate(reservation.getGate())
                .line(reservation.getLine())
                .seat(reservation.getSeat())
                .build();
    }

}