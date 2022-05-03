package bd;

import entities.Carga;
import entities.Passeio;
import exceptions.VeicExistException;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

    List<Passeio> listaPasseio = new ArrayList<>();
    List<Carga> listaCarga = new ArrayList<>();

    public BDVeiculos() {
    }

    public BDVeiculos(List<Passeio> listaPasseio, List<Carga> listaCarga) {
        this.listaPasseio = listaPasseio;
        this.listaCarga = listaCarga;
    }

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }

    public void incluiPasseio(Passeio p) throws VeicExistException {

        boolean existe = false;
        for (Passeio veicPasseio: listaPasseio) {
            if (p.getPlaca().equals(veicPasseio.getPlaca())){
                existe = true;
            }
        }
        if (existe){
            throw new VeicExistException();
        }
        else{
            listaPasseio.add(p);
        }
    }

    public void incluiCarga(Carga c) throws VeicExistException {

        boolean existe = false;
        for (Carga veicCarga: listaCarga) {
            if (c.getPlaca().equals(veicCarga.getPlaca())){
                existe = true;
            }
        }
        if (existe){
            throw new VeicExistException();
        }
        else{
            listaCarga.add(c);
        }
    }
}
