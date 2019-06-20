package com.example.flowz.textswitcherimageswitcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    TextSwitcher flowzTextSwitcher;
    Button btnnext, btnprevious;
    String[] COLEWORLD = {"Ain't no such thing as a life that's better than yours", "Ain't no such thing as a life that's better than yours", "No such thing", "No such thing","For what's love without happiness ?", "Or a hard time without the people you love ?"
    };
    int currentInex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnprevious = (Button) findViewById(R.id.previous);
        btnnext = (Button) findViewById(R.id.next);
        btnprevious.setOnClickListener(this);
        btnprevious.setOnClickListener(this);

        flowzTextSwitcher = (TextSwitcher) findViewById(R.id.textSwitch);

        flowzTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView showedtext = new TextView(getApplicationContext());
                showedtext.setTextSize(20);
                showedtext.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                showedtext.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                return showedtext;
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.next:
                if (currentInex < COLEWORLD.length - 1) {
                    currentInex = currentInex + 1;
                    flowzTextSwitcher.setText(COLEWORLD[currentInex]);
                }
                break;
            case R.id.previous:
                if (currentInex > 0) {
                    currentInex = currentInex - 1;
                    flowzTextSwitcher.setText(COLEWORLD[currentInex]);
                }
                break;
        }
    }

    public void OpenImageSwitcher(View view) {
        Intent openImageSitcher = new Intent(MainActivity.this, ImageSwicherActivity.class );
        startActivity(openImageSitcher);

    }
}