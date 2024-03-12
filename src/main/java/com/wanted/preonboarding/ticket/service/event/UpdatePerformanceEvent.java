package com.wanted.preonboarding.ticket.service.event;

import java.util.UUID;
import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class UpdatePerformanceEvent implements EventNotice{

    private UUID updatePerformanceId;
    private String performanceName;

}
