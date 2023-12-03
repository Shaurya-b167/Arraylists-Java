import java.util.*;
class WordsFreqwise
{
    private String sent;
    
    static ArrayList<Integer> freq;
    static ArrayList<String> word;
    
    WordsFreqwise(String sent)
    {
        this.sent= sent;
        String wrd="";
        int i, size, len= sent.length();
        word= new ArrayList();
        freq= new ArrayList();
        for(i=0; i<len; i++)
        {
            char ch= sent.charAt(i);
            if(Character.isLetterOrDigit(ch))
                wrd+= Character.toLowerCase(ch);
            if((!Character.isLetterOrDigit(ch) || i==len-1) && wrd.length()>0)
            {
                word.add(wrd);
                freq.add(freqOf(wrd));
                wrd="";
            }
        }
    } 
    
    void display()
    {
        System.out.println("\nGiven sentence:\n"+sent);
    }

    int freqOf(String word)
    {
        int freq=0;
        for(String wrd : this.word)
            if(wrd.equalsIgnoreCase(word))
                 freq++;
        return freq;
    }
    /*FIX the repetitions of the words!!*/
    void showWordsFreqwise()
    {
        String word1, word2;
        int i, j, size= word.size(), freq1, freq2;
        for(i=0; i<size; i++)
            for(j=0; j<size-1-i; j++)
            {
                word1= word.get(j);
                word2= word.get(j+1);
                freq1= freq.get(j);
                freq2= freq.get(j+1);
                if((freq1 < freq2) || (freq1==freq2 && word1.compareToIgnoreCase(word2)>0))
                {
                    word.set(j, word2);
                    word.set(j+1, word1);
                    freq.set(j, freq2);
                    freq.set(j+1, freq1);
                }
            }
        
        System.out.println("\nWORD\t\tFREQUENCY");
        for(i=0; i<size; i++) 
        {
           String wrd= word.get(i); 
           if(word.indexOf(wrd)==i)
              System.out.println(wrd+"\t\t"+freq.get(i));
        }
    }  
  
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a sentence to display its words frequency wise: ");
        String sent= sc.nextLine();
        
        WordsFreqwise obj= new WordsFreqwise(sent);
        System.out.println("\nEntered words: ");
        obj.display();
        System.out.println("\nEntered words frequency-vise: ");
        obj.showWordsFreqwise();
    }
}