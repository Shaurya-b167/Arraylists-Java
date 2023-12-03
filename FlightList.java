import java.util.*;
class Time
{
    private int hh, mm;
    
    Time()
    {
        hh= mm= 0;
    }
    
    void input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the hours(0-23): ");
        hh= sc.nextInt();
        System.out.print("Enter the minutes(0-59): ");
        mm= sc.nextInt();
    }
    
    void display()
    {
        System.out.print(hh+" : "+mm);
    }
    
    int timeDiff(Time tm)
    {
        Time diffObj= new Time();
        int mins1= hh*60+mm, mins2=tm.hh * 60 + tm.mm;
        if(mins2 < mins1)   
            mins2+= 24*60;  
        return mins2-mins1; 
    }
    
    void duration(int mins)
    {
        System.out.println(mins/60+" hours "+mins%60+" minutes");
    }
}

class Flight extends Time
{
    private String flightName, flightNo, route;
    private Time obj1, obj2;
    
    Flight()
    {
        flightName= flightNo= route= "";
        obj1= new Time();
        obj2= new Time();
    }
    
    void acceptDetails()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the flight name: ");
        flightName= sc.nextLine();
        System.out.print("Enter the flight number: ");
        flightNo= sc.nextLine();
        System.out.print("Enter the route: ");
        route= sc.nextLine();
        System.out.println("Enter the details of the departure time: ");
        obj1.input();
        System.out.println("Enter the details of the arrival time: ");
        obj2.input();
    }
    
    void showDetails()
    {
        System.out.print(flightName+"\t\t"+flightNo+"\t\t"+route+"\t\t");
        obj1.display();
        System.out.print("\t\t");
        obj2.display();
        System.out.print("\t\t");
        obj1.duration(getDuration());
    }
    
    int getDuration()
    {
        return obj1.timeDiff(obj2);
    }
}

public class FlightList extends Flight
{
    private ArrayList<Flight> flightList;
    
    FlightList()
    {
        flightList= new ArrayList();
    }
    
    void fillList()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the no. of flights whose details are to be stored: ");
        int n= sc.nextInt();
        for(int i=0; i<n; i++)
        {
            System.out.println("\nEnter details about flight #"+(i+1)+": ");
            FlightList obj= new FlightList();
            obj.acceptDetails();
            flightList.add(obj);
        }
    } 
    
    void showList()
    {
        int cnt=0;
        System.out.println("\n#\tNAME\t\t\tNUMBER\t\tROUTE\t\tARRIVAL TIME\tDEPARTURE TIME"+
             "\tDURATION");
        for(Flight obj: flightList)
        {
            System.out.print(++cnt+"\t");
            obj.showDetails();
        }
    } 
    
    void sortList()
    {
        int i, j, size= flightList.size();
        for(i=0; i<size; i++)
            for(j=0; j<size-1-i; j++)
            {
                Flight time1= flightList.get(j), time2= flightList.get(j+1);
                if(time1.getDuration() > time2.getDuration())
                {
                    flightList.set(j, time2);
                    flightList.set(j+1, time1);
                }
            }
    }
    
    public static void main(String[] args)
    {
        FlightList obj= new FlightList();
        obj.fillList();
        
        System.out.println("\nGiven list: ");
        obj.showList();
        
        obj.sortList();
        System.out.println("\nSorted list: ");
        obj.showList();
    }
}