package com.example.pulauindonesia;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PULAU = "extra_pulau";
    public static final String EXTRA_LUAS = "luas";
    public static final String EXTRA_PHOTO = "photo";
    public static final String EXTRA_TERLETAK = "extra_terletak";
    public static final String EXTRA_KETERANGAN = "extra_keterangan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_item_photo);
        String url = getIntent().getStringExtra(EXTRA_PHOTO);

        Glide.with(DetailActivity.this)
                .load(url)
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);

        TextView txtLuas = findViewById(R.id.tv_item_luas);
        String luas = getIntent().getStringExtra(EXTRA_LUAS);
        txtLuas.setText(getString(R.string.Nim)+luas);

        TextView txtNama = findViewById(R.id.tv_item_nama);
        String nama = getIntent().getStringExtra(EXTRA_PULAU);
        txtNama.setText(nama);

        TextView txtTerletak = findViewById(R.id.terletak);
        String terletak = getIntent().getStringExtra(EXTRA_TERLETAK);
        txtTerletak.setText(getString(R.string.Semester)+terletak);

        TextView txtKeterangan = findViewById(R.id.ket);
        String keterangan = getIntent().getStringExtra(EXTRA_KETERANGAN);
        txtKeterangan.setText(getString(R.string.TTL)+keterangan);

    }
}