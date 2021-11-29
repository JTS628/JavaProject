/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCountries;

public class tablaTarifa {
    
    String Pais;
    String Moneda;
    int techo1;
    int techo2;
    int techo3;
    int techo4;
    
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public void setTecho1(int techo1) {
        this.techo1 = techo1;
    }

    public void setTecho2(int techo2) {
        this.techo2 = techo2;
    }

    public void setTecho3(int techo3) {
        this.techo3 = techo3;
    }

    public void setTecho4(int techo4) {
        this.techo4 = techo4;
    }


    public String getPais() {
        return Pais;
    }

    public int getTecho1() {
        return techo1;
    }

    public int getTecho2() {
        return techo2;
    }

    public int getTecho3() {
        return techo3;
    }

    public int getTecho4() {
        return techo4;
    }
    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }

    public String getMoneda() {
        return Moneda;
    }
}

