import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day3Part2 {
    public static void main(String[] args) {
        ArrayList<String> oxygenList = new ArrayList<String>();
        ArrayList<String> carbonList = new ArrayList<String>();


        //Importing the data
        try{
            File inputFile = new File("0.0.1\\firstTest\\lib\\day3Input.txt");
            //File inputFile = new File("0.0.1\\firstTest\\lib\\day3Test.txt");
            Scanner myScan = new Scanner(inputFile);

            while(myScan.hasNextLine()){
                String line = myScan.nextLine();
                oxygenList.add(line);
                carbonList.add(line);
            }
            myScan.close();

        } catch (FileNotFoundException e){
            System.err.println(e);
        }

        // ---------- FINDING THE OXYGEN RATING ----------


        int index = 0;

        while(oxygenList.size() > 1 && index < oxygenList.get(0).length()){
            int countZero=0, countOne =0;
            for(int d = 0 ; d <  oxygenList.size(); d++){
                    if(oxygenList.get(d).charAt(index) == '0'){
                        countZero++;
                    } else { countOne++;}
            }

            if(countOne >= countZero){
                for(int d = 0; d < oxygenList.size(); d++){
                    if(oxygenList.get(d).charAt(index) == '0'){
                        oxygenList.remove(d);
                        d--;
                    }
                }
            }
            else{
                for(int d = 0; d < oxygenList.size(); d++){
                    if(oxygenList.get(d).charAt(index) == '1'){
                        oxygenList.remove(d); 
                        d--;
                    }
                }
            }
            

            index++;
        }
        
        int oxygenRating = Integer.parseInt(oxygenList.get(0),2);

        // ---------- FINDING THE CARBON RATING ----------
        index = 0;


        while(carbonList.size() > 1 && index < carbonList.get(0).length()){
            int countZero=0, countOne =0;
            for(int d = 0 ; d <  carbonList.size(); d++){
                    if(carbonList.get(d).charAt(index) == '0'){
                        countZero++;
                    } else { countOne++;}
            }

            if(countZero > countOne){
                for(int d = 0; d < carbonList.size(); d++){
                    if(carbonList.get(d).charAt(index) == '0'){
                        carbonList.remove(d);
                        d--;
                    }
                }
            }
            else{
                for(int d = 0; d < carbonList.size(); d++){
                    if(carbonList.get(d).charAt(index) == '1'){
                        carbonList.remove(d); 
                        d--;
                    }
                }
            }
            

            index++;
        }
        
        int carbonRating = Integer.parseInt(carbonList.get(0),2);
        System.out.println(oxygenRating);
        System.out.println(carbonRating);

        int lifeSupportRating = oxygenRating * carbonRating;
        System.out.println(lifeSupportRating);
    }
}
