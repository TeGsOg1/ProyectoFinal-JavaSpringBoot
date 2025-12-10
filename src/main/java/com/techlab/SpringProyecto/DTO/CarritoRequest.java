package com.techlab.SpringProyecto.DTO;

public class CarritoRequest {
    private Integer id;
    private Integer cant;

     public CarritoRequest(Integer id, Integer cant){
         this.id = id;
         this.cant = cant;
     }

    public Integer getCant() {
        return cant;
    }

    public Integer getId() {
        return id;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
