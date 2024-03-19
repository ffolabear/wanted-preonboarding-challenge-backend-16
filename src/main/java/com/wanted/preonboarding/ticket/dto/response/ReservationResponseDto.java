package com.wanted.preonboarding.ticket.dto.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public class ReservationResponseDto {

    private int id;
    private UUID performanceId;
    private String name;
    private String phoneNumber;
    private int round;
    private int gate;
    private char line;
    private int seat;

}