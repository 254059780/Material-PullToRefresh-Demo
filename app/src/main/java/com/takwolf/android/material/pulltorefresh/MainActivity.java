package com.takwolf.android.material.pulltorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {

    @InjectView(R.id.refresh_layout)
    protected SwipeRefreshLayout refreshLayout;

    @InjectView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private List<Entity> entityList;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        refreshLayout.setColorSchemeResources(R.color.red_light, R.color.green_light, R.color.blue_light, R.color.orange_light);
        refreshLayout.setOnRefreshListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        entityList = EntityDao.getEntityList();
        recyclerView.setAdapter(new MainAdapter(this, entityList));
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                entityList.clear();
                entityList.addAll(EntityDao.getEntityList());
                recyclerView.getAdapter().notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }

        }, 3000);
    }

}
