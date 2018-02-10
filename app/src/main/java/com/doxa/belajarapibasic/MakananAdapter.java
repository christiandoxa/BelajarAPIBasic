package com.doxa.belajarapibasic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by doxa on 10/02/18.
 */

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.Holder> {
    private List<MakananModel> mListData;
    private Context mContext;

    public MakananAdapter(List<MakananModel> mListData, Context mContext) {
        this.mListData = mListData;
        this.mContext = mContext;
    }

    @Override
    public MakananAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.adapter_item_data, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MakananAdapter.Holder holder, int position) {
        MakananModel model = mListData.get(position);

        //set data makanan
        holder.tvNamaMakanan.setText(model.getNamaMakanan());
        holder.tvHarga.setText(model.getHarga());
        holder.tvStok.setText(model.getStok());
        holder.tvSisa.setText(model.getSisa());
        holder.tvOwner.setText(model.getOwner());
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        public TextView tvNamaMakanan;
        public TextView tvHarga;
        public TextView tvStok;
        public TextView tvSisa;
        public TextView tvOwner;

        public Holder(View itemView) {
            super(itemView);

            tvNamaMakanan = (TextView) itemView.findViewById(R.id.textview_nama_makanan);
            tvHarga = (TextView) itemView.findViewById(R.id.textview_harga);
            tvSisa = (TextView) itemView.findViewById(R.id.textview_sisa_barang);
            tvStok = (TextView) itemView.findViewById(R.id.textview_stok_barang);
            tvOwner = (TextView) itemView.findViewById(R.id.textview_owner);
        }
    }
}
