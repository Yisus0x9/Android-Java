package com.yisus.first_app;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1,editTextNum2;
    private Button buttonSum;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
        addListeners();

    }
    private void initComponents(){
        editTextNum1=findViewById(R.id.eTNum1);
        editTextNum2=findViewById(R.id.eTNum2);
        textViewResult=findViewById(R.id.tvResult);
        buttonSum=findViewById(R.id.btSum);
    }

    private void addListeners(){
        buttonSum.setOnClickListener(v-> textViewResult.setText(calculateSum()));
    }

    public String calculateSum() {
        try {
            return "Resultado: " + (Integer.parseInt(editTextNum1.getText().toString()) + Integer.parseInt(editTextNum2.getText().toString()));

        }catch (Exception e){
            return "Error al realizar la suma, porfavor digite números solamente";
        }
    }
}

