package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  Integer edad;
  String nombre;
  String localidad;

  public Usuario(Integer edad, String nombre, String localidad) {
    if (edad == null || nombre == null || localidad == null) {
      throw new IllegalArgumentException("Datos inválidos");
    }
    this.edad = edad;
    this.nombre = nombre;
    this.localidad = localidad;
  }
}
