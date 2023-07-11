public class VetorOrdenado {

    private Veiculo[] veiculos;
    private int totalVeiculos;
    private long tempo_atual;


    public VetorOrdenado(int col){
        this.veiculos = new Veiculo[col];
        totalVeiculos = 0;
    }

    public int tamanho(){
        return this.totalVeiculos;
    }

    public boolean vazio(){
        if(this.tamanho() != 0){
            return false;
        }
        return true;
    }

    public Veiculo getVeiculo(int chassi) throws Exception{
        for(Veiculo veiculo : veiculos){
            if(veiculo.getChassi() == chassi){
                return veiculo;
            }
        }
        throw new Exception("Veículo não encontrado pelo código do chassi informado.");
    }

    public boolean remove(int chassi) {
        int count = -1;
        for(int i = 0; i < tamanho(); i++){
            if(veiculos[i].getChassi() == chassi){
                count = i;
                break;
            }

            if(count != -1){ // elemento encontrado
                for(int j = count; j < tamanho() - 1; j++){
                    veiculos[j] = veiculos[j + 1]; 
                }

                totalVeiculos --;
                return true;
            }

        } 
        return false;
    }

    public boolean cheio() {
        if(totalVeiculos == tamanho()){
            return true;
        }
        return false;
    }


    public void assegurarEspaco() {
        // if cheio
        Veiculo[] novos_veiculos = new Veiculo[tamanho() * 2];

        for(int i = 0; i < tamanho(); i++) {
            novos_veiculos[i] = veiculos[i];
        }

        veiculos = novos_veiculos;
    }


    public void adicionar(Veiculo novo) {
        if(cheio()){
            assegurarEspaco();
        }
        int count;
        for(count = tamanho() - 1; count >= 0; count--) {
            if(veiculos[count].getChassi() > novo.getChassi()) {
                veiculos[count + 1] = veiculos[count]; // desloca veiculo atual para a direita
            }
        }

        veiculos[count + 1] = novo;
        totalVeiculos ++;
    }


    public double getTempoAtual() {
        return tempo_atual / 1000.0;
    }

}
