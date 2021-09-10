package dev.weverton.ecommerce.domain;

import dev.weverton.ecommerce.domain.enums.PagamentoStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento {
    @Id //Relacionamento 1 para 1 com Pedido, nesse caso o id será o mesmo no pedido
    private Long id;

    private Integer status;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId //Anotacao para mapear o Id
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, PagamentoStatus status, Pedido pedido) {
        this.id = id;
        this.status = status.getCod();
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PagamentoStatus getStatus() {
        return PagamentoStatus.toEnum(this.status);
    }

    public void setStatus(PagamentoStatus status) {
        this.status = status.getCod();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
