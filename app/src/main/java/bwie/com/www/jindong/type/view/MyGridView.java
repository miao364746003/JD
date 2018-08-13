package bwie.com.www.jindong.type.view;

import android.content.Context;
import android.renderscript.Sampler;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by lenovo on 2018/8/10.
 */

public class MyGridView extends GridView{
    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, height);
    }
}
