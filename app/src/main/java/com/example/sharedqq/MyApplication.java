package com.example.sharedqq;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //友meng
        UMConfigure.init(this,"5fe3330fd1c1ad39854eb970"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
      //qq
        PlatformConfig.setQQZone("101921755", "d217723141825cd362da04324190a215");
        PlatformConfig.setQQFileProvider("com.example.sharedqq.fileprovider");
        // 其他平台设置
        PlatformConfig.setSinaWeibo("2561582317", "bb64af785027296cab93a779d5a8f8c7","http://android.com");

    }
}
