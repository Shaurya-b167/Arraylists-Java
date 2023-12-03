import java.util.*;
class StudentList
{
    ArrayList<String> name;
    ArrayList<Integer> avgMarks;
    
    StudentList()
    {
        name= new ArrayList();
        avgMarks= new ArrayList();
    }
    
    void fill()
    {
        Scanner sc= new Scanner(System.in);
        int cnt=0;
        System.out.print("Go on entering names and avg marks of students below. (Hit 'Enter' key to STOP.)\n");
        while(true)
        {
            System.out.print("\nEnter name for student #"+(++cnt)+": ");
            String nam= sc.nextLine();
            if(nam==" ") 
                break;
            name.add(nam);
            System.out.print("Enter average marks for student #"+cnt+": ");
            int avg= sc.nextInt(); sc.nextLine();
            avgMarks.add(avg);
        } 
    }
    
    void show()
    {
        int i, size= name.size();
        System.out.println("\nDetails of the students: "+
             "\nName\t\tAverage Marks");
        for(i=0; i<size; i++)
            System.out.println(name.get(i)+"\t\t"+avgMarks.get(i));
    }
    
    void sort()
    {
        String name1, name2;
        int i, j, size=name.size(), marks;
        for(i=0; i<size; i++)
           for(j=0; j<size-1-i; j++)
           {
               name1= name.get(j);
               name2= name.get(j+1);
               marks= avgMarks.get(j);
               if(name1.compareTo(name2)>0)
               {
                   name.set(j, name2);
                   name.set(j+1, name1);
                   avgMarks.set(j, avgMarks.get(j+1));
                   avgMarks.set(j+1, marks);
               }
           }
    }
    
    int getRank(int pos)
    {
        int i, j, posNum= avgMarks.get(pos+1), num, size= name.size(), max=0, lastMax, maxPos=0;
        for(i=1; i<=size; i++)
        {
            lastMax= max;
            max=0;
            for(j=0; j<size; j++)
            {
                num= avgMarks.get(j);
                if(num>max && (i==1 || num<lastMax))
                   max= num;
            }
            if(max<posNum)
               break;
        }
        return i;
    }
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        StudentList obj= new StudentList();
        obj.fill();
        System.out.print("\nEnter the position whose rank is to be found: ");
        int pos= sc.nextInt();
        
        obj.show();
        obj.sort();
        obj.getRank(pos);
    }
}