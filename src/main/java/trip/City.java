package trip;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum City {

    KYIV("1"),
    KHARKIV("2"),
    ODESSA("3"),
    DNIPRO("4"),
    DONETSK("5"),
    ZAPORIZHIA("6"),
    LVIV("7"),
    KRYVYI_RIH("8"),
    MYKOLAIV("9"),
    MARIUPOL("10");

    private String code;
    private static final Map<String, City> lookup = new HashMap<>();

    static {
        Arrays.stream(City.values())
                .forEach(city -> lookup.put(city.getCode(), city));
    }

    City(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static City get(String code) {
        return lookup.get(code);
    }

    public static String getCode(Enum e) {
        return Arrays.stream(City.values())
                .filter(city -> city.equals(e))
                .findFirst()
                .get()
                .getCode();
    }
}
