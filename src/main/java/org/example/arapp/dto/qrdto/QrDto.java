package org.example.arapp.dto.qrdto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrDto {
    private String appName;
    private String grName;
    private Integer deviceCount;
    private Integer count;
    private Date expirationDate;
}
