
public class Tarefa {
    private String texto;
    private Data d1, d2;


    public Tarefa (Data d1, Data d2, String texto) {
        this.d1 = d1;
        this.d2 = d2;
        this.texto = texto;
    }

    public String toString() {
        return String.format("%s --- %s: %s", d1,d2,texto);
    }

    public String inicio() {
        return d1.toString();
    }
    public String fim() {
        return d2.toString();
    }
    public String texto() {
        return texto;
    }

}