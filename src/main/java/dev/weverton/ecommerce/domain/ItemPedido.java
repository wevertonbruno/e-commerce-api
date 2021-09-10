package dev.weverton.ecommerce.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
public class ItemPedido {
    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidadde;
    private Double preco;

    public ItemPedido(){}

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidadde, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidadde = quantidadde;
        this.preco = preco;
    }

    @JsonIgnore
    public Pedido getPedido(){ return id.getPedido(); }

    public Produto getProduto(){ return id.getProduto(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
