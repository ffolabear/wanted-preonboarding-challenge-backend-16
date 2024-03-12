package com.wanted.preonboarding.ticket.dto.response;

import java.sql.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PerformanceResponseDto {

    private UUID id;
    private String name;
    private int price;
    private int round;
    private int type;
    private Date start_date;
    private String isReserve;

}
