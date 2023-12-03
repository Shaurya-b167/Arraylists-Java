import java.util.*;
class NewList
{
    private ArrayList<Integer> numList;
    
    void makeList()
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
    
    boolean isPrime(int n)
    {
        if(n<2)
           return false;
        for(int i=2; i<=n/2; i++)
           if(n%i==0)
              return false;
        return true;
    } 
    
    NewList formList()
    {
        NewList obj= new NewList();
        obj.numList= new ArrayList();
        for(int i=1; i<=4; i++)
            for(int num: numList)
                if((i==1 && num<0) || (i==2 && (num==0 || num==1)) || (i==3 && isPrime(num)) ||
                   (i==4 && !isPrime(num) && num>2))
                   obj.numList.add(num);
        return obj;
    }
    
    public static void main(String[] args)
    {
        NewList obj= new NewList(), newList;
        obj.makeList();
        
        System.out.println("\nGiven elements: ");
        obj.showList();
        
        newList= obj.formList();
        System.out.println("\nNew list formed containing elements in the given sequence: ");
        newList.showList();
    }
}