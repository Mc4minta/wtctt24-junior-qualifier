package com.toshi.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.appsflyer.share.Constants;
import e.j.f.y;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: PrefixSuffixEditText.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b!\u0010\u0014J\u000f\u0010\"\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010\u0018R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0016\u0010\u001f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010)\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010(¨\u0006."}, d2 = {"Lcom/toshi/view/custom/PrefixSuffixEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/x;", "d", "(Landroid/util/AttributeSet;)V", "e", "()V", "Landroid/view/MotionEvent;", "event", "", Constants.URL_CAMPAIGN, "(Landroid/view/MotionEvent;)Z", "h", "g", "k", "Landroid/graphics/Canvas;", "canvas", "a", "(Landroid/graphics/Canvas;)V", "b", "", "getColor", "()I", "i", "()Z", "", "prefix", "setPrefix", "(Ljava/lang/String;)V", "suffix", "setSuffix", "onDraw", "getCompoundPaddingLeft", "Landroid/text/TextPaint;", "Landroid/text/TextPaint;", "textPaint", "Ljava/lang/String;", "f", "I", "prefixPadding", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PrefixSuffixEditText extends AppCompatEditText {

    /* renamed from: d */
    private TextPaint f11166d;

    /* renamed from: e */
    private String f11167e;

    /* renamed from: f */
    private String f11168f;

    /* renamed from: g */
    private int f11169g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrefixSuffixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        this.f11167e = "";
        this.f11168f = "";
        d(attributeSet);
        e();
        g();
        h();
    }

    private final void a(Canvas canvas) {
        String str = this.f11168f;
        float paddingLeft = getPaddingLeft();
        float baseline = getBaseline();
        TextPaint textPaint = this.f11166d;
        if (textPaint != null) {
            canvas.drawText(str, paddingLeft, baseline, textPaint);
        } else {
            kotlin.jvm.internal.m.w("textPaint");
            throw null;
        }
    }

    private final void b(Canvas canvas) {
        Editable text = getText();
        String d2 = text == null || text.length() == 0 ? y.d(this, R.string._0_0) : String.valueOf(getText());
        TextPaint textPaint = this.f11166d;
        if (textPaint != null) {
            int measureText = ((int) textPaint.measureText(kotlin.jvm.internal.m.o(d2, " "))) + getCompoundPaddingLeft() + getPaddingLeft();
            String str = this.f11167e;
            float f2 = measureText;
            float baseline = getBaseline();
            TextPaint textPaint2 = this.f11166d;
            if (textPaint2 != null) {
                canvas.drawText(str, f2, baseline, textPaint2);
                return;
            } else {
                kotlin.jvm.internal.m.w("textPaint");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("textPaint");
        throw null;
    }

    private final boolean c(MotionEvent motionEvent) {
        Rect bounds;
        if (motionEvent.getAction() == 1) {
            Drawable drawable = getCompoundDrawablesRelative()[2];
            if (motionEvent.getRawX() >= (getRight() - ((drawable == null || (bounds = drawable.getBounds()) == null) ? 0 : bounds.width())) - getCompoundPaddingRight()) {
                setText((CharSequence) null);
                return true;
            }
        }
        return false;
    }

    private final void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.j.b.a1);
        kotlin.jvm.internal.m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.PrefixSuffixEditText)");
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "";
        }
        this.f11168f = string;
        String string2 = obtainStyledAttributes.getString(1);
        this.f11167e = string2 != null ? string2 : "";
        obtainStyledAttributes.recycle();
    }

    private final void e() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.toshi.view.custom.l
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PrefixSuffixEditText.j(PrefixSuffixEditText.this, view, motionEvent);
            }
        });
    }

    public static final boolean f(PrefixSuffixEditText this$0, View view, MotionEvent event) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.f(event, "event");
        return this$0.c(event);
    }

    private final void g() {
        TextPaint textPaint = new TextPaint();
        this.f11166d = textPaint;
        if (textPaint != null) {
            textPaint.setColor(getCurrentHintTextColor());
            TextPaint textPaint2 = this.f11166d;
            if (textPaint2 != null) {
                textPaint2.setTextSize(getTextSize());
                TextPaint textPaint3 = this.f11166d;
                if (textPaint3 != null) {
                    textPaint3.setTextAlign(Paint.Align.LEFT);
                    TextPaint textPaint4 = this.f11166d;
                    if (textPaint4 != null) {
                        textPaint4.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("textPaint");
                        throw null;
                    }
                }
                kotlin.jvm.internal.m.w("textPaint");
                throw null;
            }
            kotlin.jvm.internal.m.w("textPaint");
            throw null;
        }
        kotlin.jvm.internal.m.w("textPaint");
        throw null;
    }

    private final int getColor() {
        int i2;
        if (!i()) {
            Editable text = getText();
            if (!(text == null || text.length() == 0)) {
                i2 = R.color.textColorPrimary;
                return y.b(this, i2);
            }
        }
        i2 = R.color.textColorHint;
        return y.b(this, i2);
    }

    private final void h() {
        if (!(this.f11168f.length() == 0)) {
            setPrefix(this.f11168f);
        }
        if (this.f11167e.length() == 0) {
            return;
        }
        setSuffix(this.f11167e);
    }

    private final boolean i() {
        return (isFocusable() || isFocusableInTouchMode()) ? false : true;
    }

    public static /* synthetic */ boolean j(PrefixSuffixEditText prefixSuffixEditText, View view, MotionEvent motionEvent) {
        return f(prefixSuffixEditText, view, motionEvent);
    }

    private final void k() {
        TextPaint textPaint = this.f11166d;
        if (textPaint != null) {
            textPaint.setColor(getColor());
        } else {
            kotlin.jvm.internal.m.w("textPaint");
            throw null;
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        return super.getCompoundPaddingLeft() + this.f11169g;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.m.g(canvas, "canvas");
        k();
        a(canvas);
        b(canvas);
        super.onDraw(canvas);
    }

    public final void setPrefix(String str) {
        this.f11168f = str != null ? str : "";
        TextPaint textPaint = this.f11166d;
        if (textPaint != null) {
            this.f11169g = (int) textPaint.measureText(str);
            invalidate();
            return;
        }
        kotlin.jvm.internal.m.w("textPaint");
        throw null;
    }

    public final void setSuffix(String str) {
        if (str == null) {
            str = "";
        }
        this.f11167e = str;
        invalidate();
    }
}