package ar.edu.utn.frba.dds;

public class ActualizacionSujerenciasDiariasPorAlerta implements AlertaMeteorologicaObserver{
  public void nuevaAlerta (AlertaMeteorologica alerta){
    MotorSugerencias motorSugerenciasActual = ProveedorDeMotor.getInstance().getMotor();

    ProveedorDeMotor.getInstance().setMotor(new MotorSugerenciasSegunClima());
    ContenedorDeGuardarropas.getINSTANCE().actualizarSujerenciaDiaria();

    ProveedorDeMotor.getInstance().setMotor(motorSugerenciasActual);

    }
}
