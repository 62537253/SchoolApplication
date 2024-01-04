package kuzstu.com.Applications.model;

public enum StudentsEstimation {

    EXCELLENT (1),
    GOOD_SHIT(2),
    CHOICE(3),
    POOR(4);

    private final int id;

    StudentsEstimation(Integer id) {
        this.id = id;
    }
}
