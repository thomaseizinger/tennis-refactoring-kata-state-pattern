import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void shouldHaveLoveAllAsInitialState() throws Exception {

        GameState state = new InitialState();

        assertEquals("Love-All", state.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerOneScoringPoint_shouldBeLoveFifteen() throws Exception {

        GameState state = new InitialState();

        GameState newState = state.playerOneScored();

        assertEquals("Fifteen-Love", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerTwoScoringPoint_shouldBeFifteenLove() throws Exception {

        GameState state = new InitialState();

        GameState newState = state.playerTwoScored();

        assertEquals("Love-Fifteen", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerOneScoresTwoTimes_shouldBeThirtyLove() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerOneScored()
                .playerOneScored();

        assertEquals("Thirty-Love", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerTwoScoresTwoTimes_shouldBeLoveThirty() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerTwoScored()
                .playerTwoScored();

        assertEquals("Love-Thirty", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerTwoScoresThreeTimes_shouldBeLoveForty() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerTwoScored()
                .playerTwoScored()
                .playerTwoScored();

        assertEquals("Love-Forty", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerTwoScoresAndPlayerOneScored_shouldBeFifteenAll() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerOneScored()
                .playerTwoScored();

        assertEquals("Fifteen-All", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerTwoScores4Times_shouldBeWinForPlayer2() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerTwoScored()
                .playerTwoScored()
                .playerTwoScored()
                .playerTwoScored();

        assertEquals("Win for player 2", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerOneAndTwoScoredThreeTimesAndPlayerTwoScores_shouldBeAdvantageForPlayer2() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerOneScored()
                .playerTwoScored()
                .playerOneScored()
                .playerTwoScored()
                .playerOneScored()
                .playerTwoScored()
                .playerTwoScored();

        assertEquals("Advantage player2", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerOneAndTwoScoreThreeTimes_shouldBeDeuce() throws Exception {

        GameState state = new InitialState();

        GameState newState = state
                .playerOneScored()
                .playerOneScored()
                .playerOneScored()
                .playerTwoScored()
                .playerTwoScored()
                .playerTwoScored();

        assertEquals("Deuce", newState.asString("player1", "player2"));
    }

    @Test
    public void givenInitialState_whenPlayerOneAndTwoScoreEqualTimesAboveThreeToTen_shouldBeDeuce() throws Exception {


        for (int scores = 0; scores < 7; scores++) {
            GameState state = new EvenGameState(3);
            for (int j = 0; j < scores; j++) {
                state = state.playerOneScored().playerTwoScored();
            }
            assertEquals("Deuce", state.asString("player1", "player2"));
        }


    }
}