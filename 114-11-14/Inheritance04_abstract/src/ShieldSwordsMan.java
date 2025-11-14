public class ShieldSwordsMan extends SwordsMan{
    private int defenseCapacity;
    //建構子: 初始化劍士的名稱、生命值和攻擊力
    public ShieldSwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    //攻擊對手(劍客/魔法師)，父類別的參考指稻子類別物件
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5; // 盾牌減少5點傷害
        opponent.setHealth(opponent.getHealth() - reducedDamage);
        System.out.println(this.getName() + " 揮劍攻擊 " + opponent.getName() + " 造成 " +
                reducedDamage + " 點傷害（盾牌減少5點傷害）。" + opponent);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence(){
        this.setHealth(this.getHealth() + defenseCapacity);
        System.out.println(this.getName() + " 使用盾牌防禦，增加 " + defenseCapacity + " 點生命值。" + this);
    }
}
