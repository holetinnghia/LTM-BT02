package ute.ltm.ltm_bt02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout bg;
    ImageView img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView myText = findViewById(R.id.text_id);
        myText.setText("Text View day ne!");

        EditText myEdit = findViewById(R.id.edit_id);
        myEdit.setText("Edit View day ne!");

        AutoCompleteTextView myAuto = findViewById(R.id.auto_id);
        String[] defaultText = new String[]{
                "Đây là dòng chữ được hoàn thành tự động"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                defaultText
        );

        myAuto.setAdapter(adapter);
        myAuto.setText("Đây là AutoComplete");

        TextView txtSoN = findViewById(R.id.textViewSo);
        Button btnRnd = findViewById(R.id.buttonRnd);

        btnRnd.setOnClickListener(view -> {
            Random random = new Random();
            int number = random.nextInt(10);
            txtSoN.setText(String.valueOf(number));
        });

        bg = findViewById(R.id.constraintLayout1);
        bg.setBackgroundColor(Color.BLUE);
        bg.setBackgroundResource(R.drawable.bg2);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg1);
        arrayList.add(R.drawable.bg2);
        arrayList.add(R.drawable.bg3);
        arrayList.add(R.drawable.bg4);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) { //isChecked = true
                Toast.makeText(MainActivity.this, "Wifi đang bật", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Wifi đang tắt", Toast.LENGTH_LONG).show();
            }
        });

        CheckBox ck1 = findViewById(R.id.checkBox1);
        ck1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                bg.setBackgroundResource(R.drawable.bg3);
            } else {

                bg.setBackgroundResource(R.drawable.bg4);
            }
        });

        //RadioGroup
        RadioGroup radioGroup = findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButton1) {
                bg.setBackgroundResource(R.drawable.bg3);
            } else if (checkedId == R.id.radioButton2) {
                bg.setBackgroundResource(R.drawable.bg4);
            }
        });

        img2 = findViewById(R.id.progressBar2);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = progressBar.getProgress();
                if (current>= progressBar.getMax()){
                    current=0;
                }
                progressBar.setProgress(current + 10);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
