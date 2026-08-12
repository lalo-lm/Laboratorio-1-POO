public class CombatControler {

    private final Trainer trainer1;
    private final Trainer trainer2;
    private final PokémonDB pokémonDB;
    private int round;

    public CombatControler(Trainer trainer1, Trainer trainer2, PokémonDB pokémonDB) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.pokémonDB = pokémonDB;
        this.round = 0;
    }

    public void startCombat() {
        round = 0;
        trainer1.getTeam().forEach(Pokémon::resetForBattle);
        trainer2.getTeam().forEach(Pokémon::resetForBattle);

        while (hasAvailablePokemon(trainer1) && hasAvailablePokemon(trainer2) && round < 20) {
            playRound();
        }

        determineWinner();
    }

    public void playRound() {
        round++;
        System.out.println("\n=== Ronda " + round + " ===");

        if (!hasAvailablePokemon(trainer1) || !hasAvailablePokemon(trainer2)) {
            return;
        }

        Pokémon attacker1 = trainer1.getTeam().get(0);
        Pokémon attacker2 = trainer2.getTeam().get(0);

        attacker1.activateGimmickBuff();
        attacker2.activateGimmickBuff();

        int damage1 = calculateAttack(attacker1, attacker2);
        int damage2 = calculateAttack(attacker2, attacker1);

        attacker2.takeDamage(damage1);
        System.out.printf("%s ataca a %s y causa %d de daño. Vida restante: %d%n",
                attacker1.getName(), attacker2.getName(), damage1, attacker2.getCurrentHp());

        if (!attacker2.isFainted()) {
            attacker1.takeDamage(damage2);
            System.out.printf("%s contraataca y causa %d de daño. Vida restante: %d%n",
                    attacker2.getName(), damage2, attacker1.getCurrentHp());
        }

        if (attacker2.isFainted()) {
            trainer2.getTeam().remove(0);
            System.out.println(attacker2.getName() + " fue derrotado.");
        }

        if (attacker1.isFainted()) {
            trainer1.getTeam().remove(0);
            System.out.println(attacker1.getName() + " fue derrotado.");
        }

        trainer1.getTeam().forEach(Pokémon::advanceTurn);
        trainer2.getTeam().forEach(Pokémon::advanceTurn);
    }

    public int calculateAttack(Pokémon attacker, Pokémon defender) {
        int baseDamage = attacker.getEffectiveAttack() - (defender.getEffectiveDefense() / 2);
        int typeModifier = Pokémon.getTypeModifier(attacker.getType(), defender.getType());
        int totalDamage = baseDamage + typeModifier;

        if (typeModifier > 0) {
            System.out.println("¡Es efectivo! " + attacker.getName() + " alcanza un bonus de +" + typeModifier + ".");
        } else if (typeModifier < 0) {
            System.out.println("¡Es débil! " + attacker.getName() + " sufre un penalización de " + typeModifier + ".");
        }

        return Math.max(5, totalDamage);
    }

    public void determineWinner() {
        if (!hasAvailablePokemon(trainer1) && !hasAvailablePokemon(trainer2)) {
            System.out.println("El combate terminó en empate.");
            return;
        }

        if (!hasAvailablePokemon(trainer1)) {
            System.out.println("Ganó " + trainer2.getName() + " con su equipo.");
            return;
        }

        if (!hasAvailablePokemon(trainer2)) {
            System.out.println("Ganó " + trainer1.getName() + " con su equipo.");
            return;
        }

        System.out.println("El combate ha terminado.");
    }

    private boolean hasAvailablePokemon(Trainer trainer) {
        return trainer != null && trainer.getTeam() != null && !trainer.getTeam().isEmpty();
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public PokémonDB getPokémonDB() {
        return pokémonDB;
    }

    public int getRound() {
        return round;
    }
}