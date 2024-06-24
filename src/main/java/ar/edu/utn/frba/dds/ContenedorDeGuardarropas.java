package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class ContenedorDeGuardarropas {
  List<Guardarropa> guardarropaList = new ArrayList<Guardarropa>();
  static ContenedorDeGuardarropas INSTANCE = new ContenedorDeGuardarropas();


  void actualizarSujerenciaDiaria(){
   for(Guardarropa guardarropa : guardarropaList){
      guardarropa.actualizarSujerenciaDiaria();
    }
  }
  static ContenedorDeGuardarropas getINSTANCE(){return INSTANCE;}

  public void agregarGuardarropa(Guardarropa guardarropa) {
    guardarropaList.add(guardarropa);
  }
}
