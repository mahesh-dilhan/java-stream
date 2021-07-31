import java.util.Arrays;
import java.util.List;

public class Country {
    final String name;
    final String state;
    final int positiveCases;

    public Country(String name, String state, int positiveCases) {
        this.name = name;
        this.state = state;
        this.positiveCases = positiveCases;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getPositiveCases() {
        return positiveCases;
    }
    @Override
    public String toString() {
        return new StringBuilder().append(name).append("-"+state).append("-"+positiveCases).toString();
    }

   public final static List<Country> countryStream = Arrays.asList(
            new Country("USA", "NY", 100),
            new Country("USA", "WC", 200),
            new Country("USA", "MI", 300),
            new Country("USA", "PY", 400),
            new Country("USA", "AL", 500),
            new Country("SG", "SGK", 600),
            new Country("SG", "PUN", 700),
            new Country("SG", "PRS", 800),
            new Country("SG", "JE", 900),
            new Country("SG", "BK", 10)
    );
}
