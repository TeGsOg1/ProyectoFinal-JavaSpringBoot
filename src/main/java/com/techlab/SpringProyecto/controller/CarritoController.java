package com.techlab.SpringProyecto.controller;

import com.techlab.SpringProyecto.DTO.CarritoDTO;
import com.techlab.SpringProyecto.DTO.CarritoRequest;
import com.techlab.SpringProyecto.model.Carrito;
import com.techlab.SpringProyecto.model.Producto;
import com.techlab.SpringProyecto.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "http://localhost:4321")
public class CarritoController {
    private final CarritoService cService;

    @Autowired

    public CarritoController(CarritoService cService) {
        this.cService = cService;
    }

    @GetMapping("/confirmados")
    public ResponseEntity<List<CarritoDTO>> carritosConfirmados() {
        List<Carrito> carritos = cService.mostrarCarritos();
        List<CarritoDTO> dtos = carritos.stream()
                .map(c -> new CarritoDTO(c, cService))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping
    public ResponseEntity<CarritoDTO> mostrarCarritoAct() {
        Carrito carrito = cService.mostrarCarritoAct();
        return ResponseEntity.ok(new CarritoDTO(carrito, cService));
    }

    @PostMapping("/producto")
    public ResponseEntity<Carrito> añadirAlCarrito(@RequestBody CarritoRequest request) {
        return ResponseEntity.ok(cService.añadirAlCarro(request.getId(), request.getCant()));
    }

    @PostMapping("/confirmar")
    public ResponseEntity confirmarCarrito() {
        return ResponseEntity.ok(cService.confirmarCarrito());
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity eliminarDelCarrito(@PathVariable Integer id) {
        return ResponseEntity.ok(cService.eliminarDelCarrito(id));
    }

}
