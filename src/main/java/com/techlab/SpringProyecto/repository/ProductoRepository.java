package com.techlab.SpringProyecto.repository;

import com.techlab.SpringProyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
