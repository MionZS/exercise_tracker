import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        ListaCorridas lista = new ListaCorridas("Corridas do Usuário");
        exibirLogo();

        while (true) {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║     CONTROLE DE CORRIDAS 🏃     ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1) Cadastrar nova corrida        ║");
            System.out.println("║ 2) Listar por data               ║");
            System.out.println("║ 3) Buscar por nome               ║");
            System.out.println("║ 4) Listar por distância/nome     ║");
            System.out.println("║ 5) Listar por dificuldade        ║");
            System.out.println("║ 6) Resumo de desempenho          ║");
            System.out.println("║ 7) Excluir corrida               ║");
            System.out.println("║ 0) Sair                          ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarCorrida(lista);
                case 2 -> listar(lista.listarPorData());
                case 3 -> buscarCorrida(lista);
                case 4 -> listar(lista.listarPorDistanciaENome());
                case 5 -> listar(lista.listarPorDificuldade());
                case 6 -> mostrarResumo(lista);
                case 7 -> excluirCorrida(lista);
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirLogo() {
        System.out.println("           _________ _______  _______  _______  _        _______  _______ ");
        System.out.println("|\\     /|  \\__   __/(  ____ )(  ___  )(  ____ \\| \\    /\\(  ____ \\(  ____ )");
        System.out.println("( \\   / )     ) (   | (    )|| (   ) || (    \\/|  \\  / /| (    \\/| (    )|");
        System.out.println(" \\ (_) /      | |   | (____)|| (___) || |      |  (_/ / | (__    | (____)|");
        System.out.println("  ) _ (       | |   |     __)|  ___  || |      |   _ (  |  __)   |     __)");
        System.out.println(" / ( ) \\      | |   | (\\ (   | (   ) || |      |  ( \\ \\ | (      | (\\ (   ");
        System.out.println("( /   \\ )     | |   | ) \\ \\__| )   ( || (____/\\|  /  \\ \\| (____/\\| ) \\ \\__");
        System.out.println("|/     \\|     )_(   |/   \\__/|/     \\|(_______/|_/    \\/(_______/|/   \\__/");
    }

    private static void cadastrarCorrida(ListaCorridas lista) {
        System.out.println(">> Nova corrida");
        System.out.print("Digite o nome da corrida: ");
        String nome = scanner.nextLine();

        Corrida corrida = new Corrida(nome);

        try {
            System.out.print("Digite a data da corrida (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            if (!dataStr.isBlank()) {
                LocalDate data = LocalDate.parse(dataStr, formatter);
                corrida.setData(data);
            }
        } catch (Exception e) {
            System.out.println("Data inválida, ignorada.");
        }

        System.out.print("Digite a distância percorrida (em metros): ");
        String distStr = scanner.nextLine();
        if (!distStr.isBlank()) corrida.setDistancia(Integer.parseInt(distStr));

        System.out.print("Digite o tempo gasto (em minutos): ");
        String tempoStr = scanner.nextLine();
        if (!tempoStr.isBlank()) corrida.setTempo(Integer.parseInt(tempoStr));

        System.out.print("Dificuldade percebida (1 a 10): ");
        String difStr = scanner.nextLine();
        if (!difStr.isBlank()) corrida.setDificuldade(Integer.parseInt(difStr));

        lista.adicionarCorrida(corrida);
        System.out.println("Corrida cadastrada com sucesso!");
    }

    private static void listar(List<Corrida> corridas) {
        System.out.println(">> Lista de corridas");
        for (Corrida c : corridas) {
            System.out.println(c);
        }
    }

    private static void buscarCorrida(ListaCorridas lista) {
        System.out.print("Digite parte do nome da corrida a buscar: ");
        String trecho = scanner.nextLine();
        List<Corrida> resultados = lista.buscarPorNome(trecho);

        if (resultados.isEmpty()) {
            System.out.println("Nenhuma corrida encontrada.");
        } else {
            listar(resultados);
        }
    }

    private static void mostrarResumo(ListaCorridas lista) {
        System.out.println(">> Resumo de desempenho");
        System.out.println("Número de corridas: " + lista.getNumeroCorridas());
        System.out.println("Distância total percorrida: " + lista.getDistanciaTotal() + "m");
        System.out.println("Tempo total gasto: " + lista.getTempoTotal() + " minutos");
        System.out.printf("Tempo médio por corrida: %.2f minutos\n", lista.getTempoMedio());
    }

    private static void excluirCorrida(ListaCorridas lista) {
        System.out.print("Digite parte do nome da corrida a excluir: ");
        String trecho = scanner.nextLine();
        List<Corrida> resultados = lista.buscarPorNome(trecho);
        if (resultados.isEmpty()) {
            System.out.println("Nenhuma corrida encontrada.");
        } else if (resultados.size() == 1) {
            System.out.println("Encontrei: " + resultados.get(0));
            System.out.print("Deseja excluir <S/N>: ");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                lista.removerCorrida(resultados.get(0));
                System.out.println("Corrida excluída com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        } else {
            System.out.println("Múltiplas corridas encontradas, refine sua busca.");
            listar(resultados);
        }
    }
}
