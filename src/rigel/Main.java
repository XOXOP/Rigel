package rigel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main  {
    static String[] strings;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();//"ввод выражения");

        if (phrase.startsWith("\"")) {
             strings = phrase.split("\"");

            if(strings[1].length()<11){
                String result =new String();

                if (phrase.contains("+") && strings.length ==4) {

                        result = strings[1].concat(strings[3]);
                        overSize(result);

                } else if (phrase.contains("/")) {

                    Divider dv = new Divider();
                    result =dv.findaNumber();
                    overSize(result);

                } else if (phrase.contains("*")) {
                    Multiply mt = new Multiply();
                     result= mt.findaNumber();
                    overSize(result);

                } else if (phrase.contains("-")) {
                    Minus mn = new Minus();
                    result= mn.cutPart();
                    overSize(result);

                } else {
                    throw new IOException();
                }

            } else {
                throw new IOException();
            }
        }else{
            throw new IOException();

        }
    }
    public static void overSize(String str1) {

        if(str1.length()<41){
            System.out.println("\"" + str1 +"\"");
        } else {
            //str1= str1.substring(0,40);
            System.out.println("\"" +str1.substring(0,40) + "...\"");

        }


    }
}

class Divider {
    public static String findaNumber() throws IOException {

        String[] strings = Main.strings;
        strings[2] = strings[2].replace("/", " ");
        strings[2] = strings[2].trim();

        int num = parseInt(strings[2]);
        if(num >1 && num <11){
            String resul = strings[1].substring(0, strings[1].length() / num);

            return resul;

        }else {
            throw new IOException();
        }




    }
}

class Minus {
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
class Multiply{

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

