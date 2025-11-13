package ute.ltm.ltm_bt02;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
        String[] defaultText = new String[] {
                "Đây là dòng chữ được hoàn thành tự động"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                defaultText
        );

        myAuto.setAdapter(adapter);
        myAuto.setText("Đây là AutoComplete");

        TextView txtSoN = (TextView) findViewById(R.id.textViewSo);
        Button btnRnd = (Button) findViewById(R.id.buttonRnd);

        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int number = random.nextInt(10);
                txtSoN.setText(number + "");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}