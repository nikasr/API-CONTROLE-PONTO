package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Localidade {
    @Id
    @GeneratedValue
    private  long id;
    @ManyToOne
    private NivelAcesso nivelAcesso;
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Localidade that = (Localidade) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1280952946;
    }
}
