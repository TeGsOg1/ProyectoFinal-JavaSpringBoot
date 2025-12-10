package com.techlab.SpringProyecto.DTO;

import com.techlab.SpringProyecto.model.LineaPedido;
import com.techlab.SpringProyecto.model.Producto;
import com.techlab.SpringProyecto.service.ProductoService;

public class LineaPedidoDTO {
    private Integer idProd;
    private String nombre;
    private Double precio;
    private Integer cant;
    private String imagen;

    public LineaPedidoDTO(LineaPedido lp, ProductoService pService) {
        Producto p = pService.buscarPorId(lp.getIdProd());
        this.idProd = lp.getIdProd();
        this.nombre = p.getNombre();
        this.precio = p.getPrecio();
        this.imagen = p.getURL();
        this.cant = lp.getCant();
    }

    public Integer getCant() {
        return cant;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public String getImagen() {
        return imagen;
    }
}
