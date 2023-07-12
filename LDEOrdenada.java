// Lista Duplamente encadeada
public class LDEOrdenada implements IMap {

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
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }

        long endTime = System.nanoTime();
        tempo_atual = endTime - startTime;
    }

    public boolean vazio() {
        if (inicio == null) {
            return true;
        }
        return false;
    }

    public boolean remove(int chassi) {
        NohLDE aux = inicio;
        while (aux != null && aux.getConteudo().getChassi() != chassi) {
            aux = aux.getProximo();
        }

        if (aux == null) {
            return false; // caso nao tenha achado o NohLDE que tenha a info desejada, content
        }
        if (aux == inicio) {
            inicio = aux.getProximo();
            if (inicio != null) { // havia pelo menos 2 NohLDEs na lista
                inicio.setAnterior(null);// o primeiro da lista sempre aponta para o NohLDE anterior para null, já que
                                         // nao tem
            } else {
                fim = null; // havia apenas 1 NohLDE na lista e por isso o novo inicio é null e portanto o
                            // fim também deve ser
            }
        } else if (aux == fim) {
            aux.getAnterior().setProximo(null);
            fim = aux.getAnterior();
        } else {
            aux.getProximo().setAnterior(aux.getAnterior());
            aux.getAnterior().setProximo(aux.getProximo());
        }
        return true;
    }

    public int tamanho() {
        int cont = 0;
        NohLDE aux = inicio;
        if (inicio == null) {
            return 0;
        }
        while (aux != null) {
            aux = aux.getProximo();
            cont += 1;
        }
        return cont;
    }

    public double getTempoAtual() {
        return tempo_atual;
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

    public void imprimeLista() {
        NohLDE nohAtual = inicio;
        System.out.println("Lista:");
        while (nohAtual != null) {
            System.out.println(" - " + nohAtual.getConteudo().toString()); // Ajuste aqui para acessar a informação
                                                                           // desejada do veículo
            nohAtual = nohAtual.getProximo();
        }
    }

    public void bubble_sort() {
        if (inicio == null || inicio.getProximo() == null) {
            return;
        }

        boolean trocou;
        NohLDE atual;
        NohLDE proximo;
        long startTime = System.nanoTime();
        do {
            trocou = false;
            atual = inicio;

            while (atual != null && atual.getProximo() != null) {
                proximo = atual.getProximo();

                if (atual.getConteudo().getChassi() > proximo.getConteudo().getChassi()) {
                    // Troca os nós
                    trocarNos(atual, proximo);
                    trocou = true;
                }

                atual = atual.getProximo();
            }
        } while (trocou);

        long endTime = System.nanoTime();
        tempo_atual = endTime - startTime;
    }

    private void trocarNos(NohLDE noh1, NohLDE noh2) {
        // Troca os nós adjacentes
        if (noh1 == null || noh2 == null) {
            return; // Verifica se algum dos nós é nulo
        }

        // Atualiza as referências do próximo
        NohLDE proxNoh1 = noh1.getProximo();
        NohLDE proxNoh2 = noh2.getProximo();

        noh1.setProximo(proxNoh2);
        noh2.setProximo(proxNoh1);

        if (proxNoh1 != null) {
            proxNoh1.setAnterior(noh2);
        }
        if (proxNoh2 != null) {
            proxNoh2.setAnterior(noh1);
        }

        // Atualiza as referências do anterior
        NohLDE antNoh1 = noh1.getAnterior();
        NohLDE antNoh2 = noh2.getAnterior();

        noh1.setAnterior(antNoh2);
        noh2.setAnterior(antNoh1);

        if (antNoh1 != null) {
            antNoh1.setProximo(noh2);
        } else {
            inicio = noh2;
        }
        if (antNoh2 != null) {
            antNoh2.setProximo(noh1);
        } else {
            inicio = noh1;
        }
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
        return false;
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
