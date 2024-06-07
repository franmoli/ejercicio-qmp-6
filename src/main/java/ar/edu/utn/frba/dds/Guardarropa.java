package ar.edu.utn.frba.dds;

import com.google.common.collect.Sets;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Guardarropa {
  public List<Prenda> prendas = new ArrayList<Prenda>();
  public ProveedorDeMotor proveedor;
  public ManagerProveedorClima managerClima;
  public Usuario owner;
  public List<Usuario> usuarios;
  public List<PropuestaModificacionPrenda> propuestas = new ArrayList<>();

  public Guardarropa(Usuario owner, ProveedorDeMotor proveedor,
                     ManagerProveedorClima managerClima) {
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
    if (usuario == null || usuarios.stream().noneMatch(u -> u.equals(usuario)) ||
        !usuario.equals(owner)) {
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

  public void compartirGuardarropaCon(Usuario usuario){
    usuarios.add(usuario);
  }

}
