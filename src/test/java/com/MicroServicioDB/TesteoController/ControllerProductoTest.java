package com.MicroServicioDB.TesteoController;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.MicroServicioDB.Controlador.ControllerProducto;
import com.MicroServicioDB.Modelo.Producto;
import com.MicroServicioDB.Servicio.ProductoServicio;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class) // 
public class ControllerProductoTest {

    private MockMvc mockMvc; //ESTE METODO ES PARA CREAR SIMULACIONES DE PETICIOONES HTTP

    @Mock // OBJETO SIMULADO, (DEPENDENCIA)
    private ProductoServicio productoServicio;

    @InjectMocks //CLASE QUE VAMOS A PROBAR, Y A LA QUE SE LE INYECTARAN LAS DEPENDENCIAS
    private ControllerProducto controllerProducto;

    @BeforeEach //INDICA QUE ESTA CLASE SE DEBE EJECUTAR ANTES DE CADA PRUEBA
    void setUp() { //Configuracion: 
        mockMvc = MockMvcBuilders.standaloneSetup(controllerProducto).build(); //Indica que se probará unicamenre el controlador, para evitar cargar el resto del contexto de la aplicacion
    }

    @Test
    public void testListarProductos() throws Exception {
        //  Datos de prueba:
        Producto producto1 = new Producto(1, "Product1", "Model1", "Description1", 10.0);
        Producto producto2 = new Producto(2, "Product2", "Model2", "Description2", 20.0);
        //GIVEN:
        //Productos almacenados en una lista
        List<Producto> productos = Arrays.asList(producto1, producto2);

        //WHEN
        when(productoServicio.listarProducto()).thenReturn(productos); //Cuando se manda a llamar al servicio, en su lugar se retorna la lista de productos de prueba

        mockMvc.perform(MockMvcRequestBuilders.get("/producto/all") //Esta es la URL real del endpoint despues numero del puerto
                .contentType(MediaType.APPLICATION_JSON)) //Esto indica que se va a trabajar con formato JSON
                .andExpect(MockMvcResultMatchers.status().isOk()) //Indica que se espera un codigo 200 OK, que fue un exito
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1)) //Aqui indicamos el valor esperadp
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Product1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Product2")); //En todas estas se especifica el valor esperadp

        verify(productoServicio, times(1)).listarProducto(); //Comprueba que el metodo listarProducto se halla llamado una sola vez, de acuerdo al numero que indicamos
        verifyNoMoreInteractions(productoServicio); //Verifica que no haya habido mas interacciones con el Mock "productoServicio"
    }



    @Test
    public void seleccioonaPorId(){
        //Dato de prueba
        Producto producto1 = new Producto(1, "Product1", "Model1", "Description1", 10.0);

        //GIVEN:
        Integer id = 1;        

        //WHEN:
        when(productoServicio.productoPorId(id)).thenReturn(producto1);

        //THEN:
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/producto/{id}", id)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(producto1.getName()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

