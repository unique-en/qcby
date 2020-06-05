package com.qcby.excle;

import java.io.File;
import java.util.ArrayList;

/**
 * @author TEZ
 */
public class ReadExcel {

    public static void main(String[] args) {
        File file = new File("E://testSystem//java.xlsx");
        ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);

        if (result == null) {
            System.out.println("文件不存在：请检查路径是否正确！");
            return;
        } else if (result.size() == 0) {
            System.out.println("文件内容为空!");
            return;
        } else {
            for (int i = 1; i < result.size(); i++) {
                System.out.println("\n");
                for (int j = 0; j < result.get(i).size(); j++) {
                    System.out.print(result.get(i).get(j).toString() + "    " );

                }
            }
            String str = (String) result.get(2).get(0);
            //String ar = str.substring(0,str.length() - 3);
            System.out.print(str);
            System.out.println("\n");
        }
    }

}