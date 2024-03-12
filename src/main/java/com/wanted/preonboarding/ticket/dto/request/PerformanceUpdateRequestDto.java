package com.wanted.preonboarding.ticket.dto.request;

import java.sql.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Builder
public class PerformanceUpdateRequestDto {

    private String id;
    private String name;
    private int price;
    private int round;
    private int type;
    private Date start_date;
    private String isReserve;

}
