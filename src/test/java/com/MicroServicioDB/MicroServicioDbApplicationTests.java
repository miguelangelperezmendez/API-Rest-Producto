package com.MicroServicioDB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.MicroServicioDB.Modelo.Producto;
import com.MicroServicioDB.Servicio.ProductoRespository;
import com.MicroServicioDB.Servicio.ProductoServicio;
import com.MicroServicioDB.TesteoServicio.DatosDePrueba;

@SpringBootTest
class MicroServicioDbApplicationTests {


	@Mock
    private ProductoRespository repository;
    
    @InjectMocks
    private ProductoServicio producto;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this); // Esto indica que las anotaciones se estan habilitando para poder utilizarlas
    }

	//PROBANDO LISTAR TODOS
    @Test
    public void listAllTest(){

        //GIVE

        //WHEN
        when (repository.findAll()).thenReturn(DatosDePrueba.todosLosDatos());

		//MANDAMOS A LLAMAR AL METODO QUE DESEAMOS TESTEAR
		List<Producto> resultados = producto.listarProducto();
        //THEN
		assertNotNull(resultados);
		assertFalse(resultados.isEmpty());
		assertEquals("Shampoo", resultados.get(0).getName());
    }

	@Test
	public void listById(){
			//GIVE
		Integer id = 1;

			//WHEN
		when(repository.findById(id)).thenReturn(DatosDePrueba.porId(id));

		Producto resultado =  producto.productoPorId(id);

			//THEN
		assertNotNull(resultado);
		assertEquals("Durazno", resultado.getName());
		assertEquals(30.2, resultado.getPrecio());
	}


	//ESTE METODO YA ESTABA EN SPRING POR DEFECTO
	@Test
	void contextLoads() {
	}

}
