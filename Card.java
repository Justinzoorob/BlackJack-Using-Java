public class Card {
    private final int color; // Card's color
    private final int value; //Card's value (1 - 13, with 1 representing ACE).

    /*** Codes for the colors and non-numeric cards. Cards 2 through 10 have their numerical values
    for their codes. **/

    public final static int CLUBS = 0;
    public final static int DIAMONDS = 1;
    public final static int HEARTS = 2;
    public final static int SPADES = 3;
   
    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    /*** Constrcutor, that creates a card with a specified color and value.
    * @throws IllegalArgumentException if the parameter values are not in the ranges */
    public Card(int value, int color) {

        if(value < 1 || value > 13){ //checks if the value is in the range of [1;13]
            throw new IllegalArgumentException("Value out of range. Must be between 1 and 13");
        }
        else if(color < 0 || color > 3){ // checks if the color is in the range of [0;3]
            throw new IllegalArgumentException("Invalid color");
        }
        else{
            this.color = color;
            this.value = value;
        }
    }

    /*** Returns the color of this card.*/
    public int getColor() {
        return this.color;
    }

    /*** Returns the value of this card.
    * @return the value, which is one of the numbers 1 through 13, inclusive for a regular card.*/
    public int getValue() {
        return this.value;
    }

    /*** Returns a String representation of the card's color.
    * @return one of the strings "Spades", "Hearts", "Diamonds", or "Clubs" */
    public String ColorToString() {
        String thecolor = "";

        switch(this.color) {
            case 0: thecolor = "Clubs"; break;
            case 1: thecolor = "Diamonds"; break;
            case 2: thecolor = "Hearts"; break;
            case 3: thecolor = "Spades"; break;
        }
        return thecolor;
    }
    
    /*** Returns a String representation of the card's value.
    * @return for a regular card, one of the strings "Ace", "2", ..., "10", "Jack", "Queen", or
    "King". */
    public String ValueToString() {
        String thevalue = "";

        switch (this.value) {
            case 1: thevalue = "Ace"; break;
            case 11: thevalue = "Jack"; break;
            case 12: thevalue = "Queen"; break;
            case 13: thevalue = "King"; break;
            default: thevalue = this.value + ""; break;
        }
        return thevalue;
    }
   
    /*** Returns a string representation of this card, including both
    * its color and its value. Sample return values is: "Ace of Diamonds", */
    public String toString() {
        return this.ValueToString() + " of " + this.ColorToString();
    }
} // end class Card
