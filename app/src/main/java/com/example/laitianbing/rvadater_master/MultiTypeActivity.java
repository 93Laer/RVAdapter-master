package com.example.laitianbing.rvadater_master;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.laitianbing.rvadater_master.adapter.RVSimpleAdapter;
import com.example.laitianbing.rvadater_master.adapter.RvBaseAdapter;
import com.example.laitianbing.rvadater_master.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MultiTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView rvContent = findViewById(R.id.rv_content);
        new MultiAdater(this, getDatas()).attachLinearRv(rvContent, RVSimpleAdapter.VERTICAL);
    }

    private List<Integer> getDatas() {
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        return datas;
    }

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MultiTypeActivity.class));
    }

    class MultiAdater extends RvBaseAdapter<Integer> {

        MultiAdater(Context context, List<Integer> datas) {
            super(context, datas);
        }

        @Override
        public int getLayoutId(int position, Integer item) {
            return item % 2 == 0 ? R.layout.item_simple : R.layout.item_red_background;
        }

        @Override
        public void convert(ViewHolder holder, Integer item, int layoutId, int position) {
            switch (layoutId) {
                case R.layout.item_simple:
                    holder.setText(R.id.tv_name, String.format("样式一  item:  %s", item));
                    break;
                case R.layout.item_red_background:
                    holder.setText(R.id.tv_content, String.format("样式二  item:  %s", item));
                    break;
                default:
                    break;
            }
        }

    }
}
