package Game;

import java.io.IOException;

public class CheckCount {

    public void Winrate(int PCCount, int UserCount) throws IOException
    {                                                                          //компьютер,игрок
        if (UserCount > 21)
        {
            System.out.println("Сожалею, Вы проиграли! Перебор.");
        }
        else
        {
            if (PCCount > 21)
            {
                System.out.println("Поздравляю с победой! У PC перебор.");
            }
            else
            {
                if (PCCount > UserCount) System.out.println("Сожалею, Вы проиграли!\nВаши очки: " + UserCount + "\nОчки соперника: " + PCCount);
                if (PCCount == UserCount) System.out.println("Спор!\nВаши очки: " + UserCount + "\nОчки соперника: " + PCCount);
                if (PCCount < UserCount) System.out.println("Поздравляю, Вы выиграли!\nВаши очки: " + UserCount + "\nОчки соперника: " + PCCount);
            }
        }
    }
}
