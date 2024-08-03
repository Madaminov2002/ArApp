package org.example.arapp.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class QrCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private Integer deviceCount;
    @Column(nullable = false)
    private Date expiryTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private Group group;

}
