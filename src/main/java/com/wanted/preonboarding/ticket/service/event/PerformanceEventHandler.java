package com.wanted.preonboarding.ticket.service.event;

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

    @EventListener
    public void defaultEventListener(EventNotice event) {
        log.info("defaultEventListener             : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void transactionalEventListenerBeforeCommit(EventNotice event) {
        log.info("TransactionPhase.BEFORE_COMMIT   : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void transactionalEventListenerAfterCommit(EventNotice event) {
        log.info("TransactionPhase.AFTER_COMMIT    : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void transactionalEventListenerAfterRollback(EventNotice event) {
        log.info("TransactionPhase.AFTER_ROLLBACK  : {}", event);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void transactionalEventListenerAfterCompletion(EventNotice event) {
        log.info("TransactionPhase.AFTER_COMPLETION : {}", event);
    }

}
