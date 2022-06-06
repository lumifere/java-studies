import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a seguir os seguintes dados.\nSeu nome:");
        String dono = sc.nextLine();
        System.out.println("A marca do seu caminhão:");
        String marca = sc.nextLine();
        System.out.println("O modelo do seu caminhão:");
        String modelo = sc.nextLine();
        System.out.println("A capacidade do tanque deste caminhão:");
        double tanque_capacid = sc.nextDouble();
        System.out.println("A autonomia de km/l do caminhão:");
        double autonomia_km_l = sc.nextDouble();
        System.out.println("Qual a capacidade de caminhão?");
        double capacid_carga = sc.nextDouble();
        System.out.println("Qual a quantidade de eixos do caminhão?");
        int qnt_eixos = sc.nextInt();
        System.out.println("Qual a rodagem do caminhão?");
        double km_rodados = sc.nextDouble();

        Caminhao c1 = new Caminhao(marca, modelo, dono, tanque_capacid, autonomia_km_l, km_rodados, capacid_carga, qnt_eixos);

        int opcao = 0;
        while (opcao != 6) {
            double valor, carga;
            System.out.println("\nO que você deseja fazer a seguir?\n1 - Mostrar informações atuais do caminhão.\n2 - Alterar autonomia do caminhão.\n3 - Abastecer o tanque.\n4 - Realizar uma viagem.\n5 - Alterar quilometragem.\n6 - Sair do programa.");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    int opcao2 = 0;
                    while (opcao2 != 6){
                        System.out.println("\nQual informação do caminhão você deseja saber?\n1 - Tanque atual.\n2 - Capacidade do tanque.\n3 - Autonomia do caminhão.\n4 - Quilometragem do caminhão.\n5 - Capacidade da carga.\n6 - Voltar ao menu anterior.");
                        opcao2 = sc.nextInt();
                        switch (opcao2){
                            case 1:
                                System.out.println(c1.lerTanqueAtual()+"/"+ c1.lerTanqueCapacid());
                                break;
                            case 2:
                                System.out.println(c1.lerTanqueCapacid());
                                break;
                            case 3:
                                System.out.println(c1.lerAutonomia());
                                break;
                            case 4:
                                System.out.println(c1.lerRodagem());
                                break;
                            case 5:
                                System.out.println(c1.lerCapacidCarga());
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("\nOpção inválida, tente novamente.");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nInsira o novo valor para autonomia do caminhão:");
                    valor = sc.nextDouble();
                    if (c1.alterarAutonomia(valor)) {
                        System.out.println("Autonomia modificada com sucesso!");
                        break;
                    } else {
                        System.out.println("Valor inserido inválido.");
                    }
                    break;
                case 3:
                    System.out.println("\nQuantos litros você quer abastecer o caminhão?");
                    valor = sc.nextDouble();
                    if (c1.abastecerTanque(valor)){
                        System.out.println("\nTanque abastecido com sucesso!");
                        break;
                    } else {
                        System.out.println("\nO veículo não possui tanta capacidade assim, tente um valor menor.");
                    }
                    break;
                case 4:
                    System.out.println("\nFazer uma viagem de quantos km?");
                    valor = sc.nextDouble();
                    System.out.println("\nQual a carga a ser levada?");
                    carga = sc.nextDouble();
                    if (c1.fazerViagem(valor,carga)){
                        System.out.println("\nViagem feita com sucesso, agora seu tanque tem " + c1.lerTanqueAtual() + " litros.");
                        break;
                    } else {
                        System.out.println("\nVocê não possui combustível suficiente ou sua carga é muito pesada.");
                    }
                    break;
                case 5:
                    System.out.println("\nQual o valor atual da rodagem?");
                    valor = sc.nextDouble();
                    c1.alterarKMRodados(valor);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente.");
                    break;
            }
        }
        System.out.println("\nAdeus...");
    }
}

