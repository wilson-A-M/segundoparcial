package com.emergentes.dao;
import com.emergentes.modelo.categoria;
import java.util.List;

public interface categoriaDAO {
    public void insert(categoria almacen) throws Exception;
    public void update(categoria almacen) throws Exception;
    public void delete(int id) throws Exception;
    public categoria getById(int id) throws Exception;
    public List<categoria> getAll() throws Exception;
}

