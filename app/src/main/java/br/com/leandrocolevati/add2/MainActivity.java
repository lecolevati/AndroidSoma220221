package br.com.leandrocolevati.add2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private TextView tvOp;
    private TextView tvRes;
    private Button btnOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum1.setGravity(Gravity.CENTER);
        etNum2 = findViewById(R.id.etNum2);
        etNum2.setGravity(Gravity.CENTER);
        tvOp = findViewById(R.id.tvOp);
        tvRes = findViewById(R.id.tvRes);
        tvOp.setText(R.string.opSoma);
        btnOp = findViewById(R.id.btnOp);

        btnOp.setOnClickListener(click -> somar());

    }

    private void somar() {
        String txtNum1 = etNum1.getText().toString();
        String txtNum2 = etNum2.getText().toString();
        tvRes.setText(txtNum1);
        if (txtNum1.equals("") || txtNum2.equals("")) {
            tvRes.setText(R.string.erro_campo_vazio);
        } else {
            BigDecimal num1 = new BigDecimal(etNum1.getText().toString());
            BigDecimal num2 = new BigDecimal(etNum2.getText().toString());
            float res = num1.floatValue() + num2.floatValue();
            BigDecimal resultado = new BigDecimal(res);
            resultado = resultado.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            tvRes.setText(String.valueOf(resultado));
        }

    }
}