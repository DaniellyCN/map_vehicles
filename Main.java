import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("================================  TESTE COM ARVORE ================================");

        // Criar uma instância de ABB
        ABB abb = new ABB();

        // Adicionar veículos à árvore
        Veiculo veiculo1 = new Veiculo();
        Veiculo veiculo2 = new Veiculo();
        Veiculo veiculo3 = new Veiculo();

        abb.adiciona(veiculo1);
        abb.adiciona(veiculo2);
        abb.adiciona(veiculo3);

        // Verificar se a árvore está vazia
        boolean vazia = abb.vazio();
        System.out.println("Arvore vazia? " + vazia);

        // Verificar se a árvore contém um veículo com um determinado chassi
        boolean contem = abb.contem(veiculo2.getChassi());
        System.out.println("Arvore contem o veiculo 2? " + contem);

        int quantidadeVeiculos3 = 10;
        for (int i = 0; i < quantidadeVeiculos3; i++) {
            Veiculo veiculo = new Veiculo();
            abb.adiciona(veiculo);
        }

        System.out.println("Tempo gasto para inserir 10 veículos: " + abb.getTempoAtual() + " nanosegundos");

        int quantidadeFord3 = abb.contarVeiculosMarcaFord();
        System.out.println("Quantidade de veículos da marca Ford: " + quantidadeFord3);

        double tempoContagemFord3 = abb.getTempoAtual();
        System.out.println("Tempo para encontrar veículos da marca Ford: " + tempoContagemFord3);

        System.out.println("================================  TESTE COM VETOR ================================");
        
       
  VetorOrdenado vetorOrdenado = new VetorOrdenado(10);
            int quantidadeVeiculos1 = 10;                           //ADICIONA VEICULOS COM CHASSI ALEATORIO
        for (int i = 0; i < quantidadeVeiculos1; i++) {
            Veiculo veiculo = new Veiculo();
            vetorOrdenado.adicionar(veiculo);
        }

       System.out.println("Tempo gasto para inserir 10 veículos: " + abb.getTempoAtual() + " nanosegundos");

int quantidadeFord2 = abb.contarVeiculosMarcaFord();
System.out.println("Quantidade de veículos da marca Ford: " + quantidadeFord2);

double tempoContagemFord2 = abb.getTempoAtual();
System.out.println("Tempo para encontrar veículos da marca Ford: " + tempoContagemFord2);




        // Adicionar veículos ao vetor ordenado
        vetorOrdenado.adicionar(veiculo1);
        vetorOrdenado.adicionar(veiculo2);
        vetorOrdenado.adicionar(veiculo3);

        // Verificar se o vetor está vazio
        boolean vazio = vetorOrdenado.vazio();
        System.out.println("Vetor vazio? " + vazio);

        // Obter um veículo do vetor pelo chassi
        try {
            Veiculo veiculo = vetorOrdenado.getVeiculo(veiculo2.getChassi());
            System.out.println("Veiculo encontrado no vetor: " + veiculo);
        } catch (Exception e) {
            System.out.println("Veiculo nao encontrado no vetor.");
        }

        // Remover um veículo do vetor pelo chassi
        boolean removido = vetorOrdenado.remove(veiculo2.getChassi());
        System.out.println("Veiculo removido do vetor? " + removido);

        // Ordenar o vetor usando bubble sort
        vetorOrdenado.bubble_sort();
        System.out.println("Vetor ordenado usando bubble sort. Tempo de execucao: " + vetorOrdenado.getTempoAtual() + " microssegundos");

        // Ordenar o vetor usando selection sort
        vetorOrdenado.selection_sort();
        System.out.println("Vetor ordenado usando selection sort. Tempo de execucao: " + vetorOrdenado.getTempoAtual() + " microssegundos");

       
         


        System.out.println(
                "================================ Lista Duplamente Encadeada ================================");
        LDEOrdenada lista = new LDEOrdenada();
        int quantidadeVeiculos = 10;
        for (int i = 0; i < quantidadeVeiculos; i++) {
            Veiculo veiculo = new Veiculo();
            lista.adicionar(veiculo);
        }
        System.out.println("Tempo gasto para inserir 10 veículos: " + lista.getTempoAtual() + " nanosegundos");

        System.out.println("Antes da ordenação:");
        lista.imprimeLista();

        lista.bubble_sort();
        System.out.println("Depois da ordenação:");
        System.out.println("Tempo gasto para ordenar a lista: " + lista.getTempoAtual() + " microssegundos");

        lista.imprimeLista();
        double tempoImpressao = lista.getTempoAtual();
        System.out.println("Tempo para imprimir todos os veículos: " + tempoImpressao);

        int quantidadeFord = lista.contarVeiculosMarcaFord();
        System.out.println("Quantidade de veículos da marca Ford: " + quantidadeFord);
        double tempoContagemFord = lista.getTempoAtual();
        System.out.println("Tempo para encontrar veículos da marca Ford: " + tempoContagemFord);

    }
}
