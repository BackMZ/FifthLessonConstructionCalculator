package com.msaggik.fifthlessonconstructioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    // поля
    private TextView output; // вывод результата
    private Button buttonBack, buttonNew; // кнопки возврата назад

    private int count = 0; // количество рулонов обоев для оклейки
    private int costAll = 0; // стоимость комплекта обоев

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        // привязка полей к разметке
        output = findViewById(R.id.output);
        buttonBack = findViewById(R.id.buttonBack);
        buttonNew = findViewById(R.id.buttonNew);

        // извлечение данных из намерения
        Bundle bundle = getIntent().getExtras(); // контейнер с извлечёнными данными в виде ключ-значение

        if (bundle != null) {
            String activityName = bundle.getString("activityName");

            if (activityName.equals("wallpaper")) {
                int squareInt = bundle.getInt("keySquare"); // извлечение параметра площади оклеиваемой поверхности
                Wallpaper wallpaper = (Wallpaper) bundle.getSerializable(Wallpaper.class.getSimpleName()); // извлечение объекта рулона обоев

                // расчёт рулонов обоев (площадь поверхности (м*м) / (длину (м) * ширину (см) / 100))
                count = squareInt / ((wallpaper.getHeightWallpaper() * wallpaper.getWidthWallpaper()) / 100);
                if (squareInt % ((wallpaper.getHeightWallpaper() * wallpaper.getWidthWallpaper()) / 100) > 0) { // если при делении образуется остаток, то нужен ещё один рулон
                    count++;
                }
                // расчёт стоимости обоев
                costAll = count * wallpaper.getCostWallpaper();

                // вывод на экран результатов расчёта
                output.setText("Для строительства нужно " + count + " рулонов обоев\nИх стоимость " + costAll + " монет");
            }

            if (activityName.equals("drywall")) {
                int squareInt = bundle.getInt("keySquare");
                int[] whc = bundle.getIntArray("whc");

                count = (int) Math.ceil((double) squareInt / ((double) whc[0] * (double) whc[1]));

                costAll = count * whc[2];

                output.setText("Для строительства нужно " + count + " листов\nИх стоимость " + costAll + " монет");
            }

            if (activityName.equals("cable")) {
                int endLength = bundle.getInt("endLength");
                int[] lc = bundle.getIntArray("lc");

                count = (int) Math.ceil((double) endLength / (double) lc[0]);

                costAll = count * lc[1];

                output.setText("Для строительства нужно " + count + " кабелей\nИх стоимость " + costAll + " монет");
            }

            if (activityName.equals("paint")) {
                int square = bundle.getInt("square");
                int[] cnc = bundle.getIntArray("cnc");

                int paint = (int) Math.ceil(square * cnc[0] / 1000);

                count = (int) Math.ceil(paint / cnc[1]);

                costAll = count * cnc[2];

                output.setText("Для строительства нужно " + count + " упаковок краски\nИх стоимость " + costAll + " монет");
            }

            if (activityName.equals("radiators")) {
                int square = bundle.getInt("square");
                int[] pc = bundle.getIntArray("pc");

                count = (int) Math.ceil((square) * 100 / pc[0]);

                costAll = count * pc[1];

                output.setText("Для строительства нужно " + count + " секций радиатора\nИх стоимость " + costAll + " монет");
            }
        }

        // обработка нажатия кнопок
        buttonBack.setOnClickListener(listener);
        buttonNew.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = null; // объявление намерения

            // инициализация намерения
            switch (view.getId()) {
                case R.id.buttonBack:
                    intent = new Intent(getApplicationContext(), WallpaperActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // удаление всех активностей кроме той на которую происходит переход
                    break;
                case R.id.buttonNew:
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // перемещение нужной активности на вершину стека
                    break;
            }
            startActivity(intent); // запуск намерения
        }
    };
}