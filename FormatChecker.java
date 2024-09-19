import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FormatChecker{
    public static void main(String[] args) {
        int size =args.length;
        for(int i = 0; i<=size ; i++){
            String fileName = args[i];
            boolean val = Filechecker(fileName);
            if(val==true){
                System.out.println(fileName);
                System.out.println("VALID");
                System.out.println();
            }else{
                System.out.println("$ java FormatChecker file1 [file2 ... fileN]");
                System.out.println(fileName);
                System.out.println("INVALID");
            }
        }


    }

    //private String fileName;


    public static boolean Filechecker(String fileName){
        boolean verdict = true;
        //this.fileName = fileName;
        Scanner flsc;
        try {
            flsc = new Scanner(new File(fileName));
            int rows = flsc.nextInt();
            int cols = flsc.nextInt();
            Double[] numbs = new Double[cols*rows];
           int loops =0;
            for(int i =0;i <= rows;i++ ){
                String lnsc = flsc.nextLine();
                Scanner lineParse =new Scanner(lnsc) ;
                lineParse.useDelimiter(" ");
                for(int j = 0; j<= cols;j++){
                    Double numb = lineParse.nextDouble();
                    numbs[loops]= numb;
                    loops++;  
                }
                
                lineParse.close();
                if(numbs[(rows*cols)-1].equals(null)){
                    verdict = false;

                }else if(flsc.hasNextLine()){
                    verdict = false;
                } 
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        return verdict;
    }



}