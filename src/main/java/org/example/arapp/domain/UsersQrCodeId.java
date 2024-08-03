package org.example.arapp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsersQrCodeId implements Serializable {

    private static final long serialVersionUID = 1837465484515847862L;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Column(name = "qr_code_id", nullable = false)
    private Long qrCodeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsersQrCodeId entity = (UsersQrCodeId) o;
        return Objects.equals(this.qrCodeId, entity.qrCodeId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qrCodeId, userId);
    }

}