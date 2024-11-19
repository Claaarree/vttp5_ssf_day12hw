package sg.edu.nus.iss.vttp5a_ssf_day12hw.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReaderWriter {
    
    //Both absolute and relative file paths work! :)
    private File file = new File(".\\src\\main\\resources\\static\\text\\employees.txt");
    // private File file = new File("C:\\Users\\Clare Lau\\VTTP_SSF\\vttp5a-ssf-day12hw\\src\\main\\resources\\static\\text\\employees.txt");
    private List<String> linesRead;

    public List<String> readFile(){
        linesRead = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine(); //reading the first heading row
            while ((line = br.readLine()) != null){
                // System.out.println(line);
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

    public void writeFile(String line){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n" + line);

            bw.flush();
            fw.flush();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error in writing to file!");
            e.printStackTrace();
        }
    }
}
