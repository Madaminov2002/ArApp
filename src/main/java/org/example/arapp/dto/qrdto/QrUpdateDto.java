package org.example.arapp.dto.qrdto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrUpdateDto {
    private String appName;
    private String grName;
    private Integer deviceCount;
    private Date expiryTime;
}
