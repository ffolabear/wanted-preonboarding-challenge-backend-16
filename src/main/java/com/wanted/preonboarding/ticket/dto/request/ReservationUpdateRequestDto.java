package com.wanted.preonboarding.ticket.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class ReservationUpdateRequestDto {

    private int id;
    private String performanceId;
    private String name;
    private String phoneNumber;
    private int round;
    private int gate;
    private char line;
    private int seat;

}