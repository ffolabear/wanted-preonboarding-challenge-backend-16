package com.wanted.preonboarding.ticket.service.event;

import com.wanted.preonboarding.ticket.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class PerformanceEventHandler {

    private final ReservationService reservationService;

    @EventListener
    public void defaultEventListener(EventNotice event) {
        log.info("defaultEventListener              : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void transactionalEventListenerBeforeCommit(UpdatePerformanceEvent event) {
        log.info("TransactionPhase.BEFORE_COMMIT    : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void transactionalEventListenerAfterCommit(UpdatePerformanceEvent event) {
        log.info("TransactionPhase.AFTER_COMMIT     : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void transactionalEventListenerAfterRollback(UpdatePerformanceEvent event) {
        log.info("TransactionPhase.AFTER_ROLLBACK   : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void transactionalEventListenerAfterCompletion(UpdatePerformanceEvent event) {
        log.info("TransactionPhase.AFTER_COMPLETION : {}", event);
        reservationService.noticeReservationCustomers(event.getUpdatePerformanceId());
    }

}
