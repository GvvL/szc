package com.aydc.szc.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
/**
 * glide库设置圆角
 *
 */
public class GlideRoundTransform extends BitmapTransformation {
	  private static float radius = 0f;
	  public GlideRoundTransform(Context context) {
	    this(context, 4);
	  }
	  @SuppressWarnings("static-access")
	public GlideRoundTransform(Context context, int dp) {
	    super(context);
	    this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
	  }
	  @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
	    return roundCrop(pool, toTransform);
	  }
	  private static Bitmap roundCrop(BitmapPool pool, Bitmap source) {
	    if (source == null) return null;
	    Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
	    if (result == null) {
	      result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
	    }
	    Canvas canvas = new Canvas(result);
	    canvas.setDrawFilter(new PaintFlagsDrawFilter(0,Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
	    Paint paint = new Paint();
	    paint.setAntiAlias(true);
	    paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
	    RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
	    canvas.drawRoundRect(rectF, radius, radius, paint);
	    return result;
	  }
	  @Override public String getId() {
	    return getClass().getName() + Math.round(radius);
	  }
	}
