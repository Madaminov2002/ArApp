package org.example.arapp.jwt;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String accessToken;
    private LocalDateTime dateTime = LocalDateTime.now();

    public JwtResponse( String accessToken) {
        this.accessToken = accessToken;
    }


}
