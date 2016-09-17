package com.lqcode.lucytv.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.liqiong.lucy.BaseActivity;
import com.liqiong.lucy.module.impl.LucyController;
import com.lqcode.lucytv.R;
import com.lqcode.lucytv.network.MoviePlayerRequest;

/**
 * Created by Administrator on 2016/9/11.
 */
public class DetailsMovieActivity extends BaseActivity {
    private FloatingActionButton fab;
    private String playerUrl=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PlayerActivity.class);
                intent.putExtra("path", playerUrl);
                startActivity(intent);
            }
        });
        getPlayerUrlByNet();
    }

    private void getPlayerUrlByNet() {
        String id = getIntent().getStringExtra("id");
        new MoviePlayerRequest(id) {
            @Override
            public void _onSuccess(String result) {
                fab.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark)));
                playerUrl=result;
                LucyController.uiHelp.toast(playerUrl);
            }

            @Override
            public void _onFail(String result) {

            }
        };
    }
}