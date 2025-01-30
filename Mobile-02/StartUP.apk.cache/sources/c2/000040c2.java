package com.toshi.qr.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.appsflyer.share.Constants;
import e.j.f.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.l0.y;
import org.spongycastle.i18n.TextBundle;
import org.toshi.R;

/* compiled from: QROverlay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010s\u001a\u00020r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bt\u0010uJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\u0010\u001a\u00020\u0004*\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010)\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\"R%\u00108\u001a\n 4*\u0004\u0018\u000103038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\"R(\u0010?\u001a\u0004\u0018\u00010\u00132\b\u0010;\u001a\u0004\u0018\u00010\u00138\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b<\u0010=\"\u0004\b>\u0010\u0016R\u0016\u0010A\u001a\u00020\u00198B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u001bR\u0016\u0010C\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\"R\u0016\u0010F\u001a\u00020\f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020-8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010/R\u001d\u0010K\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u00105\u001a\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\"R\u0016\u0010O\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\"R\u0016\u0010Q\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\"R\u0016\u0010S\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bR\u0010\u001fR\u0016\u0010U\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\"R\u001f\u0010W\u001a\u0004\u0018\u0001038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\bV\u00107R\u0016\u0010Y\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\"R\u0016\u0010]\u001a\u00020Z8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020Z8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010=R\u0016\u0010c\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\"R%\u0010g\u001a\n 4*\u0004\u0018\u00010d0d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u00105\u001a\u0004\be\u0010fR\u0016\u0010i\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\"R\u0016\u0010k\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\"R\u0016\u0010m\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010\u001fR\u0016\u0010o\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010=R\u0016\u0010q\u001a\u00020\r8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\"¨\u0006v"}, d2 = {"Lcom/toshi/qr/view/custom/QROverlay;", "Landroid/view/View;", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/x;", "n", "(Landroid/util/AttributeSet;)V", "Landroid/graphics/Canvas;", "canvas", "l", "(Landroid/graphics/Canvas;)V", "k", "Landroid/text/StaticLayout;", "", "x", "y", "j", "(Landroid/text/StaticLayout;Landroid/graphics/Canvas;FF)V", "onDraw", "", TextBundle.TEXT_ENTRY, "o", "(Ljava/lang/String;)V", "m", "()V", "Landroid/graphics/Paint;", "getGradient", "()Landroid/graphics/Paint;", "gradient", "", "d", "I", "cornerColor", "getWarningIconLeft", "()F", "warningIconLeft", "getLeft", "left", Constants.URL_CAMPAIGN, "endGradient", "getWarningIconRight", "warningIconRight", "a", "F", "borderInset", "Landroid/graphics/RectF;", "getWarningRectF", "()Landroid/graphics/RectF;", "warningRectF", "getWarningIconTop", "warningIconTop", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Lkotlin/h;", "getWarningIcon", "()Landroid/graphics/drawable/Drawable;", "warningIcon", "getRight", "right", "value", "g", "Ljava/lang/String;", "setWarningText", "warningText", "getMaskPaint", "maskPaint", "getWarningIconBottom", "warningIconBottom", "getWarningTextLayout", "()Landroid/text/StaticLayout;", "warningTextLayout", "getRectF", "rectF", "getOverlayCanvas", "()Landroid/graphics/Canvas;", "overlayCanvas", "getCornerRadius", "cornerRadius", "getScanSize", "scanSize", "getWarningLeft", "warningLeft", "b", "startGradient", "getWarningRight", "warningRight", "getBracketsDrawable", "bracketsDrawable", "getBottom", "bottom", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint", "getSubtitleTextPaint", "subtitleTextPaint", "e", "headerText", "getWarningBottom", "warningBottom", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "bitmap", "getTop", "top", "getWarningSize", "warningSize", "h", "warningIconSize", "f", "subtitleText", "getWarningTop", "warningTop", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class QROverlay extends View {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private int f11106b;

    /* renamed from: c  reason: collision with root package name */
    private int f11107c;

    /* renamed from: d  reason: collision with root package name */
    private int f11108d;

    /* renamed from: e  reason: collision with root package name */
    private String f11109e;

    /* renamed from: f  reason: collision with root package name */
    private String f11110f;

    /* renamed from: g  reason: collision with root package name */
    private String f11111g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11112h;

    /* renamed from: j  reason: collision with root package name */
    private final h f11113j;

    /* renamed from: k  reason: collision with root package name */
    private final h f11114k;

    /* renamed from: l  reason: collision with root package name */
    private final h f11115l;
    private final h m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QROverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        h b2;
        h b3;
        h b4;
        h b5;
        m.g(context, "context");
        m.g(attrs, "attrs");
        this.a = 10.0f;
        this.f11106b = androidx.core.content.a.d(getContext(), R.color.overlay_gradient_start);
        this.f11107c = androidx.core.content.a.d(getContext(), R.color.overlay_gradient_end);
        this.f11108d = androidx.core.content.a.d(getContext(), R.color.white);
        String string = getResources().getString(R.string.scan_qr_code);
        m.f(string, "resources.getString(R.string.scan_qr_code)");
        this.f11109e = string;
        String string2 = getResources().getString(R.string.universal_qr_scanner_subtitle);
        m.f(string2, "resources.getString(R.string.universal_qr_scanner_subtitle)");
        this.f11110f = string2;
        this.f11112h = o.a(48);
        b2 = k.b(new b(this));
        this.f11113j = b2;
        b3 = k.b(new a(this));
        this.f11114k = b3;
        b4 = k.b(new d(this));
        this.f11115l = b4;
        b5 = k.b(new c(this));
        this.m = b5;
        n(attrs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap getBitmap() {
        return (Bitmap) this.f11114k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getBottom() {
        return getTop() + getScanSize();
    }

    private final Drawable getBracketsDrawable() {
        return (Drawable) this.f11113j.getValue();
    }

    private final float getCornerRadius() {
        return getResources().getDimension(R.dimen.corner_radius_qr_scanner);
    }

    private final Paint getGradient() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.f11106b, this.f11107c, Shader.TileMode.CLAMP));
        return paint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getLeft() {
        return getWidth() * 0.125f;
    }

    private final Paint getMaskPaint() {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        return paint;
    }

    private final Canvas getOverlayCanvas() {
        return (Canvas) this.m.getValue();
    }

    private final RectF getRectF() {
        RectF rectF = new RectF(getLeft(), getTop(), getRight(), getBottom());
        float f2 = this.a;
        rectF.inset(f2, f2);
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getRight() {
        return getWidth() - getLeft();
    }

    private final float getScanSize() {
        return getRight() - getLeft();
    }

    private final TextPaint getSubtitleTextPaint() {
        TextPaint textPaint = getTextPaint();
        textPaint.setTextSize(getResources().getDimension(R.dimen.text_size_font_medium));
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        return textPaint;
    }

    private final TextPaint getTextPaint() {
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(-1);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(getResources().getDimension(R.dimen.text_size_font_header));
        textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        return textPaint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getTop() {
        return getHeight() * 0.15f;
    }

    private final float getWarningBottom() {
        return getWarningTop() + getWarningSize();
    }

    private final Drawable getWarningIcon() {
        return (Drawable) this.f11115l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getWarningIconBottom() {
        return getWarningIconTop() + this.f11112h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getWarningIconLeft() {
        return getWarningLeft() + ((getWarningSize() - this.f11112h) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getWarningIconRight() {
        return getWarningIconLeft() + this.f11112h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getWarningIconTop() {
        return (getWarningTop() + ((getWarningSize() - this.f11112h) / 2)) * 0.85f;
    }

    private final float getWarningLeft() {
        return getWidth() * 0.25f;
    }

    private final RectF getWarningRectF() {
        RectF rectF = new RectF(getWarningLeft(), getWarningTop(), getWarningRight(), getWarningBottom());
        float f2 = this.a;
        rectF.inset(f2, f2);
        return rectF;
    }

    private final float getWarningRight() {
        return getWidth() - getWarningLeft();
    }

    private final float getWarningSize() {
        return getWarningRight() - getWarningLeft();
    }

    private final StaticLayout getWarningTextLayout() {
        String str = this.f11111g;
        StaticLayout build = StaticLayout.Builder.obtain(str != null ? str : "", 0, str == null ? 0 : str.length(), getSubtitleTextPaint(), (int) (getWarningSize() - o.a(32))).build();
        m.f(build, "obtain(\n                warningText.orEmpty(),\n                0,\n                warningText?.length ?: 0,\n                subtitleTextPaint,\n                (warningSize - 32.toPx()).toInt()\n            )\n            .build()");
        return build;
    }

    private final float getWarningTop() {
        return getTop() + ((getScanSize() - getWarningSize()) / 2);
    }

    private final void j(StaticLayout staticLayout, Canvas canvas, float f2, float f3) {
        int save = canvas.save();
        canvas.translate(f2, f3);
        try {
            staticLayout.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    private final void k(Canvas canvas) {
        List<String> K0;
        float bottom = getBottom() + getResources().getDimension(R.dimen.view_size_40);
        float dimension = getResources().getDimension(R.dimen.view_size_32) + bottom;
        canvas.drawText(this.f11109e, getWidth() / 2.0f, bottom, getTextPaint());
        K0 = y.K0(this.f11110f, new String[]{"\n"}, false, 0, 6, null);
        for (String str : K0) {
            canvas.drawText(str, getWidth() / 2.0f, dimension, getSubtitleTextPaint());
            dimension += getResources().getDimension(R.dimen.view_size_24);
        }
    }

    private final void l(Canvas canvas) {
        if (this.f11111g == null || canvas == null) {
            return;
        }
        canvas.drawRoundRect(getWarningRectF(), getCornerRadius(), getCornerRadius(), getGradient());
        getWarningIcon().draw(canvas);
        j(getWarningTextLayout(), canvas, getWidth() / 2, getWarningIconBottom() + o.a(32));
    }

    private final void n(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.j.b.e1);
        m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.QROverlay)");
        this.f11106b = obtainStyledAttributes.getColor(3, androidx.core.content.a.d(getContext(), R.color.overlay_gradient_start));
        this.f11107c = obtainStyledAttributes.getColor(2, androidx.core.content.a.d(getContext(), R.color.overlay_gradient_end));
        this.f11108d = obtainStyledAttributes.getColor(0, androidx.core.content.a.d(getContext(), R.color.white));
        String string = obtainStyledAttributes.getString(4);
        if (string == null) {
            string = getResources().getString(R.string.scan_qr_code);
            m.f(string, "resources.getString(R.string.scan_qr_code)");
        }
        this.f11109e = string;
        String string2 = obtainStyledAttributes.getString(1);
        if (string2 == null) {
            string2 = getResources().getString(R.string.universal_qr_scanner_subtitle);
            m.f(string2, "resources.getString(R.string.universal_qr_scanner_subtitle)");
        }
        this.f11110f = string2;
        obtainStyledAttributes.recycle();
    }

    private final void setWarningText(String str) {
        this.f11111g = str;
        invalidate();
    }

    public final void m() {
        setWarningText(null);
    }

    public final void o(String str) {
        performHapticFeedback(0);
        setWarningText(str);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas overlayCanvas = getOverlayCanvas();
        overlayCanvas.drawPaint(getMaskPaint());
        overlayCanvas.drawPaint(getGradient());
        overlayCanvas.drawRoundRect(getRectF(), getCornerRadius(), getCornerRadius(), getMaskPaint());
        Drawable bracketsDrawable = getBracketsDrawable();
        if (bracketsDrawable != null) {
            bracketsDrawable.draw(overlayCanvas);
        }
        k(getOverlayCanvas());
        if (canvas != null) {
            canvas.drawBitmap(getBitmap(), 0.0f, 0.0f, (Paint) null);
        }
        l(canvas);
    }
}