package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class ContenedorDeUsuario {
  List<Usuario> usuarioList = new ArrayList<Usuario>();

  static ContenedorDeUsuario INSTANCE = new ContenedorDeUsuario();
  static ContenedorDeUsuario getINSTANCE(){return INSTANCE;}

  public void agregarUsuario(Usuario usuario){
    usuarioList.add(usuario);
  }

  public List<Usuario> getUsuarios(){
    return usuarioList;
  }

}
