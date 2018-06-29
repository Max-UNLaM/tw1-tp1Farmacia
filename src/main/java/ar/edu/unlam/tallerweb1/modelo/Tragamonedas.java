package ar.edu.unlam.tallerweb1.modelo;


public class Tragamonedas {

    protected Tambor tamborUno;
    protected Tambor tamborDos;
    protected Tambor tamborTres;

    public Tragamonedas() {
        this.tamborUno = new Tambor();
        this.tamborDos = new Tambor();
        this.tamborTres = new Tambor();

    }

    public Tragamonedas(Tambor T1, Tambor T2, Tambor T3){
        tamborUno = T1;
        tamborDos = T2;
        tamborTres = T3;
    }

    public void girarTambores() {
        this.tamborUno.jugar();
        this.tamborDos.jugar();
        this.tamborTres.jugar();
    }

    public Boolean obtenerPremio() {
        return (this.tamborUno.getCara().equals(this.tamborDos.getCara()) && this.tamborUno.getCara().equals(this.tamborTres.getCara()));
    }


    public Tambor getTamborUno() {
        return tamborUno;
    }

    public void setTamborUno(Tambor tamborUno) {
        this.tamborUno = tamborUno;
    }

    public Tambor getTamborDos() {
        return tamborDos;
    }

    public void setTamborDos(Tambor tamborDos) {
        this.tamborDos = tamborDos;
    }

    public Tambor getTamborTres() {
        return tamborTres;
    }

    public void setTamborTres(Tambor tamborTres) {
        this.tamborTres = tamborTres;
    }
}
