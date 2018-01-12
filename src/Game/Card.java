package Game;

import java.io.IOException;

/**
 * Created by Игорь on 01.01.2018.
 */
class Card {
    private String name, suit;
    private Integer value;
    private boolean used;

    public Card(String Name, String Suite, Integer Value)
    {
        this.name = Name;
        this.suit = Suite;
        this.value = Value;
        this.used = false;
    }

    /**
     *
     * @return
     */
    public String getName(){return name;}

    /**
     *
     * @return
     */
    public String getSuit(){return suit;}

    /**
     *
     * @return
     */
    public Integer getValue(){return value;}

    /**
     *
     * @return
     */
    public boolean getUsed(){return used;}

    /**
     *
     */
    public void setUsed(){this.used = true;}

}
