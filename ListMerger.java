import java.util.*;
class ListMerger
{
    private ArrayList<Integer> list;

    ListMerger()
    {
        list= new ArrayList();
    }

    void fill()
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

    void show()
    {
        for(int num: list)
            System.out.print(num+", ");
        System.out.println();
    }

    int sortOrder()
    {
        int i, num1, num2, ascCnt=0, descCnt=0, size= list.size();
        for(i=0; i<size-1; i++)
        {
            num1= list.get(i);
            num2= list.get(i+1);
            if(num1<=num2)
                ascCnt++;
            else if(num1>=num2)
                descCnt++;
            if(ascCnt!=i && descCnt!=i)
                return 0;
        }
        return ascCnt==size-1? 1 : 2;
    }

    void mergeWhileSort(ListMerger list1, ListMerger list2)
    {
        int n1= list1.list.size(), n2= list2.list.size(), index1=0, index2=n2-1;
        for(int i=0; i<n1+n2; i++)
            if(index2<0 || (index1<n1 && 
                list1.list.get(index1) < list2.list.get(index2)))
                list.add(list1.list.get(index1++));
            else
                list.add(list2.list.get(index2--));
    } 
 
    public static void main(String[] args)
    {
        ListMerger obj1= new ListMerger(), obj2= new ListMerger(), 
        mergeObj= new ListMerger();

        System.out.println("Enter elements for the 1st list in ascending order: ");
        obj1.fill();
        System.out.println("Enter elements for the 2nd list in DESCENDING order:: ");
        obj2.fill();
        if(obj1.sortOrder()==1 && obj2.sortOrder()==2)
            mergeObj.mergeWhileSort(obj1, obj2);

        System.out.println("\nElements of the 1st list(as entered): ");
        obj1.show();
        System.out.println("\nElements of the 2nd list(as entered): ");
        obj2.show();
        System.out.println("\nElements of the Merge-Sorted list (as formed): ");
        mergeObj.show();
    }
}