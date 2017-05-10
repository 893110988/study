package wmm.javaframe.study.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangmm on 2017/1/4.
 */
public class ExcelUtils {

    private static final List<Short> dateShort=new ArrayList<Short>(){{
        add((short) 14);add((short) 15);add((short) 16);add((short) 17);add((short) 57);
        add((short)176);add((short)181);add((short)182);add((short)183);add((short)184);
        add((short)185);add((short)186);add((short)187);add((short)188);add((short)189);
        add((short)190);add((short)191);add((short)192);add((short)193);add((short)194);
        add((short)195);add((short)196);add((short)197);add((short)198);add((short)199);
        add((short)200);add((short)201);add((short)202);add((short)203);
    }};
    //excel只能设置单元格格式时候的时间对应的编码
    private static final List<Short> datetimeShort=new ArrayList<Short>(){{
        add((short) 18);add((short) 19);add((short) 20);add((short) 21);add((short) 32);
        add((short) 33);add((short) 56);add((short)179);add((short) 204);add((short)205);
        add((short)206);add((short)207);add((short)208);add((short)209);add((short)210);
        add((short)211);add((short)212);add((short)213);
    }};
    private static String resloveValue(Cell cell) {
        if (cell == null) {
            return "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getStringCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            if(dateShort.contains(cell.getCellStyle().getDataFormat())){
                return org.apache.commons.lang3.time.DateFormatUtils.format(cell.getDateCellValue(), "yyyy-MM-dd");
            }
            if (datetimeShort.contains(cell.getCellStyle().getDataFormat())) {
                return org.apache.commons.lang3.time.DateFormatUtils.format(cell.getDateCellValue(), "yyyy-MM-dd HH:mm:ss");
            }
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                return DateFormatUtils.format(cell.getDateCellValue(), "yyyy-MM-dd HH:mm:ss");
            }
            Long longVal = Math.round(cell.getNumericCellValue());
            if (Double.parseDouble(longVal + ".0") == cell.getNumericCellValue()) { // 判断是否含有小数位.0
                return String.valueOf(longVal);
            }
            DecimalFormat df = new DecimalFormat("0.0000000000");
            String number = df.format(cell.getNumericCellValue());
            return String.valueOf(number);
        } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
            return "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            try {
                return String.valueOf(cell.getNumericCellValue());
            } catch (IllegalStateException e) {
                return "";
            }
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }
    /**
     * 将Excel解析成Map
     *
     * @param is excel数据
     * @return 结构化预览数据，key为sheet名，value为抽取的预览数据（包含头）
     */
    public static Map<String, List<List<String>>> readExcel(InputStream is) {
        Map<String, List<List<String>>> map = new LinkedHashMap<>();
        try (Workbook workbook = WorkbookFactory.create(is)) {
            for (int sheetNum = 0, sheetNums = workbook.getNumberOfSheets(); sheetNum < sheetNums; sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                int lastRowNum = sheet.getLastRowNum();
                if (lastRowNum < 0) {
                    continue;
                }
                String sheetName = sheet.getSheetName();
                ArrayList arrayList =new ArrayList();
                map.put(sheetName,arrayList);
                sheet.rowIterator().forEachRemaining(row->{
                    ArrayList arrayList1 =new ArrayList();
                    for(int i=0;i<sheet.getRow(0).getLastCellNum();i++){
                        try{
                            arrayList1.add(ManyToSimpleUtils.convert(resloveValue(row.getCell(i)),0));
                        }catch(Exception e){
                            //System.out.println(row.getCell(i).getCellType());
                            arrayList1.add(row.getCell(i));
                        }
                    }
                    arrayList.add(arrayList1);
                });

            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void write(Map<String, List<List<String>>> map,String newPath) throws IOException{
        Workbook wb = new XSSFWorkbook();// 创建一个新的excel的文档对象
        if (null != map && null != newPath) {
            map.forEach((sheetName,value)->{
                Sheet sheet = wb.createSheet(sheetName);// 在文档对象中创建一个表单..默认是表单名字是Sheet0、Sheet1....
                // Sheet sheet = wb.createSheet("hell poi");//在创建爱你表单的时候指定表单的名字

                /**
                 * 设置Excel表的第一行即表头
                 */

                if(value.size()==0){
                    return;
                }
                Row row = sheet.createRow(0);
                for (int i = 0; i < value.get(0).size(); i++) {

                    Cell headCell = row.createCell(i);
                    headCell.setCellType(Cell.CELL_TYPE_STRING);// 设置这个单元格的数据的类型,是文本类型还是数字类型
                    //headCell.setCellStyle(style);// 设置表头样式
                    headCell.setCellValue(value.get(0).get(i));// 给这个单元格设置值
                }

                //去掉头
                for (int i = 1; i < value.size(); i++) {
                    Row rowdata = sheet.createRow(i);// 创建数据行
                    List list = value.get(i);
                    for(int j=0;j<list.size();j++){
                        Cell celldata = rowdata.createCell(j);// 在一行中创建某列..
                        //celldata.setCellType(Cell.CELL_TYPE_STRING);
                        celldata.setCellValue( (String)(list.get(j)));
                    }
                }
            });
            // 文件流
            File file = new File(newPath);
            OutputStream os = new FileOutputStream(file);
            os.flush();
            wb.write(os);
            os.close();
        }
    }

    /**
     * Use InputStreamReader and System.in to read data from console
     *
     * @param prompt
     *
     * @return input string
     */
    private static String readDataFromConsole(String prompt) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            System.out.print(prompt);
            str = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static void readAndWrite(String oldPath, String newPath) throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(oldPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        write(readExcel(fis),newPath);
    }

    public static void main(String[] args) {
        //"C:\\Users\\Administrator\\Desktop\\aaa.xlsx"
        String oldPath = readDataFromConsole("Please input oldPath：");
        //"C:\\Users\\Administrator\\Desktop\\1.xlsx"
        String newPath = readDataFromConsole("Please input newPath：");

    }
}
