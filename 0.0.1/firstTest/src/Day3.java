import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        ArrayList<Integer> zeroCounter = new ArrayList<Integer>();

        int decGamma, decEpsilon, powerCons;
        int lengthFile = 0;

        //Importing the data - if value is a zero adding 1 to zero counter for that index
        try{
            File inputFile = new File("0.0.1\\firstTest\\lib\\day3Input.txt");
            //File inputFile = new File("0.0.1\\firstTest\\lib\\day3Test.txt");
            Scanner myScan = new Scanner(inputFile);
            if(myScan.hasNextLine()){
                int lineLength =  myScan.nextLine().length();
                for(int i = 0; i<lineLength; i++){zeroCounter.add(0);}
            }
            while(myScan.hasNextLine()){
                String line =  myScan.nextLine();
                char[] ln = line.toCharArray();
                for(int i = 0; i<ln.length; i++){
                    if(ln[i] == '0'){
                        int z = zeroCounter.get(i) + 1;
                        zeroCounter.set(i,z);                       
                    }
                }
                lengthFile++;
            }
            myScan.close();

        } catch (FileNotFoundException e){
            System.err.println(e);
        }

        //Calculating the value of gamma and epsilon
        char[] epsilonRate = new char[zeroCounter.size()]; 
        char[] gammaRate = new char[zeroCounter.size()];
        for(int i = 0; i<zeroCounter.size(); i++){
            if(zeroCounter.get(i) < (lengthFile/2)){
                epsilonRate[i] = '0';
                gammaRate[i] = '1';
                /*
                epsilonRate.set(i, 0);
                gammaRate.set(i, 1);
                */
            }
            else{
                epsilonRate[i] = '1';
                gammaRate[i] = '0';
                /*
                epsilonRate.set(i, 1);
                gammaRate.set(i, 0);
                */
            }
        }

        decEpsilon = Integer.parseInt(String.valueOf(epsilonRate),2);
        decGamma = Integer.parseInt(String.valueOf(gammaRate),2);
        System.out.println(decEpsilon);
        System.out.println(decGamma);
        powerCons = decEpsilon * decGamma;
        
        System.out.println(powerCons);

    }
}
