package simulator;

import java.io.*;

public class LoggerWrite
{
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;

    public LoggerWrite()
    {
        try {
            file = new File("simulation.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
        }catch (IOException e)
        {
            System.out.println("error while creating file or instantiating filewrite or bufferedwrite");
        }
    }

    public static void writeToFile(String str)
    {
        try
        {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        catch (IOException e)
        {
            System.out.println("error while writing to file");
        }
    }

    public static void closeFile()
    {
        try
        {
            if (bufferedWriter != null)
                bufferedWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("error!, could not close the file");
        }
    }
}
