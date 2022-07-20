import java.io.*;
import java.util.ArrayList;

public class Day4 {

    public static boolean cardSolver(int[][] cardiB, ArrayList<Integer> subBingo){
        int i = 0;
        int counter =0;
        //columns next
        int f = 0;
        while(f < 4 && counter !=5){
            counter = 0;
            for(int g = 0; g<5; g++){
                if(subBingo.contains(cardiB[g][f])){
                    counter++;
                }
                if(counter == 5){return true;}
            }
            f++;
        }

        
        //rows first
        while(i < 4 && counter !=5){
            counter = 0;
            for(int j = 0; j<5; j++){
                if(subBingo.contains(cardiB[i][j])){
                    counter++;
                }
                if(counter == 5){return true;}
            }
            i++;
        }

        

        return false;

    }

    public static void main(String[] args) {
        ArrayList<Integer> bingoNumbers = new ArrayList<Integer>();
        ArrayList<int[][]> cards = new ArrayList<int[][]>();

        try{
            //FileInputStream file = new FileInputStream("0.0.1/firstTest/lib/day4TestData.txt");
            //FileInputStream file = new FileInputStream("0.0.1/firstTest/lib/day4Testy.txt");
            FileInputStream file = new FileInputStream("0.0.1/firstTest/lib/day4InputData.txt");
            DataInputStream data = new DataInputStream(file);
            BufferedReader line = new BufferedReader(new InputStreamReader(data));
            String thisLine;

            while((thisLine = line.readLine()) != null){
                if(thisLine.contains(",")){
                    String[] bingoNumString = thisLine.split(",");
                    for(String num : bingoNumString){
                        bingoNumbers.add(Integer.parseInt(num));
                    }
                    thisLine = line.readLine();
                } else {
                    int i = 0;
                    int[][] fiveByFive = new int[5][5];
                    while(i < 5 ){
                        thisLine = thisLine.stripLeading();
                        String[] bingoLine = thisLine.split("\\s* \\s*");
                        int[] five = new int[5];
                        for(int j =0; j < bingoLine.length; j++){
                            five[j] = Integer.parseInt(bingoLine[j]);
                        }
                        fiveByFive[i] = five;
                        i++;
                        thisLine = line.readLine();
                    }
                    cards.add(fiveByFive);
                }
            }

            data.close();
        } catch(Exception e){ System.err.println(e);}

        
        int numIndex = 5;
        //Create sub list of bingo numbers we are currently using
        ArrayList<Integer> subBingo = new ArrayList<Integer>();
        /*
        for(int i = 0; i< 5; i++){subBingo.add(bingoNumbers.get(i)); }


        boolean bingo = false;
        int[][] bingoCard = new int[5][5];
        
        while(!bingo && subBingo.size() <= bingoNumbers.size()){
            for(int[][] cardiB : cards){
                bingo = cardSolver(cardiB, subBingo);
                if(bingo){bingoCard = cardiB; break;}
            }
            if(bingo){break;}
            subBingo.add(bingoNumbers.get(numIndex));
            numIndex++;
        }

        int sum = 0;
        int finalScore = 0;
        if(bingo){
            for(int i =0; i<5; i++){
                for(int j=0; j<5;j++){
                    
                    if(!subBingo.contains(bingoCard[i][j])){sum = sum + bingoCard[i][j];}
                }
            }
        }
        
        finalScore = sum * subBingo.get(numIndex-1);
        System.out.println(finalScore);
        */

        //-----------Part Two----------


        //Time stores index of bingoNumber called default = -1
        int[] time = new int[cards.size()];
        boolean[] won = new boolean[cards.size()];
        for(int i = 0; i < time.length; i++){time[i] = -1;}
        //Re-set subBingo
        numIndex = 5;
        subBingo.clear();
        for(int i = 0; i< 5; i++){subBingo.add(bingoNumbers.get(i)); }

        //Find longest bingo card to go BINGO
        while(subBingo.size() < bingoNumbers.size()){
            for(int i = 0; i < cards.size(); i++){
                if(won[i] == false){
                    if(cardSolver(cards.get(i), subBingo)){
                        time[i] = numIndex;
                        won[i] = true;
                    }
                }
                
            }
            subBingo.add(bingoNumbers.get(numIndex));
            numIndex++;
        } 

        //Find the max value of bingoNumbers index
        int max = 0, indexOfLongest = 0;
        for(int i = 0; i < time.length; i++){
            if(time[i] > max){
                max = time[i];
                indexOfLongest = i; 
            }
        }

        //Finding the bingoCard that took the longest and putting it in bingoCard
        
        int[][] bingoCard = new int[5][5];

        bingoCard = cards.get(indexOfLongest);

        //Setting subBingo to be clear and only filled with the numbers up to bingo called
        subBingo.clear();
        for(int i = 0; i < max; i++){
            subBingo.add(bingoNumbers.get(i)); 
        }

        int sum = 0;
        int finalScore = 0;
        for(int i =0; i<5; i++){
            for(int j=0; j<5;j++){         
                if(! (subBingo.contains( bingoCard[i][j] )) ){sum = sum + bingoCard[i][j];}
            }
        }

        finalScore = sum * bingoNumbers.get(max-1);
        System.out.println(finalScore);
        System.out.println(sum);
        System.out.println(bingoNumbers.get(max-1));

        for(int i =0; i<5; i++){
            for(int j=0; j<5;j++){         
                System.out.print(bingoCard[i][j] + " ");
            }
            System.out.println();
        }
        for(int i =0; i<5; i++){
            for(int j=0; j<5;j++){         
                System.out.print((subBingo.contains( bingoCard[i][j] )) + " ");
            }
            System.out.println();
        }
        //End of main
    }
}
