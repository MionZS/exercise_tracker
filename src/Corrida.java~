import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Corrida implements Comparable<Corrida>, Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private LocalDate data;
    private int distancia;   // em metros
    private int tempo;       // em minutos
    private int dificuldade; // escala de esforço de 1 a 10

    // Construtor mínimo: apenas nome
    public Corrida(String nome) {
        this.nome = nome;
        this.data = null;
        this.distancia = 0;
        this.tempo = 0;
        this.dificuldade = 0;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty()) throw new IllegalArgumentException();
        this.nome = nome;
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public int getDistancia() { return distancia; }
    public void setDistancia(int distancia) { this.distancia = distancia; }

    public int getTempo() { return tempo; }
    public void setTempo(int tempo) { this.tempo = tempo; }

    public int getDificuldade() { return dificuldade; }
    public void setDificuldade(int dificuldade) { this.dificuldade = dificuldade; }

    // Ordenação natural por data (mais antigas primeiro), tratando null
    @Override
    public int compareTo(Corrida outra) {
        if (this.data == null && outra.data == null) return 0;
        if (this.data == null) return 1;
        if (outra.data == null) return -1;
        return this.data.compareTo(outra.data);
    }

    // Representação em string para exibição
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataStr = (data != null) ? data.format(fmt) : "--/--/----";
        return String.format("%s - %s - %dm - %dmin - dif %d",
                dataStr, nome, distancia, tempo, dificuldade);
    }

    public void modificar(int campo, String valor) {
        switch (campo) {
            case 1:
                setNome(valor);
                break;
            case 2:
                try {
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    setData(LocalDate.parse(valor, fmt));
                } catch (DateTimeParseException e) {
                    // valor inválido, manter data
                }
                break;
            case 3:
                try {
                    setDistancia(Integer.parseInt(valor));
                } catch (NumberFormatException e) {
                    // inválido, manter distância
                }
                break;
            case 4:
                try {
                    setTempo(Integer.parseInt(valor));
                } catch (NumberFormatException e) {
                    // inválido, manter tempo
                }
                break;
            case 5:
                try {
                    setDificuldade(Integer.parseInt(valor));
                } catch (NumberFormatException e) {
                    // inválido, manter dificuldade
                }
                break;
            default:
                // opção inexistente
                break;
        }
    }
}
