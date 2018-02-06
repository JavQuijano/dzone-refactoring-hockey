package com.dzone.albanoj2.refactoring.hockey;

import java.util.List;

public class GoalieStatistics {

    private final Season season;

    public GoalieStatistics(Season season) {
        this.season = season;
    }

    public double getGoalsAgainstAverage() {

        if (season.getGames().isEmpty()) {
            return 0.0;
        }
        else {
            List<Game> games = season.getGames();
            int tga = 0;

            for (Game game: games) {
                tga += game.getGoalsAgainst();
            }

            double mins = 0;

            for (Game game: games) {
                mins += game.getMinutesPlayed();
            }

            return (tga / mins) * 60;
        }
    }

    public double getSavePercentage() {

        if (season.getGames().isEmpty()) {
            return 0.0;
        }
        else {
            List<Game> games = season.getGames();
            int g = 0;

            for (Game game: games) {
                g += game.getGoalsAgainst();
            }

            int tsoga = 0;

            for (Game game: games) {
                tsoga += game.getShotsOnGoalAgainst();
            }

            return ((double) tsoga - g) / tsoga;
        }
    }
}
