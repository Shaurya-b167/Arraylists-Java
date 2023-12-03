import java.util.*;
class MultiSet
{
    public static void fill (ArrayList<Integer> list)
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
    
    public static void show(ArrayList<Integer> list)
    {
        for(int num: list)
            System.out.print(num+", ");
        System.out.println();
    }
    
    public static ArrayList intersection(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList inter= new ArrayList();
        inter= new ArrayList();
        for(int num : list1)
            if(list2.indexOf(num)!=-1 && inter.indexOf(num)==-1) 
                inter.add(num);
        return inter;
    } 
    
    public static ArrayList union(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList uni= new ArrayList();
        uni= new ArrayList();
        for(int num: list1)
            if(!uni.contains(num))
                uni.add(num);
        for(int num: list2)
            if(!uni.contains(num))
                uni.add(num);
        return uni;
    } 
    
    public static void main(String[] args)
    {
        ArrayList<Integer> list1= new ArrayList(), list2= new ArrayList(), inter, uni;
        System.out.println("Elements for the 1st list: ");
        fill(list1);
        System.out.println("Elements for the 2nd list: ");
        fill(list2);
        
        System.out.println("\nElements of the 1st list(as entered): ");
        show(list1);
        System.out.println("\nElements of the 2nd list(as entered): ");
        show(list2);
        
        inter= intersection(list1, list2);
        uni= union(list1, list2);
        System.out.println("\nIntersection elements: ");
        show(inter);
        System.out.println("\nUnion elements: ");
        show(uni);
    } 
}