package com.techlab.SpringProyecto.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class LineaPedido {
    private Integer cant;
    private Integer idProd;

    public LineaPedido() {}

    public LineaPedido(Integer productoId, Integer cant) {
        this.idProd = productoId;
        this.cant = cant;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public Integer getIdProd() {
        return idProd;
    }
}
