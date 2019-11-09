package com.id.alnsmth.customselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerDataAdapter.itemCallback {

    private RecyclerView recyclerView;
    private ArrayList<DataModel> mList;
    private DataModel mDataModel;
    private RecyclerDataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        initData();


        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerDataAdapter(this, mList, this);
        recyclerView.setAdapter(mAdapter);

    }

    private void initData(){
        mList = new ArrayList<>();
        mDataModel = new DataModel();
        mDataModel.setChecked(true);
        mDataModel.setFraction(12);
        mDataModel.setUnit("CTN");
        mDataModel.setNormalPrice(20000D);
        mDataModel.setPromoPrice(18000D);
        mDataModel.setPromo(true);
        mList.add(mDataModel);

        mDataModel = new DataModel();
        mDataModel.setChecked(false);
        mDataModel.setFraction(6);
        mDataModel.setUnit("PCK");
        mDataModel.setNormalPrice(11000D);
        mDataModel.setPromoPrice(0D);
        mDataModel.setPromo(false);
        mList.add(mDataModel);

        mDataModel = new DataModel();
        mDataModel.setChecked(false);
        mDataModel.setFraction(1);
        mDataModel.setUnit("PCS");
        mDataModel.setNormalPrice(2000D);
        mDataModel.setPromoPrice(0D);
        mDataModel.setPromo(false);
        mList.add(mDataModel);

    }

    @Override
    public void itemCallback(int position) {
        DataModel p = mList.get(position);
        p.setChecked(true);
        for (int x = 0; x < mList.size(); x++) {
            DataModel ship = mList.get(x);
            if (x != position) {
                ship.setChecked(false);
            }
        }

        mAdapter.notifyDataSetChanged();
        recyclerView.refreshDrawableState();

        Toast.makeText(this, p.getUnit() + " is selected", Toast.LENGTH_SHORT).show();
    }
}
