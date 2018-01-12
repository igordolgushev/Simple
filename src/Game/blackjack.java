package Game;

import java.io.IOException;
import java.util.Scanner;

public class blackjack {

    public static void main(String[] args) throws IOException {
        byte cardUser, cardPC;

        System.out.println("Вы запустили программу для игры в BlackJack");
        System.out.print("Введите свое имя:");
        String username = (new Scanner(System.in)).nextLine();
        System.out.printf("Удачи, %s! \n",username);

        Stack stack = new Stack();
        Statistic Show = new Statistic();
        CheckCount Game = new CheckCount();

        do
        {
            cardUser = 0;   //обнуляем очки игрока
            cardPC = 0;     // обнуляем очки PC

            do              //набор очков компьютером
            {
                cardPC += stack.getCard(false);
            }while (cardPC <= 16);  //задана жесткая уставка очков

            do              //набор очков игроком
            {
                cardUser += stack.getCard(true);

                System.out.print("Ваши очки: " + cardUser + " .");
                if (cardUser == 21) //заработали очко, далее набирать нет смысла
                {
                    break;
                }
                if (cardUser > 21)  //перебор, далее набирать нет смысла
                {
                    break;
                }
                System.out.printf("Карт: %d. Кол-во подходящих карт: %d. Успешная взятка: %f.\n", Show.SumCardsInPuck(stack.Puck), Show.HopeSuccessTake(stack.Puck,cardUser), Show.HopeSuccessTakePrc(Show.HopeSuccessTake(stack.Puck,cardUser),Show.SumCardsInPuck(stack.Puck)));
            } while((new Question()).Request(username + ", еще карту? ", "Введите Y/N"));

            Game.Winrate(cardPC,cardUser);

        }while((new Question()).Request(username + ", желаете сыграть еще раз?", "Введите Y/N"));
    }

}