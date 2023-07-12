public class Main {
    public static void main(String[] args) {
        LDEOrdenada lista = new LDEOrdenada();
        
       
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

        

        
    }
}
