import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FormatChecker{
    public static void main(String[] args) {




    }

    private String fileName;


    public boolean Filechecker(){
        //boolean verdict = new boolean;
        Scanner flsc;
        try {
            flsc = new Scanner(new File(this.fileName));
        } catch (FileNotFoundException e) {
            throw FileNotFoundException
            e.printStackTrace();
        }
        int rows = flsc.nextInt();
        int cols = flsc.nextInt();
        
        
        
        
        
        
        return (Boolean) null;
    }



}