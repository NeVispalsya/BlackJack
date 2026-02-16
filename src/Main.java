import dto.Card;
import dto.GameResult;
import dto.Player;
import exception.DeckException;
import service.DeckService;
import service.GameService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DeckException {
        System.out.println("Black Jack 2026");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your name :");
        String name = sc.nextLine();

        System.out.println("Please enter number of games: ");
        int games = sc.nextInt();
        sc.nextLine();

        Player player = new Player(name);

        System.out.println(String.format("%s want play %s games", player.getName(), games));


        DeckService ds = new DeckService();
        GameService gs = new GameService();
        ds.createDeck(1);
        int counter = 1;

        sc.nextLine();

        do {
            System.out.println("-------------->>>>");
            System.out.println(String.format("%s game form %s games", counter, games));

            game(player, ds, gs, sc);
            List<Card> computerHand = gs.getComputerHand(ds.getDeck());

            int pScore = gs.calculateHandScore(player.getHand());
            int cScore = gs.calculateHandScore(computerHand);

            System.out.println("======");
            System.out.println("player hand : " + player.getHand() + " >>>> score : " + pScore );
            System.out.println("computer hand : " + computerHand + " >>>> score : " + cScore );

            GameResult gr = gs.getGameResult(pScore, cScore);
            System.out.println(gr);

        }
        while (nextGame(counter++, games, sc));
        System.out.println("THE END");

    }


    private static boolean nextGame(int gameNumber, int games, Scanner sc){
        if (gameNumber != games){
            System.out.println("Next game ... [Y/N]");
            String input = sc.nextLine().toUpperCase();

            if (input.equals("N")){
                return false;
            } else if (input.equals("Y")){
                return true;
            }
        } else {
            return false;
        }
        return true;
    }


    private static void game(Player pl, DeckService ds, GameService gs, Scanner sc){
        String nextCard;
        pl.clearHand();
        do {
            List<Card> hand = pl.getHand();
            // first time 2 card
            if (hand.isEmpty()){
                hand.add(ds.dealCard());
            }
            hand.add(ds.dealCard());
            int score = gs.calculateHandScore(hand);
            System.out.println("player hand : " + hand + " >>>> score : " + score );

            if (score < 21) {
                System.out.println("Next card ... [Y/N]");
                nextCard = sc.nextLine().toUpperCase();
            } else {
                break;
            }

        } while(nextCard.equals("Y"));

    }
}