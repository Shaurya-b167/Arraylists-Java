import java.util.*;
class SentenceEncoder
{
    private ArrayList<String> sentList;
    
    SentenceEncoder()
    {
        sentList= new ArrayList();
    }
    
    void storeInList()
    {
        Scanner sc= new Scanner(System.in);
        int cnt=0;
        System.out.print("Go on entering sentences below. (Hit 'Enter' key to STOP.)\n");
        while(true)
        {
            System.out.println("Enter sentence #"+(++cnt)+": ");
            String sent= sc.nextLine();
            if(sent.isEmpty()) 
                break;
            sentList.add(sent);
        } 
    }
    
    void showList()
    {
        int i=0;
        System.out.println("\n#\tSENTENCE");
        for(String sent : sentList)
        {
            System.out.print(++i+"\t");
            System.out.println(sent);
        }
    }
    
    void encodeList()
    {
        String encodedStr;
        int i, size= sentList.size();
        for(i=0; i<size; i++)
        {
            encodedStr= encode(sentList.get(i), i);
            sentList.set(i, encodedStr);
        }
    }
    
    String encode(String sentence, int rowPos)
    {
        String word="", encodedStr="";;
        int i, len= sentence.length(), val;
        for(i=0; i<len; i++)
        {
            char ch= sentence.charAt(i);
            val= (int)ch;
            if(Character.isLetterOrDigit(ch))
               if(rowPos%2==0)
                   word+= val==89 || val==90 || val>120? (char)(ch-24) : (char)(ch+2);
               else
                  word+= Character.toLowerCase(ch);
            if(!Character.isLetterOrDigit(ch) || i==len-1)
            {
                encodedStr= rowPos%2!=0? word+ (encodedStr=="" || i==len-1? " " : ch) + encodedStr : 
                          encodedStr + word + (i==len-1? "" : ch);
                word="";
            }
        }
        len= encodedStr.length();
        return (Character.toUpperCase(encodedStr.charAt(0)) + encodedStr.substring(1, len)).trim()+ ".";
    } 
    
    public static void main(String[] args)
    {
        SentenceEncoder obj= new SentenceEncoder();
        obj.storeInList();
        
        System.out.println("\nSentences as entered: ");
        obj.showList();
        
        obj.encodeList();
        System.out.println("\nEncoded sentences: ");
        obj.showList();
    }
}