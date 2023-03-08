package modelo;

public abstract class Modelo implements Cloneable{
    
    private int id;
    private String nome;

    public Modelo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void Ver_info();

    @Override
    public Modelo clone() throws CloneNotSupportedException {
        return (Modelo) super.clone();
    }

}
