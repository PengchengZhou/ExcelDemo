package cn.edu.seu.pczhou.dao.impl;

import cn.edu.seu.pczhou.dao.QuestionDao;
import cn.edu.seu.pczhou.model.Question;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 鹏程 on 2016/8/28.
 */
public class JdbcQuestionDao implements QuestionDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Question question) {
        String sql = "insert into questions " +
                "(question, answer_A, answer_B, answer_C, answer_D, answer_right) " +
                "values(?, ?, ?, ?, ?, ?)";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getAnswer_A());
            ps.setString(3, question.getAnswer_B());
            ps.setString(4, question.getAnswer_C());
            ps.setString(5, question.getAnswer_D());
            ps.setString(6, question.getAnswer_right());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Question findQuestionById(int id) {
        String sql = "select * from questions where id=?";

        Connection conn=null;

        try{
            conn=dataSource.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            Question question=null;
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                question=new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("answer_A"),
                        rs.getString("answer_B"),
                        rs.getString("answer_C"),
                        rs.getString("answer_D"),
                        rs.getString("answer_right")
                );
            }
            rs.close();
            ps.close();
            return question;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(conn !=null){
                try{
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
