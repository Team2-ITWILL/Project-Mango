package mango.qna_board.db;

import java.util.List;
import mango.anony_board.db.AnonyBoardBean;

public abstract interface IQnaBoard
{
  public abstract int InsertQnaBoard(QnaBoardBean paramQnaBoardBean);

  public abstract int UpdateQnaBoard(QnaBoardBean paramQnaBoardBean);

  public abstract int DelelteQnaBoard(QnaBoardBean paramQnaBoardBean);

  public abstract void updateReadCount(QnaBoardBean paramQnaBoardBean);

  public abstract AnonyBoardBean getQnaBoardContent(QnaBoardBean paramQnaBoardBean);

  public abstract List<AnonyBoardBean> SearchQnaBoard(String paramString);

  public abstract int getCountQnaBoard();
}