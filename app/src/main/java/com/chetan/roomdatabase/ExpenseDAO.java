package com.chetan.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import static com.chetan.roomdatabase.DatabasHelper.EXPENSE_TABLE;
import java.util.List;

@Dao
public interface ExpenseDAO {

    @Query("select * from "+EXPENSE_TABLE )
    List<Expense> getAllExpenses();

    @Insert
    void addExpense(Expense expense);

    @Delete
    void  deleteExpense(Expense expense);

    @Update
    void updteExpense(Expense expense);
}
