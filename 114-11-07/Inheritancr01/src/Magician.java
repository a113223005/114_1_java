public class Magician extends Role{
    //private int healPower;

    public Magician(String name, int health, int magicPower, int healPower) {
        super(name, health, magicPower);
        this.healPower = healPower;
    }

    public int getHealthPower() {
        return healPower;
    }

    public void attack(Magician opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " 施放魔法攻擊 " + opponent.getName() + "，造成 " +
                this.getAttactPower + " 點傷害。" + opponent);
    }

    public void heal(Role ally) {
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " 治療 " + ally.getName() + "，恢復 " + this.healPower + " 點生命值。" + ally);
    }

    public String toString(){
        return super.toString() + ", 治療力: " + healPower;
    }
}
