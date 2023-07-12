public class ABB {
    
    private NohArvore raiz;
    private long tempo_atual;

    public ABB(){
        raiz = null;
    }

    public ABB(NohArvore raiz) {
        this.raiz = raiz;
    }

    public boolean vazio() {
        if (raiz == null){
            return true;
        }
        return false;
    }

    public void adiciona(Veiculo veiculo) {
        if (vazio()){
            this.raiz = new NohArvore(veiculo);
        }else {
            NohArvore auxiliar = this.raiz;
            while (auxiliar != null) {
                if (veiculo.getChassi() < auxiliar.getConteudo().getChassi()) {
                    if (auxiliar.getEsquerda() == null) {
                        NohArvore newNoh = new NohArvore(veiculo);
                        auxiliar.setEsquerda(newNoh);
                        newNoh.setPai(auxiliar);
                        return;
                    }
                    auxiliar = auxiliar.getEsquerda();
                } else {
                    if (auxiliar.getDireita() == null) {
                        NohArvore newNoh = new NohArvore(veiculo);
                        auxiliar.setDireita(newNoh);
                        newNoh.setPai(auxiliar); 
                        return;
                    }
                    auxiliar = auxiliar.getDireita();
                } 
            }
        } 
    } 

    // método recursivo
    public void adicionarRecursivo(Veiculo veiculo) {
        if (vazio()){
            this.raiz = new NohArvore(veiculo);
        } else {
            adicionarRecursivo(this.raiz, veiculo);
        }
    }

    private void adicionarRecursivo(NohArvore node, Veiculo veiculo) {
        if (veiculo.getChassi() < node.getConteudo().getChassi()) {
            if (node.getEsquerda() == null) {
                NohArvore novoNode = new NohArvore(veiculo);
                node.setEsquerda(novoNode);
                novoNode.setPai(node);
                return;
            }
            adicionarRecursivo(node.getEsquerda(), veiculo);
        
        } else {
            if (node.getDireita() == null) {
                NohArvore novoNode = new NohArvore(veiculo);
                node.setDireita(novoNode);
                novoNode.setPai(node);
                return;
            }
            adicionarRecursivo(node.getDireita(), veiculo);
        }
    }


    public boolean contem(int chassi) {
        if (vazio()) {
            return false;
        }
        NohArvore auxiliar = raiz;
        while (auxiliar != null) {
            if (auxiliar.getConteudo().getChassi() == chassi) {
                return true;
            } else if (chassi < auxiliar.getConteudo().getChassi()) {
                auxiliar = auxiliar.getEsquerda();
            } else {
                auxiliar = auxiliar.getDireita();
            }
        }
        return false;
    }

    public double getTempoAtual() {
        return tempo_atual / 1000.0;
    }

    
    public int contarVeiculosMarcaFord() {
    long startTime = System.nanoTime();

    int contador = 0;
    contarVeiculosMarcaFordRecursivo(raiz, contador);

    long endTime = System.nanoTime();
    tempo_atual = endTime - startTime;

    return contador;
}

private void contarVeiculosMarcaFordRecursivo(NohArvore noh, int contador) {
    if (noh != null) {
        if (noh.getConteudo().isMarcaFord()) {
            contador++;
        }
        contarVeiculosMarcaFordRecursivo(noh.getEsquerda(), contador);
        contarVeiculosMarcaFordRecursivo(noh.getDireita(), contador);
    }
}

    
}
