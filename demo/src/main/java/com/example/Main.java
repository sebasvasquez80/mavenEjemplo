package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Entidad.Empleado;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        // crearEmpleado("Juan", 30);
        Empleado empleado = leerEmpleado(2L); // Cambiado a 1L para que sea Long
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado.getNombre() + ", Edad: " + empleado.getEdad());
        }

        em.close();
        emf.close();
    }

// Método para crear un nuevo empleado
//     public static void crearEmpleado(String nombre, int edad) {
//         EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
//         EntityManager em = emf.createEntityManager();
//         em.getTransaction().begin();
//         Empleado empleado = new Empleado();
//         empleado.setNombre(nombre);
//         empleado.setEdad(edad);
//         em.persist(empleado);
//         em.getTransaction().commit();
//         em.close();
//     }
    public static Empleado leerEmpleado(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();
        Empleado empleado = em.find(Empleado.class, id);
        em.close();
        return empleado;
    }
}
