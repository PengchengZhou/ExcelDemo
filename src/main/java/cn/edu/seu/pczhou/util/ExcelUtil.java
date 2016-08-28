package cn.edu.seu.pczhou.util;

import cn.edu.seu.pczhou.dao.QuestionDao;
import cn.edu.seu.pczhou.model.Question;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鹏程 on 2016/8/28.
 */
public class ExcelUtil {
    public static List<Question> getQuestionsFromExcel(String filename) {
        File file = new File(filename);
        List<Question> questions = new ArrayList<Question>();

        try {
            Workbook wb = Workbook.getWorkbook(file);
            Sheet[] sheets = wb.getSheets();
            if (sheets != null && sheets.length > 0) {
                for (int i = 0; i < sheets.length; ++i) {
                    int numRows = sheets[i].getRows();
                    for (int j = 0; j < numRows; ++j) {
                        Cell[] cells = sheets[i].getRow(j);
                        if (cells != null && cells.length >= 7 && cells[1].getContents().startsWith("A")) {
                            Question question = new Question(
                                    cells[0].getContents(),
                                    cells[1].getContents(),
                                    cells[2].getContents(),
                                    cells[3].getContents(),
                                    cells[4].getContents(),
                                    cells[5].getContents()
                            );
                            questions.add(question);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public static void storeQuestionsToDatabase(List<Question> questions) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/demoContext.xml");
        QuestionDao questionDao = (QuestionDao) context.getBean("questionDao");

        for (Question question : questions) {
            questionDao.insert(question);
        }
    }

}
