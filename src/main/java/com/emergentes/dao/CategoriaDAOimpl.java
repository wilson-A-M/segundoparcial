package com.emergentes.dao;

import com.emergentes.modelo.categoria;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;  

public abstract class CategoriaDAOimpl extends ConexionDB implements categoriaDAO {

    @Override
    public void insert(categoria categoria) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO categoria(categoria) VALUES (?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(categoria categoria) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE categorias SET categorias=? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, categoria.getCategoria());
            ps.setInt(2, categoria.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM categorias WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public categoria getById(int id) throws Exception {
        categoria categoria = new categoria();
        try {
            this.conectar();
            String sql = "SELECT * FROM categoria WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return categoria;
    }

    @Override
    public List<categoria> getAll() throws Exception {
        ArrayList<categoria> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM categorias";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                categoria categoria = new categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categorias"));
                lista.add(categoria);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
