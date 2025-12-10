package com.techlab.SpringProyecto.repository;

import com.techlab.SpringProyecto.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {}