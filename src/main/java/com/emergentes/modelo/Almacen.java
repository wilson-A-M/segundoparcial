package com.emergentes.modelo;


public class Almacen {
    private int id;
    private String descripcion;
    private int cantidad;
    private float precio;
    private int categoria;
    
    public Almacen(){
        id = 0;
        descripcion = "";
        cantidad = 0;
        precio = 0;
        categoria = 0 ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Almacen{" + "id=" + id + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", precio=" + precio + ", categoria=" + categoria + '}';
    }
    
    
    
    
}
