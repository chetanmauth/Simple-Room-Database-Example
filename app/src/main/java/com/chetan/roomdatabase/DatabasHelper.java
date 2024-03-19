package com.chetan.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class, exportSchema = false, version = 1)
public abstract class DatabasHelper extends RoomDatabase {

    public static final String EXPENSE_TABLE = "expense";
    private static final String DB_NAME = "expenseDB";

    private static DatabasHelper instance;

    public static synchronized DatabasHelper getDB(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, DatabasHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract ExpenseDAO expenseDAO();

}
