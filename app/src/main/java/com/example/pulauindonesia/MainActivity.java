package com.example.pulauindonesia;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPulau;
    private ArrayList<Pulau> list = new ArrayList<>();
    private ListPluAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPulau = findViewById(R.id.rv_bsw);
        rvPulau.setHasFixedSize(true);

        list.addAll(PulauData.getListData());
        showRecyclerList();
    }
    private void showRecyclerList() {
        rvPulau.setLayoutManager(new LinearLayoutManager(this));
        ListPluAdapter listPulauAdapter = new ListPluAdapter(list);
        rvPulau.setAdapter(listPulauAdapter);

        listPulauAdapter.setOnItemClickCallback
                (new ListPluAdapter.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(Pulau data) {
                        showSelectedPulau(data);
                    }
                });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                showAbout();
                break;

        }
    }
    private void showAbout() {
        Intent aboutIntent = new Intent(MainActivity.this, About.class);
        startActivity(aboutIntent);
    }
    private void showSelectedPulau(Pulau bsw) {
        Intent moveWithDataIntent = new Intent(MainActivity.this,
                DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PULAU, bsw.getNama());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PHOTO, bsw.getPhoto());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_LUAS, bsw.getLuas());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_TERLETAK, bsw.getTerletak());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_KETERANGAN, bsw.getKeterangan());
        startActivity(moveWithDataIntent);
        //Toast.makeText(this, "Kamu memilih " + bsw.getNama(), Toast.LENGTH_SHORT).show();
    }
}