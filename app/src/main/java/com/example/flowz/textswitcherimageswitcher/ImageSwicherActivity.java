package com.example.flowz.textswitcherimageswitcher;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.ViewSwitcher.ViewFactory;

public class ImageSwicherActivity extends AppCompatActivity  implements View.OnClickListener {
    ImageSwitcher imageSwitcher;
    Button btnnext, btnprevious;
    int [] pics = {R.drawable.flower, R.drawable.ime, R.drawable.ic_launcher_background, R.drawable.imev, R.drawable.ic_launcher_foreground
    };
    int currentInex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_swicher);

        btnprevious = (Button) findViewById(R.id.previous);
        btnnext = (Button) findViewById(R.id.next);
        btnprevious.setOnClickListener(this);
        btnprevious.setOnClickListener(this);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView picture = new ImageView(getApplicationContext());
                picture.setScaleType(ImageView.ScaleType.FIT_CENTER);
                picture.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return picture;
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.next:
                if (currentInex < pics.length - 1) {
                    currentInex = currentInex + 1;
                    imageSwitcher.setImageResource(pics[currentInex]);
                }
                break;
            case R.id.previous:
                if (currentInex > 0) {
                    currentInex = currentInex - 1;
                    imageSwitcher.setImageResource(pics[currentInex]);
                }
                break;
        }
    }
}