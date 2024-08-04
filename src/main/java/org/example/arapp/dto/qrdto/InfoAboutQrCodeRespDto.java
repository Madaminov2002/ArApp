package org.example.arapp.dto.qrdto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Builder
@Getter
public class InfoAboutQrCodeRespDto {
    String qrCode;
    Long expiration;
    String groupName;
    String appName;
    Integer deviceLimit;
    Integer registeredUsers;
}
