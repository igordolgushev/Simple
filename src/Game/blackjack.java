package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class blackjack {

    public static void main(String[] args) throws IOException {
        byte cardUser, cardPC;

        System.out.println("Вы запустили программу для игры в BlackJack");
        System.out.print("Введите свое имя:");
        String username = inString();
        System.out.printf("Удачи %s! \n",username);

        ArrayList<Puck> pucks = new ArrayList<>();


        pucks.add(new Puck("Двойка","Пик",2));
        pucks.add(new Puck("Двойка","Бубны",2));
        pucks.add(new Puck("Двойка","Треф",2));
        pucks.add(new Puck("Двойка","Черви",2));

        pucks.add(new Puck("Тройка","Пик",3));
        pucks.add(new Puck("Тройка","Бубны",3));
        pucks.add(new Puck("Тройка","Треф",3));
        pucks.add(new Puck("Тройка","Черви",3));

        pucks.add(new Puck("Четвёрка","Пик",4));
        pucks.add(new Puck("Четвёрка","Бубны",4));
        pucks.add(new Puck("Четвёрка","Треф",4));
        pucks.add(new Puck("Четвёрка","Черви",4));

        pucks.add(new Puck("Пятёрка","Пик",5));
        pucks.add(new Puck("Пятёрка","Бубны",5));
        pucks.add(new Puck("Пятёрка","Треф",5));
        pucks.add(new Puck("Пятёрка","Черви",5));

        pucks.add(new Puck("Шетёрка","Пик",6));
        pucks.add(new Puck("Шетёрка","Бубны",6));
        pucks.add(new Puck("Шетёрка","Треф",6));
        pucks.add(new Puck("Шетёрка","Черви",6));

        pucks.add(new Puck("Семёрка","Пик",7));
        pucks.add(new Puck("Семёрка","Бубны",7));
        pucks.add(new Puck("Семёрка","Треф",7));
        pucks.add(new Puck("Семёрка","Черви",7));

        pucks.add(new Puck("Восьмёрка","Пик",8));
        pucks.add(new Puck("Восьмёрка","Бубны",8));
        pucks.add(new Puck("Восьмёрка","Треф",8));
        pucks.add(new Puck("Восьмёрка","Черви",8));

        pucks.add(new Puck("Девятка","Пик",9));
        pucks.add(new Puck("Девятка","Бубны",9));
        pucks.add(new Puck("Девятка","Треф",9));
        pucks.add(new Puck("Девятка","Черви",9));

        pucks.add(new Puck("Десятка","Пик",10));
        pucks.add(new Puck("Десятка","Бубны",10));
        pucks.add(new Puck("Десятка","Треф",10));
        pucks.add(new Puck("Десятка","Черви",10));

        pucks.add(new Puck("Валет","Пик",10));
        pucks.add(new Puck("Валет","Бубны",10));
        pucks.add(new Puck("Валет","Треф",10));
        pucks.add(new Puck("Валет","Черви",10));

        pucks.add(new Puck("Дама","Пик",10));
        pucks.add(new Puck("Дама","Бубны",10));
        pucks.add(new Puck("Дама","Треф",10));
        pucks.add(new Puck("Дама","Черви",10));

        pucks.add(new Puck("Король","Пик",10));
        pucks.add(new Puck("Король","Бубны",10));
        pucks.add(new Puck("Король","Треф",10));
        pucks.add(new Puck("Король","Черви",10));

        if (QuestionText(username + ", cколько будет стоить Туз: 0 - 1 очко, 1 - 11 очков?")) {
            pucks.add(new Puck("Туз", "Пик", 11));
            pucks.add(new Puck("Туз", "Бубны", 11));
            pucks.add(new Puck("Туз", "Треф", 11));
            pucks.add(new Puck("Туз", "Черви", 11));
        } else {
            pucks.add(new Puck("Туз", "Пик", 1));
            pucks.add(new Puck("Туз", "Бубны", 1));
            pucks.add(new Puck("Туз", "Треф", 1));
            pucks.add(new Puck("Туз", "Черви", 1));
        }

        do
        {
            cardUser = 0;                                                       //обнуляем очки игрока
            cardPC = 0;                                                         // обнуляем очки PC

            do
            {                                                                 //набор очков компьютером
                cardPC += giveCard(pucks, false);
            }while (cardPC <= 16);                                              //задана жесткая уставка очков = 16

            do
            {                                                                 //набор очков игроком
                cardUser += giveCard(pucks, true);
                System.out.print("Ваше количество очков: " + cardUser + " .");
                if (cardUser == 21){                                            //заработали очко, далее набирать нет смысла
                    break;
                }
                if (cardUser > 21){                                             //перебор, далее набирать нет смысла
                    break;
                }
                System.out.printf("%s, желаете еще карту? ",username);
            } while(Question());

            winrate(cardPC,cardUser);                                           //вывод результата игры

            System.out.printf("%s, желаете сыграть еще раз?\n",username);
        }while(Question());
    }


    /**
     *
     * @param a
     * @param b
     * @throws IOException
     */
    public static void winrate(int a, int b) throws IOException
    {                                                                          //компьютер,игрок
        if (b > 21)
        {
            System.out.println("Сожалею, Вы проиграли! Перебор.");
        }
        else
        {
            if (a > 21)
            {
                System.out.println("Поздравляю с победой! У PC перебор.");
            }
            else
            {
                if (a > b) System.out.println("Сожалею, Вы проиграли!\nВаши очки: " + b + "\nОчки соперника: " + a);
                if (a == b) System.out.println("Спор!\nВаши очки: " + b + "\nОчки соперника: " + a);
                if (a < b) System.out.println("Поздравляю, Вы выиграли!\nВаши очки: " + b + "\nОчки соперника: " + a);
            }
        }
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static String inString() throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return (reader.readLine());
    }

    /**
     *
     * @param pucks
     * @param ShowMessage
     * @return
     * @throws IOException
     */
    public static int giveCard(ArrayList<Puck> pucks, boolean ShowMessage) throws IOException          // выдаем курту случайным целым числом
    {
        Random myRandom = new Random();
        Integer indexCard;

        do {
            indexCard = myRandom.nextInt(pucks.size());
        }
        while (pucks.get(indexCard).getUsed());

        pucks.get(indexCard).setUsed();
        if (ShowMessage) {
            System.out.print("Ваша карта: " + pucks.get(indexCard).getName() + " " + pucks.get(indexCard).getSuit() + ". ");
        }
        return pucks.get(indexCard).getValue();
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static boolean Question() throws IOException //запрос к игороку на продолжение или окончание действия (набор карт или проведение игры)
    {
        boolean question;
        System.out.print("Выберете: Y - да, N - нет. Ответ:");
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
                question = Question();
                break;
        }

        return question;
    }

    /**
     *
     * @param text
     * @return
     * @throws IOException
     */
    public static boolean QuestionText (String text) throws IOException
    {
        System.out.println(text);
        boolean question;
        switch (inString())
        {
            case "1":
                question = true;
                break;
            case "0":
                question = false;
                break;
            default:
                question = QuestionText(text);
                break;
        }
        return question;
    }

}

