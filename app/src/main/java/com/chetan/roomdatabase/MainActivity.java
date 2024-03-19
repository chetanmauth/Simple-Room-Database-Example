package com.chetan.roomdatabase;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.chetan.roomdatabase.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabasHelper databasHelper=DatabasHelper.getDB(getApplicationContext());

        binding.btnAddItem.setOnClickListener(view -> {

            String title=binding.etTitle.getText().toString();
            String amount=binding.etAmount.getText().toString();
            new Thread(() -> databasHelper.expenseDAO().addExpense(new Expense(title,amount))).start();
        });
    }
}