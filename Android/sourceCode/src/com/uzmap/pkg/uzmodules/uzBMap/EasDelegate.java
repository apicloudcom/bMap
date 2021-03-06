package com.uzmap.pkg.uzmodules.uzBMap;

import android.app.Activity;
import android.content.Context;

import java.io.File;

import com.baidu.mapapi.SDKInitializer;
import com.uzmap.pkg.uzcore.uzmodule.AppInfo;
import com.uzmap.pkg.uzcore.uzmodule.ApplicationDelegate;

/**
 * 继承自ApplicationDelegate的类，APICloud引擎在应用初始化之初就会将该类初始化一次（即new一个出来），并保持引用，
 * 在应用整个运行期间，会将生命周期事件通过该对象通知出来。<br>
 * 该类需要在module.json中配置，其中name字段可以任意配置，因为该字段将被忽略，请参考module.json中EasDelegate的配置
 */
public class EasDelegate extends ApplicationDelegate {

	/**
	 * 继承自ApplicationDelegate的类，APICloud引擎在应用初始化之初就会将该类初始化一次（即new一个出来），并保持引用，
	 * 在应用整个运行期间，会将生命周期事件通过该对象通知出来。<br>
	 * 该类需要在module.json中配置，其中name字段可以任意配置，因为该字段将被忽略，请参考module.json中EasDelegate的配置
	 */
	public EasDelegate() {
		//应用运行期间，该对象只会初始化一个出来
	}

	@Override
	public void onApplicationCreate(Context context, AppInfo info) {
		SDKInitializer.initialize(context);
		String themeParent = context.getFilesDir().getAbsolutePath();
		File file1 = new File(themeParent, "customConfigdir/blackNight/custom_config");//黑夜模式
		if (!file1.exists()) {
			BMapConfig.copyFile(context, 1, themeParent, file1.getAbsolutePath());
		}
		File file2 = new File(themeParent, "customConfigdir/freshBlue/custom_config");//清新蓝
		if (!file2.exists()) {
			BMapConfig.copyFile(context, 2, themeParent, file2.getAbsolutePath());
		}
		File file3 = new File(themeParent, "customConfigdir/midnightBlue/custom_config");//午夜蓝
		if (!file3.exists()) {
			BMapConfig.copyFile(context, 3, themeParent, file3.getAbsolutePath());
		}
	}
	
	

	@Override
	public void onActivityResume(Activity activity, AppInfo info) {
		//APP从后台回到前台时，APICloud引擎将通过该函数回调事件
		
	}

	@Override
	public void onActivityPause(Activity activity, AppInfo info) {
		//APP从前台退到后台时，APICloud引擎将通过该函数回调事件
	}

	@Override
	public void onActivityFinish(Activity activity, AppInfo info) {
		//APP即将结束运行时，APICloud引擎将通过该函数回调事件
	}

}
