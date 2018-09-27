package com.example.laitianbing.rvadater_master;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.laitianbing.rvadater_master.adapter.RVSimpleAdapter;
import com.example.laitianbing.rvadater_master.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SimpleActivity extends AppCompatActivity {

    private RecyclerView rvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rvContent = findViewById(R.id.rv_content);
        RVSimpleAdapter adapter = new RVSimpleAdapter<String>(this, getDatas(), R.layout.item_simple) {
            @Override
            public void convert(ViewHolder holder, String item) {
                holder.setText(R.id.tv_name, item);
            }
        };

        //垂直
        adapter.attachLinearRv(rvContent, RVSimpleAdapter.VERTICAL);

        //水平
//        adapter.attachLinearRv(rvContent, RVSimpleAdapter.HORIZONTAL);

        //自定义
//        rvContent.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        rvContent.setItemAnimator(new DefaultItemAnimator());
//        rvContent.setAdapter(adapter);
    }

    private List<String> getDatas() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("item:  " + i);
        }
        return datas;
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, SimpleActivity.class));
    }
}
