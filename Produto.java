public class Produto {
    private String nome;
    private int codigo;
    private float preco;

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
        return "nome: " + this.nome + " codigo: " + this.codigo + " preço: " + String.format("%.2f", this.preco);
    }
}
