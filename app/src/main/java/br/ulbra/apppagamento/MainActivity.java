package br.ulbra.apppagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
    RadioButton rbMasc, rbFem;


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
        rbMasc = findViewById(R.id.rbMasculino);
        rbFem = findViewById(R.id.rbFeminino);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double salarioB;
                int nFihos;
                String nome;
                String sexo;

                nome = edtNome.getText().toString();
                salarioB = Double.parseDouble(edtSalBrut.getText().toString());
                nFihos = Integer.parseInt(edtNumFilho.getText().toString());
                txtNome.setText(checarGenero());
                txtInss.setText(String.valueOf(calcularInss(salarioB)));
                txtIr.setText(String.valueOf(calcularIr(salarioB)));
                txtSalLiqui.setText(String.valueOf(calcularSalario(salarioB, nFihos)));
            }
        });

    }

    public double calcularInss(double salarioB) {
        double inss = 0.0;

        if (salarioB < 1212.00) {
            inss = (salarioB * 0.075);

        } else if (salarioB >= 1212.01 && salarioB <= 2427.35) {
            inss = (salarioB * 0.09);

        } else if (salarioB >= 2457.36 && salarioB <= 341.03) {
            inss = (salarioB * 0.12);

        } else {
            inss = (salarioB * 0.14);
        }
        return inss;
    }

    public double calcularIr(double salarioB) {
        double ir;

        if (salarioB < 1903.98) {
            ir = 0;

        } else if (salarioB >= 1903.99 && salarioB <= 2826.65) {
            ir = (salarioB * 0.075);

        } else if (salarioB >= 2826.66 && salarioB <= 3751.05) {
            ir = (salarioB * 0.15);

        } else {
            ir = (salarioB * 0.225);
        }
        return ir;
    }

    public double calcularSF(int nfilhos, double salarioB) {
        double sf = 0;

        if (salarioB <= 1212.00) {
            sf = (nfilhos * 56.47);
        }
        return sf;
    }

    public String checarGenero() {
        String sexo = null;
        if (rbMasc.isChecked()) {
            sexo = "Sr. " + edtNome.getText().toString();

        } else {
            sexo = "Sra. " + edtNome.getText().toString();
        }
        return sexo;
    }

    public double calcularSalario(double salarioB, int nFilhos) {
        double salarioL = (salarioB - calcularInss(salarioB) - calcularIr(salarioB) + calcularSF(nFilhos,salarioB));
        return salarioL;
    }

}