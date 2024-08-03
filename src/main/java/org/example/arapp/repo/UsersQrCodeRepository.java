package org.example.arapp.repo;

import org.example.arapp.domain.UsersQrCode;
import org.example.arapp.domain.UsersQrCodeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersQrCodeRepository extends JpaRepository<UsersQrCode, UsersQrCodeId> {
  List<UsersQrCode> findById_QrCodeId(Long qrCodeId);
}