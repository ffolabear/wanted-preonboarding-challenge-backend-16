package com.wanted.preonboarding.ticket.service.notice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CanceledTicketInfo {

    private String customerName;
    private String performanceName;
    private String message;

}