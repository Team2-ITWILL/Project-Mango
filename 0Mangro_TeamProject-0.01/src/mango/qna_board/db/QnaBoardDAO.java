package mango.qna_board.db;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mango.connection.db.DBconnection;

public class QnaBoardDAO extends DBconnection
{
  public void insertQnaBoard(QnaBoardBean qbean)
  {
    int num = 0;
    try
    {
      getConnection();

      this.sql = "select max(qna_board_num) from qna_board";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        num = this.rs.getInt(1) + 1;
      }

      this.sql = "insert into qna_board(qna_board_num, mem_email, qna_board_pwd, qna_board_title, qna_board_content, qna_board_read, qna_board_date, qna_board_ip, qna_re_lev, qna_re_ref, qna_re_seq)values(?, ?, ?, ?, ?, ?,  now(), ?, ?, ?, ?)";

      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, num);
      this.pstmt.setString(2, qbean.getMem_email());
      this.pstmt.setString(3, qbean.getQna_board_pwd());
      this.pstmt.setString(4, qbean.getQna_board_title());
      this.pstmt.setString(5, qbean.getQna_board_content());
      this.pstmt.setInt(6, 0);
      this.pstmt.setString(7, qbean.getQna_board_ip());
      this.pstmt.setInt(8, 0);
      this.pstmt.setInt(9, num);
      this.pstmt.setInt(10, 0);

      this.pstmt.executeUpdate();
    }
    catch (Exception e)
    {
      System.out.println("insertQnaBoard에서 오류 " + e);
    }
    finally
    {
      resourceClose();
    }
  }

  public int getQnaBoardCount()
  {
    int count = 0;
    try
    {
      getConnection();

      this.sql = "select count(*) from qna_board";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        count = this.rs.getInt(1);
      }

    }
    catch (Exception e)
    {
      System.out.println("getQnaBoardCount에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return count;
  }

  public int getSearchQnaBoardCount(String search_key, String search_word)
  {
    int count = 0;
    try
    {
      getConnection();

      this.sql = ("select count(*) from qna_board where + " + search_key + " Like '%" + search_word + "%'");
      this.pstmt = this.con.prepareStatement(this.sql);

      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        count = this.rs.getInt(1);
      }

    }
    catch (Exception e)
    {
      System.out.println("getSearchQnaBoardCount()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return count;
  }

  public List<QnaBoardBean> getQnaBoardList(int startRow, int pageSize)
  {
    List qnaBoardList = new ArrayList();
    try
    {
      getConnection();

      this.sql = "select * from qna_board order by qna_re_ref desc, qna_re_seq asc limit ?, ?";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, startRow - 1);
      this.pstmt.setInt(2, pageSize);
      this.rs = this.pstmt.executeQuery();

      while (this.rs.next())
      {
        QnaBoardBean qbean = new QnaBoardBean();

        qbean.setQna_board_num(this.rs.getInt("qna_board_num"));
        qbean.setMem_email(this.rs.getString("mem_email"));
        qbean.setQna_board_pwd(this.rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(this.rs.getString("qna_board_title"));
        qbean.setQna_board_content(this.rs.getString("qna_board_content"));
        qbean.setQna_board_read(this.rs.getInt("qna_board_read"));
        qbean.setQna_board_date(this.rs.getDate("qna_board_date"));
        qbean.setQna_board_ip(this.rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(this.rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(this.rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(this.rs.getInt("qna_re_seq"));

        qnaBoardList.add(qbean);
      }

    }
    catch (Exception e)
    {
      System.out.println("getQnaBoardList()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return qnaBoardList;
  }

  public List<QnaBoardBean> getSearchQnaBoardList(int startRow, int pageSize, String search_key, String search_word)
  {
    List qnaBoardList = new ArrayList();
    try
    {
      getConnection();

      if ((search_key == null) || (search_word.equals(null))) {
        this.sql = "select * from qna_board order by qna_board_num desc, qna_re_ref desc, qna_re_seq asc, qna_board_num desc limit ?, ?";
      }
      else
      {
        this.sql = 
          ("select * from qna_board where " + 
          search_key + " like '%" + search_word + "%' " + 
          "order by qna_board_num desc, qna_re_ref desc, qna_re_seq asc, qna_board_num desc limit ?, ?");
      }

      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, startRow - 1);
      this.pstmt.setInt(2, pageSize);
      this.rs = this.pstmt.executeQuery();

      while (this.rs.next())
      {
        QnaBoardBean qbean = new QnaBoardBean();

        qbean.setQna_board_num(this.rs.getInt("qna_board_num"));
        qbean.setMem_email(this.rs.getString("mem_email"));
        qbean.setQna_board_pwd(this.rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(this.rs.getString("qna_board_title"));
        qbean.setQna_board_content(this.rs.getString("qna_board_content"));
        qbean.setQna_board_read(this.rs.getInt("qna_board_read"));
        qbean.setQna_board_date(this.rs.getDate("qna_board_date"));
        qbean.setQna_board_ip(this.rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(this.rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(this.rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(this.rs.getInt("qna_re_seq"));

        qnaBoardList.add(qbean);
      }

    }
    catch (Exception e)
    {
      System.out.println("getSearchQnaBoardList()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return qnaBoardList;
  }

  public QnaBoardBean getQnaBoard(int num)
  {
    QnaBoardBean qbean = null;
    try
    {
      getConnection();

      this.sql = "select * from qna_board where qna_board_num = ?";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, num);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next())
      {
        qbean = new QnaBoardBean();

        qbean.setQna_board_num(this.rs.getInt("qna_board_num"));
        qbean.setMem_email(this.rs.getString("mem_email"));
        qbean.setQna_board_pwd(this.rs.getString("qna_board_pwd"));
        qbean.setQna_board_title(this.rs.getString("qna_board_title"));
        qbean.setQna_board_content(this.rs.getString("qna_board_content"));
        qbean.setQna_board_read(this.rs.getInt("qna_board_read"));
        qbean.setQna_board_date(this.rs.getDate("qna_board_date"));
        qbean.setQna_board_ip(this.rs.getString("qna_board_ip"));
        qbean.setQna_re_lev(this.rs.getInt("qna_re_lev"));
        qbean.setQna_re_ref(this.rs.getInt("qna_re_ref"));
        qbean.setQna_re_seq(this.rs.getInt("qna_re_seq"));
      }

    }
    catch (Exception e)
    {
      System.out.println("getQnaBoard()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return qbean;
  }

  public void UpdateReadCount(int num)
  {
    try
    {
      getConnection();

      this.sql = "update qna_board set qna_board_read = qna_board_read+1 where qna_board_num = ?";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, num);

      this.pstmt.executeUpdate();
    }
    catch (Exception e)
    {
      System.out.println("UpdateReadCount()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }
  }

  public int UpdateQnaBoard(QnaBoardBean qbean)
  {
    int check = -1;
    try
    {
      getConnection();

      this.sql = "select qna_board_pwd from qna_board where qna_board_num = ?";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, qbean.getQna_board_num());
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next())
      {
        if (qbean.getQna_board_pwd().equals(this.rs.getString("qna_board_pwd")))
        {
          check = 1;

          this.sql = "update qna_board set qna_board_title = ?, qna_board_content = ? where qna_board_num = ?";
          this.pstmt = this.con.prepareStatement(this.sql);
          this.pstmt.setString(1, qbean.getQna_board_title());
          this.pstmt.setString(2, qbean.getQna_board_content());
          this.pstmt.setInt(3, qbean.getQna_board_num());

          this.pstmt.executeUpdate();
        }
        else
        {
          check = 0;
        }

      }

    }
    catch (Exception e)
    {
      System.out.println("UpdateQnaBoard()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return check;
  }

  public int DeleteQnaBoard(int num, String pwd)
  {
    int check = -1;

    label181: 
    try { getConnection();

      this.sql = "select qna_board_pwd from qna_board where qna_board_num = ?";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, num);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next())
      {
        if (pwd.equals(this.rs.getString("qna_board_pwd")))
        {
          check = 1;

          this.sql = "delete from qna_board where qna_board_num = ?";
          this.pstmt = this.con.prepareStatement(this.sql);
          this.pstmt.setInt(1, num);

          this.pstmt.executeUpdate();

          break label181;
        }
      }
      else check = 0;

    }
    catch (Exception e)
    {
      System.out.println("DeleteQnaBoard()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }

    return check;
  }

  public void reInsertQnaBoard(QnaBoardBean qbean)
  {
    int num = 0;
    try
    {
      getConnection();

      this.sql = "select max(qna_board_num) from qna_board";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.rs = this.pstmt.executeQuery();

      if (this.rs.next()) {
        num = this.rs.getInt(1) + 1;
      }

      this.sql = "update qna_board set qna_re_seq = qna_re_seq+1 where qna_re_ref = ? AND qna_re_seq > ?";
      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, qbean.getQna_re_ref());
      this.pstmt.setInt(2, qbean.getQna_re_seq());
      this.pstmt.executeUpdate();

      this.sql = "insert into qna_board(qna_board_num, mem_email, qna_board_pwd, qna_board_title, qna_board_content, qna_board_read, qna_board_date, qna_board_ip, qna_re_lev, qna_re_ref, qna_re_seq)values(?, ?, ?, ?, ?, ?,  now(), ?, ?, ?, ?)";

      this.pstmt = this.con.prepareStatement(this.sql);
      this.pstmt.setInt(1, num);
      this.pstmt.setString(2, qbean.getMem_email());
      this.pstmt.setString(3, qbean.getQna_board_pwd());
      this.pstmt.setString(4, qbean.getQna_board_title());
      this.pstmt.setString(5, qbean.getQna_board_content());
      this.pstmt.setInt(6, 0);
      this.pstmt.setString(7, qbean.getQna_board_ip());
      this.pstmt.setInt(8, qbean.getQna_re_lev() + 1);
      this.pstmt.setInt(9, qbean.getQna_re_ref());
      this.pstmt.setInt(10, qbean.getQna_re_seq() + 1);

      this.pstmt.executeUpdate();
    }
    catch (Exception e)
    {
      System.out.println("reInsertQnaBoard()에서 오류" + e);
    }
    finally
    {
      resourceClose();
    }
  }
}