public class Item{
    Produto itemProduto;
    int quantidade;

    public Item(Produto produto, int quantidade){
        this.itemProduto = produto;
        this.quantidade = quantidade;
    }

    public void setItemProduto(Produto itemProduto){
        this.itemProduto = itemProduto;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public Produto getItemProduto(){
        return this.itemProduto;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public String toString(){
        return this.itemProduto.toString() + " quantidade: " + this.quantidade;
    }
}
