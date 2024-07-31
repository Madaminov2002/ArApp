package org.example.arapp.repo;

import java.util.Optional;
import org.example.arapp.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByDeviceId(String deviceId);
    Optional<Admin> findAdminByMacAddress(String macAddress);
}