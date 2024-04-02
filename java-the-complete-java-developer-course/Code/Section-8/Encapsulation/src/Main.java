public class Main {
    public static void main(String[] args) {
        UnencapsulatedPlayer player = new UnencapsulatedPlayer();

        player.fullName = "Tim";
        player.health = 10;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        player.health = 200;

        player.loseHealth(11);
        System.out.println("Remaining health = " + player.healthRemaining());

        EncapsulatedPlayer evan = new EncapsulatedPlayer("Evan", 200, "Sword");
        System.out.println("Initial health is " + evan.healthRemaining());


    }
}
