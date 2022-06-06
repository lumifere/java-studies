import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a seguir os seguintes dados sobre o seu carro.\nSeu nome:");
        String dono = sc.nextLine();
        System.out.println("A marca do seu carro:");
        String marca = sc.nextLine();
        System.out.println("O modelo do seu carro:");
        String modelo = sc.nextLine();
        System.out.println("A capacidade do tanque deste carro:");
        double tanque_capacid = sc.nextDouble();
        System.out.println("A autonomia de km/l do carro:");
        double autonomia_km_l = sc.nextDouble();

        Veículo v1 = new Veículo(marca, modelo, dono, tanque_capacid, autonomia_km_l);

        int opcao = 0;
        while (opcao != 5) {
            double valor;
            System.out.println("\nO que você deseja fazer a seguir?\n1 - Mostrar informações atuais do carro.\n2 - Alterar autonomia do carro.\n3 - Abastecer o tanque.\n4 - Realizar uma viagem.\n5 - Sair do programa.");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    int opcao2 = 0;
                    while (opcao2 != 5){
                        System.out.println("\nQual informação do carro você deseja?\n1 - Tanque atual.\n2 - Capacidade do tanque.\n3 - Autonomia do carro.\n4 - Quilometragem do carro.\n5 - Voltar ao menu anterior.");
                        opcao2 = sc.nextInt();
                        switch (opcao2){
                            case 1:
                                System.out.println(v1.lerTanqueAtual()+"\n");
                                break;
                            case 2:
                                System.out.println(v1.lerTanqueCapacid()+"\n");
                                break;
                            case 3:
                                System.out.println(v1.lerAutonomia()+"\n");
                                break;
                            case 4:
                                System.out.println(v1.lerRodagem()+"\n");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.\n");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Insira o novo valor para autonomia do carro:");
                    valor = sc.nextDouble();
                    if (v1.alterarAutonomia(valor)) {
                        System.out.println("Autonomia modificada com sucesso!\n");
                        break;
                    } else {
                        System.out.println("Valor inserido inválido.\n");
                    }
                    break;
                case 3:
                    System.out.println("Quantos litros você quer abastecer o carro?");
                    valor = sc.nextDouble();
                    if (v1.abastecerTanque(valor)){
                        System.out.println("Tanque abastecido com sucesso!\n");
                        break;
                    } else {
                        System.out.println("O veículo não possui tanta capacidade assim, tente um valor menor.\n");
                    }
                    break;
                case 4:
                    System.out.println("Fazer uma viagem de quantos km?");
                    valor = sc.nextDouble();
                    if (v1.fazerViagem(valor)){
                        System.out.println("Viagem feita com sucesso, agora seu tanque tem " + v1.lerTanqueAtual() + " litros.\n");
                        break;
                    } else {
                        System.out.println("Você não possui combustível suficiente, tente abastecer primeiro\n.");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        }
        System.out.println("Adeus...");
    }
}
