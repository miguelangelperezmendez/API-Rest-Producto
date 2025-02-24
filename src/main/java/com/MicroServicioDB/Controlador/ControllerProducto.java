package com.MicroServicioDB.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.MicroServicioDB.Modelo.Producto;
import com.MicroServicioDB.Servicio.ProductoServicio;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {
     
@Autowired
private ProductoServicio servicio;

    // ENDPOINT http://localhost:7370/producto/all
    @GetMapping("/all")
    public @ResponseBody List<Producto> ListarProductos(){
        
        return servicio.listarProducto();
    }

    // ENPOINT http://localhost:7370/producto/2
    @GetMapping("/{id}")
    public @ResponseBody Producto ObtenerProductoId(@PathVariable Integer id){
        return servicio.productoPorId(id);
    }

    // ENDPOINT http://localhost:7370/producto/5
    @DeleteMapping("/{id}")
    public void EliminarProducto(@PathVariable Integer id){
        servicio.eliminarProductoId(id);
    }

    // JSON: {"name":"Televisor", "model":"Panasonic", "descripcion":"Para ver peliculas"}
    // ENDPOINT http://localhost:7370/producto/
    @PostMapping("/")
    public void guardarProducto(@RequestBody Producto producto){
        servicio.guardarProducto(producto);
    }
}
