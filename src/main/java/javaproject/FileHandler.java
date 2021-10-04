package javaproject;

import java.util.LinkedList;
import java.io.*;

/**
 *
 * @author Rock_it_twice
 */
public class FileHandler {
    String fileName = "members.csv";
    //Methods
    public LinkedList<Member> readFile(){        
        String lineRead;
        Member mem;
        String[] splitLine;        
        LinkedList<Member> m = new LinkedList<>();
        
        
        try(BufferedReader reader = 
                new BufferedReader(new FileReader(fileName)))
        {
            lineRead = reader.readLine();
            while (lineRead != null)
            {
                splitLine = lineRead.split(" , ");

                if (splitLine[0].equals("S"))
                {
                    mem = new SingleClubMember('S', 
                            Integer.parseInt(splitLine[1]), splitLine[2], 
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                }
                else
                {
                    mem = new MultiClubMember('M', 
                            Integer.parseInt(splitLine[1]), splitLine[2], 
                            Double.parseDouble(splitLine[3]),
                            Integer.parseInt(splitLine[4]));
                }
                
                m.add(mem);
                lineRead = reader.readLine();
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
        return m;
    }
    public void appendFile(String mem){        
        try(BufferedWriter writer = 
                new BufferedWriter(new FileWriter(fileName, true)))
        {
            writer.write(mem + "\n");
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void overwriteFile(LinkedList<Member> m)
    {
        String s;        
        String fileNameTemp = "members.temp";
        try(BufferedWriter writer = 
                new BufferedWriter(new FileWriter(fileNameTemp, false)))
        {
            for (int i=0; i < m.size(); i++)
            {
                s = m.get(i).toString();
                writer.write(s + "\n");
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            File f = new File(fileName);
            File tf = new File(fileNameTemp);
            f.delete();
            tf.renameTo(f);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
