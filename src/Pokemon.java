import java.util.HashSet;
import java.util.TreeSet;

public class Pokemon {
    public static void main(String [] args) {
        String filePath = "/Users/carlosquiroz/PokemonProj/files/Pokemon.csv";
        CsvReader reader = new CsvReader();
        reader.readFile(filePath);
        HashSet<Character> characterSet = reader.getCharacterSet();

        try {
            HashSet<Character> hpSet = getHitPointList(-1, characterSet);
            print(hpSet);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Number of Legendary Pokemon: " + getIsLegendaryCount(characterSet));
        TreeSet<Character> nameSet = getCharacterByFirstLetter('B', characterSet);
        print(nameSet);
    }

    /**
     * @param maxHP - max hp from user input
     * @param baseSet - characterSet in main
     * @return - set of Pokemon characters that have a range of HP from 0 - maxHp
     */
    public static HashSet<Character> getHitPointList(int maxHP, HashSet<Character>baseSet) throws Exception {
        if(maxHP < 0)
            throw new Exception("Invalid HP. Must be a positive Integer.");

        HashSet<Character> hpSet = new HashSet<>();

        for(Character pkMon : baseSet) {
            if(pkMon.getHP() <= maxHP)
                hpSet.add(pkMon);
        }
        return hpSet;
    }

    /**
     * @param baseSet is characterSet in main
     * @return the total count of characters that are marked as legendary
     */
    public static int getIsLegendaryCount(HashSet<Character> baseSet) {
        int legendCount = 0;

        for(Character pkMon : baseSet) {
            if(pkMon.getLegendary())
                legendCount++;
        }
        return legendCount;
    }

    /**
     * @param firstLetter - first letter of Pokemon name
     * @param baseSet - characterSet in main
     * @return - set that orders Character objects by name
     */
    public static TreeSet<Character> getCharacterByFirstLetter(char firstLetter, HashSet<Character> baseSet) {
        TreeSet<Character> nameSet = new TreeSet<>();

        for(Character pkMon : baseSet) {
            if(pkMon.getName().charAt(0) == firstLetter)
                nameSet.add(pkMon);
        }
        return nameSet;
    }

    // Helper print methods
    public static void print(HashSet<Character> hs) {
        for (Character h : hs)
            h.info();
    }
    public static void print(TreeSet<Character> hs) {
        for (Character h : hs)
            h.info();
    }
}