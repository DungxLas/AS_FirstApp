package com.pjhfdx.dungx.firstapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText numStart;
    EditText numEnd;
    Button btnRandom;
    TextView resultRd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnRandom.setOnClickListener(v -> {
            String minStr = numStart.getText().toString().trim();
            String maxStr = numEnd.getText().toString().trim();

            if (minStr.isEmpty() || maxStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Vui lòng không để trống!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isNumeric(minStr) || !isNumeric(maxStr)) {
                Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                return;
            }

            int min = Integer.parseInt(minStr);
            int max = Integer.parseInt(maxStr);

            if (max <= min) {
                Toast.makeText(MainActivity.this, "Bạn có chắc không? Số lớn hơn phải lớn hơn số nhỏ hơn chứ! Đừng làm tôi cười 😂", Toast.LENGTH_SHORT).show();
                return;
            }

            Random rd = new Random();

            int num = rd.nextInt(max - min + 1) + min;
            resultRd.setText(String.valueOf(num));
        });
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void anhXa() {
        numStart = (EditText) findViewById(R.id.editTextNumStart);
        numEnd = (EditText) findViewById(R.id.editTextNumEnd);
        btnRandom = (Button) findViewById(R.id.buttonRandom);
        resultRd = (TextView) findViewById(R.id.textViewRandom);
    }
}