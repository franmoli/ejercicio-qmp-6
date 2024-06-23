package ar.edu.utn.frba.dds;

import java.util.List;
import java.math.BigDecimal;

public interface ProveedorDeClima {
  BigDecimal getTemperatura(String localidad);
  List<String> obtenerAlertasMeteorologicas();
}
