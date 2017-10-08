package id.ac.budiluhur.bukabuku.features.main;

import android.os.Bundle;

import id.ac.budiluhur.bukabuku.R;
import id.ac.budiluhur.bukabuku.base.mvp.MvpActivity;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView {

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
