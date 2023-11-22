package qa.enums;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    WEBKIT("webkit");

    private final String name;

    Browser(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }
}
