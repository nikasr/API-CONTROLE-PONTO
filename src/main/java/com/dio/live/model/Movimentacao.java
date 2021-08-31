package com.dio.live.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movimentacao {

        @AllArgsConstructor
        @NoArgsConstructor
        @EqualsAndHashCode
        @Embeddable
        public  class  MovimentacaoId implements Serializable{
            private long idMovimento;
            private long idUsuario;
        }
        @Id
        @GeneratedValue
        @EmbeddedId
        private MovimentacaoId movimentacaoId;
        private LocalDateTime dataEntrada;
        private LocalDateTime dataSaida;
        private BigDecimal periodo;
        @ManyToOne
        private Ocorrencia ocorrencia;
        @ManyToOne
        private Calendario calendario;

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
                Movimentacao that = (Movimentacao) o;

                if (!Objects.equals(movimentacaoId, that.movimentacaoId)) return false;
                return Objects.equals(movimentacaoId, that.movimentacaoId);
        }

        @Override
        public int hashCode() {
                return Objects.hashCode(movimentacaoId);
        }
}
