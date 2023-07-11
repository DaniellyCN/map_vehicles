// Lista Duplamente encadeada
public class LDEOrdenada {
    
    private NohLDE inicio;
    private NohLDE fim;
    private long tempo_atual;

    public LDEOrdenada() {
        inicio = null;
        fim = null;
    }

    public void adicionar(Veiculo veiculo) {
        NohLDE novo = new NohLDE(veiculo);
        if(fim==null){
            inicio = novo;
            fim = novo;
        }else{
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
    }

    public boolean vazio(){
        if(inicio == null){
            return true;
        }
        return false;
    }

    public boolean remove(int chassi) {
        NohLDE aux = inicio;
        while(aux != null && aux.getConteudo().getChassi() != chassi){
            aux = aux.getProximo();
        }
    
        if(aux==null){
            return false; // caso nao tenha achado o NohLDE que tenha a info desejada, content
        }
        if(aux==inicio){
            inicio = aux.getProximo();
            if(inicio != null){ // havia pelo menos 2 NohLDEs na lista
                inicio.setAnterior(null);// o primeiro da lista sempre aponta para o NohLDE anterior para null, já que nao tem
            }else{
                fim = null; // havia apenas 1 NohLDE na lista e por isso o novo inicio é null e portanto o fim também deve ser
            }
        }else if(aux == fim){
            aux.getAnterior().setProximo(null);
            fim = aux.getAnterior();
        }else{
            aux.getProximo().setAnterior(aux.getAnterior());
            aux.getAnterior().setProximo(aux.getProximo());
        }
        return true;
    }

    public int tamanho(){
        int cont = 0;
        NohLDE aux = inicio;
        if(inicio==null){
            return 0;
        }
        while(aux!=null){
            aux = aux.getProximo();
            cont+=1;
        }
        return cont;
    }

    
    public double getTempoAtual() {
        return tempo_atual / 1000.0;
    }

}
