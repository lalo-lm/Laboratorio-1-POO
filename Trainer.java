import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private final String name;
    private final List<Pokémon> team;
    private int selectedPokémonIndex;

    public Trainer(String name) {
        this.name = name;
        this.team = new ArrayList<>();
        this.selectedPokémonIndex = -1;
    }

    public Trainer(String name, Pokémon[] pokémon) {
        this(name);
        if (pokémon != null) {
            for (Pokémon pokemon : pokémon) {
                if (pokemon != null && !team.contains(pokemon)) {
                    team.add(pokemon);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Pokémon> getTeam() {
        return team;
    }

    public void addPokémon(Pokémon pokemon) {
        if (pokemon != null && !team.contains(pokemon)) {
            team.add(pokemon);
        }
    }

    public Pokémon[] getPokémon() {
        return team.toArray(Pokémon[]::new);
    }

    public Pokémon selectPokemon(int index) {
        if (index >= 0 && index < team.size()) {
            selectedPokémonIndex = index;
            return team.get(index);
        }

        return null;
    }

    public Pokémon getSelectedPokemon() {
        if (selectedPokémonIndex >= 0 && selectedPokémonIndex < team.size()) {
            return team.get(selectedPokémonIndex);
        }

        return null;
    }
}