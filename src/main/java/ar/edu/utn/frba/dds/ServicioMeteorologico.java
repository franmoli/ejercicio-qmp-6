package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioMeteorologico {
  ProveedorDeClima proveedor;
  List<String> listaDeAlertas;
  List<AlertaMeteorologicaObserver> listaDeObserver;

  public ServicioMeteorologico(ProveedorDeClima proveedor) {
    if (proveedor == null) {
      throw new NullPointerException("Proveedor no puede ser nulo");
    }
    listaDeObserver = new ArrayList<AlertaMeteorologicaObserver>();
    this.proveedor = proveedor;
  }

  public void setProveedor(ProveedorDeClima proveedor) {
    if (proveedor == null) {
      throw new NullPointerException("Proveedor no puede ser nulo");
    }
    this.proveedor = proveedor;
  }

  public ProveedorDeClima getProveedor() {
    return proveedor;
  }

  public void actualizarAlertasMeteorologicas() {

    List<AlertaMeteorologica> alertasObtenidas =
        formatearAlertaMeteorologicas(this.proveedor.obtenerAlertasMeteorologicas());


    if (!alertasObtenidas.isEmpty()) {
      alertasObtenidas.forEach(alerta -> {
        listaDeObserver.forEach(observer -> {observer.nuevaAlerta(alerta);});
      });
    }
  }

  private List<AlertaMeteorologica> formatearAlertaMeteorologicas(List<String> alertas) {
    return alertas.stream().map(this::stringToAlertaMeteorologica).toList();
  }

  private AlertaMeteorologica stringToAlertaMeteorologica(String alerta) {
    if (alerta == null) {
      throw new NullPointerException("Alerta no puede ser nulo");
    }
    return switch (alerta) {
      case "STORM" -> new AlertaMeteorologica(TipoDeAlertaMeteorologica.TORMENTA, LocalDate.now());
      case "HAIL" -> new AlertaMeteorologica(TipoDeAlertaMeteorologica.GRANIZO, LocalDate.now());
      case "WIND" -> new AlertaMeteorologica(TipoDeAlertaMeteorologica.VIENTO, LocalDate.now());
      default -> throw new IllegalArgumentException("Alerta incorrecta");
    };
  }

  public void onAlerta(AlertaMeteorologicaObserver observer) {
    listaDeObserver.add(observer);
  }


}
