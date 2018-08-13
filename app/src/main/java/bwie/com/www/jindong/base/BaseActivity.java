package bwie.com.www.jindong.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(initLayout());
        initView();
        initGetData();
        initListener();
    }

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initGetData();

    protected abstract void initListener();


}
