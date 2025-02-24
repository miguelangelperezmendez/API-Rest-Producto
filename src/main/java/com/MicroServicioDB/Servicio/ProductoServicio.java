package com.MicroServicioDB.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MicroServicioDB.Modelo.Producto;

//Esta es la implementacion
//Aqui incluimos toda la logica del negocio para el CRUD
@Service
public class ProductoServicio  implements ProductoServInterface{

    //Inyectamos nuestra clase REPOSITORIO para poder implementar los metodos CRUD de Spring
    @Autowired
    private ProductoRespository repository;

    //Logica para listar todos los productos
    @Override
    @Transactional(readOnly = true)  //De spring framework, metodo de solo lectura
    public List<Producto> listarProducto() {
       return (List<Producto>)repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto productoPorId(Integer id) {
        return repository.findById(id).orElse(null); //Aqui no empleamos la clase Optional, sino que empleamos un or, para indicar una accion en caso de que no existe el valor
    }

    @Override
    public void eliminarProductoId(Integer id) {
        repository.deleteById(id); //Indicamos que va a eliminar por el Id que reciva por parametro
    }

    @Override
    public void guardarProducto(Producto producto) {
        repository.save(producto);
    }
    
}
