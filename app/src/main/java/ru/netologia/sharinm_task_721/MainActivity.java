package ru.netologia.sharinm_task_721;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textSearch =findViewById(R.id.editText);
        final EditText textLatitude =findViewById(R.id.Latitude);
        final EditText textLongitude =findViewById(R.id.Longitude);
        Button btnSearch = findViewById(R.id.buttonSearch);
        final CheckBox checkBox = findViewById(R.id.checkbox);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String search;

                if (checkBox.isChecked()) {
                    search = "geo:?q=" + textSearch.getText().toString();
                } else {

                    search = "geo:" + textLatitude.getText().toString() + ", " + textLongitude.getText().toString();
                }

                Uri uri = Uri.parse(search);

                intent.setData(uri);

                startActivity(intent);
            }
        });

    }
}
