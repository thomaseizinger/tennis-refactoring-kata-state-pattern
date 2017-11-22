public class AdvantagePlayer2GameState implements GameState {

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {
        return "Advantage " + namePlayer2;
    }

    @Override
    public GameState playerOneScored() {
        return null;
    }

    @Override
    public GameState playerTwoScored() {
        return new WinPlayer2GameState();
    }
}
