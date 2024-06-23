package ar.edu.utn.frba.dds;

import java.math.BigDecimal;
import java.util.List;

public class ProveedorDeClimaMock  implements ProveedorDeClima{
  BigDecimal temperatura;

  public BigDecimal getTemperatura(String localidad) {
    return temperatura;
  }

  public List<String> obtenerAlertasMeteorologicas() {
    return List.of("STORM", "HAIL");
  }

  public void setTemperatura(BigDecimal temperatura) {
    this.temperatura = temperatura;
  }



}
