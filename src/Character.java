public class Character implements Comparable<Character> {
    private boolean is_legendary;
    private String name;
    private int hp;

    public Character () {
        this.name = " ";
        this.is_legendary = false;
        this.hp = -1;
    }

    public Character(String dataLine) {
        String[] data = dataLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        this.name = data[30].trim();
        this.hp = Integer.parseInt(data[28].trim());
        this.is_legendary = Integer.parseInt(data[40].trim()) == 1;
    }

    // getters
    public boolean getLegendary() {
        return this.is_legendary;
    }
    public String getName() {
        return this.name;
    }
    public int getHP() {
        return this.hp;
    }

    // info (print method)
    public void info() {
        System.out.printf("Name: %-15s HP: %-5d Legendary: %-5b%n", this.name, this.hp, this.is_legendary);
    }

    @Override
    public int compareTo(Character that) {
        int nameComp = this.name.compareTo(that.name);
        if(nameComp != 0)
            return nameComp;

        int legendaryComp = Boolean.compare(this.is_legendary, that.is_legendary);
        if(legendaryComp != 0)
            return legendaryComp;

        return Integer.compare(this.hp, that.hp);
    }
}