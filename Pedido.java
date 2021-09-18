import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido{
    static private int cont = 1;
    private int codigo;
    private LocalDateTime dataHora;
    private Garcom garcom;
    private LinkedList<Item> itens;

    public Pedido(Garcom garcom){
        this.codigo = cont++;
        this.dataHora = LocalDateTime.now();
        this.garcom = garcom;
        this.itens = new LinkedList<Item>();
    }

    public void setItens(Item item){
        this.itens.add(item);
    }

    public LocalDateTime getData(){
        return this.dataHora;
    }

    public Garcom getGarcom(){
        return this.garcom;
    }

    public LinkedList<Item> getItens(){
        return this.itens;
    }
    public int getCodigo(){
        return this.codigo;
    }

    public int fecharPedido(){
        int total = 0;

        for(Item i: itens){
            total += i.getQuantidade() * i.getItemProduto().getpreco();
        }

        return total;
    }


    public void liberaItens(){
        itens.clear();
    }

    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("%-6d", this.codigo) + " "
        + this.dataHora.format(formato) + " "
        + String.format("%-15s", this.garcom.getNome());
    }
}
