public class AdvantageGameState implements GameState {

    private final Player playerInAdvantage;

    public AdvantageGameState(Player playerInAdvantage) {
        this.playerInAdvantage = playerInAdvantage;
    }

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {
        return "Advantage " + namePlayer2;
    }

    @Override
    public GameState playerOneScored() {

        if(playerInAdvantage == Player.PLAYER1){
            return new WinGamestate(Player.PLAYER1);
        }
        return new EvenGameState(-1);
    }

    @Override
    public GameState playerTwoScored() {
        return new WinGamestate(Player.PLAYER2);
    }
}
