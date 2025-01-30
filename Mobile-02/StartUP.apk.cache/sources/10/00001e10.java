package com.coinbase.wallet.features.commonui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import h.c.s;
import h.c.t0.g;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.o;
import org.toshi.R;

/* compiled from: AmountSliderView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:B\u0019\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b9\u0010=B#\b\u0016\u0012\u0006\u00108\u001a\u000207\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\u0006\u0010>\u001a\u00020\t¢\u0006\u0004\b9\u0010?J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J)\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005R+\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R<\u0010\u001c\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b \u001b*\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00140\u00140\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u00102\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006@"}, d2 = {"Lcom/coinbase/wallet/features/commonui/views/AmountSliderView;", "Landroid/widget/LinearLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lkotlin/x;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/widget/SeekBar;", "seekBar", "", "progress", "", "fromUser", "onProgressChanged", "(Landroid/widget/SeekBar;IZ)V", "onStartTrackingTouch", "(Landroid/widget/SeekBar;)V", "onStopTrackingTouch", "updateSliderValueIfNeeded", "Lh/c/s;", "Lkotlin/o;", "", "amountSliderObservable", "Lh/c/s;", "getAmountSliderObservable", "()Lh/c/s;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "amountSliderSubject", "Lh/c/v0/b;", "", "value", "getDescriptionText", "()Ljava/lang/String;", "setDescriptionText", "(Ljava/lang/String;)V", "descriptionText", "", "shortAnimDuration$delegate", "Lkotlin/h;", "getShortAnimDuration", "()J", "shortAnimDuration", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "getCurrentValue", "()F", "setCurrentValue", "(F)V", "currentValue", "isDescriptionVisible", "()Z", "setDescriptionVisible", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountSliderView extends LinearLayout implements SeekBar.OnSeekBarChangeListener {
    private final s<o<Float, Boolean>> amountSliderObservable;
    private final h.c.v0.b<o<Float, Boolean>> amountSliderSubject;
    private final h.c.k0.a disposeBag;
    private final h shortAnimDuration$delegate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmountSliderView(Context context) {
        this(context, null, 0);
        m.g(context, "context");
    }

    private final long getShortAnimDuration() {
        return ((Number) this.shortAnimDuration$delegate.getValue()).longValue();
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final s<o<Float, Boolean>> getAmountSliderObservable() {
        return this.amountSliderObservable;
    }

    public final float getCurrentValue() {
        return ((SeekBar) findViewById(e.j.a.amountSlider)).getProgress() / 100.0f;
    }

    public final String getDescriptionText() {
        return ((TextView) findViewById(e.j.a.sliderInterestText)).getText().toString();
    }

    public final boolean isDescriptionVisible() {
        TextView sliderInterestText = (TextView) findViewById(e.j.a.sliderInterestText);
        m.f(sliderInterestText, "sliderInterestText");
        return sliderInterestText.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s<o<Float, Boolean>> observeOn = this.amountSliderObservable.throttleLatest(getShortAnimDuration(), TimeUnit.MILLISECONDS, true).observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "amountSliderObservable\n            .throttleLatest(shortAnimDuration, TimeUnit.MILLISECONDS, true)\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(g.h(observeOn, null, null, new AmountSliderView$onAttachedToWindow$1(this), 3, null), this.disposeBag);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.disposeBag.d();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        h.c.v0.b<o<Float, Boolean>> bVar = this.amountSliderSubject;
        int i3 = e.j.a.amountSlider;
        bVar.onNext(new o<>(Float.valueOf(i2 / ((SeekBar) findViewById(i3)).getMax()), Boolean.valueOf(i2 == ((SeekBar) findViewById(i3)).getMax())));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public final void setCurrentValue(float f2) {
        int a;
        a = kotlin.f0.c.a(f2 * 100);
        ((SeekBar) findViewById(e.j.a.amountSlider)).setProgress(a);
    }

    public final void setDescriptionText(String value) {
        m.g(value, "value");
        ((TextView) findViewById(e.j.a.sliderInterestText)).setText(value);
    }

    public final void setDescriptionVisible(boolean z) {
        TextView sliderInterestText = (TextView) findViewById(e.j.a.sliderInterestText);
        m.f(sliderInterestText, "sliderInterestText");
        sliderInterestText.setVisibility(z ? 0 : 8);
    }

    public final void updateSliderValueIfNeeded() {
        if (getCurrentValue() >= 1.0f) {
            this.amountSliderSubject.onNext(new o<>(Float.valueOf(1.0f), Boolean.TRUE));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmountSliderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        m.g(context, "context");
        m.g(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountSliderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h b2;
        m.g(context, "context");
        this.disposeBag = new h.c.k0.a();
        h.c.v0.b<o<Float, Boolean>> d2 = h.c.v0.b.d();
        m.f(d2, "create<Pair<Float, Boolean>>()");
        this.amountSliderSubject = d2;
        b2 = k.b(new AmountSliderView$shortAnimDuration$2(this));
        this.shortAnimDuration$delegate = b2;
        s<o<Float, Boolean>> hide = d2.hide();
        m.f(hide, "amountSliderSubject.hide()");
        this.amountSliderObservable = hide;
        setOrientation(1);
        setVerticalGravity(16);
        setForegroundGravity(16);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int pxSize = View_CommonKt.getPxSize(this, R.dimen.view_size_16);
        setPadding(0, pxSize, 0, pxSize);
        LayoutInflater.from(getContext()).inflate(R.layout.view_amount_slider, (ViewGroup) this, true);
        int i3 = e.j.a.amountSlider;
        ((SeekBar) findViewById(i3)).setMax(100);
        ((SeekBar) findViewById(i3)).setOnSeekBarChangeListener(this);
    }
}