package br.ulbra.apppagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtSalBrut, edtNumFilho;
    Button btnCalcular;
    TextView txtNome;
    TextView txtInss;
    TextView txtIr;
    TextView txtSalLiqui;
    RadioGroup rgSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = findViewById(R.id.edtNome);
        edtSalBrut = findViewById(R.id.edtSalBruto);
        edtNumFilho = findViewById(R.id.edtNumFilhos);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtNome = findViewById(R.id.txtNomeRes);
        txtInss = findViewById(R.id.txtInss);
        txtIr = findViewById(R.id.txtIR);
        txtSalLiqui = findViewById(R.id.txtSalLiq);
        rgSexo = findViewById(R.id.rgSexo);
    }

    public void InssDesc(View view) {
        double Inss = 0.0;
        double salarioB = Double.parseDouble(edtSalBrut.getText().toString());
        if (salarioB < 1212.00) {
            Inss = salarioB - (salarioB * 0.075);
        }else if (salarioB >= 1212.01 && salarioB <=2427.35){
            Inss = salarioB - (salarioB * 0.09);
        }else if(salarioB >= 2457.36 && salarioB <=341.03){
            Inss = salarioB - (salarioB * 0.12);
        }else{
            Inss = salarioB - (salarioB * 0.14);
        }
        
    }
}