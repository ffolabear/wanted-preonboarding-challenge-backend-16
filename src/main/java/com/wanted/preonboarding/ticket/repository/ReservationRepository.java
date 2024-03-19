package com.wanted.preonboarding.ticket.repository;


import com.wanted.preonboarding.ticket.entity.Reservation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByPerformanceId(UUID performanceID);

}
