public class Vetor {

    private Veiculo[] veiculos;
    private int totalVeiculos = 0;

    public Vetor(int col){
        this.veiculos = new Veiculo[col];
    }

    public int size(){
        return this.totalVeiculos;
    }

    public boolean isEmpty(){
        if(this.size() != 0){
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


    public boolean remove(int chassi){
        int count = -1;
        for(int i = 0; i < size(); i++){
            if(veiculos[i].getChassi() == chassi){
                count = i;
                break;
            }

            if(count != -1){ // elemento encontrado
                for(int j = count; j < size() - 1; i++){
                    veiculos[j] = veiculos[i + 1]; 
                }

                totalVeiculos --;
                return true;
            }

        } 
        return false;
    }

}
