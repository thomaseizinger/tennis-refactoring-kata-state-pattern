import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TennisTest {

    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }
    
    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][] {
                { 0, 0, "Love-All" },                  // 0
                { 1, 1, "Fifteen-All" },               // 1
                { 2, 2, "Thirty-All"},                 // 2
                { 3, 3, "Deuce"},                      // 3
                { 4, 4, "Deuce"},                      // 4
                { 5, 5, "Deuce"},                      // 5
                { 6, 6, "Deuce"},                      // 6
                { 7, 7, "Deuce"},                      // 7
                { 1, 0, "Fifteen-Love"},               // 8
                { 0, 1, "Love-Fifteen"},               // 9
                { 2, 0, "Thirty-Love"},                // 10
                { 0, 2, "Love-Thirty"},                // 11
                { 3, 0, "Forty-Love"},                 // 12
                { 0, 3, "Love-Forty"},                 // 13
                { 4, 0, "Win for player1"},            // 14
                { 0, 4, "Win for player2"},            // 15
                { 2, 1, "Thirty-Fifteen"},             // 16
                { 1, 2, "Fifteen-Thirty"},             // 17
                { 3, 1, "Forty-Fifteen"},              // 18
                { 1, 3, "Fifteen-Forty"},              // 19
                { 4, 1, "Win for player1"},            // 20
                { 1, 4, "Win for player2"},            // 21
                { 3, 2, "Forty-Thirty"},               // 22
                { 2, 3, "Thirty-Forty"},               // 23
                { 4, 2, "Win for player1"},            // 24
                { 2, 4, "Win for player2"},            // 25
                { 4, 3, "Advantage player1"},          // 26
                { 3, 4, "Advantage player2"},          // 27
                { 5, 4, "Advantage player1"},          // 28
                { 4, 5, "Advantage player2"},          // 29
                { 15, 14, "Advantage player1"},        // 30
                { 14, 15, "Advantage player2"},        // 31
                { 6, 4, "Win for player1"},            // 32
                { 4, 6, "Win for player2"},            // 33
                { 16, 14, "Win for player1"},          // 34
                { 14, 16, "Win for player2"},          // 35
        });
    }

    public void checkAllScores(TennisGame game) {
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.wonPoint("player1");
            if (i < this.player2Score)
                game.wonPoint("player2");
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame1() {
        TennisGame1 game = new TennisGame1("player1", "player2");
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame2() {
        TennisGame2 game = new TennisGame2("player1", "player2");
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame3() {
        TennisGame3 game = new TennisGame3("player1", "player2");
        checkAllScores(game);
    }

    @Test
    public void checkAllScoresTennisGame4() {
        TennisGame4 game = new TennisGame4("player1", "player2");
        checkAllScores(game);
    }

}
