package com.wanted.preonboarding.ticket.service.event;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class UpdatePerformanceEvent implements EventNotice {

    private UUID updatePerformanceId;
    private String performanceName;

}
