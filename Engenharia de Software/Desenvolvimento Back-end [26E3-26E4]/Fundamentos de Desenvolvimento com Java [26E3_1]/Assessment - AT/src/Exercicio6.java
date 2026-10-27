class Veiculo {

    String placa;
    String modelo;
    int anoFabricacao;
    double quilometragem;

    public Veiculo(String placa, String modelo, int anoFabricacao, double quilometragem) {
        this.placa = placa;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.quilometragem = quilometragem;
    }

    public void exibirDetalhes() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de fabricação: " + anoFabricacao);
        System.out.println("Quilometragem: " + quilometragem + " km");
        System.out.println();
    }

    public void registrarViagem(double km) {
        quilometragem += km;
    }
}

public class Exercicio6 {

    public static void main(String[] args) {

        Veiculo veiculo1 = new Veiculo("ABC-1234", "Toyota Corolla", 2022, 35000);
        Veiculo veiculo2 = new Veiculo("DEF-5678", "Honda Civic", 2023, 20000);

        veiculo1.registrarViagem(250);
        veiculo2.registrarViagem(180);

        System.out.println("Veículo 1:");
        veiculo1.exibirDetalhes();

        System.out.println("Veículo 2:");
        veiculo2.exibirDetalhes();
    }
}