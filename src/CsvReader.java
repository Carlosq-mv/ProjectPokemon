import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CsvReader {
    private HashSet<Character> set;

    public boolean readFile(String fileName) {
        set = new HashSet<>();
        File myFile = new File(fileName);

        try {
            FileReader fReader  = new FileReader(myFile);
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            boolean done = false;

            bReader.readLine(); //skips header column line
            while(!done) {
                line = bReader.readLine();
                if(line == null)
                    done = true;
                else {
                    Character pkMon = new Character(line);
                    set.add(pkMon);
                }
            }
            bReader.close();
            fReader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No such file: " + myFile);
        } catch (IOException e) {
            System.out.println("IO trouble");
        }
        return false;
    }

    public HashSet<Character> getCharacterSet() {
        return set;
    }
}
