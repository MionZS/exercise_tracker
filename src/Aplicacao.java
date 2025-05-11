import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        exibirLogo();

        // Exibição inicial do menu
        do {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║     CONTROLE DE CORRIDAS 🏃      ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1) Cadastrar nova corrida        ║");
            System.out.println("║ 2) Listar corridas por data      ║");
            System.out.println("║ 3) Buscar corrida por nome       ║");
            System.out.println("║ 4) Listar por distância          ║");
            System.out.println("║ 5) Listar por dificuldade        ║");
            System.out.println("║ 6) Resumo de desempenho          ║");
            System.out.println("║ 7) Excluir corrida existente     ║");
            System.out.println("║ 0) Sair                          ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println();
            System.out.println("[34m🔹 Escolha uma opção:[0m");
            System.out.print(">>> ");

            String entrada = scanner.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = -1; // valor inválido para forçar aviso
            } // consumir o ENTER

            if (opcao == 1) {
                exibirSeparador();
                System.out.println("[34m🔹 Cadastrar corrida:[0m");
                System.out.print(">>> ");
                scanner.nextLine(); // simulação de entrada
            } else if (opcao == 2) {
                exibirSeparador();
                System.out.println("[34m🔹 Listar corridas por data:[0m");
            } else if (opcao == 3) {
                exibirSeparador();
                System.out.println("[34m🔹 Buscar corrida por nome:[0m");
            } else if (opcao == 4) {
                exibirSeparador();
                System.out.println("[34m🔹 Listar corridas por distância:[0m");
            } else if (opcao == 5) {
                exibirSeparador();
                System.out.println("[34m🔹 Listar corridas por dificuldade:[0m");
            } else if (opcao == 6) {
                exibirSeparador();
                System.out.println("[34m🔹 Mostrar resumo de desempenho:[0m");
            } else if (opcao == 7) {
                exibirSeparador();
                System.out.println("[34m🔹 Excluir corrida existente:[0m");
                System.out.print(">>> ");
                scanner.nextLine(); // simulação de entrada
            } else if (opcao == 0) {
                exibirSeparador();
                System.out.println("[33m🔸 Encerrando o programa...[0m");
                System.out.println();
            } else {
                System.out.println();
                System.out.println("[33m🔸 Opção inválida. Tente novamente.[0m");
                System.out.println();
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirLogo() {
        System.out.println("           _________ _______  _______  _______  _        _______  _______ ");
        System.out.println("|\\     /|  \\__   __/(  ____ )(  ___  )(  ____ \\| \\    /\\(  ____ \\(  ____ )");
        System.out.println("( \\   / )     ) (   | (    )|| (   ) || (    \\/|  \\  / /| (    \\/| (    )|");
        System.out.println(" \\ (_) /      | |   | (____)|| (___) || |      |  (_/ / | (__    | (____)|");
        System.out.println("  ) _ (       | |   |     __)|  ___  || |      |   _ (  |  __)   |     __)");
        System.out.println(" / ( ) \\      | |   | (\\ (   | (   ) || |      |  ( \\ \\ | (      | (\\ (   ");
        System.out.println("( /   \\ )     | |   | ) \\ \\__| )   ( || (____/\\|  /  \\ \\| (____/\\| ) \\ \\__");
        System.out.println("|/     \\|     )_(   |/   \\__/|/     \\|(_______/|_/    \\/(_______/|/   \\__/");
    }
    public static void exibirSeparador() {
        System.out.println("-..- - .-. .- -.-. -.- . .-.-..- - .-. .- -.-. -.- . .-.");
    }
}
