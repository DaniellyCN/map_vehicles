public class NohLDE {
    
    private Veiculo veiculo;
    private NohLDE anterior;
    private NohLDE proximo;

    public NohLDE(Veiculo veiculo){
        this.veiculo = veiculo;
        anterior = null;
        proximo = null;
    }
    public Veiculo getConteudo() {return veiculo;}
    public NohLDE getProximo() {return proximo;}
    public void setProximo(NohLDE n) { this.proximo = n; }
    public NohLDE getAnterior() {return anterior;}
    public void setAnterior(NohLDE n) { this.anterior = n; }
    public void setConteudo(Veiculo conteudo) {
    }

}
