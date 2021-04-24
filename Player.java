/***The Player class should be able to represent the set of cards a player has in hand.
* The player class must allow to take a card from the deck and put it in the hand,
* count the points of the cards in hand...
**/
import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand; // The cards in the plyaer's hand.

    /*Constructor*/
    Player(){
        hand = new ArrayList<Card>();
    }

    /*Accessor*/
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /*** Remove all cards from the hand, leaving it empty. */
    public void clear() {
        hand.clear();
    }

    /*** Add a card to the hand. It is added at the end of the current hand.
     * @param card the non-null card to be added.
     * @throws NullPointerException if the parameter card is null.
     */

    public void add(Card card) {
        if (card == null) {
            throw new NullPointerException("The card passed into this hand is null");
        } else { 
            hand.add(card);
        }
    }

    /** * Remove a card from the hand, if present.
     * @param card the card to be removed. If card is null or if the card is not in
     * the hand, then nothing is done.
     */
    public void remove(Card card) {
        hand.remove(card);
    }

    /*** Remove the card in a specified position from the hand.
     * @param position the position of the card that is to be removed, where
     * positions are numbered starting from zero.
     * @throws IllegalArgumentException if the position does not exist in
     * the hand, that is if the position is less than 0 or greater than
     * or equal to the number of cards in the hand.
     */
    public void remove(int position) {
        if (position < 0 || position >= hand.size() ) {
            throw new IllegalArgumentException("Position value does not exist in the hand");
        } else {
            hand.remove(position);
        }
    }

    /*** Returns the number of cards in the hand. */
    public int totalCards() {
        return hand.size();
    }

    /*** Gets the card in a specified position in the hand. (Note that this card
     * is not removed from the hand!)
     * @param position the position of the card that is to be returned
     * @throws IllegalArgumentException if position does not exist in the hand
     */
    public Card getCard(int position) {
        if (position < 0 || position >= hand.size() ) {
            throw new IllegalArgumentException("Position value does not exist in the hand");
        } else {
            return hand.get(position);
        }
    }

    /** * Computes and returns the total value of this hand in the game */
    public int getHandTotal () {
        int total = 0;
        boolean ace = false;

        for (int i = 0; i < hand.size(); i++ ) {
            int cardVal = hand.get(i).getValue();
            if (cardVal >= 10) {
                total += 10;
            } else if (cardVal == 1) {
                ace = true;
            } else {
                total += cardVal;
            }
        }
        return (total <= 11 && ace) ? total + 10 : total;
    }

    /** * Sorts the cards in the hand so that cards of the same color are
     * grouped together, and within a color the cards are sorted by value.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByColor() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        newHand.add(hand.get(0));
        
        for (int i = 1; i < hand.size(); i++) {
            Card addCard = hand.get(i);
            for (int j = 0; j < newHand.size(); j++) {
                Card handCard = newHand.get(j);
                if (addCard.getColor() < handCard.getColor()) {
                    newHand.add(j, addCard);
                    break;
                } else if (addCard.getColor() == handCard.getColor() && addCard.getValue() < handCard.getValue()) { 
                    newHand.add(j, addCard);
                    break;
                } 
            }
            if (!newHand.contains(addCard)) {
                newHand.add(addCard);
            }
        }

        hand = newHand;
    }

    /*** Sorts the cards in the hand so that cards of the same value are
     * grouped together. Cards with the same value are sorted by color.
     * Note that aces are considered to have the lowest value, 1.
     */
    public void sortByValue() {
        ArrayList<Card> newHand = new ArrayList<Card>();
        newHand.add(hand.get(0));
        
        for (int i = 1; i < hand.size(); i++) {
            Card addCard = hand.get(i);
            for (int j = 0; j < newHand.size(); j++) {
                Card handCard = newHand.get(j);
                if (addCard.getValue() < handCard.getValue()) {
                    newHand.add(j, addCard);
                    break;
                } else if (addCard.getValue() == handCard.getValue() && addCard.getColor() < handCard.getColor()) { 
                    newHand.add(j, addCard);
                    break;
                } 
            }
            if (!newHand.contains(addCard)) {
                newHand.add(addCard);
            }
        }

        hand = newHand;
    }
}// end class Player

