package dto;

public class SourceIndustry {
    private String source;
    private String industry;

    public SourceIndustry(String source, String industry) {
        this.source = source;
        this.industry = industry;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "SourceIndustry{" +
                "source='" + source + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }
}
