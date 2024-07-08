public class Player {
    private Houses houses;
    private int hp = 20;
    private int mana = 50;
    private final int attackDamage = 2;
    private final String name;
    // Atti. ที่กำหนดค่ามาแล้วนั้น ไม่ต้องกำนหนด constructor
    public Player(String name){
        this.name = name;
    }
    
    public Player(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    public int getAttackDamage() {
        return this.attackDamage;
    }
    
    public int getHP() {
        return this.hp;
    }
    
    public Houses getHouses() {
        return this.houses;
    }
    
    public int getMana() {
        return this.mana;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setHP(int hp) {
        if (hp > 20) {
            this.hp = 20;
        }
        else if (hp > 0){
            this.hp = hp;
        }
        else {
            this.hp = 0;
        }
    }
    
    public void setHouses(Houses houses) {
        this.houses = houses;
    }
    
    public void setMana(int mana) {
        if (mana > 50) {
            this.mana = 50;
        }
        else if (mana > 0){
            this.mana = mana;
        }
        else {
            this.mana = 0;
        }
    }
    
    public void attack(Player target, Spell spell) {
        if (this.getHouses() instanceof Hufflepuff){
            ((Hufflepuff) this.getHouses()).attackSpell(this, target, spell);
        }
        else {
            ((Gryffindor) this.getHouses()).attackSpell(this, target, spell);
        }
        if (target.getHP() == 0) {
            System.out.println("[DEAD] : " + target.getName() + " was killed by " + this.getName());
        }
    }
    
    public boolean equals(Player player) {
        return (this.getName().equals(player.getName())) && (this.getHouses() == player.getHouses());
    }
    
    public void protectFromPlayer(Player target) {
        if (this.getHouses() instanceof Hufflepuff){
            ((Hufflepuff) this.getHouses()).defense(this, target);
        }
        else {
            ((Gryffindor) this.getHouses()).defense(this, target);
        }
    }
    
    @Override
    public String toString() {
        return "[Player] : " + this.getName() + " HP: " + this.getHP() + " Mana: " + this.getMana() + " || " + this.getHouses();
    }
}
