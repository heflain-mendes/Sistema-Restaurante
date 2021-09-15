import java.util.ArrayList;
import java.time.LocalDateTime;

public class Pedido{
    static private int cont = 0;
    private int codigo;
    private LocalDateTime dataHora;
    private Garcom garcom;
    private ArrayList<Item> itens;

    public Pedido(Garcom garcom){
        this.codigo = cont++;
        this.dataHora = LocalDateTime.now();
        this.garcom = garcom;
        this.itens = null;
    }

    public void setItens(ArrayList<Item> itens){
        this.itens = itens;
    }

    public LocalDateTime getData(){
        return this.dataHora;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }

    public ArrayList<Item> getItens(){
        return this.itens;
    }

    public int fecharPedido(){
        int total = 0;

        for(Item i: itens){
            total += i.getQuantidade() * i.getItemProduto().getpreco();
        }

        return total;
    }

    public String toString(){
        return "Codigo: " + this.codigo + "matricula garçom: " + String.format("%8d",this.garcom.getMAtricula()) +
        "nome do garçom: " + this.garcom.getNome();
    }
}
