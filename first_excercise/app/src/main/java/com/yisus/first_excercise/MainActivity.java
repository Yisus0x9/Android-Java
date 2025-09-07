package com.yisus.first_excercise;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNum1,editTextNum2,editTextNum3;
    private Button buttonEvaluate;
    private TextView textViewStatus;

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
        editTextNum1=findViewById(R.id.editText1);
        editTextNum2=findViewById(R.id.editText2);
        editTextNum3=findViewById(R.id.editText3);
        textViewStatus=findViewById(R.id.textViewStatus);
        buttonEvaluate=findViewById(R.id.buttonEvaluate);
    }

    private void addListeners(){
        buttonEvaluate.setOnClickListener(e->{
            String status="Status : ";
            if(calculateMedia()>5){
                status+="APROBADO";
            }else{
                status+="REPROBADO";
            }
            textViewStatus.setText(status);
        });
    }

    public int calculateMedia(){
        try {
            int num1= Integer.parseInt(editTextNum1.getText().toString());
            int num2= Integer.parseInt(editTextNum2.getText().toString());
            int num3= Integer.parseInt(editTextNum3.getText().toString());
            return (num1+num2+num3)/3;
        }catch (Exception e){
            Toast.makeText(this,"Error al obtene status",Toast.LENGTH_LONG).show();
            return 0;
        }
    }
}