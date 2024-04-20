package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DrywallActivity extends AppCompatActivity {

    private EditText square;
    private EditText widthDrywall, heightDrywall, costDrywall;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drywall);

        square = findViewById(R.id.square);
        widthDrywall = findViewById(R.id.power);
        heightDrywall = findViewById(R.id.numLiters);
        costDrywall = findViewById(R.id.cost);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int squareInt = Integer.parseInt(square.getText().toString());
            int width = Integer.parseInt(widthDrywall.getText().toString());
            int height = Integer.parseInt(heightDrywall.getText().toString());
            int cost = Integer.parseInt(costDrywall.getText().toString());

            int[] whc = new int[3];
            whc[0] = width;
            whc[1] = height;
            whc[2] = cost;

            Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);
            intent.putExtra("activityName", "drywall");
            intent.putExtra("keySquare", squareInt);
            intent.putExtra("whc", whc);
            startActivity(intent);
        }
    };
}