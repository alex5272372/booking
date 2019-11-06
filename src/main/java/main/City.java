package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum City {

    KYIV("1", 0, "Kyiv"),
    KHARKIV("2", 1, "Kharkiv"),
    ODESSA("3", 2, "Odessa"),
    DNIPRO("4", 3, "Dnipro"),
    DONETSK("5", 4, "Donetsk"),
    ZAPORIZHIA("6", 5, "Zaporizhia"),
    LVIV("7", 6, "Lviv"),
    KRYVYI_RIH("8", 7, "Kryvyi rih"),
    MYKOLAIV("9", 8, "Mykolaiv"),
    MARIUPOL("10", 9, "Mariupol");

    private String code;
    private static final Map<String, City> lookup = new HashMap<>();
    private int id;
    private String name;
    private static final City ids[] = new City[10];

    static {
        Arrays.stream(City.values())
                .forEach(city -> lookup.put(city.getCode(), city));
        Arrays.stream(City.values())
                .forEach(city -> lookup.put(city.getName(), city));
        Arrays.stream(City.values()).forEach(city -> ids[city.getId()] = city);
    }

    City(String code, int id, String name) {
        this.code = code;
        this.id = id;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public static City get(String code) {
        return lookup.get(code);
    }

    public static City getByName(String name) {
        return lookup.get(name);
    }

    public static String getCode(Enum e) {
        return Arrays.stream(City.values())
                .filter(city -> city.equals(e))
                .findFirst()
                .get()
                .getCode();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static City getById(int id) {
        return ids[id];
    }

    public static int getCount() {
        return ids.length;
    }
}
