package cn.itzyq.progressandloadingdialog.activity;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.itzyq.progressandloadingdialog.LoadingDialog;
import cn.itzyq.progressandloadingdialog.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView poStyle,ptStyle,loStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        poStyle = findViewById(R.id.poStyle);
        ptStyle = findViewById(R.id.ptStyle);
        loStyle = findViewById(R.id.loStyle);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        poStyle.setOnClickListener(this);
        ptStyle.setOnClickListener(this);
        loStyle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.poStyle:
                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                //设置标题
                pd.setTitle("我是加载框");
                //设置提示信息
                pd.setMessage("正在加载...");
                //设置ProgressDialog 是否可以按返回键取消；
                pd.setCancelable(false);
                pd.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
                //显示ProgressDialog
                pd.show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //删除progressdialog,cancel与dismiss作用相同。
                        pd.cancel();
                    }
                },2000);
                break;
            case R.id.ptStyle:
                //show(Context context, CharSequence title, CharSequence message, boolean indeterminate, boolean cancelable, OnCancelListener cancelListener)
                final ProgressDialog pd2 = ProgressDialog.show(MainActivity.this,"刷新","刷新中");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pd2.dismiss();
                    }
                },2000);
                break;
            case R.id.loStyle:
                LoadingDialog.Builder builder=new LoadingDialog.Builder(MainActivity.this)
                        .setMessage("加载中...")
                        .setCancelable(false);
                final LoadingDialog dialog=builder.create();
                dialog.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                },2000);

                break;
        }
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
