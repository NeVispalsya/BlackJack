package dto;

    public class Card {

        private Suit suit;
        private Rank rank;

        public int getCost() {
            return rank.getCost();
        }

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank=rank;
        }


        @Override
        public String toString() {
            return String.format("%s%s", rank.getName(), suit.getSymbol());
        }
    }



