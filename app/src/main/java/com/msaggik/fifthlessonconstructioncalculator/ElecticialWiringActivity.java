package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ElecticialWiringActivity extends AppCompatActivity {

    private EditText endLengthCable;
    private EditText lengthOneCable, costCable;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electicial_wiring);

        endLengthCable = findViewById(R.id.square);
        lengthOneCable = findViewById(R.id.power);
        costCable = findViewById(R.id.numLiters);
        button = findViewById(R.id.button);

        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int endLength = Integer.parseInt(endLengthCable.getText().toString());
            int[] lc = new int[2];

            lc[0] = Integer.parseInt(lengthOneCable.getText().toString());
            lc[1] = Integer.parseInt(costCable.getText().toString());

            Intent intent = new Intent(getApplicationContext(), CalculationActivity.class);
            intent.putExtra("activityName", "cable");
            intent.putExtra("endLength", endLength);
            intent.putExtra("lc", lc);

            startActivity(intent);
        }
    };
}