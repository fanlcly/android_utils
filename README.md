# android_utils
整理了一个强大的android工具库和常用的控件，会持续更新。

工具库：  
[DatePickerViewUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/DatePickerViewUtils.java)  
[DateUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/DateUtils.java)  
[DensityUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/DensityUtils.java)  
[KeyboardUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/KeyboardUtils.java)  
[PicassoUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/PicassoUtils.java)  
[RegexUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/RegexUtils.java)  
[ScreenUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/ScreenUtils.java)  
[SinglePickerViewUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/SinglePickerViewUtils.java)  
[SpUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/SpUtils.java)  
[Timber](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/Timber.java)  
[ToastUtils](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/utils/ToastUtils.java)  

自定义UI组件：  
[AlertView](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/widget/AlertView.java)  
[BottomNavigationBar](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/widget/BottomNavigationBar.java)  
[CircleImageView](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/widget/CircleImageView.java)  
[ClearEditText](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/widget/ClearEditText.java)  
[SmoothCheckBox](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/widget/SmoothCheckBox.java)  
[SwitchButton](https://github.com/fanlcly/android_utils/blob/master/androidutils/src/main/java/com/fancy/androidutils/widget/SwitchButton.java)  

引用到的库：  
[picasso](http://square.github.io/picasso/)  
[PickerView](https://github.com/Bigkoo/Android-PickerView)  

另外还要感谢JakeWharton提供的[timber](https://github.com/JakeWharton/timber)和[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)的作者以及被借鉴的N多优秀的工具类的作者们！！  

用法：
####如何使用：  
1.将其添加到project的build.gradle中。  

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  或者添加maven  
  
  	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

2.添加依赖到APP的build.gradle中。  
	dependencies {
	        implementation 'com.github.fanlcly:android_utils:0.0.1'
	}
  
  或者  
  
  	<dependency>
	    <groupId>com.github.fanlcly</groupId>
	    <artifactId>android_utils</artifactId>
	    <version>0.0.1</version>
	</dependency>
