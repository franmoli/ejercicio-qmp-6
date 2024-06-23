package ar.edu.utn.frba.dds;

public class NotificarLlevarParaguas implements AlertaMeteorologicaObserver{
  public void nuevaAlerta (AlertaMeteorologica alerta){
    if( alerta.getTipo() == TipoDeAlertaMeteorologica.TORMENTA){
      Notificador.getINSTANCE().enviarNotificacion("Lleva paraguas");
    }
  }
}
