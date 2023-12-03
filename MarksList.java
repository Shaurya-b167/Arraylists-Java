import java.util.*;
class MarksList
{
    private ArrayList<Integer> marksList;

    void storeMarks()
    {
        Scanner sc= new Scanner(System.in);
        marksList= new ArrayList();
        System.out.print("Go on entering marks of student of below. (Enter -1 to STOP.)\n");
        while(true)
        {
            int num= sc.nextInt();
            if(num == -1)
                break;
            marksList.add(num);
        } 
    }

    void showMarks()
    {
        for(int num: marksList)
            System.out.print(num+", ");
        System.out.println();
    }

    int getFrequency(int marks)
    {
        int freq=0;
        for(int mks: marksList)
            if(mks == marks)
                freq++;
        return freq;
    }

    float getMean()
    {
        int totalMks=0;
        for(int mks: marksList)
            totalMks+= mks;
        return (float)totalMks/marksList.size();
    }
    /*# Fix the below code to calculate Median in an unsorted array.   */
    float getMedian()
    {
        int i, size= marksList.size(), cnt=0, end= size%2==0? size/2+1 : size/2;
        float min=0, prevMin=0;
        while(++cnt<=end)
        {
            prevMin=min;
            min=100;
            for(int num: marksList)
                if(num < min && num>prevMin)
                    min= num;
        } 
        return size%2==0? (prevMin+min)/2 : min; 
    } 
    
    int getMode()
    {
        int freq= 0, maxFreq=0, mode= 0;
        for(int mks: marksList)
        {
            freq= getFrequency(mks);
            if(freq >= maxFreq)
            {
                maxFreq= freq;
                mode= mode < mks ? mks: mode;
            }
        }
        return mode;
    }

    public static void main(String[] args)
    {
        MarksList obj= new MarksList();
        obj.storeMarks();
        
        System.out.println("\nEntered elements: ");
        obj.showMarks();

        System.out.println("\nMean of the marks: "+obj.getMean()+
            "\nMedian of the marks: "+obj.getMedian()+
            "\nMode of the marks: "+obj.getMode());
    }
}
