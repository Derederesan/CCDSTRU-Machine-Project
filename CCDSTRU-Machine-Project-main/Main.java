import java.util.*; 
import java.util.HashSet;
import java.util.Set; 

public class Main
{
    public static void main(String[] args)
    {
        GameSystem game = new GameSystem();
        Scanner scanner = new Scanner(System.in);
        String input;  
        Set<Integer> userChoice = new HashSet<>();
        while(game.isGameOver()==false)
        {
            userChoice.clear(); 
            game.PlayerRoll();
            System.out.println("Dice Sum: " + game.getSum());
            System.out.println("Open Numbers: " + game.getOpen());
            game.CheckGameOver(game.isGameOver()); 
            game.checkWinner(game.isGameWinner()); 
            game.GameOver();
            if(game.isGameOver()==false)
            {
                System.out.println("Enter your choices (separate with spaces): ");
                input= scanner.nextLine(); 
                String [] choiceArray = input.split("\\s"); 
                for(int i=0; i<choiceArray.length; i++)
                {
                    userChoice.add(Integer.parseInt(choiceArray[i])); 
                }
                game.SelectNumbers(userChoice);
                while(game.isValid()==false)
                {
                    userChoice.clear(); 
                    System.out.println("Choices sum must equal to the dice sum!"); 
                    System.out.println("Enter your choices (separate with spaces): ");
                    input= scanner.nextLine(); 
                    choiceArray = input.split("\\s"); 
                    for(int i=0; i<choiceArray.length; i++)
                    {
                        userChoice.add(Integer.parseInt(choiceArray[i]));     
                    }
                    game.SelectNumbers(userChoice);
                    
            }
            }
            
        }

        scanner.close(); 
        
    }
}