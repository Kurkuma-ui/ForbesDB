package dto;

public class CSVObject {

    private int rank;
    private String name;
    private float networth;
    private int Age;
    private String country;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetworth(float networth) {
        this.networth = networth;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    private String source;
    private String industry;
    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public float getNetworth() {
        return networth;
    }

    public int getAge() {
        return Age;
    }

    public String getCountry() {
        return country;
    }

    public String getSource() {
        return source;
    }

    public String getIndustry() {
        return industry;
    }

}
