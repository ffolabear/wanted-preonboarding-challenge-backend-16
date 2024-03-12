package com.wanted.preonboarding.ticket.entity;

import com.wanted.preonboarding.ticket.dto.request.PerformanceUpdateRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Performance {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int round;
    @Column(nullable = false)
    private int type;
    @Column(nullable = false)
    private Date start_date;
    @Column(nullable = false, name = "is_reserve", columnDefinition = "varchar default 'disable'")
    private String isReserve;

    public void updatePerformance(PerformanceUpdateRequestDto performanceUpdateRequestDto) {
        this.name = performanceUpdateRequestDto.getName();
        this.price = performanceUpdateRequestDto.getPrice();
        this.round = performanceUpdateRequestDto.getRound();
        this.type = performanceUpdateRequestDto.getType();

        if (performanceUpdateRequestDto.getStart_date() != null) {
            this.start_date = performanceUpdateRequestDto.getStart_date();
        }
        if (performanceUpdateRequestDto.getIsReserve() != null) {
            this.isReserve = performanceUpdateRequestDto.getIsReserve();
        }
    }

}
