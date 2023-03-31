package eu.dar3;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Company {

    private static Map<String, Date> map = new HashMap<>();
    private static int count = 0;

    private String fileName;
    private Date date;

    public Company(String fileName, Date date) {
        this.fileName = fileName;
        this.date = date;
        map.put(fileName, date);
        count++;
    }

}
