package ar.edu.utn.frba.dds;

import java.util.List;

public class ContenedorDeGuardarropas {
  List<Guardarropa> guardarropaList;
  static ContenedorDeGuardarropas INSTANCE = new ContenedorDeGuardarropas();


  void actualizarSujerenciaDiaria(){
   for(Guardarropa guardarropa : guardarropaList){
      guardarropa.actualizarSujerenciaDiaria();
    }
  }

  static ContenedorDeGuardarropas getINSTANCE(){return INSTANCE;}

}
