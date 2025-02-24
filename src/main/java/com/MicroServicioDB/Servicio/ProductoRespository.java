package com.MicroServicioDB.Servicio;

import org.springframework.data.repository.CrudRepository;

import com.MicroServicioDB.Modelo.Producto;

public interface ProductoRespository extends CrudRepository<Producto, Integer>{ //Tambien puede extender de JPARepository, de echo esta es mas completa, ya que tambien implementa la paginacion

    //Esta clase implementa todos los metodos CRUD que nos provee Spring para no programarlos de nuevo, 
    //implementamos los que nos brinda por defecto
    
}
