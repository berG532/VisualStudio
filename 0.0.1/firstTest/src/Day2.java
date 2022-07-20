import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {   
    public static void main(String args[]){
        int f = 0, d= 0, p = 0 , number = 0, aim = 0;

        

        try {
            File myObj = new File("0.0.1\\firstTest\\src\\day2Input.txt");
            try (//File myObj = new File("0.0.1\\firstTest\\src\\day2TestData.txt");
            Scanner in = new Scanner(myObj)) {
                while(in.hasNextLine()){
                    String s =in.nextLine();
                    number = Integer.valueOf(s.substring(s.indexOf(" ")+1));  
                    if(s.startsWith("forward")){
                        f = f + number;
                        d = d + aim * number;
                        //System.out.println(s);
                        //System.out.println("The new value of forward is " + f + " and the new value of depth is " + aim + " * " + number + " = " + d);
                        //aim = 0;
                        if(d < 0){d=0;}
                    }
                    else if(s.startsWith("down")){
                        aim = aim + number;
                        //System.out.println(s);
                        //System.out.println("Down results in value of aim being " + aim);
                    }
                    else if(s.startsWith("up")){
                        aim = aim - number;
                        //System.out.println(s);
                        //System.out.println("UP results in value of aim being " + aim);
                    }                
                }
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            System.err.println(e);
        }

        p = f * d;
        System.out.println("The final depth is " + d + ", and the final horizontal position is " + f + ", so the total movement is " + p);

    }
}
