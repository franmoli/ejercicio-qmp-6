package ar.edu.utn.frba.dds;

import java.time.LocalDate;

public class AlertaMeteorologica {
  TipoDeAlertaMeteorologica tipoDeAlertaMeteorologica;
  LocalDate fechaDeAlerta;
  public AlertaMeteorologica(TipoDeAlertaMeteorologica tipo, LocalDate fechaDeAlerta) {
    tipoDeAlertaMeteorologica = tipo;
    this.fechaDeAlerta = fechaDeAlerta;
  }

  public TipoDeAlertaMeteorologica getTipo() {
    return tipoDeAlertaMeteorologica;
  }

  public LocalDate getFechaDeAlerta() {
    return fechaDeAlerta;
  }
}
