import java.util.*;
class CrossedList
{
    private ArrayList<Integer> arrList;
    
    void makeList()
    {
        Scanner sc= new Scanner(System.in);
        arrList= new ArrayList();
        System.out.print("Go on entering integers below. (Enter -1 to STOP.)\n");
        while(true)
        {
            int num= sc.nextInt();
            if(num == -1)
                break;
            arrList.add(num);
        } 
    }
    
    void showList()
    {
        for(int num: arrList)
            System.out.print(num+", ");
        System.out.println();
    }
   
    CrossedList copyCrissCrossed()
    {
        CrossedList obj= new CrossedList();
        obj.arrList= new ArrayList();
        int i, size= arrList.size();
        for(i=0; i<size-1; i+=2)
        {
            obj.arrList.add(i, arrList.get(i+1));
            obj.arrList.add(i+1, arrList.get(i));
        }
        if(size%2!=0)
           obj.arrList.add(size-1, arrList.get(size-1));
        return obj;
    } 
    
    public static void main(String[] args)
    {
        CrossedList obj= new CrossedList(), crossed;
        obj.makeList();
        
        System.out.println("\nGiven List: ");
        obj.showList();
        
        crossed= obj.copyCrissCrossed();
        System.out.println("\nCrossed List: ");
        crossed.showList();
    }
}