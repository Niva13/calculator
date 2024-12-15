package com.example.calculator1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //public TextView result, result2; //DO NOT TOUCH
    public TextView upper, down;
    public String num = "";
    public int multinum = 0, flag = 0, chAFlag=0, numInt=0;
    public float num1 = 0, num2 = 0;
    public float resultNumfloat = 0;
    public char chAction = ' ';


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

        this.upper = findViewById(R.id.textViewRes);
        this.upper.setText("");

        this.down = findViewById(R.id.textView);
        this.down.setText(" ");

    }

    public void funcButtonAction(View view) {

        if(this.chAFlag==0) {
            Button button = (Button) view;
            this.chAFlag=1;
            this.chAction = button.getText().toString().charAt(0);

            try {
                if (this.flag == 0) {
                    this.num1 = Float.valueOf(this.num);
                    this.flag = 1;
                } else {
                    this.num2 = Float.valueOf(this.num);
                    this.flag = 0;
                }
                //this.upper.setText(this.upper.getText() + button.getText().toString());
            } catch (NumberFormatException e) {
                this.upper.setText("Invalid integer input");
            }

            if (multinum == 1) {
                upper.setText(down.getText() + button.getText().toString());
            } else {
                this.upper.setText(this.upper.getText() + button.getText().toString());
            }

            this.multinum = 1;
            num = "";
        }
        else
        {

        }

    }

    public void funcButtonEqual(View view) {
        Button button = (Button) view;

        this.num2 = Float.valueOf(this.num);

        if (this.chAction == '/') {
            if (this.num2 != 0) {
                if (!(down.getText().toString().equals("ERROR")))
                {
                    this.resultNumfloat = this.num1 / this.num2;
                    this.num1 = this.resultNumfloat;
                    this.down.setText(Float.toString(this.resultNumfloat));

                    if (this.resultNumfloat % 1 == 0) {
                        this.numInt = (int) this.resultNumfloat;
                        this.down.setText(Integer.toString(this.numInt));
                    } else {
                        this.numInt = (int) this.resultNumfloat;
                        this.down.setText(Float.toString(this.resultNumfloat));
                    }
                } else {
                    this.down.setText("ERROR");
                }
            } else
            {
                this.down.setText("ERROR");
            }
        }

        else if (!(down.getText().toString().equals("ERROR")))
        {
            if (this.chAction == '*') {
                this.resultNumfloat = this.num1 * this.num2;
            } else if (this.chAction == '+') {
                this.resultNumfloat = this.num1 + this.num2;
            } else if (this.chAction == '-') {
                this.resultNumfloat = this.num1 - this.num2;
            }
            this.num1 = this.resultNumfloat;

            if(this.resultNumfloat % 1==0)
            {
                this.numInt = (int)this.resultNumfloat;
                this.down.setText(Integer.toString(this.numInt));
            }
            else
            {
                this.down.setText(Float.toString(this.resultNumfloat));
            }

        }
        else
        {
            this.down.setText("ERROR");
        }
        this.flag = 1;
        this.chAction=' ';
        this.chAFlag = 0;
    }


    public void funcButtonNum(View view) {
        Button button = (Button) view;

        if (this.flag == 0 ) {
            this.num = this.num + button.getText().toString();
            this.upper.setText(this.upper.getText() + button.getText().toString());
        } else {
            this.num = "";
            this.num = this.num + button.getText().toString();
            this.upper.setText(this.upper.getText() + button.getText().toString());
            this.flag = 0;
        }

    }

    public void funcButtonAC(View view) {
        this.num1 = 0;
        this.num2 = 0;
        this.flag = 0;
        this.resultNumfloat = 0;
        this.upper.setText("");
        this.down.setText("");
        this.num = "";
        this.chAction = ' ';
        this.multinum = 0;
        this.chAFlag =0;
    }

}