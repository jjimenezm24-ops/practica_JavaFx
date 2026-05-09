package com.practica.productos.servicio;

import com.practica.productos.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {

        productos.add(p);
    }

    public List<Producto> listar() {

        return new ArrayList<>(productos);
    }

    public void eliminar(String nombre) {

        productos.removeIf(
                p -> p.getNombre().equalsIgnoreCase(nombre)
        );
    }

    public Producto buscar(String nombre) {

        for (Producto p : productos) {

            if (p.getNombre().equalsIgnoreCase(nombre)) {

                return p;
            }
        }

        return null;
    }
}