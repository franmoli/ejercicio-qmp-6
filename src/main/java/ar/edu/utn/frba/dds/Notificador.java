package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Notificador {

  static Notificador INSTANCE = new Notificador();
  static Notificador getINSTANCE(){return INSTANCE;}

  MailSender mailSender;
  NotificationService notificationService;

  public void setMailSender(MailSender mailSender) {
    this.mailSender = mailSender;
  }
  public void setNotificationService(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  public void enviarMail(String destinatario, String mensaje){
    mailSender.send(destinatario, mensaje);
  }

  public void enviarNotificacion( String mensaje){
    notificationService.notify(mensaje);
  }
}
