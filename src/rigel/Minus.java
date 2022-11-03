package rigel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.reverse;

public class Minus {
    public static String cutPart() throws IOException {

        String[] strings = Main.strings;
        if(strings[3].length()<11 && strings.length== 4){
            String[] chart = strings[1].split(" ");
            String[] sharp = strings[3].split(" ");

            Collection c2 = new ArrayList<>();
            for (String elem : chart) {
                boolean add = c2.add(elem);
            }
            Collection e2 = new ArrayList<>();
            for (String elem : sharp) {
                boolean add = e2.add(elem);
            }
            c2.removeAll(e2);

            String resul = " ";

            for (Object str : c2) {
                resul += str;
            }

            return resul;
        }else {
            throw new IOException();
        }



    }
}

