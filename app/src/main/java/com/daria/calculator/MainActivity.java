package com.daria.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getSimpleName(); // == "MainActivity"

    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    private TextView operandTV;
    private TextView operationTV;
    private TextView operatorTV;

    private EditText resultET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_3);

        // Инициализация
        operandTV = findViewById(R.id.tvOperand);
        operationTV = findViewById(R.id.tvOperation);
        operatorTV = findViewById(R.id.tvOperator);

        resultET = findViewById(R.id.etResult);

        Button plusBtn = findViewById(R.id.btnPlus);
        Button minusBtn = findViewById(R.id.btnMinus);
        Button multiBtn = findViewById(R.id.btnMulti);
        Button divBtn = findViewById(R.id.btnDiv);

        plusBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        multiBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);

        Log.d(TAG, "onCreate");
    }

    @Override
    public void onClick(View v) {
        // 1. 'Запоминание' операнда
        String resultText = resultET.getText().toString();
        operandTV.setText(resultText);

        // 2. 'Запоминание' операции
        Button btn = (Button) v;
        String btnText = btn.getText().toString();
        operationTV.setText(btnText);

        // 3. Отчистка поля ввода
        clearResult();

        Log.d(TAG, "onClick");
    }

    private void clearResult() {
        //Отчистка поля ввода
        resultET.setText("");
    }

    public void onClearClick(View v) {
        //Отчистка поля ввода
        clearResult();

        //При необходимости отчистка остальных данных
        Button btn = (Button) v;
        String btnText = btn.getText().toString();

        if (btnText.equals("C")) {
            operatorTV.setText("");
            operationTV.setText("");
            operandTV.setText("");
        }

        Log.d(TAG, "onClearClick");
    }

    public void onNumberClick(View v) {
        Button btn = (Button) v;
        String btnText = btn.getText().toString();
        resultET.append(btnText);

        Log.d(TAG, "onNumberClick");
    }

    public void onEqualsClick(View v) {
        // 1. 'Запоминание' оператора
        String resultText = resultET.getText().toString();
        operatorTV.setText(resultText);

        // 2. Отображение результата
        double result = calculate();
        String resText = String.valueOf(result);
        resultET.setText(resText);

        Log.d(TAG, "onEqualsClick");
    }

    private double calculate() {
        // 1.  Получение первого числа и преобразование String -> double
        String operandText = operandTV.getText().toString();
        double firstNumber = Double.parseDouble(operandText);

        // 2.  Получение второго числа и преобразование String -> double
        String operatorText = operatorTV.getText().toString();
        double secondNumber = Double.parseDouble(operatorText);

        // 3.  Вычисление результата в зависимости от оператора
        String operation = operationTV.getText().toString();
        switch (operation) {
            case ADDITION:
                return firstNumber + secondNumber;
            case SUBTRACTION:
                return firstNumber - secondNumber;
            case MULTIPLICATION:
                return firstNumber * secondNumber;
            case DIVISION:
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
