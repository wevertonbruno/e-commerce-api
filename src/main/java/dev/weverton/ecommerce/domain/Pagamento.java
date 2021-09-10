package dev.weverton.ecommerce.domain;

import dev.weverton.ecommerce.domain.enums.PagamentoStatus;

import java.util.Objects;

public class Pagamento {
    private Long id;
    private PagamentoStatus status;

    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, PagamentoStatus status, Pedido pedido) {
        this.id = id;
        this.status = status;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PagamentoStatus getStatus() {
        return status;
    }

    public void setStatus(PagamentoStatus status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
