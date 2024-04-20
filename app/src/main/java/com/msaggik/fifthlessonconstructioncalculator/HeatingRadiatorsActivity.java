package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HeatingRadiatorsActivity extends AppCompatActivity {

    private EditText square;
    private EditText power, cost;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heating_radiators);

        square = findViewById(R.id.square);
        power = findViewById(R.id.power);
        cost = findViewById(R.id.cost);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int squareInt = Integer.parseInt(square.getText().toString());
            int powerInt = Integer.parseInt(power.getText().toString());
            int costInt = Integer.parseInt(cost.getText().toString());

            int[] pc = new int[2];
            pc[0] = powerInt;
            pc[1] = costInt;

            Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);
            intent.putExtra("activityName", "radiators");
            intent.putExtra("square", squareInt);
            intent.putExtra("pc", pc);
            startActivity(intent);
        }
    };
}