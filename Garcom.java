public class Garcom {
    private String nome;
    private int matricula;

    public Garcom(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome(){
        return this.nome;
    }

    public int getMAtricula(){
        return this.matricula;
    }

    public String toString(){
        return String.format("%-9d", this.matricula) + " "
        + String.format("%s",this.nome);
    }
}
