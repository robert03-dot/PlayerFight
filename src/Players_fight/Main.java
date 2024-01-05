package Players_fight;

public class Main {
    public static void main(String[] args) {
        Player_Status player1 = new Player_Status();
        player1.IntPlayer("Tux",3,30000);
        Player_Status player2 = new Player_Status();
        player2.IntPlayer("Doge",3,50000);
        player1.findArtifact(3);
        player2.findArtifact(5);
        player1.setWeaponInHand();
        player2.setWeaponInHand();
        player1.movePlayerTo(12,45);
        player2.movePlayerTo(34,78);
        player1.displayPlayerStatus();
        player2.displayPlayerStatus();
        System.out.println(player1.shouldAttackOpponent(player2));
        player1.attackOpponent(player2);
        player2.displayPlayerStatus();
        player1.attackOpponent(player2);
        player2.displayPlayerStatus();
        player1.attackOpponent(player2);
        player1.attackOpponent(player2);
        player2.displayPlayerStatus();
    }
}
