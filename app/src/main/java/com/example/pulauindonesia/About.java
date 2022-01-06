package com.example.pulauindonesia;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView imageView = findViewById(R.id.imageView);
        String url = "https://i.pinimg.com/736x/ee/51/b0/ee51b02f04572844364abdfff6827196.jpg";

        Glide.with(About.this)
                .load(url)
                .apply(new RequestOptions().override(200,200))
                .into(imageView);
    }
}