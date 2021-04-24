import java.util.Random;

/*** Deck represents a deck of playing cards and contains 52 regular cards. */
public class Deck {

    private Card[] deck; // an array of 52 cards.
    private int number; //the number of cards that have been dealt from the deck

    /*** Constructs a regular 52-card poker deck. Initially, the cards are in a sorted order. */
    public Deck() {
        this.deck = new Card[52];
        this.number = 0;

        //creates the deck of cards using a predetermined order
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                this.deck[i * 13 + j] = new Card(j + 1, i);
            }
        } 
   }

    private void refill(){ //remakes the deck by using the original predertermin
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[i * 13 + j] = new Card(j + 1, i);
            }
        } 
   }

    /*** Put all the used cards back into the deck (if any), and shuffle the deck into a random order. */
    public void shuffle() {
        this.refill();

        Random rand = new Random();
        
        for (int i = 0; i < deck.length; i++) {
			int toSwap = rand.nextInt(deck.length);
			Card temp = deck[toSwap];
			deck[toSwap] = deck[i];
			deck[i] = temp;
		}
    }

    /*** Returns the number of cards left in the deck. */
    public int numberLeft() {
        return 52 - this.number;
    }

    /*** Removes the next card from the deck and return it. It is illegal to call this method if there are no
    * more cards in the deck. You can check the number of cards remaining by calling the numberLeft()
    * function.
    * @return the card which is removed from the deck.
    * @throws IllegalStateException if there are no cards left in the deck
    */
    public Card take() {
        if(this.numberLeft() == 0){
            throw new IllegalStateException("The deck is empty");
        }

        Card x = this.deck[this.numberLeft()-1];
        this.number++;
        return x;
    }
} // end class Deck
   
