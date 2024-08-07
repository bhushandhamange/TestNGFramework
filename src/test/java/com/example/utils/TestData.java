package com.example.utils;

import org.testng.annotations.DataProvider;
import com.example.utils.ExcelUtils;

import java.lang.reflect.Method;

public class TestData {

    @DataProvider(name = "searchDataProvider")
    public Object[][] searchDataProvider(Method m) {
        String excelPath = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
        String sheetName = m.getName();
//        System.out.println("Test Name : "+ sheetName);
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        return excelUtils.getTestData();
    }
}
