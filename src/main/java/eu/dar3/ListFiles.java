package eu.dar3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListFiles {

/*
    public static Set<String> listFilesUsingJavaIO(String folder) {

        return Stream.of(new File(folder)
                .listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }
*/

    public static Map<String, Date> generateFilesListMap (String folder) throws IOException {
        Map<String, Date> map = new HashMap<>();

        File[] files = new File(folder).listFiles();
        if (files != null && files.length != 0) {
            for (File file : files)
            {
                if (file.isFile())
                {
                    BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.toURI()), BasicFileAttributes.class);
                    FileTime fileTime = attributes.lastModifiedTime();
                    Date date = new Date(fileTime.toMillis());
                    map.put(file.getName(), date);
    //                System.out.println(date);
                }
            }
        }
        return map;
    }}
