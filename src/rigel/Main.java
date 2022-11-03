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


