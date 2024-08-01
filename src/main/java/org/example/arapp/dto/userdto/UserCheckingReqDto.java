package org.example.arapp.dto.userdto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;
import org.example.arapp.domain.User;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class UserCheckingReqDto implements Serializable {
    @NotEmpty
    String appName;
    @NotEmpty
    String deviceId;
}