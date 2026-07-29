import java.util.HashSet;
import java.util.Set; 

public class GameSystem
{
    //determine the role of the applicable sets 
    //research how to add the open and closed variables 
    private Set<Integer> Open = new HashSet<>();
    private Set<Integer> Closed = new HashSet<>();
    private Set<Integer> choice = new HashSet<>();
    
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
            this.Open.add(i);
        }
    }
    public void PlayerRoll()
    {
        //d1 & d2 are randomly assigned values from 1-6 
        this.d1 = (int) (Math.random() * 6) + 1; 
        this.d2 = (int) (Math.random() * 6) + 1;
        this.sum=d1+d2; 
    }

    public void SelectNumbers(Set<Integer> choice)
{
    this.choice.clear();
    this.choice.addAll(choice);

    // Check if choice is a subset of Open
    if(!Open.containsAll(choice))
    {
        valid = false;
        return;
    }

    // compute the sum of the chosen numbers
    int total = 0;
    for(int num : choice)
    {
        total += num;
    }

    // check if the total matches the dice sum
    if(total == sum)
    {
        valid = true;   // Toggle valid
        CloseNumbers(); 
    }
    else
    {
        valid = false;
    }
}

    public void CloseNumbers()
    {
    if(valid)
    {
        Open.removeAll(choice);     // open = Open - choice
        Closed.addAll(choice);      // closed = Closed U choice

        valid = true;             // will reset valid back to false
    }
    }

    public void CheckGameOver(boolean over)
    {
        this.over = !hasPossibleMoves();

    }

    private boolean hasPossibleMoves()
    {
        // check if there is any subset of Open that sums to the current dice sum
        return subsetSum(Open, sum, new HashSet<>());
    }

    private boolean subsetSum(Set<Integer> set, int target, Set<Integer> current)
    {
        if(target == 0)
        {
            return true;
        }
        if(target < 0 || set.isEmpty())
        {
            return false;
        }

        Integer[] numbers = set.toArray(new Integer[0]);
        for(int i = 0; i < numbers.length; i++)
        {
            Set<Integer> newSet = new HashSet<>(set);
            newSet.remove(numbers[i]);
            Set<Integer> newCurrent = new HashSet<>(current);
            newCurrent.add(numbers[i]);
            if(subsetSum(newSet, target - numbers[i], newCurrent))
            {
                return true;
            }
        }
        return false;
    }

    public void checkWinner(boolean win)
    {
        
         this.win = this.Open.isEmpty(); 
            
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
        return new HashSet<>(Open); 
    }

    public Set<Integer> getClosed()
    {
        return this.Closed;
    }

    public Set<Integer> getChoice()
    {
        return this.choice; 
    }

    public int getD1()
    {
        return this.d1; 
    }

    public int getD2()
    {
        return this.d2; 
    }

    public int getSum()
    {
        return this.sum; 
    }

    public boolean isValid()
    {
        return this.valid; 
    }

    public boolean isGameOver()
    {
        return this.over; 
    }

    public boolean isGameWinner()
    {
        return this.win; 
    }
    

}