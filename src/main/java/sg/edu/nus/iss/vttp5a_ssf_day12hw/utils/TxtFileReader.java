package sg.edu.nus.iss.vttp5a_ssf_day12hw.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TxtFileReader {
    
    // File file = new File(".\\src\\main\\resources\\static\\text\\employees.txt");
    private File file = new File("C:\\Users\\Clare Lau\\VTTP_SSF\\vttp5a-ssf-day12hw\\src\\main\\resources\\static\\text\\employees.txt");
    private List<String> linesRead;

    public List<String> readFile(){
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine(); //reading the first heading row
            while (line != null){
                linesRead.add(line);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File to read cannot be found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in reading file!");
            e.printStackTrace();
        }

        return linesRead;
    }
}
