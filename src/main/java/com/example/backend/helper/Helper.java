package com.example.backend.helper;

import com.example.backend.model.Lesson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {
    public static boolean checkExcelFormat(MultipartFile file){
        String contentType = file.getContentType();
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<Lesson> getAllLessons(InputStream is){

        List<Lesson> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            //workbook.getSheet("data");
            XSSFSheet sheet = workbook.getSheet("data");
            int numberRow = 7;
            int addedValueRow = 18;
            int countRow = 12;
            int countColumn = 7;
            List<Lesson> lessons = new ArrayList<>();
            List<Integer> numberMonths = new ArrayList<>();


            String firstMonth = sheet.getRow(6).getCell(0).getStringCellValue();
            if (firstMonth.equals("сентябрь")){
                numberMonths.add(9);
                numberMonths.add(10);
                numberMonths.add(11);
                numberMonths.add(12);
            }
            else{
                numberMonths.add(2);
                numberMonths.add(3);
                numberMonths.add(4);
                numberMonths.add(5);
            }

            //Row row =





            for (int i = numberRow; i < 216; i++){
                Row row = sheet.getRow(i);

                for (int j = 0; j < countColumn; j++){
                    row.getCell(j);
                }
            }


            //int rowNumber = 0;
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()){
                Row row = rows.next();
                Iterator<Cell> cells = row.iterator();
                while (cells.hasNext()){
                    Cell cell = cells.next();
                }

            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
