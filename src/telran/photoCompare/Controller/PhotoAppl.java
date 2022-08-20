package telran.photoCompare.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class PhotoAppl {
    public static void main(String[] args) {
        if(args.length > 2) {
            System.out.println("Wrong number of arguments");
            return;
        }
        try (FileInputStream fin1 = new FileInputStream(args[0]);
        FileInputStream fin2 = new FileInputStream(args[1])){
            byte[] photoArr1 = new byte[fin1.available()];
            photoArr1 = fin1.readAllBytes();
            byte[] photoArr2 = new byte[fin2.available()];
            photoArr2 = fin2.readAllBytes();
            boolean areEqual = Arrays.equals(photoArr1,photoArr2);
            System.out.println("It is " + areEqual + " that both  photos are equal");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
