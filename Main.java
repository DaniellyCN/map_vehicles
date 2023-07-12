import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("================================ ABB ================================");

        ABB abb = new ABB();

        int quantidadeVeiculoss = 10;
        for (int i = 0; i < quantidadeVeiculoss; i++) {
            Veiculo veiculo = new Veiculo();
            abb.adiciona(veiculo);
        }

        System.out.println("Tempo gasto para inserir 10 veículos: " + abb.getTempoAtual() + " nanosegundos");

        System.out.println("Antes da ordenação");
        abb.imprimirArvore(); // Imprime a árvore antes de ordenar

        System.out.println("Depois da ordenação");
        abb.imprimirEmOrdem();

        double tempoSegundos = abb.getTempoAtual();
        System.out.println("Tempo de execução para ordenar : " + tempoSegundos + " segundos");

        int quantidadeFordd = abb.contarVeiculosMarcaFord();
        System.out.println("Quantidade de veículos da marca Ford: " + quantidadeFordd);

        double tempoContagemFordd = abb.getTempoAtual();
        System.out.println("Tempo para encontrar veículos da marca Ford: " + tempoContagemFordd);

        System.out.println("================================ Vetor ================================");

        VetorOrdenado vetorOrdenado = new VetorOrdenado(10);
        int quantidadeVeiculos1 = 10; 
        for (int i = 0; i < quantidadeVeiculos1; i++) {
            Veiculo veiculo = new Veiculo();
            vetorOrdenado.adicionar(veiculo);
        }


        vetorOrdenado.imprimeVetor();
        System.out.println("Tempo gasto para inserir 10 veículos: " + abb.getTempoAtual() + " nanosegundos");

        int quantidadeFord2 = abb.contarVeiculosMarcaFord();
        System.out.println("Quantidade de veículos da marca Ford: " + quantidadeFord2);

        double tempoContagemFord2 = abb.getTempoAtual();
        System.out.println("Tempo para encontrar veículos da marca Ford: " + tempoContagemFord2);


        // Ordenar o vetor usando bubble sort
        vetorOrdenado.bubble_sort();
        System.out.println("Vetor ordenado usando bubble sort. Tempo de execucao: " + vetorOrdenado.getTempoAtual()
                + " microssegundos");

        // Ordenar o vetor usando selection sort
        vetorOrdenado.selection_sort();
        System.out.println("Vetor ordenado usando selection sort. Tempo de execucao: " + vetorOrdenado.getTempoAtual()
                + " microssegundos");

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
