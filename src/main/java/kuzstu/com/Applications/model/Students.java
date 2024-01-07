package kuzstu.com.Applications.model;

import java.util.Date;

public record Students(
        int id_student,
        int id_class,
        String name_student,
        Date dater,
        String address,
        boolean gender,
        StudentsEstimation estimation)
 {

}
