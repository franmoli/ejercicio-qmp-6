package ar.edu.utn.frba.dds;

public class NotificarEvitarAuto implements AlertaMeteorologicaObserver{
    public void nuevaAlerta (AlertaMeteorologica alerta){
    if( alerta.getTipo() == TipoDeAlertaMeteorologica.GRANIZO){
        Notificador.getINSTANCE().enviarNotificacion("No salgas con el auto");
      }
    }
}
