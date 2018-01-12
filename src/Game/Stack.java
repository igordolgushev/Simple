package Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Stack {
    ArrayList<Card> Puck = new ArrayList<Card>();

    Question Tuz = new Question();

    public Stack() throws IOException {
        setCard();
    }

    public void setCard() throws IOException
    {
        Puck.add(new Card("Двойка","Бубны",2));
        Puck.add(new Card("Двойка","Треф",2));
        Puck.add(new Card("Двойка","Черви",2));

        Puck.add(new Card("Тройка","Пик",3));
        Puck.add(new Card("Тройка","Бубны",3));
        Puck.add(new Card("Тройка","Треф",3));
        Puck.add(new Card("Тройка","Черви",3));

        Puck.add(new Card("Четвёрка","Пик",4));
        Puck.add(new Card("Четвёрка","Бубны",4));
        Puck.add(new Card("Четвёрка","Треф",4));
        Puck.add(new Card("Четвёрка","Черви",4));

        Puck.add(new Card("Пятёрка","Пик",5));
        Puck.add(new Card("Пятёрка","Бубны",5));
        Puck.add(new Card("Пятёрка","Треф",5));
        Puck.add(new Card("Пятёрка","Черви",5));

        Puck.add(new Card("Шетёрка","Пик",6));
        Puck.add(new Card("Шетёрка","Бубны",6));
        Puck.add(new Card("Шетёрка","Треф",6));
        Puck.add(new Card("Шетёрка","Черви",6));

        Puck.add(new Card("Семёрка","Пик",7));
        Puck.add(new Card("Семёрка","Бубны",7));
        Puck.add(new Card("Семёрка","Треф",7));
        Puck.add(new Card("Семёрка","Черви",7));

        Puck.add(new Card("Восьмёрка","Пик",8));
        Puck.add(new Card("Восьмёрка","Бубны",8));
        Puck.add(new Card("Восьмёрка","Треф",8));
        Puck.add(new Card("Восьмёрка","Черви",8));

        Puck.add(new Card("Девятка","Пик",9));
        Puck.add(new Card("Девятка","Бубны",9));
        Puck.add(new Card("Девятка","Треф",9));
        Puck.add(new Card("Девятка","Черви",9));

        Puck.add(new Card("Десятка","Пик",10));
        Puck.add(new Card("Десятка","Бубны",10));
        Puck.add(new Card("Десятка","Треф",10));
        Puck.add(new Card("Десятка","Черви",10));

        Puck.add(new Card("Валет","Пик",10));
        Puck.add(new Card("Валет","Бубны",10));
        Puck.add(new Card("Валет","Треф",10));
        Puck.add(new Card("Валет","Черви",10));

        Puck.add(new Card("Дама","Пик",10));
        Puck.add(new Card("Дама","Бубны",10));
        Puck.add(new Card("Дама","Треф",10));
        Puck.add(new Card("Дама","Черви",10));

        Puck.add(new Card("Король","Пик",10));
        Puck.add(new Card("Король","Бубны",10));
        Puck.add(new Card("Король","Треф",10));
        Puck.add(new Card("Король","Черви",10));

        if (Tuz.Request("Cколько будет стоить Туз: 0 - 1 очко, 1 - 11 очков?", "Введите 0/1")) {
            Puck.add(new Card("Туз", "Пик", 11));
            Puck.add(new Card("Туз", "Бубны", 11));
            Puck.add(new Card("Туз", "Треф", 11));
            Puck.add(new Card("Туз", "Черви", 11));
        } else {
            Puck.add(new Card("Туз", "Пик", 1));
            Puck.add(new Card("Туз", "Бубны", 1));
            Puck.add(new Card("Туз", "Треф", 1));
            Puck.add(new Card("Туз", "Черви", 1));
        }
    }

    public int getCard(boolean ShowMessage) throws IOException
    {
        Random myRandom = new Random();
        Integer indexCard;
        ArrayList<Card> puck = this.Puck;

        do {
            indexCard = myRandom.nextInt(puck.size());
        }
        while (puck.get(indexCard).getUsed());

        puck.get(indexCard).setUsed();
        if (ShowMessage) {
            System.out.print("Карта: " + puck.get(indexCard).getName() + " " + puck.get(indexCard).getSuit() + ". ");
        }
        return puck.get(indexCard).getValue();
    }
}
