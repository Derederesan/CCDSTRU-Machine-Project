public class Main
{
    public static void main(String[] args)
    {
        GameSystem game = new GameSystem();

        game.PlayerRoll();
        System.out.println(game.getD1() + " + " + game.getD2() + " = " + game.getSum());

        game.PlayerRoll();
        System.out.println(game.getD1() + " + " + game.getD2() + " = " + game.getSum());

        game.PlayerRoll();
        System.out.println(game.getD1() + " + " + game.getD2() + " = " + game.getSum());
    }
}