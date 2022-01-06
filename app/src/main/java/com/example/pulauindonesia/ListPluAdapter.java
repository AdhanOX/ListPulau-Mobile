package com.example.pulauindonesia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPluAdapter extends RecyclerView.Adapter<ListPluAdapter.ListViewHolder> {
    private ArrayList<Pulau> listPulau;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListPluAdapter(ArrayList<Pulau> list) {this.listPulau = list;}

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pulau,
                viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Pulau bsw = listPulau.get(position);

        Glide.with(holder.itemView.getContext())
                .load(bsw.getPhoto())
                .apply(new RequestOptions()
                        .override(80,80))
                .into(holder.imgPhoto);

        holder.tvNama.setText(bsw.getNama());
        //holder.tvTerletak.setText(bsw.getSemester());
        holder.tvLuas.setText(bsw.getLuas());
        //holder.tvKeterangan.setText(bsw.getTTL());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listPulau.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPulau.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvNama, tvTerletak, tvLuas, tvKeterangan;
        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvLuas = itemView.findViewById(R.id.tv_item_luas);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Pulau data);
    }
}
