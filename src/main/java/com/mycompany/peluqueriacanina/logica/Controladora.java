package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String nombreDuenio, String celu, String observacines, String alergico, String atenEsp) {

        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celu);

        Mascota masco = new Mascota();
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        masco.setObservaciones(observacines);
        masco.setUnDuenio(duenio);

        controlPersis.guardar(duenio, masco);

    }

    public List<Mascota> traerMascotas() {

        return controlPersis.traerMascotas();

    }

    public void borrarMacota(int num_cliente) {
        controlPersis.BorrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza,
            String color, String nombreDuenio, String celu, String observacines,
            String alergico, String atenEsp) {
            
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observacines);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atenEsp);
        
        controlPersis.modificarMascota(masco);
        
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getIdDuenio());
        
        dueno.setCelDuenio(celu);
        dueno.setNombre(nombreDuenio);
        
        this.modificarDueño(dueno);
        
    }

    private Duenio buscarDuenio(int idDuenio) {
        return controlPersis.traerDuenio(idDuenio);
    }

    private void modificarDueño(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

}
