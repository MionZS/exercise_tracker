import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListaCorridas implements Iterable<Corrida> {
    private final String nomeLista;
    private final ArrayList<Corrida> corridas;

    public ListaCorridas(String nomeLista) {
        this.nomeLista = nomeLista;
        this.corridas = new ArrayList<>();
    }

    public Corrida getCorrida(int i) {
        return corridas.get(i);
    }

    public void adicionarCorrida(Corrida corrida) {
        corridas.add(corrida);
    }

    /*
    public void removerCorrida(int i) {
        corridas.remove(i);
    } */

    public void removerCorrida(Corrida corrida) {
        corridas.remove(corrida);
    }

    /*
    public int getTamanho() {
        return corridas.size();
    } */
/*
    public void ordenarPorData() {
        Collections.sort(corridas);
    } */

    /*
    public void ordenarPorDistanciaENome() {
        Collections.sort(corridas, Comparator.comparingInt(Corrida::getDistancia).reversed()
                .thenComparing(Corrida::getNome));
    } */

    public List<Corrida> listarPorDificuldade() {
        return corridas.stream()
                .sorted(Comparator.comparingInt(Corrida::getDificuldade).reversed())
                .collect(Collectors.toList());
    }

    public List<Corrida> buscarPorNome(String trecho) {
        String termo = trecho.toLowerCase();
        List<Corrida> resultado = new ArrayList<>();
        for (Corrida c : corridas) {
            if (c.getNome().toLowerCase().contains(termo)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public boolean removerPorTrechoNome(String trecho) {
        List<Corrida> encontradas = buscarPorNome(trecho);
        if (encontradas.size() == 1) {
            removerCorrida(encontradas.getFirst());
            return true;
        }
        return false;
    }

    public int getNumeroCorridas() {
        return corridas.size();
    }

    public int getDistanciaTotal() {
        int total = 0;
        for (Corrida c : corridas) {
            total += c.getDistancia();
        }
        return total;
    }

    public int getTempoTotal() {
        int total = 0;
        for (Corrida c : corridas) {
            total += c.getTempo();
        }
        return total;
    }

    public double getTempoMedio() {
        if (corridas.isEmpty()) return 0;
        return (double) getTempoTotal() / corridas.size();
    }

    public List<Corrida> listarPorData() {
        return corridas.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Corrida> listarPorDistanciaENome() {
        return corridas.stream()
                .sorted(Comparator.comparingInt(Corrida::getDistancia).reversed()
                        .thenComparing(Corrida::getNome))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Corrida> iterator() {
        return corridas.iterator();
    }

    @Override
    public String toString() {
        return "ListaCorridas [nomeLista=" + nomeLista + ", corridas=" + corridas + "]";
    }
}
