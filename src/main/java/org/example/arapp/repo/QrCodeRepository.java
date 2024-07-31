package org.example.arapp.repo;

import java.util.List;
import org.example.arapp.domain.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
    @Query(nativeQuery = true,value = "select qr_code.code,group_id,id ,qr_code.device_count, expiry_time from qr_code group by group_id,  qr_code.code, id")
    List<QrCode> groupByGrId(Long grId);
}