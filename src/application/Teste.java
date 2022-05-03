package application;

import bd.BDVeiculos;
import entities.Carga;
import entities.Passeio;
import exceptions.VeicExistException;
import exceptions.VelocException;
import utils.Leitura;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) throws VelocException, VeicExistException {

        Leitura lt = new Leitura();
        BDVeiculos bdVeiculos =  new BDVeiculos();

        int opt = 0;

        while (opt !=7){
            System.out.println("\n\nSistema de Gestão de Veículos - Menu Inicial\n");
            System.out.println("\t1. Cadastrar Veículo de Passeio");
            System.out.println("\t2. Cadastrar Veículo de Carga");
            System.out.println("\t3. Imprimir Todos os Veículos de Passeio");
            System.out.println("\t4. Imprimir Todos os Veículos de Carga");
            System.out.println("\t5. Imprimir Veículo de Passeio pela Placa");
            System.out.println("\t6. Imprimir Veículo de Carga pela Placa");
            System.out.println("\t7. Sair do Sistema");

            opt = Integer.parseInt(lt.entDados("\nEntre com a opção desejada: "));

            switch (opt){
                case 1:
                    String continua;
                    do{
                        Passeio passeio = new Passeio();
                        System.out.println("\n\n==================================\n");
                        passeio.setPlaca(lt.entDados("Entre com o valor da placa: "));
                        passeio.setMarca(lt.entDados("Entre com o nome da marca: "));
                        passeio.setModelo(lt.entDados("Entre com o nome do modelo: "));
                        passeio.setCor(lt.entDados("Entre com a cor do veiculo: "));

                        try {
                            passeio.setVelocMax(Float.parseFloat(lt.entDados("Entre com a velocidade máxima: ")));
                        }catch(VelocException e){
                            passeio.setVelocMax(e.velocException(passeio));
                        }

                        passeio.setQtdRodas(Integer.parseInt(lt.entDados("Entre com a quantidade de rodas: ")));
                        passeio.getMotor().setQtdPist(Integer.parseInt(lt.entDados("Entre com a quantidade de pistões do motor do veiculo: ")));
                        passeio.getMotor().setPotencia(Integer.parseInt(lt.entDados("Entre com a potencia do veiculo: ")));
                        passeio.setQtdPassegeiros(Integer.parseInt(lt.entDados("Entre com a quantidade de passageiros do veiculo: ")));

                        try{
                            bdVeiculos.incluiPasseio(passeio);
                        }
                        catch(VeicExistException e){
                            e.veicExistException();
                        }


                        continua = lt.entDados("\nDeseja adicionar outro veiculo de passeio? (SIM ou NAO)");
                    }while(continua.equals("SIM"));

                    break;

                case 2:

                    do{
                        Carga carga = new Carga();
                        System.out.println("\n\n==================================\n");
                        carga.setPlaca(lt.entDados("Entre com o valor da placa do veiculo: "));
                        carga.setMarca(lt.entDados("Entre com o nome da marca do veiculo: "));
                        carga.setModelo(lt.entDados("Entre com o modelo do veiculo: "));
                        carga.setCor(lt.entDados("Entre com a cor do veiculo: "));

                        try {
                            carga.setVelocMax(Float.parseFloat(lt.entDados("Entre com a velocidade máxima: ")));
                        }catch(VelocException e){
                            carga.setVelocMax(e.velocException(carga));
                        }

                        carga.setQtdRodas(Integer.parseInt(lt.entDados("Entre com a quantidade de rodas do veiculo: ")));
                        carga.getMotor().setQtdPist(Integer.parseInt(lt.entDados("Entre com a quantidade de pistões do motor do veiculo: ")));
                        carga.getMotor().setPotencia(Integer.parseInt(lt.entDados("Entre com a potencia do veiculo: ")));
                        carga.setCargaMax(Integer.parseInt(lt.entDados("Entre com a carga maxima suportada pelo veiculo: ")));
                        carga.setTara(Integer.parseInt((lt.entDados("Entre com o peso de tara do veiculo: "))));

                        try{
                            bdVeiculos.incluiCarga(carga);
                        }
                        catch(VeicExistException e){
                            e.veicExistException();
                        }

                        continua = lt.entDados("\nDeseja adicionar outro veiculo de carga? (SIM ou NAO)");

                    }while (continua.equals("SIM"));

                    break;

                case 3:

                    System.out.println("\n\n==================================\n");
                    System.out.println("Os veiculos de passeio cadastrados são:");
                    for (Passeio veicPasseio: bdVeiculos.getListaPasseio()) {
                        System.out.println(veicPasseio);
                    }
                    System.out.println("\nFim da lista de veiculos==========");
                    lt.entDados("Tecle enter para retornar ao menu inicial:");

                    break;

                case 4:

                    System.out.println("\n\n==================================\n");
                    System.out.println("Os veiculos de carga cadastrados são:");
                    for (Carga veicCarga: bdVeiculos.getListaCarga()) {
                        System.out.println(veicCarga    );
                    }
                    System.out.println("\nFim da lista de veiculos==========");
                    lt.entDados("Tecle enter para retornar ao menu inicial:");

                    break;

                case 5:

                    System.out.println("\n\n==================================");
                    String placaPasseio = lt.entDados("Entre com a placa do veiculo de passeio: ");
                    for (Passeio veicPasseio: bdVeiculos.getListaPasseio()) {
                        if (placaPasseio.equals(veicPasseio.getPlaca())){
                            System.out.println("\nSeguem os dados do veiculo:");
                            System.out.printf("%s", veicPasseio.getPlaca());
                            System.out.printf("Veiculo Passeio{placa=%s, marca=%s, modelo=%s, cor=%s, velocMax=%.2f km/h, qtdRodas=%d, motor=Motor{qtdPist= %d, potencia= d%c cv}, qtdPassageiros= %d, velocidadeCalc = %.2f m/h, totalCaracteres = %d}",
                                    veicPasseio.getPlaca(), veicPasseio.getMarca(), veicPasseio.getModelo(), veicPasseio.getCor(), veicPasseio.getVelocMax(), veicPasseio.getQtdRodas(), veicPasseio.getMotor().getQtdPist(), veicPasseio.getMotor().getPotencia(), veicPasseio.getQtdPassegeiros(), veicPasseio.calcVel(veicPasseio.getVelocMax()), veicPasseio.calcula());
                            }
                    }
                    lt.entDados("\n\nTecle enter para retornar ao menu inicial:");

                    break;

                case 6:

                    System.out.println("\n\n==================================");
                    String placaCarga = lt.entDados("Entre com a placa do veiculo de carga: ");
                    for (Carga veicCarga: bdVeiculos.getListaCarga()) {
                        if (placaCarga.equals(veicCarga.getPlaca())){
                            System.out.println("\nSeguem os dados do veiculo:");
                            System.out.printf("Veiculo Carga{placa=%s, marca=%s, modelo=%s, cor=%s, velocMax=%.2f km/h, qtdRodas=%d, motor=Motor{qtdPist= %d, potencia= d%c cv}, cargaMax= %d, tara= %d, velocidadeCalc = %.2f cm/h, somaAtributos = %d}",
                                    veicCarga.getPlaca(), veicCarga.getMarca(), veicCarga.getModelo(), veicCarga.getCor(), veicCarga.getVelocMax(), veicCarga.getQtdRodas(), veicCarga.getMotor().getQtdPist(), veicCarga.getMotor().getPotencia(), veicCarga.getCargaMax(), veicCarga.getTara(), veicCarga.calcVel(veicCarga.getVelocMax()), veicCarga.calcula());
                        }
                    }
                    lt.entDados("\n\nTecle enter para retornar ao menu inicial:");

                    break;

                case 7:

                    System.out.println("\n\nSaindo do sistema==================");
                    System.out.println("Aplicação encerrada");

                    break;

                default:
                    System.out.println("Entre com uma das opções abaixo:");

                    break;
            }
        }
    }
}
