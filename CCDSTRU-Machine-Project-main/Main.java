public class Main
{
    public static void main(String[] args)
    {
        GameSystem game = new GameSystem();

        game.PlayerRoll();

        System.out.println("Dice Sum: " + game.getSum());
        System.out.println("Open Numbers: " + game.getOpen());
    }
}