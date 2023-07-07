public interface IMap {
    public int size();
    public boolean isEmpty();
    public boolean containsKey(int chassi) throws Exception;
    public boolean containsValue(Veiculo veiculo) throws Exception;
    public Veiculo getVeiculo(int chassi) throws Exception;
    public Veiculo putVeiculo(int chassi, Veiculo veiculo) throws Exception;
    public boolean remove(int chassi) throws Exception;
    public void putAllVeiculos() throws Exception; // conferir qual deve ser o parâmetro, se tiver um
    public void clear();
    public boolean equals() throws Exception; // conferir qual deve ser o parâmetro
    public int codeHash() throws Exception;
}
