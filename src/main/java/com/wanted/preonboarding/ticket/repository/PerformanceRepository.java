package com.wanted.preonboarding.ticket.repository;


import com.wanted.preonboarding.ticket.entity.Performance;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, UUID> {
}
