package org.example.arapp.dto.groupdto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.arapp.domain.Group}
 */
@Value
public class AppAndGroupForGetQrsReqDto implements Serializable {
    @NotEmpty
    String groupName;

    @NotEmpty
    String appName;
}