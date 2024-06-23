package ar.edu.utn.frba.dds;

import java.util.List;

public class EnviarMailPorAlerta implements AlertaMeteorologicaObserver {
  public void nuevaAlerta(AlertaMeteorologica alerta) {
    enviarMailAlerta(alerta);
  }

  private void enviarMailAlerta(AlertaMeteorologica alerta) {
    String mensaje;
    switch (alerta.getTipo()) {
      case GRANIZO -> mensaje = "Se recibio una alerta de granizo";
      case VIENTO -> mensaje = "Se recibio una alerta de viento";
      case TORMENTA -> mensaje = "Se recibio una alerta de tormenta";
      default -> mensaje = "Se recibio una alerta";
    }

    List<Usuario> usuarios = ContenedorDeUsuario.getINSTANCE().getUsuarios();
    usuarios.forEach(usuario -> Notificador.getINSTANCE().enviarMail(usuario.getEmail(), mensaje));

  }
}
