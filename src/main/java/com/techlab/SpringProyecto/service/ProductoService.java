package com.techlab.SpringProyecto.service;

import com.techlab.SpringProyecto.model.Producto;
import com.techlab.SpringProyecto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> obtenerTodos() {
        return repo.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Producto crearProducto(Producto producto) {
        return repo.save(producto);
    }

    public Producto actualizar(Integer id, Producto datos) {
        Producto p = buscarPorId(id);
        if (p != null) {
            p.setNombre(datos.getNombre());
            p.setCategoria(datos.getCategoria());
            p.setURL(datos.getURL());
            p.setPrecio(datos.getPrecio());
            p.setStock(datos.getstock());
            return repo.save(p);
        }
        return null;
    }

    public boolean eliminar(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}