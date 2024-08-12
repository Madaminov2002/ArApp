package org.example.arapp.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.example.arapp.domain.QrCode;
import org.example.arapp.projection.QrProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
    @Query(nativeQuery = true, value = "select qr_code.code,group_id,id ,qr_code.device_count, expiry_time from qr_code group by group_id,  qr_code.code, id")
    List<QrCode> groupByGrId(Long grId);

    Optional<QrCode> findByCode(String code);

    List<QrCode> findQrCodesByGroupId(Long groupId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update qr_code set device_count=:count where id>0 and group_id=:grId")
    void updateQrCodesDeviceCount(@Param("grId") Long grId, @Param("count") Integer count);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update qr_code set expiry_time=:eTime where group_id=:grId")
    void updateQrCodesExpiryTime(@Param("grId") Long grId, @Param("eTime") Date expiryTime);

    @Query(nativeQuery = true,value = "select qr_code.code,id from qr_code where id>=:low and id<=:high")
    List<QrProjection> finnById(@Param("low")Long low, @Param("high")Long high);
}