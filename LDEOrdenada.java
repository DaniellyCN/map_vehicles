// Lista Duplamente encadeada
public class LDEOrdenada implements IMap{
    
    private NohLDE inicio;
    private NohLDE fim;
    private long tempo_atual;

    public LDEOrdenada() {
        inicio = null;
        fim = null;
    }

    public void adicionar(Veiculo veiculo) {
        long startTime = System.nanoTime();
        NohLDE novo = new NohLDE(veiculo);
        if(fim==null){
            inicio = novo;
            fim = novo;
        }else{
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }

        long endTime = System.nanoTime();
        tempo_atual = endTime - startTime;
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



    public int contarVeiculosMarcaFord() {
    long startTime = System.nanoTime();

    int contador = 0;
    NohLDE aux = inicio;

    while (aux != null) {
        if (aux.getConteudo().isMarcaFord()) {
            contador++;
        }
        aux = aux.getProximo();
    }

    long endTime = System.nanoTime();
    tempo_atual = endTime - startTime;

    return contador;
}





//não tá ordenando direito
public void mostrarVeiculosOrdenados() {
    // Ordena os veículos pelo número de chassi em ordem crescente

    NohLDE aux = inicio;

    while (aux != null) {
        System.out.println(aux.getConteudo().toString());
        aux = aux.getProximo();
    }
}

    public void bubbleSort() {
    long startTime = System.nanoTime();

    boolean trocado;
    NohLDE atual;
    NohLDE anterior = null;

    do {
        trocado = false;
        atual = inicio;

        while (atual != null && atual.getProximo() != anterior) {
            // Verifica se é necessário trocar o atual com o próximo nó
            if (atual.getConteudo().getChassi() > atual.getProximo().getConteudo().getChassi()) {
                trocarNohs(atual, atual.getProximo());
                trocado = true;
            }

            atual = atual.getProximo();
        }

        anterior = atual; // O último nó comparado na iteração anterior é o novo 'anterior'
    } while (trocado);

    long endTime = System.nanoTime();
    tempo_atual = endTime - startTime;
}

    private void trocarNohs(NohLDE a, NohLDE b) {
    // Troca os nós a e b na lista

    // Atualiza os nós adjacentes a 'a'
    if (a.getAnterior() != null) {
        a.getAnterior().setProximo(b);
    } else {
        inicio = b; // 'a' era o nó de início da lista, agora 'b' será
    }
    b.setAnterior(a.getAnterior());

    // Atualiza os nós adjacentes a 'b'
    if (b.getProximo() != null) {
        b.getProximo().setAnterior(a);
    } else {
        fim = a; // 'b' era o nó final da lista, agora 'a' será
    }
    a.setProximo(b.getProximo());

    // Realiza a troca dos nós 'a' e 'b'
    a.setAnterior(b);
    b.setProximo(a);
}



    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean containsKey(int chassi) throws Exception {
       NohLDE aux = inicio;
        while (aux != null) {
            if (aux.getConteudo().getChassi() == chassi) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false
        ;
    }

    @Override
    public boolean containsValue(Veiculo veiculo) throws Exception {
        NohLDE aux = inicio;
        while (aux != null) {
            if (aux.getConteudo().equals(veiculo)) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    @Override
    public Veiculo getVeiculo(int chassi) throws Exception {
      NohLDE aux = inicio;
        while (aux != null) {
            if (aux.getConteudo().getChassi() == chassi) {
                return aux.getConteudo();
            }
            aux = aux.getProximo();
        }
        throw new Exception("Veículo não encontrado pelo código do chassi informado.");
    }

    @Override
    public Veiculo putVeiculo(int chassi, Veiculo veiculo) throws Exception {
      if (containsKey(chassi)) {
            throw new Exception("Já existe um veículo com o mesmo código de chassi.");
        }

        adicionar(veiculo);
        return veiculo;
    }

    @Override
    public void putAllVeiculos() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putAllVeiculos'");
    }

    @Override
    public void clear() {
       inicio = null;
        fim = null;
    }

    @Override
    public boolean equals() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'equals'");
    }

    @Override
    public int codeHash() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'codeHash'");
    }

}
