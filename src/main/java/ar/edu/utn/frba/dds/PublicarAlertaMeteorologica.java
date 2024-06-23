package ar.edu.utn.frba.dds;

public class PublicarAlertaMeteorologica implements AlertaMeteorologicaObserver{
    public void nuevaAlerta (AlertaMeteorologica alerta){
      ContenedorDeAlertasPublicadas.getINSTANCE().publicarAlerta(alerta);
    }
}
