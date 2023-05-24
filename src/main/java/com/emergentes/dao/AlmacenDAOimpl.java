package com.emergentes.dao;

import com.emergentes.modelo.Almacen;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlmacenDAOimpl extends ConexionDB implements AlmacenDAO {

    @Override
    public void insert(Almacen almacen) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO productos(descripcion,cantidad,precio,categoria)values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, almacen.getDescripcion());
            ps.setInt(2, almacen.getCantidad());
            ps.setFloat(3, almacen.getPrecio());
            ps.setString(4, almacen.getCategoria());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Almacen almacen) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos SET descripcion=?, cantidad=?, precio=?, categoria=? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, almacen.getDescripcion());
            ps.setInt(2, almacen.getCantidad());
            ps.setFloat(3, almacen.getPrecio());
            ps.setString(4, almacen.getCategoria());
            ps.setInt(5, almacen.getId());

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
            String sql = "DELETE FROM productos WHERE id=?";
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
    public Almacen getById(int id) throws Exception {
        Almacen alm = new Almacen();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos WHERE id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alm.setId(rs.getInt("id"));
                alm.setDescripcion(rs.getString("descripcion"));
                alm.setCantidad(rs.getInt("cantidad"));
                alm.setPrecio(rs.getFloat("precio"));
                alm.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return alm;
    }

    @Override
    public List<Almacen> getAll() throws Exception {
        ArrayList<Almacen> lista = new ArrayList<Almacen>();
        try {
            this.conectar();
            String sql = "SELECT * FROM productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Almacen alm = new Almacen();

                alm.setId(rs.getInt("id"));
                alm.setDescripcion(rs.getString("descripcion"));
                alm.setCantidad(rs.getInt("cantidad"));
                alm.setPrecio(rs.getFloat("precio"));
                alm.setCategoria(rs.getString("categoria"));

                lista.add(alm);
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
