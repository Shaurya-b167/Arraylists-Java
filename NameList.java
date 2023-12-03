import java.util.*;
class NameList
{
    private ArrayList<String> nameList;
    
    NameList()
    {
        nameList= new ArrayList();
    }
    
    void store()
    {
        Scanner sc= new Scanner(System.in);
        int cnt=0;
        System.out.print("Go on entering names below. (Hit 'Enter' key to STOP.)\n");
        while(true)
        {
            System.out.print("Enter name #"+(++cnt)+": ");
            String nam= sc.nextLine();
            if(nam.isEmpty()) 
                break;
            nameList.add(nam);
        } 
    } 
    
    void show()
    {
        sort();
        for(String name: nameList)
             System.out.print(name+", ");
        System.out.println();
    } 
    
    void sort()
    {
        Collections.sort(nameList);
        /*
        String name1, name2;;
        int i, size= nameList.size(), j;
        for(i=0; i<size; i++)
            for(j=0; j<size-1-i; j++)
            {
                name1= nameList.get(j);
                name2= nameList.get(j+1);
                if(name1.compareToIgnoreCase(name2) > 0)
                {
                    nameList.set(j, name2);
                    nameList.set(j+1, name1);
                }
            }
            */
    }
    
    void merge(NameList A, NameList B)
    {
        for(String name : A.nameList)
            if(nameList.indexOf(name)==-1)
                nameList.add(name);
        for(String name: B.nameList)
           if(nameList.indexOf(name)==-1)
               nameList.add(name);
    }
    
    public static void main(String[] args)
    {
        NameList obj1= new NameList(), obj2= new NameList(), obj3= new NameList();
        System.out.println("Elements for the first array: ");
        obj1.store();
        System.out.println("\nElements for the second array: ");
        obj2.store();
        
        obj3.merge(obj1, obj2);
        
        System.out.println("\nFirst sorted list: ");
        obj1.show();
        System.out.println("\nSecond sorted list: ");
        obj2.show();
        System.out.println("\nMerged sorted list: ");
        obj3.show();
    }
}