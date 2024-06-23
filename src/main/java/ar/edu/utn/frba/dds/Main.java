package ar.edu.utn.frba.dds;

import java.math.BigDecimal;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Guardarropa guardarropa;
    ProveedorDeClimaMock proveedorDeClima;
    Prenda musculosa;
    Prenda camisa;
    Prenda jean;
    Prenda shorts;
    Prenda zapatos;
    Prenda ojotas;

    proveedorDeClima = new ProveedorDeClimaMock();
    ServicioMeteorologico servicioMeteorologico = new ServicioMeteorologico(proveedorDeClima);
    Usuario usuario =
        new Usuario(34, "Juan Carlos", "Buenos Aires, Argentina", "juancito@gmail.com");
    MotorSugerenciasSegunClima motor = new MotorSugerenciasSegunClima();
    ProveedorDeMotor proveedorDeMotor = new ProveedorDeMotor();
    proveedorDeMotor.setMotor(motor);
    guardarropa = new Guardarropa(usuario, proveedorDeMotor, servicioMeteorologico);



  }
}