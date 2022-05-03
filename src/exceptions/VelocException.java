package exceptions;

import entities.Passeio;
import entities.Veiculo;

public class VelocException extends Exception {

    public float velocException(Veiculo veiculo){
        System.out.println("A velocidade máxima esta fora dos limites brasileiros");
        if (veiculo instanceof Passeio){
            return 100;
        }else{
            return 90;
        }
    }
}
