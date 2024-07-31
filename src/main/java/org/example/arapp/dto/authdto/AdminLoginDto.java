package org.example.arapp.dto.authdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginDto {
    private String macAddress;
    private String password;
    private String deviceID;
}
