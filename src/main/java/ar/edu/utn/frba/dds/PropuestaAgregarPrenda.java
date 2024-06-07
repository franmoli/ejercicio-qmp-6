package ar.edu.utn.frba.dds;

public class PropuestaAgregarPrenda extends PropuestaModificacionPrenda{

  public PropuestaAgregarPrenda(Prenda prenda, Guardarropa guardarropa) {
    this.prenda = prenda;
    this.guardarropa = guardarropa;
  }

  @Override
  public void aceptarPropuesta() {
      super.aceptarPropuesta();
      guardarropa.agregarPrenda(prenda);
  }

  @Override
  public void deshacerPropuesta() {
    super.deshacerPropuesta();
    guardarropa.eliminarPrenda(prenda);
  }


}
