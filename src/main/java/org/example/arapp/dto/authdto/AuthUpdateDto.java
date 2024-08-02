package org.example.arapp.dto.authdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUpdateDto {
    private String macAddress;
    private String newPassword;
}
