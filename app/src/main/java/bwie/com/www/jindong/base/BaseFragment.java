package bwie.com.www.jindong.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by lenovo on 2018/8/8.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    private View view;
    public T presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(initLayout(), container, false);
        presenter = getPresenter();
        initView(view);
        initData();
        initClickEvent();
        return view;
    }

    protected abstract T getPresenter();

    protected abstract int initLayout();

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract void initClickEvent();


}
