package com.qcby.excle;

import java.util.ArrayList;

public class WriteExcel {

    public static void main(String[] args) {

        ArrayList<ArrayList<Object>> result = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> aa = new ArrayList<Object>();
        aa.add("one");
        aa.add("two");
        aa.add("three");
        aa.add("three");
        aa.add("three");

        result.add(aa);
        ExcelUtil.writeExcel(result, "E:/java.xlsx");
    }

}
