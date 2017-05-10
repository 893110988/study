package wmm.javaframe.study.confirmtype;


import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcelUtils {

    private static String resloveValue(Cell cell) {
        if (cell == null) {
            return "";
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getStringCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
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
     * @param is            excel数据
     * @param maxRowNumbers 返回的预览条数，-1表示返回所有
     * @return 结构化预览数据，key为sheet名，value为随机抽取的预览数据（包含头）
     */
    public static Map<String, List<List<String>>> readExcel(InputStream is, int maxRowNumbers) {
        Map<String, List<List<String>>> result = new LinkedHashMap<>();
        try (Workbook workbook = WorkbookFactory.create(is)) {
            for (int sheetNum = 0, sheetNums = workbook.getNumberOfSheets(); sheetNum < sheetNums; sheetNum++) {
                Sheet sheet = workbook.getSheetAt(sheetNum);
                int lastRowNum = sheet.getLastRowNum();
                if (lastRowNum <= 0) {
                    continue;
                }
                List<List<String>> rows = new ArrayList<>(lastRowNum);

                int lastColumnNum = sheet.getRow(0).getLastCellNum();
                List<Integer> shuffleRowNumbers = new ArrayList<>();
                shuffleRowNumbers.add(0);
                List<Integer> shuffleRows = IntStream.range(1, lastRowNum).collect(ArrayList::new, List::add, List::addAll);
                Collections.shuffle(shuffleRows);
                shuffleRows.stream()
                        .limit(maxRowNumbers)
                        .collect(() -> shuffleRowNumbers, List::add, List::addAll);
                result.put(sheet.getSheetName(), shuffleRowNumbers.stream()
                        .map(rowNum -> IntStream.range(0, lastColumnNum)
                                .mapToObj(columnNum -> resloveValue(sheet.getRow(rowNum).getCell(columnNum)))
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList()));
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\11.xlsx");
        Map<String, List<List<String>>> map = readExcel(fis, 10);
      /*  DataTypeConfirmService dataTypeConfirmService = new DataTypeConfirmServiceImpl();


        Map<String, Map<String, Integer>> type = dataTypeConfirmService.getRowTypeConfirm(map, 300);
        System.out.println(type.toString());

        Map<String, Map<String, Integer>> type1 = dataTypeConfirmService.getRowTypeConfirm(map, 300);
        System.out.println(type1.toString());
        Map<String, Map<String, Integer>> type2 = dataTypeConfirmService.getRowTypeConfirm(map, 300);
        System.out.println(type2.toString());

        Map<String, Map<String, Map<Integer, Integer>>> proportion = dataTypeConfirmService.getRowTypeProportion(map, 300);
        System.out.println(proportion.toString());
*/
    }
}