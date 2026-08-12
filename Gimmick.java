import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gimmick {
    private final String name;
    private final String effect;
    private final int probability;
    private final int attackBonus;
    private final int defenseBonus;

    public Gimmick(String name, String effect, int probability) {
        this(name, effect, probability, 0, 0);
    }

    public Gimmick(String name, String effect, int probability, int attackBonus, int defenseBonus) {
        this.name = name;
        this.effect = effect;
        this.probability = probability;
        this.attackBonus = attackBonus > 0 ? attackBonus : extractBonus(effect, "ataque");
        this.defenseBonus = defenseBonus > 0 ? defenseBonus : extractBonus(effect, "defensa");
    }

    private static int extractBonus(String effect, String stat) {
        if (effect == null) {
            return 0;
        }

        Matcher matcher = Pattern.compile("(\\d+)\\s*" + stat, Pattern.CASE_INSENSITIVE).matcher(effect);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }

        return 0;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public int getProbability() {
        return probability;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public int getDefenseBonus() {
        return defenseBonus;
    }

    @Override
    public String toString() {
        return name + " (" + effect + ", probabilidad: " + probability + "% )";
    }
}