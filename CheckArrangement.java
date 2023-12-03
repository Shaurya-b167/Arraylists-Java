import java.util.*;
class CheckArrangement
{
    private ArrayList<Integer> numList;
    
    void fillList()
    {
        Scanner sc= new Scanner(System.in);
        numList= new ArrayList();
        System.out.print("Go on entering integers below. (Enter -1 to STOP.)\n");
        while(true)
        {
            int num= sc.nextInt();
            if(num == -1)
                break;
            numList.add(num);
        } 
    }
    
    void showList()
    {
        for(int num: numList)
            System.out.print(num+", ");
        System.out.println();
    }
    
    void checkList()
    {
        int i, size= numList.size();
        for(i=0; i<size/2; i++)
            if(numList.get(i)!=numList.get(size-i-1))
            {
                System.out.println("\nThe list elements are NOT in Palindromic arrangement!");
                return;
            }
        System.out.println("\nThe list elements are in palindromic arrangement!");
    } 
    
    public static void main(String[] args)
    {
        CheckArrangement obj= new CheckArrangement();
        obj.fillList();
        
        System.out.println("\nGiven elements: ");
        obj.showList();
        
        obj.checkList();
    }
}