package ar.edu.utn.frba.dds;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Guardarropa {
  public List<Prenda> prendas = new ArrayList<Prenda>();
  public ProveedorDeMotor proveedor;
  public ServicioMeteorologico managerClima;
  public Usuario owner;
  public List<Usuario> usuarios = new ArrayList<Usuario>();
  public List<PropuestaModificacionPrenda> propuestas = new ArrayList<>();
  public Atuendo sugerenciaDiaria;


  public Guardarropa(Usuario owner, ProveedorDeMotor proveedor,
                     ServicioMeteorologico managerClima) {
    if (owner == null || proveedor == null || managerClima == null) {
      throw new NullPointerException("No se puede crear un guardarropas con usuario o proveedor "
          + "nulos");
    }
    this.owner = owner;
    this.proveedor = proveedor;
    this.managerClima = managerClima;
  }


  public void agregarPrenda(Prenda prenda) {
    if (this.prendaValida(prenda)) {
      prendas.add(prenda);
    }
  }

  public void eliminarPrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public List<Atuendo> generarSugerencias(Usuario usuario) {
    if (usuario == null ^ (!usuario.equals(owner) &&
        usuarios.stream().noneMatch(u -> u.equals(usuario)))
    ) {
      throw new RuntimeException("Usuario invalido");
    }
    BigDecimal temperatura = managerClima.getProveedor().getTemperatura(usuario.localidad);
    return this.proveedor.motorSugerencias.generarSugerencias(prendas, usuario, temperatura);
  }

  private boolean prendaValida(Prenda prenda) {
    if (prenda == null) {
      return false;
    }

    return (prenda.material != null && prenda.colorPrincipal != null && prenda.trama != null);
  }

  public void aniadirPropuesta(PropuestaModificacionPrenda propuesta) {
    this.propuestas.add(propuesta);
  }

  public void compartirGuardarropaCon(Usuario usuario) {
    usuarios.add(usuario);
  }

  public void actualizarSujerenciaDiaria() {
    Random random = new Random();
    List<Atuendo> listaDeSugerencias = this.generarSugerencias(owner);
    int randomIndex = random.nextInt(listaDeSugerencias.size());
    this.sugerenciaDiaria = listaDeSugerencias.get(randomIndex);
  }
}
