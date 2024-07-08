public class Hufflepuff extends Houses implements Magicable{
    public Hufflepuff() {
        super("Hufflepuff", "YELLOW");
    }
    
    @Override
    public void attackSpell(Player player, Player target, Spell spell) {
        if (spell instanceof Incendio) {
            target.setHP(target.getHP() - (spell.getDamage() + player.getAttackDamage()));
            player.setMana(player.getMana() - 3);
        }
        else if (spell instanceof Expelliarmus){
            target.setHP(target.getHP() - (spell.getDamage()+player.getAttackDamage()));
            player.setMana(player.getMana() - 4);
        }
        System.out.println("[" + player.getName() + "] : use spell ( " + spell.getName() + " )!");
    }
    
    @Override
    public void defense(Player player, Player damage){
        player.setHP(player.getHP() + 4);
        player.setMana(player.getMana() + 3);
        System.out.println("[" + player.getName() + "] : Protego !");
    }
}
