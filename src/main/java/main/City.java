package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum City {

    KYIV(0, "Kyiv"),
    KHARKIV(1, "Kharkiv"),
    ODESSA(2, "Odessa"),
    DNIPRO(3, "Dnipro"),
    DONETSK(4, "Donetsk"),
    ZAPORIZHIA(5, "Zaporizhia"),
    LVIV(6, "Lviv"),
    KRYVYI_RIH(7, "Kryvyi rih"),
    MYKOLAIV(8, "Mykolaiv"),
    MARIUPOL(9, "Mariupol");

    private static final Map<String, City> lookup = new HashMap<>();
    private int id;
    private String name;
    private static final City ids[] = new City[10];

    static {
        Arrays.stream(City.values())
                .forEach(city -> lookup.put(city.getName(), city));
        Arrays.stream(City.values()).forEach(city -> ids[city.getId()] = city);
    }

    City(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static City get(int id) {
        return ids[id];
    }

    public static City getByName(String name) {
        return lookup.get(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return ids.length;
    }
}
