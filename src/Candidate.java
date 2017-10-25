public class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
