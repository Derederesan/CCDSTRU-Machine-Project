import java.util.HashSet;
import java.util.Set; 

public class GameSystem
{
    //determine the role of the applicable sets 
    //research how to add the open and closed variables 
    private Set<Integer> Open = new HashSet<>();
    private Set<Integer> Closed = new HashSet<>();
    
    //open=n 
    //closed = null 
    private int d1; 
    private int d2; 
    private int sum; 

    private boolean valid=false; 
    private boolean over=false; 
    private boolean win=false; 

    public GameSystem()
    {
        int i;
        for(i=1; i<=12; i++)
        {
            this.open.add(i);
        }
    }
    public void PlayerRoll()
    {
        //d1 & d2 are randomly assigned values from 1-6 
        this.d1 = (int) (Math.random() * 6) + 1; 
        this.d2 = (int) (Math.random() * 6) + 1;
        this.sum=d1+d2; 
    }

    public void SelectNumbers()
    {
        //check if choice is subset of open 
            //also adds the choices to sum 
            //not valid will be valid
        //if not subset 
            //valid = false 
       
    }

    public void CloseNumbers()
    {

    }

    public void CheckGameOver(boolean over)
    {

    }

    public void checkWinner(boolean win)
    {
        if(this.open.isEmpty())
        {
            this.win=true; 
        }    
    }

    public void GameOver()
    {
        //add result which contains the player that won and the player that lost 
        if(this.win==true)
        {
            System.out.println("Player Wins!");//maybe have smth to keep track of who the current player is and update this
        }
        else if(this.over ==true && this.win == false)
        {
            System.out.println("Player Loses");
        }
    }

    //getters for variables

    public Set<Integer> getOpen()
    {
        return this.Open; 
    }

    public Set<Integer> getClosed()
    {
        return this.closed;
    }

    public int getSum()
    {
        return this.sum; 
    }


}