package org.example.arapp.dto.userdto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.arapp.domain.User}
 */
@Value
public class UserRegisterDto implements Serializable {
    @NotEmpty
    String appName;
    @NotEmpty
    String deviceId;
    @NotEmpty
    String qrCode;
}