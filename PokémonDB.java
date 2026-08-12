import java.util.ArrayList;
import java.util.List;

public class PokémonDB {
    private final List<Pokémon> pokémon;

    public PokémonDB() {
        this.pokémon = new ArrayList<>();
        //"Megaevolución", "+20 defensa +10 ataque", 30
        //"Gigantamax", "+30 defensa + 15 ataque", 40
        //"Movimiento-Z", "+35 ataque", 35
        pokémon.add(new Pokémon("Charizard", Pokémon.Type.Fire, 84, 78, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Blastoise", Pokémon.Type.Water, 83, 100, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Venasaur", Pokémon.Type.Grass, 82, 83, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Pikachu", Pokémon.Type.Electric, 55, 40, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Victribeel", Pokémon.Type.Grass, 105, 65, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Gyarados", Pokémon.Type.Water, 125, 79, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Arcanine", Pokémon.Type.Fire, 110, 80, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Raichu", Pokémon.Type.Electric, 90, 55, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Sceptile", Pokémon.Type.Grass, 85, 65, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Infernape", Pokémon.Type.Fire, 104, 71, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Luxray", Pokémon.Type.Electric, 120, 79, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Torterra", Pokémon.Type.Grass, 109, 105, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Empoleon", Pokémon.Type.Water, 86, 88, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Electivire", Pokémon.Type.Electric, 123, 67, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Ampharos", Pokémon.Type.Electric, 75, 85, new Gimmick("Megaevolución", "+20 defensa y + 10 ataque", 30)));
        pokémon.add(new Pokémon("Blaziken", Pokémon.Type.Fire, 120, 70, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Swampert", Pokémon.Type.Water, 110, 90, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Incineroar", Pokémon.Type.Fire, 115, 90, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Toxtricity", Pokémon.Type.Electric, 94, 75, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Rillaboom", Pokémon.Type.Grass, 80, 75, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Cinderace", Pokémon.Type.Fire, 116, 75, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Inteleon", Pokémon.Type.Water, 85, 65, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Zeraora", Pokémon.Type.Electric, 112, 75, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Tapu Koko", Pokémon.Type.Electric, 115, 85, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Boltund", Pokémon.Type.Electric, 90, 60, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Regieleki", Pokémon.Type.Electric, 100, 50, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Manectric", Pokémon.Type.Electric, 125, 70, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Eelektross", Pokémon.Type.Electric, 120, 90, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Houndoom", Pokémon.Type.Fire, 90, 50, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Heatran", Pokémon.Type.Fire, 91, 106, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Coalossal", Pokémon.Type.Fire, 110, 80, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Centiskorch", Pokémon.Type.Fire, 115, 65, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Iron Moth", Pokémon.Type.Fire, 90, 70, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Scovillain", Pokémon.Type.Fire, 85, 60, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Greninja", Pokémon.Type.Water, 95, 85, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Drednaw", Pokémon.Type.Water, 90, 100, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Lapras", Pokémon.Type.Water, 85, 80, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Urshifu", Pokémon.Type.Water, 130, 100, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Toxapex", Pokémon.Type.Water, 63, 152, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Primarina", Pokémon.Type.Water, 74, 74, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Tapu Fini", Pokémon.Type.Water, 75, 115, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Chesnaught", Pokémon.Type.Grass, 107, 105, new Gimmick("Megaevolución", "+20 defensa y +10 ataque", 30)));
        pokémon.add(new Pokémon("Flapple", Pokémon.Type.Grass, 85, 70, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Appletun", Pokémon.Type.Grass, 85, 110, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Roserade", Pokémon.Type.Grass, 70, 65, new Gimmick("Gigantamax", "+30 defensa + 15 ataque", 40)));
        pokémon.add(new Pokémon("Decidueye", Pokémon.Type.Grass, 107, 75, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Tsareena", Pokémon.Type.Grass, 120, 75, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
        pokémon.add(new Pokémon("Tapu Bulu", Pokémon.Type.Grass, 130, 115, new Gimmick("Movimiento-Z", "+35 ataque", 35)));
    }

    public List<Pokémon> getPokémon() {
        return pokémon;
    }

    public String getPokémonList() {
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < pokémon.size(); i++) {
            int indiceMostrado = i + 1;
            list.append(String.format("%2d. %-12s | %-8s | Ataque: %-3d | Defensa: %-3d | %s%n",
                    indiceMostrado,
                    pokémon.get(i).getName(),
                    pokémon.get(i).getType(),
                    pokémon.get(i).getAttack(),
                    pokémon.get(i).getDefense(),
                    pokémon.get(i).getGimmick().getName()));
        }
        return list.toString();
    }
}