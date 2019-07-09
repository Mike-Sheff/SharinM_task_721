package ru.netologia.sharinm_task_721;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutplace;
    private LinearLayout layoutLatitude;
    private LinearLayout layoutLongitude;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textSearch = findViewById(R.id.editText);
        final EditText textLatitude = findViewById(R.id.Latitude);
        final EditText textLongitude = findViewById(R.id.Longitude);
        layoutplace = findViewById(R.id.linearPlace);
        layoutLatitude = findViewById(R.id.linearCoordinatesLatitude);
        layoutLongitude = findViewById(R.id.linearCoordinatesLongitude);
        Button btnSearch = findViewById(R.id.buttonSearch);
        checkBox = findViewById(R.id.checkbox);

        btnSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String search;

                if (checkBox.isChecked()) {
                    if (textSearch.getText().toString().isEmpty()){
                     search = getString(R.string.textSearchPlace, textSearch.getHint().toString());
                    } else {
                        search =  getString(R.string.textSearchPlace, textSearch.getText().toString());
                    }
                } else {
                    if (textSearch.getText().toString().isEmpty()){
                        search = getString(R.string.textSearchCoordinates, textLatitude.getHint().toString(), textLongitude.getHint().toString());
                    } else {
                        search = getString(R.string.textSearchCoordinates, textLatitude.getText().toString(), textLongitude.getText().toString());
                    }
                }

                Uri uri = Uri.parse(search);

                intent.setData(uri);

                startActivity(intent);
            }
        });

        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (checkBox.isChecked()) {
                    layoutplace.setVisibility(View.VISIBLE);
                    layoutLatitude.setVisibility(View.GONE);
                    layoutLongitude.setVisibility(View.GONE);
                } else {
                    layoutplace.setVisibility(View.GONE);
                    layoutLatitude.setVisibility(View.VISIBLE);
                    layoutLongitude.setVisibility(View.VISIBLE);
                }
            }
        };

        checkBox.setOnCheckedChangeListener(checkedChangeListener);
    }
}