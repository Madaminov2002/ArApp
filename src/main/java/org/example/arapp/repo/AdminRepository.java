package org.example.arapp.repo;

import java.util.Optional;
import org.example.arapp.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByDeviceId(String deviceId);
    Optional<Admin> findAdminByMacAddress(String macAddress);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update admin set password=:password where mac_address=:mAddress")
    void updateByMacAddress(@Param("mAddress") String macAddress, @Param("password") String password);
}