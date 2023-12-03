import java.util.*;
class CountryCapital
{
    private ArrayList<String> country, capital;
    
    CountryCapital()
    {
        country= new ArrayList();
        capital= new ArrayList();
    }
    
    void fill()
    {
        Scanner sc= new Scanner(System.in);
        int cnt=0;
        System.out.print("Go on entering names and ages of students below. (Hit 'Enter' key to STOP.)\n");
        while(true)
        {
            System.out.println("\nEnter details of Country #"+ ++cnt+": ");
            System.out.print("Enter name of country : ");
            String cntry= sc.nextLine();
            if(cntry.isEmpty()) 
                break;
            country.add(cntry);
            System.out.print("Enter its capital: ");
            String cap= sc.nextLine(); 
            capital.add(cap);
        } 
    }
    
    void show()
    {
        int i, size= country.size();
        System.out.println("\nDetails of the countries: "+
             "\nName\t\t\tCapital");
        for(i=0; i<size; i++)
            System.out.println(country.get(i)+"\t\t"+capital.get(i));
    }
    /*# Fix the below code in the lines of Incremental Search! */
    void incSearch(String item)
    {
        String cntry, cap;
        int i, size= capital.size(), len= item.length();
        for(i=0; i<size; i++)
        {
            cntry= country.get(i).substring(0, len);
            cap= capital.get(i).substring(0, len);
            if(item.equalsIgnoreCase(cntry) || item.equalsIgnoreCase(cap))
            {
                System.out.println("\nMatch found!"+
                     "\nCountry: "+country.get(i)+
                     "\nCapital: "+capital.get(i));
            } 
        }
        System.out.println("\nMatch NOT found in either of the lists!");
    }
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        CountryCapital obj= new CountryCapital();
        obj.fill();
               
        obj.show();
        
        System.out.print("\nEnter the search item to be found: ");
        String item= sc.nextLine();
        
        obj.incSearch(item);
    }
}