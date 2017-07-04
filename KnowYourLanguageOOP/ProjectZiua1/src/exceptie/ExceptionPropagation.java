package exceptie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class ExceptionPropagation {

    void metoda1(){
        int d=50/0;
    }

    void metoda2() throws MyException{
        try{
            metoda1();
        }catch(Exception e){
            System.out.println("exception handled");
            throw new MyException("Excercitiul 4-Nested");
        }
    }


    public String readFirstLineFromFile(String path)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
            try  {
                return br.readLine();
            }
            catch (IOException e){
                System.err.println("Nu merge aplicatia!");
                return "";
            }
            finally {
                if (br != null) br.close();
            }
        }


    public String readFirstLineFromFile2(String path)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        try  {
            return br.readLine();
        }
        finally {
            if (br != null) br.close();
        }
    }

    public void multiCatch() {

        int num1 = 10;
        int num2 = 0;
        int result = 0;
        int arr[] = new int[5];

        try {
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;
            arr[4] = 4;
            arr[5] = 5;

            result = num1 / num2;
            System.out.println("Result of Division : " + result);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e1) {
            System.out.println("Err: Divided by Zero");
            System.out.println("Err: Array Out of Bound");
        }

    }

    public void multipleCatch() {

        int num1 = 10;
        int num2 = 0;
        int result = 0;
        int arr[] = new int[5];

        try {
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;


            result = num1 / num2;
            System.out.println("Result of Division : " + result);

        } catch (ArithmeticException e) {
            System.out.println("Err: Divided by Zero");

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Err: Array Out of Bound");
        }

    }
}
