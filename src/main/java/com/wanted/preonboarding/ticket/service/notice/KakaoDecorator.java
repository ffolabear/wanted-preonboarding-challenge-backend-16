package com.wanted.preonboarding.ticket.service.notice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoDecorator implements DecoratorComponent {

    private final DecoratorComponent decoratorComponent;

    public KakaoDecorator(DecoratorComponent decoratorComponent) {
        this.decoratorComponent = decoratorComponent;
    }

    @Override
    public void operation(CanceledTicketInfo canceledTicketInfo) {
        log.info("[카카오톡 알림] {}님, {}", canceledTicketInfo.getCustomerName(), canceledTicketInfo.getMessage());
        decoratorComponent.operation(canceledTicketInfo);
    }
}
