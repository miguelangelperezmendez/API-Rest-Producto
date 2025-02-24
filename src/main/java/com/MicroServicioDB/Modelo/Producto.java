package com.MicroServicioDB.Modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//DESCIPCION: DESARROLLO DE API TIPO MVC: MODELO, CONTROLLER, SERVICIO, DAO. ESTA APP REALIZA UN CRUD COMPLETO Y FUNCIONAL CON 5 DEPENDENCIAS
//            EL CODIGO ES MAS SENCILLO PERO FUNCIONA A LA PERFECCION
// NOS BASAMOS EN EL ESTE TUTORIAL PARA SU DESARROLLO: https://youtu.be/Z_VXoDhmDPU?si=y3QmC_2E_f4IisqV


//Estas Anotaciones se cargan de JPA
@Entity
@Table(name = "producto2") //Este será en nombre de nuestra tabla en Oracle, la cual se va a crear automaticamnete
public class Producto implements Serializable{ // Implementamos la interfaz Seriablizable que nos ayuda a trabajar en lo web

    @Id  // De JPA, indica que es nuestra primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Indicamos que nuestro id es autoincrementable
    private Integer id;
    private String name;
    private String model;
    private String descripcion;
    private double precio;

    //CONSTRUCTORES
    public Producto() {
    }
    public Producto(Integer id, String name, String model, String descripcion, double precio) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //GETTERS Y SETTERS
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
   
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
