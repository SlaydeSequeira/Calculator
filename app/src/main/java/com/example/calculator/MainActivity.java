package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView answerTextView;
    private String currentNumber = "";
    private String operation = "";
    private double firstNumber = 0;
    private double secondNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerTextView = findViewById(R.id.Answer);

        Button button0 = findViewById(R.id.btn_0);
        Button button1 = findViewById(R.id.btn_1);
        Button button2 = findViewById(R.id.btn_2);
        Button button3 = findViewById(R.id.btn_3);
        Button button4 = findViewById(R.id.btn_4);
        Button button5 = findViewById(R.id.btn_5);
        Button button6 = findViewById(R.id.btn_6);
        Button button7 = findViewById(R.id.btn_7);
        Button button8 = findViewById(R.id.btn_8);
        Button button9 = findViewById(R.id.btn_9);
        Button buttonDot = findViewById(R.id.btn_dot);
        Button buttonClear = findViewById(R.id.btn_clear);
        Button buttonDelete = findViewById(R.id.btn_del);
        Button buttonDivide = findViewById(R.id.btn_divide);
        Button buttonMultiply = findViewById(R.id.btn_multiply);
        Button buttonMinus = findViewById(R.id.btn_minus);
        Button buttonAdd = findViewById(R.id.btn_add);
        Button buttonEqual = findViewById(R.id.btn_equal);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAdd(view);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMinus(view);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMultiply(view);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickDivide(view);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEqual(view);
            }
        });


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNumber("9");
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!currentNumber.contains(".")) {
                    updateNumber(".");
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });


    }
    private void clear() {
        currentNumber = "";
        operation = "";
        firstNumber = 0;
        secondNumber = 0;
        answerTextView.setText("0");
    }

    private void delete() {
        if (currentNumber.length() > 0) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            answerTextView.setText(currentNumber);
        }
    }


    private void updateNumber(String s) {
        if (currentNumber.length() < 15) { // max length of the number is 15 digits
            currentNumber += s;
            if (!operation.equals("")) { // check if there is an operation stored
                answerTextView.setText(firstNumber + " " + operation + " " + currentNumber);
            } else { // if there is no operation stored, display only the current number
                answerTextView.setText(currentNumber);
            }
        }
    }

    public void onClickAdd(View view) {
        firstNumber = Double.parseDouble(currentNumber);
        operation = "+";
        currentNumber = "";
        answerTextView.setText(firstNumber + " " + operation);
    }


    public void onClickMinus(View view) {
        firstNumber = Double.parseDouble(currentNumber);
        operation = "-";
        currentNumber = "";
        answerTextView.setText(firstNumber + " " + operation);
    }

    public void onClickMultiply(View view) {
        firstNumber = Double.parseDouble(currentNumber);
        operation = "*";
        currentNumber = "";
        answerTextView.setText(firstNumber + " " + operation);

    }

    public void onClickDivide(View view) {
        firstNumber = Double.parseDouble(currentNumber);
        operation = "/";
        currentNumber = "";
        answerTextView.setText(firstNumber + " " + operation);
    }

    public void onClickEqual(View view) {
        secondNumber = Double.parseDouble(currentNumber);

        double result = 0;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    // handle division by zero error
                    answerTextView.setText("Error");
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
        }

        answerTextView.setText(String.valueOf(result));
        currentNumber = String.valueOf(result);
        operation = "";
    }

}