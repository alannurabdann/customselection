package com.id.alnsmth.customselection;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.RecyclerViewHolder> {

    private final Activity context;
    private ArrayList<DataModel> mData;
    private itemCallback mAdapterCallback;

    public RecyclerDataAdapter(Activity context, ArrayList<DataModel> data, itemCallback adapterCallback) {
        this.context = context;
        this.mData = data;
        mAdapterCallback = adapterCallback;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int position){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selection, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder h, int pos) {
        DataModel s = mData.get(pos);

        if (s.isPromo){
            h.tvPricePromo.setVisibility(View.VISIBLE);
            h.tvPriceNormal.setBackground(context.getDrawable(R.drawable.strikethrough));
        }else {
            h.tvPricePromo.setVisibility(View.GONE);
            h.tvPriceNormal.setBackground(null);
        }

        h.tvPriceNormal.setText(getPriceFormat(s.getNormalPrice()));
        h.tvPricePromo.setText(getPriceFormat(s.getPromoPrice()));
        h.tvBundling.setText(s.getUnit() + " - " + s.getFraction() + " PCS");

        h.radioButton.setChecked(s.isChecked());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView tvBundling, tvPriceNormal, tvPricePromo;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            tvBundling = itemView.findViewById(R.id.bundling);
            tvPriceNormal = itemView.findViewById(R.id.harga_normal);
            tvPricePromo = itemView.findViewById(R.id.harga_promo);
            radioButton = itemView.findViewById(R.id.radio_button);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAdapterCallback.itemCallback(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });

        }

    }

    public interface itemCallback {
        //onItemClick handler
        void itemCallback(int position);
    }

    private String getPriceFormat(Double price){
        String pattern = "###,###,###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String value = decimalFormat.format(price);
        String priceFormat = "Rp " + value.replace(",",".");

        return priceFormat;
    }
}
