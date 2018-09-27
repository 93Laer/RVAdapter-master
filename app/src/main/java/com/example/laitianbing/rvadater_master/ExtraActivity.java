package com.example.laitianbing.rvadater_master;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.laitianbing.rvadater_master.adapter.RVSimpleAdapter;
import com.example.laitianbing.rvadater_master.adapter.RvBaseAdapter;
import com.example.laitianbing.rvadater_master.adapter.ViewHolder;
import com.example.laitianbing.rvadater_master.bean.A;
import com.example.laitianbing.rvadater_master.bean.B;

import java.util.ArrayList;
import java.util.List;

public class ExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView rvContent = findViewById(R.id.rv_content);
        ExtraAdater adater = new ExtraAdater(this, getDatas());
        adater.attachLinearRv(rvContent, RVSimpleAdapter.VERTICAL);
        rvContent.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    List getDatas() {
        List datas = new ArrayList();
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                datas.add(new A());
            } else {
                datas.add(new B());
            }
        }
        return datas;
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, ExtraActivity.class));
    }

    class ExtraAdater extends RvBaseAdapter<Object> {

        ExtraAdater(Context context, List<Object> datas) {
            super(context, datas);
        }

        @Override
        public int getLayoutId(int position, Object item) {
            if (item instanceof A) {
                return R.layout.item_simple;
            } else {
                return R.layout.item_red_background;
            }
        }

        @Override
        public void convert(ViewHolder holder, Object item, int layoutId, int position) {
            if (item instanceof A) {
                holder.setText(R.id.tv_name, String.format("对象: %s", ((A) item).name));
            } else {
                holder.setText(R.id.tv_content, String.format("对象: %s", ((B) item).name));

            }
        }

    }
}
