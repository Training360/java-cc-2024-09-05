package datamunging2;

public class FootballLine implements Line {

    private String team;

    private int goalsFor;

    private int goalsAgainst;

    public FootballLine(String team, int goalsFor, int goalsAgainst) {
        this.team = team;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    @Override
    public int getDiff() {
        return Math.abs(goalsFor - goalsAgainst);
    }

    @Override
    public String getLabel() {
        return team;
    }
}
