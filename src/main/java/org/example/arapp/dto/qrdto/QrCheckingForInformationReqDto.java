package org.example.arapp.dto.qrdto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrCheckingForInformationReqDto {
    @NotEmpty
    String qrCode;
}
