package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppCompatProgressBarHelper.java */
/* loaded from: classes.dex */
public class n {
    private static final int[] a = {16843067, 16843068};

    /* renamed from: b  reason: collision with root package name */
    private final ProgressBar f858b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f859c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ProgressBar progressBar) {
        this.f858b = progressBar;
    }

    private Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private Drawable d(Drawable drawable, boolean z) {
        if (drawable instanceof androidx.core.graphics.drawable.c) {
            androidx.core.graphics.drawable.c cVar = (androidx.core.graphics.drawable.c) drawable;
            Drawable b2 = cVar.b();
            if (b2 != null) {
                cVar.a(d(b2, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = d(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f859c == null) {
                this.f859c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(a());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable e(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                Drawable d2 = d(animationDrawable.getFrame(i2), true);
                d2.setLevel(10000);
                animationDrawable2.addFrame(d2, animationDrawable.getDuration(i2));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap b() {
        return this.f859c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i2) {
        s0 v = s0.v(this.f858b.getContext(), attributeSet, a, i2, 0);
        Drawable h2 = v.h(0);
        if (h2 != null) {
            this.f858b.setIndeterminateDrawable(e(h2));
        }
        Drawable h3 = v.h(1);
        if (h3 != null) {
            this.f858b.setProgressDrawable(d(h3, false));
        }
        v.w();
    }
}