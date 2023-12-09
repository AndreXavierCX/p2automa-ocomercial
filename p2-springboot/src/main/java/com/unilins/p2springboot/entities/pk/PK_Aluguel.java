package com.unilins.p2springboot.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.unilins.p2springboot.entities.Carro;
import com.unilins.p2springboot.entities.Cliente;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PK_Aluguel implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Carro carro;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carro, cliente);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PK_Aluguel that = (PK_Aluguel) obj;
        return Objects.equals(carro, that.carro) && Objects.equals(cliente, that.cliente);
    }
}
