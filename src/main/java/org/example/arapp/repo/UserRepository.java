package org.example.arapp.repo;

import lombok.extern.slf4j.Slf4j;
import org.example.arapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDeviceIdAndAppName(String deviceId, String appName);
}