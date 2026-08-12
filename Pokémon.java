public class Pokémon {
    private final String name;
    private final Type type;
    private final int attack;
    private final int defense;
    private final Gimmick gimmick;
    private int currentHp;
    private int temporaryAttackBonus;
    private int temporaryDefenseBonus;
    private int gimmickTurnsRemaining;

    public enum Type {
        Fire, Water, Grass, Electric
    }

    public static int getTypeModifier(Type attackerType, Type defenderType) {
        if (attackerType == Type.Fire && defenderType == Type.Grass) {
            return 20;
        }
        if (attackerType == Type.Fire && defenderType == Type.Water) {
            return -10;
        }
        if (attackerType == Type.Grass && defenderType == Type.Water) {
            return 20;
        }
        if (attackerType == Type.Grass && defenderType == Type.Fire) {
            return -10;
        }
        if (attackerType == Type.Water && defenderType == Type.Fire) {
            return 20;
        }
        if (attackerType == Type.Water && defenderType == Type.Grass) {
            return -10;
        }
        if (attackerType == Type.Electric && defenderType == Type.Water) {
            return 20;
        }
        if (attackerType == Type.Electric && defenderType == Type.Grass) {
            return -10;
        }
        return 0;
    }

    public Pokémon(String name, Type type, int attack, int defense, Gimmick gimmick) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.gimmick = gimmick;
        this.currentHp = 100;
        this.temporaryAttackBonus = 0;
        this.temporaryDefenseBonus = 0;
        this.gimmickTurnsRemaining = 0;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getEffectiveAttack() {
        return attack + temporaryAttackBonus;
    }

    public int getEffectiveDefense() {
        return defense + temporaryDefenseBonus;
    }

    public Gimmick getGimmick() {
        return gimmick;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void activateGimmickBuff() {
        if (gimmick == null) {
            return;
        }

        if (gimmickTurnsRemaining > 0) {
            return;
        }

        temporaryAttackBonus = gimmick.getAttackBonus();
        temporaryDefenseBonus = gimmick.getDefenseBonus();
        gimmickTurnsRemaining = 2;
    }

    public void advanceTurn() {
        if (gimmickTurnsRemaining > 0) {
            gimmickTurnsRemaining--;
            if (gimmickTurnsRemaining == 0) {
                temporaryAttackBonus = 0;
                temporaryDefenseBonus = 0;
            }
        }
    }

    public void takeDamage(int damage) {
        currentHp = Math.max(0, currentHp - damage);
    }

    public boolean isFainted() {
        return currentHp <= 0;
    }

    public int getGimmickTurnsRemaining() {
        return gimmickTurnsRemaining;
    }

    public void resetForBattle() {
        currentHp = 100;
        temporaryAttackBonus = 0;
        temporaryDefenseBonus = 0;
        gimmickTurnsRemaining = 0;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-8s | Ataque: %-3d | Defensa: %-3d | Gimmick: %s",
                name, type, attack, defense, gimmick.getName());
    }
}