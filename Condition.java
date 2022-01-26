import javax.print.DocFlavor.STRING;

public enum Condition {

    EXTREME_DEMOCRAT("Progressive"), DEMOCRAT("Liberal"), MIDDLE("Moderate"), REPUBLICAN("Conservative"),
    TRUMPIST("Extremist");

    private String condition;

    Condition(String condition){
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
