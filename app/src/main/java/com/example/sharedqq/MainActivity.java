package com.example.sharedqq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;


public class MainActivity extends AppCompatActivity {
    private Button shared_qq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared_qq=findViewById(R.id.shared_qq);


        shared_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shared();
            }
        });
    }

    private void shared() {
        //图片
        UMImage image = new UMImage(MainActivity.this, "http://ww4.sinaimg.cn/large/610dc034jw1f2uyg3nvq7j20gy0p6myx.jpg");//网络图片
        image.setThumb(new UMImage(MainActivity.this, R.mipmap.ic_launcher));
        //分享面板
        new ShareAction(MainActivity.this).withText("这是分享").withMedia(image).setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ)
                .setCallback(shareListener).open();

    }

    //QQ与新浪不需要添加Activity，但需要在使用QQ分享或者授权的Activity中，添加：
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}