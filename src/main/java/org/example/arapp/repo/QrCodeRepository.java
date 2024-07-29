package org.example.arapp.repo;

import lombok.extern.slf4j.Slf4j;
import org.example.arapp.domain.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
}