package com.MicroServicioDB.TesteoServicio;

import java.util.List;
import java.util.Optional;

import com.MicroServicioDB.Modelo.Producto;

public class DatosDePrueba {

    public static List<Producto> playerListMock(){

        //ESTA ES MI BASE DE DATOS DE PRUEBA (MOCK)
        System.out.println("- > Obteniendo listado de Jugadores / Mock");

        return List.of(
            new Producto(3, "Shampoo", "Sedal", "Shampoo de 100 ml", 40.5),
            new Producto(4, "Durazno", "Campo", "Precio por kilo", 30.2),
            new Producto(5, "Playera", "Contempo", "Talla chica", 200),
            new Producto(6, "Cepillo de dientes", "Colgate", "Cerdas suaves", 100)
        );
    }

    public static List<Producto> todosLosDatos (){
        return DatosDePrueba.playerListMock();
    }

    public static Optional<Producto> porId(Integer num){
        Producto producto = DatosDePrueba.playerListMock().get(num);
        return Optional.ofNullable(producto);
    }

    
}
