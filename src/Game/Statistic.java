package Game;

import java.io.IOException;
import java.util.ArrayList;

public class Statistic {

    /**
     *
     * @param puck
     * @param value
     * @return
     * @throws IOException
     */
    public Integer HopeSuccessTake(ArrayList<Card> puck, int value) throws IOException
    {
        int count= 0;

        for (Card pck : puck) {
            if ((pck.getValue() <= (21 - value)) & !pck.getUsed()) {
                count++;
            }
        }

        return count;
    }

    /**
     *
     * @param hopeSuccessTake
     * @param sizePuck
     * @return
     * @throws IOException
     */
    public float HopeSuccessTakePrc(int hopeSuccessTake, int sizePuck) throws IOException
    {
        return (hopeSuccessTake/(float)sizePuck * 100);
    }

    /**
     *
     * @param puck
     * @return
     * @throws IOException
     */
    public Integer SumCardsInPuck(ArrayList<Card> puck) throws IOException
    {
        Integer sumCardsInPuck = 0;

        for (Card pck: puck)
        {
            if (!pck.getUsed()) sumCardsInPuck++;
        }
        return sumCardsInPuck;
    }

}
