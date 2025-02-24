package com.MicroServicioDB.Servicio;

import java.util.List;

import com.MicroServicioDB.Modelo.Producto;

public interface ProductoServInterface {
    List<Producto> listarProducto();
    Producto productoPorId(Integer id);
    void eliminarProductoId(Integer id);
    void guardarProducto(Producto producto);
    
}
