public class Produto {
    private String nome;
    private int codigo;
    private float preco;

    public Produto(String nome,int codigo,float preco){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setpreco(float preco){
        this.preco = preco;
    }

    public String getNome(){
        return this.nome;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public float getpreco(){
        return this.preco;
    }

    public String toString(){
        return String.format("%-8d" ,this.codigo) + " "
        + String.format("%-15s", this.nome) + " "
        + String.format("%.2f", this.preco);
    }
}
