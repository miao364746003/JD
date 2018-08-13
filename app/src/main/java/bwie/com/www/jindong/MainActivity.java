package bwie.com.www.jindong;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bwie.com.www.jindong.base.BaseActivity;
import bwie.com.www.jindong.home.HomeActivity;

public class MainActivity extends BaseActivity {
    private int page = 3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==0){
//                startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                finish();
            }
        }
    };

    @Override
    protected int initLayout() {
//        activity_main
        return R.layout.title_bar;
    }

    @Override
    protected void initView() {
        new Thread(){
            @Override
            public void run() {
                try {
                   while (page>0){
                       page--;
                       sleep(1000);
                       handler.sendEmptyMessage(page);
                   }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    @Override
    protected void initGetData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
