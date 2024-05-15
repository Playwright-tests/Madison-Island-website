package qa.support;

public class Formatter {

    public static String format(String price, String quantity) {

        double value = Double.parseDouble(price.replaceAll("\\s", "").replace("$", ""));

        return "$" + String.format("%.2f", value * Integer.parseInt(quantity)).replace(",", ".");
    }
}
