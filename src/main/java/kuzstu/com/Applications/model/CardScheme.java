package kuzstu.com.Applications.model;

public enum CardScheme {
    Scheme1 (0),
    Scheme2(1);

    private final int id;

    CardScheme(Integer id) {
        this.id = id;
    }
}
