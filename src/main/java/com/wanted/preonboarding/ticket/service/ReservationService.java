package com.wanted.preonboarding.ticket.service;

import com.wanted.preonboarding.core.domain.response.ResponseListDto;
import com.wanted.preonboarding.ticket.dto.request.ReservationUpdateRequestDto;
import com.wanted.preonboarding.ticket.dto.response.ReservationResponseDto;
import com.wanted.preonboarding.ticket.entity.Performance;
import com.wanted.preonboarding.ticket.entity.Reservation;
import com.wanted.preonboarding.ticket.mapper.ReservationMapper;
import com.wanted.preonboarding.ticket.repository.PerformanceRepository;
import com.wanted.preonboarding.ticket.repository.ReservationRepository;
import com.wanted.preonboarding.ticket.service.notice.BaseComponent;
import com.wanted.preonboarding.ticket.service.notice.CanceledTicketInfo;
import com.wanted.preonboarding.ticket.service.notice.DecoratorComponent;
import com.wanted.preonboarding.ticket.service.notice.EmailDecorator;
import com.wanted.preonboarding.ticket.service.notice.KakaoDecorator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PerformanceRepository performanceRepository;
    private final ReservationMapper reservationMapper;
    private DecoratorComponent realComponent;

    public ResponseListDto<ReservationResponseDto> findAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponseDto> reservationResponseDtos = reservations.stream()
                .map(reservationMapper::of)
                .toList();
        return ResponseListDto.<ReservationResponseDto>builder()
                .data(reservationResponseDtos)
                .build();
    }

    public ReservationResponseDto updateReservations(ReservationUpdateRequestDto reservationRequestDto) {
        Reservation reservation = reservationRepository
                .findById(reservationRequestDto.getId())
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 공연입니다."));
        return reservationMapper.of(reservation);
    }

    public void noticeReservationCustomers(UUID performanceId) {

        Performance findPerformance = performanceRepository
                .findById(performanceId)
                .orElseThrow(() -> new NoSuchElementException("알수없는 에러가 발생했습니다."));

        List<Reservation> reservationCustomer = getReservationCustomer(performanceId);
        List<CanceledTicketInfo> canceledTicketInfos = reservationCustomer.stream()
                .map(reservation -> CanceledTicketInfo.builder()
                        .customerName(reservation.getName())
                        .performanceName(findPerformance.getName())
                        .message(reservationUpdateMessage(findPerformance))
                        .build()
                )
                .toList();

        //이메일, 카카오톡 등으로 변경 가능
        for (CanceledTicketInfo cancelInfo : canceledTicketInfos) {
            realComponent = new BaseComponent();
            realComponent = new EmailDecorator(new KakaoDecorator(realComponent));
            realComponent.operation(cancelInfo);
        }
    }

    private List<Reservation> getReservationCustomer(UUID performanceId) {
        return reservationRepository.findByPerformanceId(performanceId);
    }

    private String reservationUpdateMessage(Performance performance) {
        return "예약하신 " + performance.getName() + " 공연에 새로운 소식이 등록되었습니다.";
    }

}