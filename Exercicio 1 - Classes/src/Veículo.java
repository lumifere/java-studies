public class Veículo {
    public String marca, modelo, dono;
    private double tanque_capacid, tanque_atual, autonomia_km_l, km_rodados;

    public Veículo(String marca, String modelo, String dono, double tanque_capacid, double autonomia_km_l){
        this.tanque_atual = 0;
        this.km_rodados = 0;
        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;

        if (!validarProp(tanque_capacid)){
            System.out.println("Parâmetro inválido! O valor padrão de 10 será aplicado à capacidade do seu tanque.");
            tanque_capacid = 10;
        }
        this.tanque_capacid = tanque_capacid;

        if (!validarProp(autonomia_km_l)){
            System.out.println("Parâmetro inválido! O valor padrão de 10 será aplicado à autonomia do seu carro.");
            autonomia_km_l = 10;
        }
        this.autonomia_km_l = autonomia_km_l;
    }

    private boolean validarProp(double prop){
        return (prop > 0);
    }

    public double lerTanqueAtual(){
        return this.tanque_atual;
    }

    public double lerTanqueCapacid(){
        return this.tanque_capacid;
    }

    public double lerAutonomia(){
        return this.autonomia_km_l;
    }

    public double lerRodagem(){
        return this.km_rodados;
    }

    public boolean alterarAutonomia(double autonomia){
        if (validarProp(autonomia)){
            this.autonomia_km_l = autonomia;
            return true;
        } else {
            return false;
        }
    }

    public boolean abastecerTanque(double litros){
        if (validarProp(litros) && (this.tanque_atual + litros <= this.tanque_capacid)){
            this.tanque_atual += litros;
            return true;
        } else {
            return false;
        }
    }

    public boolean fazerViagem(double km){
        if (km/this.autonomia_km_l <= this.tanque_atual){
            this.tanque_atual -= km/this.autonomia_km_l;
            this.km_rodados += km;
            return true;
        } else {
            return false;
        }
    }
}
