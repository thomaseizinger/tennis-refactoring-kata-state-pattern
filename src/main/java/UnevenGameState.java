public class UnevenGameState implements GameState {

    private final int pointsPlayer1;
    private final int pointsPlayer2;

    private final RunningScoreNameMapper scoreNameMapper;

    public UnevenGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
        scoreNameMapper = new RunningScoreNameMapper();
    }

    @Override
    public String asString(String namePlayer1, final String name) {
        return String.format("%s-%s", scoreNameMapper.mapScore(pointsPlayer1), scoreNameMapper.mapScore(pointsPlayer2));
    }

    @Override
    public GameState playerOneScored() {

        if (pointsPlayer1 + 1 == 4) {
            return new WinPlayer1GameState();
        }

        if (pointsPlayer1 + 1 == pointsPlayer2) {
            return new EvenGameState(pointsPlayer1 + 1);
        }

        return new UnevenGameState(pointsPlayer1 + 1, pointsPlayer2);
    }

    @Override
    public GameState playerTwoScored() {

        int incrementedPointsPlayer2 = pointsPlayer2 + 1;

        if(incrementedPointsPlayer2 == 4 && pointsPlayer1 != incrementedPointsPlayer2){
            return new WinPlayer2GameState();
        }

        if(incrementedPointsPlayer2 == this.pointsPlayer1){
            return new EvenGameState(incrementedPointsPlayer2);
        }

        return new UnevenGameState(this.pointsPlayer1, incrementedPointsPlayer2);
    }
}
