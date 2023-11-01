
package com.emergentes.modelo;

/**
 *
 * @author WILSON ALANOCA MENA
 */
public class categoria {
    private int id;
    private String categoria;
    
     public categoria(){
        id = 0;
        categoria="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
