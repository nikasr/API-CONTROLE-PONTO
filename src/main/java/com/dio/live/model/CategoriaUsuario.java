package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
public class CategoriaUsuario {
    @Id
    @GeneratedValue
    private long id;
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriaUsuario that = (CategoriaUsuario) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 2059934939;
    }
}
