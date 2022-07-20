import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class App {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int incrMeas = 0;
        int trackerCurrent=0, trackerNext=0;
        try {
            File myObj = new File("0.0.1\\firstTest\\src\\data1.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                numbers.add(myReader.nextInt());
            }
            myReader.close();
        } catch (FileNotFoundException e) { System.err.println(e);}

        for(int i = 0; i < numbers.size()-2; i++){
            trackerCurrent = trackerNext;
            trackerNext = numbers.get(i) + numbers.get(i+1) + numbers.get(i+2);
            if(trackerCurrent<trackerNext && trackerCurrent!=0){
                incrMeas++;
            }
        }

        System.out.println(incrMeas);
        }
}
