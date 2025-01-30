package com.toshi.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: ProgressBar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u001f\u0010\u0015¨\u0006'"}, d2 = {"Lcom/toshi/view/custom/ProgressBar;", "Landroid/view/View;", "Lkotlin/x;", "a", "()V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "progress", "setProgress", "(I)V", "Landroid/graphics/Paint;", "e", "Lkotlin/h;", "getPaint", "()Landroid/graphics/Paint;", "paint", "b", "getForegroundColor", "()I", "foregroundColor", "Landroid/graphics/RectF;", "d", "Landroid/graphics/RectF;", "fgRect", Constants.URL_CAMPAIGN, "bgRect", "f", "I", "getBackgroundColor", "backgroundColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ProgressBar extends View {
    private final kotlin.h a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.h f11170b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f11171c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f11172d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.h f11173e;

    /* renamed from: f  reason: collision with root package name */
    private int f11174f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.jvm.internal.m.g(context, "context");
        kotlin.jvm.internal.m.g(attrs, "attrs");
        b2 = kotlin.k.b(new q(this));
        this.a = b2;
        b3 = kotlin.k.b(new r(this));
        this.f11170b = b3;
        b4 = kotlin.k.b(s.a);
        this.f11173e = b4;
        a();
    }

    private final void a() {
        int pxSize = View_CommonKt.getPxSize(this, R.dimen.progress_height);
        this.f11171c = new RectF(new Rect(0, 0, getRight(), pxSize));
        this.f11172d = new RectF(new Rect(0, 0, 0, pxSize));
    }

    private final int getBackgroundColor() {
        return ((Number) this.a.getValue()).intValue();
    }

    private final int getForegroundColor() {
        return ((Number) this.f11170b.getValue()).intValue();
    }

    private final Paint getPaint() {
        return (Paint) this.f11173e.getValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        getPaint().setColor(getBackgroundColor());
        RectF rectF = this.f11171c;
        if (rectF != null && canvas != null) {
            canvas.drawRect(rectF, getPaint());
        }
        double width = getWidth() * (this.f11174f / 100);
        getPaint().setColor(getForegroundColor());
        RectF rectF2 = this.f11172d;
        if (rectF2 != null) {
            rectF2.right = (float) width;
        }
        if (rectF2 != null && canvas != null) {
            canvas.drawRect(rectF2, getPaint());
        }
        if (this.f11174f == 100) {
            animate().alpha(0.0f).setDuration(1000L).start();
        }
        super.onDraw(canvas);
    }

    public final void setProgress(int i2) {
        if (i2 == 100) {
            this.f11174f = 0;
        } else if (i2 >= this.f11174f) {
            this.f11174f = i2;
        }
        invalidate();
    }
}