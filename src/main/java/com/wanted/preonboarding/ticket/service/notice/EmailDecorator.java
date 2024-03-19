package com.wanted.preonboarding.ticket.service.notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailDecorator implements DecoratorComponent {

    private final DecoratorComponent decoratorComponent;

    public EmailDecorator(DecoratorComponent decoratorComponent) {
        this.decoratorComponent = decoratorComponent;
    }

    @Override
    public void operation(CanceledTicketInfo canceledTicketInfo) {
        log.info("[이메일 알림] {}님, {}", canceledTicketInfo.getCustomerName(), canceledTicketInfo.getMessage());
        decoratorComponent.operation(canceledTicketInfo);
    }
}
