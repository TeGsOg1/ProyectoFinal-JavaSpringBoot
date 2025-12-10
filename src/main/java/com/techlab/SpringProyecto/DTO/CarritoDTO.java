package com.techlab.SpringProyecto.DTO;

import com.techlab.SpringProyecto.model.Carrito;
import com.techlab.SpringProyecto.service.CarritoService;

import java.util.List;

public class CarritoDTO {
    private Long id;
    private List<LineaPedidoDTO> productos;
    private Double total;

    public CarritoDTO(Carrito carrito, CarritoService cService) {
        this.id = carrito.getId();
        this.productos = carrito.getProductos()
                .stream()
                .map(lp -> new LineaPedidoDTO(lp, cService.getpService()))
                .toList();
        this.total = cService.obtenerTotal(carrito);
    }

    public Double getTotal() {
        return total;
    }

    public List<LineaPedidoDTO> getProductos() {
        return productos;
    }

    public Long getId() {
        return id;
    }
}
