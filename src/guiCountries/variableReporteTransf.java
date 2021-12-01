/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCountries;

/**
 *
 * @author JJ
 */
public class variableReporteTransf {
    
    String usuario;
    String paisdestino;
    String tipoenvio;
    String monedaenvio;
    int montoenv;
    int tarifdest;
    int tarifserv;
    int tottransf;
    String fecha;

    public String getPaisdestino() {
        return paisdestino;
    }

    public String getTipoenvio() {
        return tipoenvio;
    }

    public int getMontoenv() {
        return montoenv;
    }

    public int getTarifdest() {
        return tarifdest;
    }

    public int getTarifserv() {
        return tarifserv;
    }

    public int getTottransf() {
        return tottransf;
    }

    public void setPaisdestino(String paisdestino) {
        this.paisdestino = paisdestino;
    }

    public void setTipoenvio(String tipoenvio) {
        this.tipoenvio = tipoenvio;
    }

    public void setMontoenv(int montoenv) {
        this.montoenv = montoenv;
    }

    public void setTarifdest(int tarifdest) {
        this.tarifdest = tarifdest;
    }

    public void setTarifserv(int tarifserv) {
        this.tarifserv = tarifserv;
    }

    public void setTottransf(int tottransf) {
        this.tottransf = tottransf;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonedaenvio() {
        return monedaenvio;
    }

    public void setMonedaenvio(String monedaenvio) {
        this.monedaenvio = monedaenvio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
        
}
