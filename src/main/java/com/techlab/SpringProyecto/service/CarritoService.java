package com.techlab.SpringProyecto.service;

import com.techlab.SpringProyecto.Exceptions.ProductoNoEncontradoException;
import com.techlab.SpringProyecto.Exceptions.StockInsuficienteException;
import com.techlab.SpringProyecto.model.Carrito;
import com.techlab.SpringProyecto.model.LineaPedido;
import com.techlab.SpringProyecto.model.Producto;
import com.techlab.SpringProyecto.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {
    private Carrito carritoAct;

    private ProductoService pService;

    private final CarritoRepository repo;
    @Autowired
    public CarritoService(ProductoService pService, CarritoRepository repo) {
        this.pService = pService;
        this.repo = repo;
        this.carritoAct = new Carrito();
    }


    public Carrito añadirAlCarro(Integer id, Integer cant) {
        if (cant <= 0) throw new RuntimeException("La cantidad ingresada es invalida!");

        Producto p = pService.buscarPorId(id);

        if (p == null) throw new ProductoNoEncontradoException("El producto ingresado no existe!");
        if (!restarStock(p, cant)) throw new StockInsuficienteException("El stock solicitado es menor al disponible");

        for (LineaPedido c : carritoAct.getProductos()) {
            if (c.getIdProd().equals(p.getId())) {
                c.setCant(c.getCant() + cant);
                carritoAct = repo.save(carritoAct);
                return carritoAct;
            }
        }

        carritoAct.getProductos().add(new LineaPedido(id, cant));
        carritoAct = repo.save(carritoAct);
        return carritoAct;
    }

    public boolean restarStock(Producto p, Integer stock){
        if(p == null) return false;
        if (p.getstock() < stock) return false;
        p.setStock(p.getstock() - stock);
        return true;
    }

    public Carrito confirmarCarrito() {
        carritoAct = repo.save(carritoAct);
        carritoAct = repo.save(new Carrito());
        return carritoAct;
    }

    public Carrito mostrarCarritoAct() {
        return carritoAct;
    }

    public List<Carrito> mostrarCarritos() {
        return repo.findAll();
    }

    public Carrito eliminarDelCarrito(Integer id) {
        // Buscar la línea de pedido directamente
        LineaPedido linea = null;
        for (LineaPedido lp : carritoAct.getProductos()) {
            if (lp.getIdProd().equals(id)) {
                linea = lp;
                break;
            }
        }

        if (linea == null) {
            throw new ProductoNoEncontradoException("No se encontró el producto!");
        }

        Integer stockRec = linea.getCant();

        carritoAct.getProductos().remove(linea);

        // Devolver stock al producto
        Producto producto = pService.buscarPorId(id);
        producto.setStock(producto.getstock() + stockRec);
        pService.actualizar(id, producto);

        return repo.save(carritoAct);
    }

    public ProductoService getpService(){
        return pService;
    }

    public Double obtenerTotal(Carrito carrito) {
        double total = 0.0;
        for (LineaPedido lp : carrito.getProductos()) {
            Producto p = pService.buscarPorId(lp.getIdProd());
            total += lp.getCant() * p.getPrecio();
        }
        return total;
    }

}
