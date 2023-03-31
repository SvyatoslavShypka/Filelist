package eu.dar3;

import eu.dar3.ListFiles;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        String folder = "C:\\Company_check";
        if (args.length == 0) {
            throw new IllegalArgumentException("no folder name");
        }
        String folder = args[0];
        Map<String, Date> map;
        Map<String, Integer> monthQuantity = new TreeMap<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//        sdf.format(new Date());

        map = ListFiles.generateFilesListMap(folder);
        for (Map.Entry<String, Date> entry: map.entrySet()
             ) {
            monthQuantity.merge(sdf.format(entry.getValue()).substring(0,7), 1, Integer::sum);
//            System.out.println(entry.getKey() + " : " + sdf.format(entry.getValue()));
        }
        System.out.println("total files number: " + map.size());
        for (Map.Entry<String, Integer> entry: monthQuantity.entrySet()
             ) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
/*
// workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet
                = workbook.createSheet("Companies");

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> companyData
                = new TreeMap<String, Object[]>();

        int countCell = 1;
        companyData.put(Integer.toString(countCell), new Object[] { "No", "NAME", "Date" });
        for (Map.Entry<String, Date> entry: map.entrySet()
        ) {
            countCell++;
            companyData.put(Integer.toString(countCell),
                    new Object[] { Integer.toString(countCell -1), entry.getKey(),
                    sdf.format(entry.getValue()) });
//            System.out.println(entry.getKey() + " : " + sdf.format(entry.getValue()));
        }

        Set<String> keyid = companyData.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = companyData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File("C:\\2\\projects\\goit\\Modul1\\company_list.xlsx"));

        workbook.write(out);
        out.close();
*/
    }
}
