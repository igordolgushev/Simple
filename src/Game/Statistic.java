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
    public Integer HopeSuccessTake(ArrayList<Puck> puck, int value) throws IOException
    {
        int count= 0;

        for (Puck pck : puck) {
            if (pck.getValue() <= value) {
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
    public Integer HopeSuccessTakePrc(int hopeSuccessTake, int sizePuck) throws IOException
    {
        return (hopeSuccessTake/sizePuck * 100);
    }

    /**
     *
     * @param puck
     * @return
     * @throws IOException
     */
    public Integer SumCardsInPuck(ArrayList<Puck> puck) throws IOException
    {
        Integer sumCardsInPuck = 0;

        for (Puck pck: puck)
        {
            if (!pck.getUsed()) sumCardsInPuck++;
        }
        return sumCardsInPuck;
    }

}
