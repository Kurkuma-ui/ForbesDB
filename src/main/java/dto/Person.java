package dto;

public class Person {
    private String name;
    private int age;
    private String country;
    private double networth;
    private String source;

    public Person(String name, int age, String country, double networth, String source) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.networth = networth;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getNetworth() {
        return networth;
    }

    public void setNetworth(double networth) {
        this.networth = networth;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", networth=" + networth +
                ", source='" + source + '\'' +
                '}';
    }
}
