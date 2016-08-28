package cn.edu.seu.pczhou.demo;

import cn.edu.seu.pczhou.model.Question;
import cn.edu.seu.pczhou.util.ExcelUtil;

import java.util.List;

/**
 * Created by 鹏程 on 2016/8/28.
 */
public class Demo {

    public static void main(String[] args) {

        String filename = "C:\\Users\\鹏程\\Desktop\\整合.xls";

        // 从excel表格读取所有的question
        List<Question> questions= ExcelUtil.getQuestionsFromExcel(filename);
        // 将读取到的question存入数据库
        ExcelUtil.storeQuestionsToDatabase(questions);

        System.out.println("End");
    }
}
