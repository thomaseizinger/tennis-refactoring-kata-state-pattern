public class WinGamestate implements GameState {

    private final Player winner;

    public WinGamestate(Player winner) {
        this.winner = winner;
    }

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {
        if (winner == Player.PLAYER1){
            return "Win for " + namePlayer1;
        }
        return "Win for " + namePlayer2;
    }

    @Override
    public GameState playerOneScored() {
        return null;
    }

    @Override
    public GameState playerTwoScored() {
        return null;
    }
}
