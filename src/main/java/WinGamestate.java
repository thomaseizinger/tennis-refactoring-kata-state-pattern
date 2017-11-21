public class WinGamestate implements GameState {
    @Override
    public String asString(String namePlayer1, final String name) {
        return "Win for player 2";
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
