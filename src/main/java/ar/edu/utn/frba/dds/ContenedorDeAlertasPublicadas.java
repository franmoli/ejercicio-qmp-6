package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class ContenedorDeAlertasPublicadas {
  List<AlertaMeteorologica> alertasList = new ArrayList<AlertaMeteorologica>();
  static ContenedorDeAlertasPublicadas INSTANCE = new ContenedorDeAlertasPublicadas();

  static ContenedorDeAlertasPublicadas getINSTANCE(){return INSTANCE;}

  public void publicarAlerta(AlertaMeteorologica alerta){
    alertasList.add(alerta);
  }
}
