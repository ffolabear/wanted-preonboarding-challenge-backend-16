package com.wanted.preonboarding.ticket.service.notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseComponent implements DecoratorComponent {

    @Override
    public void operation(CanceledTicketInfo canceledTicketInfo) {
        log.info("[기본 알림] {}님, {}", canceledTicketInfo.getCustomerName(), canceledTicketInfo.getMessage());
    }
}