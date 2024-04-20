package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaintActivity extends AppCompatActivity {

    private EditText square;
    private EditText consumption, numLiters, costPaint;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);

        square = findViewById(R.id.square);
        consumption = findViewById(R.id.power);
        numLiters = findViewById(R.id.numLiters);
        costPaint = findViewById(R.id.cost);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int squareInt = Integer.parseInt(square.getText().toString());
            int consumptionInt = Integer.parseInt(consumption.getText().toString());
            int numLitersInt = Integer.parseInt(numLiters.getText().toString());
            int cost = Integer.parseInt(costPaint.getText().toString());

            int[] cnc = new int[3];
            cnc[0] = consumptionInt;
            cnc[1] = numLitersInt;
            cnc[2] = cost;

            Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);
            intent.putExtra("activityName", "paint");
            intent.putExtra("square", squareInt);
            intent.putExtra("cnc", cnc);
            startActivity(intent);
        }
    };
}