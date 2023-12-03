import java.util.*;
class Book
{
    private String title, author, publ;
    private int stock;
    private float price;
    
    void getData()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the title: ");
        title= sc.nextLine();
        System.out.print("Enter the name of the author: ");
        author= sc.nextLine();
        System.out.print("Enter the name of the publisher: ");
        publ= sc.nextLine();
        System.out.print("Enter the no. of copies available: ");
        stock= sc.nextInt();
        System.out.print("Enter the price of a single copy: Rs ");
        price= sc.nextFloat();
    }
    
    void putData()
    {
        System.out.println(title+"\t\t"+author+"\t\t"+publ+"\t\t"+price+"\t\t"+stock);
    }
    
    boolean hasMatched(String title, String author)
    {
        return this.title.equalsIgnoreCase(title) && this.author.equalsIgnoreCase(author)?
           true : false;
    }
    
    boolean isInStock(String title, String author, int n)
    {
        return hasMatched(title, author) && n<=stock? true : false;
    }
    
    float getBillAmount(int n)
    {
        return (float)(n*price);
    }
    
    int getStock()
    {
        return stock;
    }
    
    void setStock(int n)
    {
        stock-=n;
    }
}

public class BookList extends Book
{
    private ArrayList<Book> bookList;
    
    BookList()
    {
        bookList= new ArrayList();
    }
    
    void fill()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the no. of books in the store: ");
        int n= sc.nextInt();
        for(int i=0; i<n; i++)
        {
            System.out.println("\nEnter details about book #"+(i+1)+": ");
            Book obj= new Book();
            obj.getData();
            bookList.add(obj);
        }
    } 
    
    void show()
    {
        int cnt=0;
        System.out.println("\n#\tNAME\t\t\tAUTHOR\t\tPUBLISHER\tPRICE(RS)\tSTOCK(NO OF COPIES)");
        for(Book obj : bookList)
        {
            System.out.print(++cnt+"\t");
            obj.putData();
        }
    }
    
    void sell(String title, String author, int n)
    {
        for(Book obj : bookList)
        {
            if(obj.isInStock(title, author, n))
            {
                System.out.println("\nStock available!"+
                     "\nBill price: Rs "+obj.getBillAmount(n));
                obj.setStock(n);
                return;
            }
            else if(obj.hasMatched(title, author))
            {
                System.out.println("\nSorry! We don't have enough stock of the specified "+
                    " book"+"\nAvailable copies: "+obj.getStock());
                return;
            }
        } 
        System.out.println("\nWe don't have the specified book in the store!");
    } 
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        BookList obj= new BookList();
        obj.fill();
        
        System.out.println("\nGiven List: ");
        obj.show();
        
        System.out.println("\nEnter the details of the book to be bought: ");
        System.out.print("Enter the title: ");
        String title= sc.nextLine();
        System.out.print("Enter the name of the author: ");
        String author= sc.nextLine();
        System.out.print("Enter the no. of copies to be bought: ");
        int n= sc.nextInt();
        
        obj.sell(title, author, n);
    }
}