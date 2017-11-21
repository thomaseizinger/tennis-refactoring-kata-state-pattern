public class EvenGameState implements GameState {

    private final int points;

    public EvenGameState(int points) {
        this.points = points;
    }

    @Override
    public String asString(String namePlayer1, final String namePlayer2) {

        if(points >= 3){
            return "Deuce";
        }

        return "Fifteen-All";
    }

    @Override
    public GameState playerOneScored() {
        return new UnevenGameState(points + 1, points);
    }

    @Override
    public GameState playerTwoScored() {

        int incrementedPointsPlayer2 = points + 1;

        if (incrementedPointsPlayer2 == 4) {
            return new AdvantageGameState(Player.PLAYER2);
        }

        return new UnevenGameState(points, incrementedPointsPlayer2);
    }
}
