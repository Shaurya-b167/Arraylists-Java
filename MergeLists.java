import java.util.*;
class MergeLists
{
    private ArrayList<Integer> list;
    
    MergeLists()
    {
        list= new ArrayList();
    }
    
    void fillList()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Go on entering integers below. (Enter -1 to STOP.)\n");
        while(true)
        {
            int num= sc.nextInt();
            if(num == -1)
                break;
            list.add(num);
        } 
    }
    
    void showList()
    {
        for(int num: list)
            System.out.print(num+", ");
        System.out.println();
    }
    
    void mergeLists(MergeLists list1, MergeLists list2)
    {
        MergeLists obj= new MergeLists();
        obj.list= new ArrayList();
        int i, num, size1= list1.list.size(), size2= list2.list.size(), frontCnt=0, backCnt;
        for(i=0; i<size1+size2; i++)
        {
            if(i<size1)
            {
                num= list1.list.get(i);
                if(num%2!=0)
                   obj.list.add(frontCnt++, num);
                else
                   obj.list.add(num);
                continue;
            }
            backCnt= frontCnt;
            num= list2.list.get(i-size1);
            if(num%2!=0)
                obj.list.add(frontCnt++, num);
            else
                obj.list.add(backCnt++, num);
        } 
        System.out.println("\nList after merging both lists according to the given regulations: ");
        obj.showList();
    }
    
    public static void main(String[] args)
    {
        MergeLists obj1= new MergeLists(), obj2= new MergeLists();
        
        System.out.println("Elements for the 1st list: ");
        obj1.fillList();
        System.out.println("Elements for the 2nd list: ");
        obj2.fillList();
        
        System.out.println("\nElements of the 1st list(as entered): ");
        obj1.showList();
        System.out.println("\nElements of the 2nd list(as entered): ");
        obj2.showList();
        
        obj1.mergeLists(obj1, obj2);
    }
}