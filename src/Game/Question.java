package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question {

    public static String inString() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return (reader.readLine());
    }

    public boolean Request(String text, String repeat) throws IOException {
        boolean question;
        System.out.print(text);
        switch (inString())
        {
            case "1":
            case "Y":
            case "y":
                question = true;
                break;
            case "0":
            case "N":
            case "n":
                question = false;
                break;
            default:
                System.out.print(repeat);
                question = Request("", repeat);
                break;
        }
        return question;
    }
}
