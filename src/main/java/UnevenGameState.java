public class UnevenGameState implements GameState {

    private final int pointsPlayer1;
    private final int pointsPlayer2;

    public UnevenGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
    }

    @Override
    public String asString(String namePlayer1, final String name) {
        return String.format("%s-%s", getScoreName(pointsPlayer1), getScoreName(pointsPlayer2));
    }

    private String getScoreName(int score) {

        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
        }

        throw new IllegalArgumentException();
    }

    @Override
    public GameState playerOneScored() {
//        if (pointsPlayer1 + 1 == pointsPlayer2) {
//            return new EvenGameState(pointsPlayer1 + 1);
//        }
        return new UnevenGameState(pointsPlayer1 + 1, pointsPlayer2);
    }

    @Override
    public GameState playerTwoScored() {

        int incrementedPointsPlayer2 = pointsPlayer2 + 1;

        if(incrementedPointsPlayer2 == 4 && pointsPlayer1 != incrementedPointsPlayer2){
            return new WinGamestate();
        }

        if(incrementedPointsPlayer2 == this.pointsPlayer1){
            return new EvenGameState(incrementedPointsPlayer2);
        }

        return new UnevenGameState(this.pointsPlayer1, incrementedPointsPlayer2);
    }
}
