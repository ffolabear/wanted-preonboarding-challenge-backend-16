package com.wanted.preonboarding.ticket.dto.request;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PerformanceRequestDto {

    private String name;
    private int price;
    private int round;
    private int type;
    private Date start_date;
    private String isReserve;
}
