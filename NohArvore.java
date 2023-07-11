public class NohArvore {
    
    private Veiculo veiculo;
    private NohArvore esquerda;
    private NohArvore direita;
    private NohArvore pai;

    public NohArvore(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Veiculo getConteudo() {return veiculo;}
    public NohArvore getEsquerda() {return esquerda;}
    public void setEsquerda(NohArvore n) { this.esquerda = n; }
    public NohArvore getDireita() {return direita;}
    public void setDireita(NohArvore n) { this.direita = n; }
    public NohArvore getPai() {return pai;}
    public void setPai(NohArvore n) { this.pai = n; }


}
