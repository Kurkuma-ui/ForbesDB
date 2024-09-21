package dto;

public class ForbesRating {
    private int rank;
    private String name;

    public ForbesRating(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ForbesRating{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }
}
