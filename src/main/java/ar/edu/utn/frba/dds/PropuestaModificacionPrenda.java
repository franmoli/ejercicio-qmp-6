package ar.edu.utn.frba.dds;

public abstract class PropuestaModificacionPrenda {
  public Prenda prenda;
  public Guardarropa guardarropa;
  public EstadoPropuesta estado = EstadoPropuesta.PENDIENTE;

  public void aceptarPropuesta(){
      estado = EstadoPropuesta.ACEPTADA;
  };

  public void rechazarPropuesta(){
    estado = EstadoPropuesta.RECHAZADA;
  }

  public void deshacerPropuesta(){
    if(estado != EstadoPropuesta.ACEPTADA){
      throw new RuntimeException("No se puede deshacer una operacion que no se acepto");
    }else {
      estado = EstadoPropuesta.RECHAZADA;
    }
  }
}
