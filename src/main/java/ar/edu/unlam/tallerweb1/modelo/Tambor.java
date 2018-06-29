package ar.edu.unlam.tallerweb1.modelo;

import java.util.concurrent.ThreadLocalRandom;

public class Tambor {
    protected Integer cara;
    public Tambor(){}
    public Tambor(boolean jugar) {
        if (jugar) {
            this.jugar();
        }
    }

    public Integer getCara() {
        return cara;
    }

    public void setCara(Integer cara) {
        this.cara = cara;
    }

    public void jugar() {
        this.cara = ThreadLocalRandom.current().nextInt(1, 9 + 1);
    }
}
