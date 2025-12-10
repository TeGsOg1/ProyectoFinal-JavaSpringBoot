package com.techlab.SpringProyecto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double precio;
    private Integer stock;
    private String descripcion;
    private String categoria;
    private String URL;

    public Producto() {}
    public Producto(String nombre, Double precio, Integer stock, String categoria, String descripcion, String URL) {
        this.stock = stock;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.URL = URL;
    }

    public Integer getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getURL() {
        return URL;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getstock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            return;
        }
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null ) return;
        this.descripcion = descripcion;
    }

    public void setStock(Integer stock) {
        if (stock < 0 ) {
            return;
        }
        this.stock = stock;
    }

    public void setPrecio(Double precio) {
        if ( precio < 0 ) {
            return;
        }
        this.precio = precio;
    }

    public void setURL(String URL) {
        if ( URL == null) {
            return;
        }
        this.URL = URL;
    }

    public void setCategoria(String categoria) {
        if (categoria == null ) {
            return;
        }
        this.categoria = categoria;
    }
}
