package rigel;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main  {
    static String[] stroka;
    static String phrase;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        phrase = sc.nextLine();//"ввод выражения");

        if (phrase.startsWith("\"")) {
            stroka = phrase.split("\"");
            if(stroka[1].length() <11) {


                if (phrase.contains("+") || phrase.contains("-")) {
                    Minus mn = new Minus();
                    mn.cutPart();


                } else if ((phrase.contains("/")) || (phrase.contains("*"))) {

                    Divider dv = new Divider();
                    dv.findaNumber();


                } else {
                    throw new IOException();
                }
            }else {
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
            System.out.println("\"" +str1.substring(0,39) + "...\"");
        }

    }
}

class Divider {
    public static void findaNumber() throws IOException {
        String[] strin = Main.stroka;
        if(strin.length <4) {

            if (Main.phrase.contains("/")) {
                strin[2] = strin[2].replace("/", " ");


            } else {
                strin[2] = strin[2].replace("*", " ");

            }
            strin[2] = strin[2].trim();
            int num = parseInt(strin[2]);
            if (num > 0 && num < 11) {
                if (Main.phrase.contains("/")) {
                    System.out.println(strin[1].substring(0, strin[1].length() / num));

                } else {
                    String resul = strin[1];
                    for (int i = 1; i < num; i++) {
                        resul += strin[1];
                    }
                    Main.overSize(resul);
                }

            } else {
                throw new IOException();
            }
        }else {
            throw new IOException();

        }

    }
}

class Minus {
    public static void cutPart() throws IOException {

        String[] strin = Main.stroka;
        boolean isBigger = ((strin.length !=4 )||( strin[3].length()>10));
        if(isBigger) {
            throw new IOException();
        }else {
            String result = new String();
            if (Main.phrase.contains("+")) {
                result = strin[1].concat(strin[3]);
                Main.overSize(result);
            } else {

                String x = strin[3];
                String str = strin[1];

                String target = strin[1];
                for (int i = 0; i < str.length(); i++) {
                    if (str.regionMatches(i, x, 0, x.length())) {
                        target = str.substring(0, i);
                        target += str.substring(i + x.length(), str.length());
                    }

                }
                System.out.println("\"" + target + "\"");
            }
        }


    }
}



