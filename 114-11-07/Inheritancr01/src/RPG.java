public class RPG {
    public static void main(String[] args) {
        SwordsMan swordsMan_light = new SwordsMan("勇士", 100, 20);
        SwordsMan swordsMan_dark = new SwordsMan("法師", 80, 15, 10);

        Magician magician_light = new Magician("勇士", 100, 20);
        Magician magician_dark = new Magician("法師", 80, 15, 10);


        System.out.println("戰鬥開始！");
        swordsMan_light.attack(swordsMan_dark);
        magician_dark.attack(magician_light);
        magician_dark.heal(magician_dark);


        System.out.println("戰鬥結束！");
    }
}
