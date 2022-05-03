package exceptions;

public class VeicExistException extends Exception{

    public  void veicExistException(){
        System.out.println("\n\tJá existe um veículo com esta placa!");
    }
}
