public class VetorOrdenado {

    private Veiculo[] veiculos;
    private int totalVeiculos;
    private long tempo_atual;

    public VetorOrdenado(int col) {
        this.veiculos = new Veiculo[col];
        totalVeiculos = 0;
    }

    public int tamanho() {
        return this.totalVeiculos;
    }

    public boolean vazio() {
        if (this.tamanho() != 0) {
            return false;
        }
        return true;
    }

    public Veiculo getVeiculo(int chassi) throws Exception {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getChassi() == chassi) {
                return veiculo;
            }
        }
        throw new Exception("Veículo não encontrado pelo código do chassi informado.");
    }

    public boolean remove(int chassi) {
        int count = -1;
        for (int i = 0; i < tamanho(); i++) {
            if (veiculos[i].getChassi() == chassi) {
                count = i;
                break;
            }

            if (count != -1) { // elemento encontrado
                for (int j = count; j < tamanho() - 1; j++) {
                    veiculos[j] = veiculos[j + 1];
                }

                totalVeiculos--;
                return true;
            }

        }
        return false;
    }

    public boolean cheio() {
        if (totalVeiculos == tamanho()) {
            return true;
        }
        return false;
    }

    public void assegurarEspaco() {
        // if cheio
        Veiculo[] novos_veiculos = new Veiculo[tamanho() * 2];

        for (int i = 0; i < tamanho(); i++) {
            novos_veiculos[i] = veiculos[i];
        }

        veiculos = novos_veiculos;
    }

    public void adicionar(Veiculo novo) {
        if (cheio()) {
            assegurarEspaco();
        } else {
            veiculos[totalVeiculos] = novo;
            totalVeiculos++;
        }

    }

    public void bubble_sort() {
        long startTime = System.nanoTime();

        for (int i = 0; i < tamanho(); i++) {
            for (int j = 0; j < tamanho() - 1; j++) {
                if (veiculos[j].getChassi() > veiculos[j + 1].getChassi()) {
                    Veiculo auxiliar = veiculos[j];
                    veiculos[j] = veiculos[j + 1];
                    veiculos[j + 1] = auxiliar;
                }
            }
        }
        long endTime = System.nanoTime();
        tempo_atual = endTime - startTime;
    }

    public void selection_sort() {
        long startTime = System.nanoTime();

        for (int i = 0; i < tamanho() - 1; i++) {
            int menorIndice = i;
            for (int j = i + 1; j < tamanho(); j++) {
                if (veiculos[j].getChassi() < veiculos[menorIndice].getChassi()) {
                    menorIndice = j;
                }
            }

            Veiculo temp = veiculos[i];
            veiculos[i] = veiculos[menorIndice];
            veiculos[menorIndice] = temp;
        }

        long endTime = System.nanoTime();
        tempo_atual = endTime - startTime;
    }

    public double getTempoAtual() {
        return tempo_atual / 1000.0;
    }

    public int contarVeiculosMarcaFord() {
        long startTime = System.nanoTime();

        int contador = 0;
        for (int i = 0; i < tamanho(); i++) {
            if (veiculos[i].isMarcaFord()) {
                contador++;
            }
        }

        long endTime = System.nanoTime();
        tempo_atual = endTime - startTime;

        return contador;
    }

    public void imprimeVetor() {
        System.out.println("Vetor atual:");
        for (int i = 0; i < tamanho(); i++) {
            System.out.println(" - Veiculo chassi: " + veiculos[i].getChassi() + " marca: " + veiculos[i].getMarca());
        }
    }

}
