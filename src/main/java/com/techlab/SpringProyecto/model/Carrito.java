package com.techlab.SpringProyecto.model;

import com.techlab.SpringProyecto.service.ProductoService;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "carrito_productos", joinColumns = @JoinColumn(name = "carrito_id"))
    private List<LineaPedido> productos = new ArrayList<>();

    public Carrito() {}

    public Long getId() {
        return id;
    }

    public List<LineaPedido> getProductos() {
        return productos;
    }

}