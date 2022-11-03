package rigel;

import java.io.IOException;

import static java.lang.Integer.parseInt;
public class Multiply{

    public static String findaNumber() throws IOException {

        String[] strings = Main.strings;
        strings[2] = strings[2].replace("*"," ");
        strings[2] = strings[2].trim();

        int num= parseInt(strings[2]);
        if(num >1 && num <11) {

            String resul = strings[1];
            for (int i = 1; i < num; i++) {
                resul += strings[1];
            }

            return resul;
        }else{
            throw new IOException();
        }

    }

}

