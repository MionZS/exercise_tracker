import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Corrida implements Comparable<Corrida>, Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate data;
    private String nome;
    private int distancia; // em metros
    private int tempo; // em minutos
    private int dificuldade; // escala de esforço de 1 a 10

    // Construtor completo
    public Corrida(String nome, LocalDate data, int distancia, int tempo, int dificuldade) {
        this.nome = nome;
        this.data = data;
        this.distancia = distancia;
        this.tempo = tempo;
        this.dificuldade = dificuldade;
    }

    // Construtor apenas com nome
    public Corrida(String nome) {
        this.nome = nome;
        this.data = null;
        this.distancia = 0;
        this.tempo = 0;
        this.dificuldade = 0;
    }

    // Getters e Setters
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    // Implementação de Comparable para ordenar por data
    @Override
    public int compareTo(Corrida outra) {
        return this.data.compareTo(outra.data);
    }

    // Método toString
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataStr = (data != null) ? data.format(formatter) : "Data não informada";
        String distanciaStr = (distancia > 0) ? String.format("%d.%03dm", distancia / 1000, distancia % 1000) : "Distância não informada";
        String tempoStr = (tempo > 0) ? tempo + " minutos" : "Tempo não informado";
        String dificuldadeStr = (dificuldade > 0) ? "Dificuldade: " + dificuldade + "/10" : "Dificuldade não informada";

        return String.format("%s - %s - %s - %s - %s",
                dataStr, nome, distanciaStr, tempoStr, dificuldadeStr);
    }
}
