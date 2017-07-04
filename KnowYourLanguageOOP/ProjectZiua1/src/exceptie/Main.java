package exceptie;

import java.io.IOException;

/**
 * Created by Robert.Dumitrescu on 7/4/2017.
 */
public class Main {

    public Main() throws MyException {
        throw new MyException("Eroare de la mine");
    }

    public static void main(String[] args) throws MyException,IOException {
        ExceptionPropagation obj = new ExceptionPropagation();
        obj.metoda2();
        System.out.println(obj.readFirstLineFromFile("C:\\Users\\robert.dumitrescu\\IdeaProjects\\ProjectZiua1\\src\\exceptie\\text.txt"));
        System.out.println(obj.readFirstLineFromFile2("C:\\Users\\robert.dumitrescu\\IdeaProjects\\ProjectZiua1\\src\\exceptie\\text.txt"));
        obj.multiCatch();
        obj.multipleCatch();

    }
}
