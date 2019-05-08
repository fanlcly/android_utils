package com.fancy.androidutils.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;

import com.fancy.androidutils.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

/**
 * 图片加载帮助类(Picasso)
 *
 * @author fanlei
 * @version 1.0 2018\12\4 0004
 * @since JDK 1.7
 */
public class PicassoUtils {
    private static PicassoUtils instance;

    /**
     * 圆形
     */
    public static String PICASSO_BITMAP_SHOW_CIRCLE_TYPE = "PicassoUtils_Circle_Type";
    /**
     * 圆角
     */
    public static String PICASSO_BITMAP_SHOW_ROUND_TYPE = "PicassoUtils_Round_Type";
    /**
     * 正常
     */
    public static String PICASSO_BITMAP_SHOW_NORMAL_TYPE = "PicassoUtils_Normal_Type";


    private PicassoUtils() {
    }


    public static PicassoUtils getInstance() {
        if (instance == null) {
            synchronized (PicassoUtils.class) {
                if (instance == null) {
                    instance = new PicassoUtils();
                }
            }
        }
        return instance;
    }


    //Picasso使用的方法汇总：
    //Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
    //Picasso.with(context).load(url).into(view);
    //Picasso.with(context).load(url) .resize(50, 50).centerCrop().into(imageView)
    ////这里的placeholder将resource传入通过getResource.getDrawable取资源，所以可以是张图片也可以是color id
    //Picasso.with(context).load(url).placeholder(R.drawable.user_placeholder).error(R.drawable.user_placeholder_error).into(imageView);
    //
    // Resources, assets, files, content providers 加载图片都支持
    //Picasso.with(context).load(R.drawable.landing_screen).into(imageView1);
    //Picasso.with(context).load("file:///android_asset/DvpvklR.png").into(imageView2);
    //Picasso.with(context).load(new File(...)).into(imageView3);
    ////这里显示notification的图片
    //Picasso.with(activity).load(Data.URLS[new Random().nextInt(Data.URLS.length)]).resizeDimen(R.dimen.notification_icon_width_height,    R.dimen.notification_icon_width_height).into(remoteViews, R.id.photo, NOTIFICATION_ID, notification);
    ////这里是通过设置tag标签，就是当前传过来的context，这样就可以根据这个context tag来pause和resume显示了
    //Picasso.with(context).load(url).placeholder(R.drawable.placeholder).error(R.drawable.error).fit().tag(context).into(view);
    ////监听onScrollStateChanged的时候调用执行
    //picasso.resumeTag(context);
    //picasso.pauseTag(context);
    //Picasso.with(context).load(contactUri).placeholder(R.drawable.contact_picture_placeholder).tag(context).into(holder.icon);


    /**
     * 加载图片通过地址
     * @param context
     * @param path
     * @param imageView
     */
    public void loadImage(Context context, String path, ImageView imageView) {
        loadImage(context, path, imageView, R.color.bg_b1b1b2, R.color.bg_b1b1b2, PICASSO_BITMAP_SHOW_NORMAL_TYPE, 0);
    }


    /**
     * 加载图片通过地址
     *
     * @param context
     * @param path
     * @param imageView
     * @param placeholderimage 占位图片
     * @param errorimage       加载错误图片
     * @param bitmapShowType   PICASSO_BITMAP_SHOW_CIRCLE_TYPE ， PICASSO_BITMAP_SHOW_ROUND_TYPE ，PICASSO_BITMAP_SHOW_NORMAL_TYPE
     * @param roundRadius      设置圆角半径
     */
    public void loadImage(Context context, String path, ImageView imageView, int placeholderimage, int errorimage, String bitmapShowType, float roundRadius) {
        if (bitmapShowType.equals(PICASSO_BITMAP_SHOW_CIRCLE_TYPE)) {
            Picasso.with(context).load(path).placeholder(placeholderimage).error(errorimage).transform(new CircleTransform()).into(imageView);
        } else if (bitmapShowType.equals(PICASSO_BITMAP_SHOW_ROUND_TYPE)) {
            Picasso.with(context).load(path).placeholder(placeholderimage).error(errorimage).transform(new RoundTransform(roundRadius)).into(imageView);
        } else {
            Picasso.with(context).load(path).placeholder(placeholderimage).error(errorimage).into(imageView);
        }
    }

    /**
     * 加载图片本地 通过id
     *
     * @param context
     * @param localimage     R.drawable.landing_screen
     * @param imageView
     */
    public void loadImage(Context context, int localimage, ImageView imageView) {
        loadImage(context,localimage,imageView,PICASSO_BITMAP_SHOW_NORMAL_TYPE,0);
    }



    /**
     * 加载图片本地 通过id
     *
     * @param context
     * @param localimage     R.drawable.landing_screen
     * @param imageView
     * @param bitmapShowType PICASSO_BITMAP_SHOW_CIRCLE_TYPE ， PICASSO_BITMAP_SHOW_ROUND_TYPE ，PICASSO_BITMAP_SHOW_NORMAL_TYPE
     * @param roundRadius    设置圆角半径
     */
    public void loadImage(Context context, int localimage, ImageView imageView, String bitmapShowType, float roundRadius) {
        if (bitmapShowType.equals(PICASSO_BITMAP_SHOW_CIRCLE_TYPE)) {
            Picasso.with(context).load(localimage).placeholder(R.drawable.img_loading).error(R.drawable.img_load_error).transform(new CircleTransform()).into(imageView);
        } else if (bitmapShowType.equals(PICASSO_BITMAP_SHOW_ROUND_TYPE)) {
            Picasso.with(context).load(localimage).transform(new RoundTransform(roundRadius)).into(imageView);
        } else {
            Picasso.with(context).load(localimage).into(imageView);
        }
    }


    /**
     * 加载图片 设置宽高  图片默认居中 （centerCrop() ）
     *
     * @param context
     * @param path
     * @param imageView
     * @param targetWidth
     * @param targetHeight
     * @param bitmapShowType PICASSO_BITMAP_SHOW_CIRCLE_TYPE ， PICASSO_BITMAP_SHOW_ROUND_TYPE ，PICASSO_BITMAP_SHOW_NORMAL_TYPE
     * @param roundRadius    设置圆角半径
     */
    public void loadImageWithWidtAndHeight(Context context, String path, ImageView imageView, int targetWidth, int targetHeight, String bitmapShowType, float roundRadius) {
        if (bitmapShowType.equals(PICASSO_BITMAP_SHOW_CIRCLE_TYPE)) {
            Picasso.with(context).load(path).resize(targetWidth, targetHeight).centerCrop().transform(new CircleTransform()).into(imageView);
        } else if (bitmapShowType.equals(PICASSO_BITMAP_SHOW_ROUND_TYPE)) {
            Picasso.with(context).load(path).resize(targetWidth, targetHeight).centerCrop().transform(new RoundTransform(roundRadius)).into(imageView);
        } else {
            Picasso.with(context).load(path).resize(targetWidth, targetHeight).centerCrop().into(imageView);
        }
    }


    //--------------------------------------------------

    /**
     * 设置圆形头像
     */
    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }


    /**
     * 绘制圆角
     */
    public class RoundTransform implements Transformation {
        private float radius;

        public RoundTransform(float radius) {
            this.radius = radius;
        }

        @Override
        public String key() {
            return "round";
        }

        @Override
        public Bitmap transform(Bitmap bitmap) {
            int size = Math.min(bitmap.getWidth(), bitmap.getHeight());

            int x = (bitmap.getWidth() - size) / 2;
            int y = (bitmap.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap.createBitmap(bitmap, x, y, size, size);
            if (squaredBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                    bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final int color = 0xff424242;
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            final RectF rectF = new RectF(rect);

            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawRoundRect(rectF, radius, radius, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            squaredBitmap.recycle();
            return output;
        }

    }
}
