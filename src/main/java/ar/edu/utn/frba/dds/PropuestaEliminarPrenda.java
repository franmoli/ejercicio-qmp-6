package ar.edu.utn.frba.dds;

public class PropuestaEliminarPrenda extends PropuestaModificacionPrenda {


  public PropuestaEliminarPrenda(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  @Override
  public void aceptarPropuesta() {
    super.aceptarPropuesta();
    guardarropa.eliminarPrenda(prenda);
  }

  public void deshacerPropuesta() {
    super.deshacerPropuesta();
    guardarropa.agregarPrenda(prenda);
  }


}
