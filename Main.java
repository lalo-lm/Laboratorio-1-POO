import java.util.Scanner;

public class Main {
    private static void selectTeamForTrainer(Scanner sc, PokémonDB pokemonDB, Trainer trainer) {
        System.out.println("\n" + trainer.getName() + ", elige 4 Pokémon para tu equipo.");
        System.out.println(pokemonDB.getPokémonList());

        while (trainer.getTeam().size() < 4) {
            System.out.print("Selecciona el Pokémon " + (trainer.getTeam().size() + 1) + " de 4: ");
            String input = sc.nextLine().trim();

            int selectedIndex;
            try {
                selectedIndex = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
                continue;
            }

            if (selectedIndex < 0 || selectedIndex >= pokemonDB.getPokémon().size()) {
                System.out.println("Índice inválido. Intenta nuevamente.");
                continue;
            }

            Pokémon chosen = pokemonDB.getPokémon().get(selectedIndex);
            if (trainer.getTeam().contains(chosen)) {
                System.out.println("Ese Pokémon ya fue elegido. Intenta con otro.");
                continue;
            }

            trainer.addPokémon(chosen);
            System.out.println("Seleccionaste: " + chosen.getName());
        }
    }

    private static void printTrainerTeam(Trainer trainer) {
        System.out.println("\nEquipo de " + trainer.getName() + ":");
        for (int i = 0; i < trainer.getTeam().size(); i++) {
            System.out.println((i + 1) + ". " + trainer.getTeam().get(i).getName());
        }
    }

    private static void showPokemonStats(Pokémon pokemon) {
        System.out.println("\nEstadísticas de " + pokemon.getName());
        System.out.println("Tipo: " + pokemon.getType());
        System.out.println("Ataque: " + pokemon.getAttack());
        System.out.println("Defensa: " + pokemon.getDefense());
        System.out.println("Gimmick: " + pokemon.getGimmick().getName() + " | " + pokemon.getGimmick().getEffect());
    }

    private static void showTrainerTeamDetails(Scanner sc, Trainer trainer) {
        printTrainerTeam(trainer);
        if (trainer.getTeam().isEmpty()) {
            return;
        }

        System.out.println("\nElige un Pokémon del equipo para ver sus estadísticas:");
        String input = "";
        while (!input.equals("0")) {
            System.out.print("Ingresa el número del Pokémon (0 para volver): ");
            input = sc.nextLine().trim();

            try {
                int selected = Integer.parseInt(input) - 1;
                if (input.equals("0")) {
                    break;
                }
                if (selected < 0 || selected >= trainer.getTeam().size()) {
                    System.out.println("Índice inválido.");
                    continue;
                }

                showPokemonStats(trainer.getTeam().get(selected));
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            PokémonDB pokemonDB = new PokémonDB();

            System.out.println("=== Registro de entrenadores ===");
            System.out.print("Nombre del entrenador 1: ");
            String trainer1Name = sc.nextLine().trim();
            while (trainer1Name.isEmpty()) {
                System.out.print("Ingresa un nombre válido para el entrenador 1: ");
                trainer1Name = sc.nextLine().trim();
            }

            System.out.print("Nombre del entrenador 2: ");
            String trainer2Name = sc.nextLine().trim();
            while (trainer2Name.isEmpty()) {
                System.out.print("Ingresa un nombre válido para el entrenador 2: ");
                trainer2Name = sc.nextLine().trim();
            }

            Trainer trainer1 = new Trainer(trainer1Name);
            Trainer trainer2 = new Trainer(trainer2Name);

            selectTeamForTrainer(sc, pokemonDB, trainer1);
            selectTeamForTrainer(sc, pokemonDB, trainer2);

            System.out.println("\n=== Equipos seleccionados ===");
            showTrainerTeamDetails(sc, trainer1);
            showTrainerTeamDetails(sc, trainer2);

            System.out.println("\n=== ¡COMBATE! ===");
            CombatControler combat = new CombatControler(trainer1, trainer2, pokemonDB);
            combat.startCombat();
        }
    }
}