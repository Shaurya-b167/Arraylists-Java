import java.util.*;
class BinSearchNames
{
    ArrayList<String> name;
    ArrayList<Integer> age;
    
    BinSearchNames()
    {
        name= new ArrayList();
        age= new ArrayList();
    }
    
    void fill()
    {
        Scanner sc= new Scanner(System.in);
        int cnt=0;
        System.out.print("Go on entering names and ages of students below. (Hit 'Enter' key to STOP.)\n");
        while(true)
        {
            System.out.println("\nEnter details for Student #"+ ++cnt+": "); 
            System.out.print("Enter name: ");
            String nam= sc.nextLine();
            if(nam.equals("")) 
                break;
            name.add(nam);
            System.out.print("Enter age: ");
            int ag= sc.nextInt(); sc.nextLine();
            age.add(ag);
        } 
    }
    
    void show()
    {
        int i, size= name.size();
        System.out.println("\nDetails of the students: "+
             "\nName\t\t\tAge");
        for(i=0; i<size; i++)
            System.out.println(name.get(i)+"\t\t"+age.get(i));
    }
    
    void sortRecords()
    {
        String name1, name2;
        int i, j, size=name.size(), yrs;
        for(i=0; i<size; i++)
           for(j=0; j<size-1-i; j++)
           {
               name1= name.get(j);
               name2= name.get(j+1);
               yrs= age.get(j);
               if(name1.compareTo(name2)>0)
               {
                   name.set(j, name2);
                   name.set(j+1, name1);
                   age.set(j, age.get(j+1));
                   age.set(j+1, yrs);
               }
           }
    }
    
    void binSearch(String name)
    {
        int size= this.name.size(), start=0, end= size-1, mid, yrs=0;
        while(start<=end)
        {
            mid= (start+end)/2;
            if(name.equalsIgnoreCase(this.name.get(mid)))
            {
                System.out.println("\n"+name+" is found in the list and is of "+age.get(mid)+
                    " years old!");
                return;
            }
            else if(name.compareTo(this.name.get(mid))<0)
                end= mid-1;
            else
                start= mid+1;
        }
        System.out.println("\nMatch NOT found in the list!");
    }
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        BinSearchNames obj= new BinSearchNames();
        
        obj.fill();
                
        obj.show();
        
        System.out.print("\nEnter the name to search in the list: ");
        String name= sc.nextLine();
        
        obj.sortRecords();
        obj.binSearch(name);
    }
}