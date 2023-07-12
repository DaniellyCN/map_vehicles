public class Main {
    public static void main(String[] args) {
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

        // Criar uma instância de VetorOrdenado
        VetorOrdenado vetorOrdenado = new VetorOrdenado(5);

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




  









        
        /*TESTE COM LDE  
         * 
         * 
         *  LDEOrdenada lista = new LDEOrdenada();
        
       
        int quantidadeVeiculos = 10;
        for (int i = 0; i < quantidadeVeiculos; i++) {
            Veiculo veiculo = new Veiculo();
            lista.adicionar(veiculo);
        }

        System.out.println("Tempo gasto para inserir 100.000 veículos: " + lista.getTempoAtual() + " nanosegundos");
        
        lista.mostrarVeiculosOrdenados();
        lista.bubbleSort();


        int quantidadeFord = lista.contarVeiculosMarcaFord();
        System.out.println("Quantidade de veículos da marca Ford: " + quantidadeFord);

        double tempoContagemFord = lista.getTempoAtual();
        System.out.println("tempo para encontrar veículos da marca Ford: " + tempoContagemFord);
         * 
         */
    }
}
