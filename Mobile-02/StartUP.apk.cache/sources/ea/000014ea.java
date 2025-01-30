package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.commonui.R;
import com.coinbase.wallet.commonui.extensions.CharSequence_CommonKt;
import com.coinbase.wallet.commonui.extensions.ImageView_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CurrencyPickerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0012¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R$\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010+\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0014R\u0016\u0010,\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(R*\u0010-\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u0006R$\u0010\u000e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR$\u00106\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00188B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u0016\u00107\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010(R\u0016\u00108\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010(R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lcom/coinbase/wallet/commonui/views/CurrencyPickerView;", "Landroid/widget/FrameLayout;", "", "isVisible", "Lkotlin/x;", "toggleErrorLabel", "(Z)V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "setCoin", "(Lcom/coinbase/wallet/blockchains/models/Wallet;)V", "", "imageURL", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "displayName", "fillDetails", "(Ljava/lang/String;Lcom/coinbase/wallet/blockchains/models/CurrencyCode;Ljava/lang/String;)V", "", "currencyTextColor", "I", "Landroid/view/View;", "container", "Landroid/view/View;", "", "value", "getFiatBalance", "()Ljava/lang/CharSequence;", "setFiatBalance", "(Ljava/lang/CharSequence;)V", "fiatBalance", "errorBackgroundTint", "getCryptoBalance", "setCryptoBalance", "cryptoBalance", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Landroid/widget/TextView;", "errorLabel", "Landroid/widget/TextView;", "fallbackIcon", "currencyCodeView", "backgroundTint", "cryptoBalanceView", "insufficientBalance", "Z", "getInsufficientBalance", "()Z", "setInsufficientBalance", "getCurrencyCode", "setCurrencyCode", "getCurrencyName", "setCurrencyName", "currencyName", "currencyNameView", "fiatBalanceView", "Landroid/widget/ImageView;", "currencyIcon", "Landroid/widget/ImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CurrencyPickerView extends FrameLayout {
    private final int backgroundTint;
    private final View container;
    private final TextView cryptoBalanceView;
    private final TextView currencyCodeView;
    private final ImageView currencyIcon;
    private final TextView currencyNameView;
    private final int currencyTextColor;
    private final h.c.k0.a disposeBag;
    private final int errorBackgroundTint;
    private final TextView errorLabel;
    private final TextView fallbackIcon;
    private final TextView fiatBalanceView;
    private boolean insufficientBalance;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrencyPickerView(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrencyPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ CurrencyPickerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final CharSequence getCurrencyCode() {
        CharSequence text = this.currencyCodeView.getText();
        m.f(text, "currencyCodeView.text");
        return text;
    }

    private final CharSequence getCurrencyName() {
        CharSequence text = this.currencyNameView.getText();
        m.f(text, "currencyNameView.text");
        return text;
    }

    private final void setCurrencyCode(CharSequence charSequence) {
        this.currencyCodeView.setText(charSequence);
    }

    private final void setCurrencyName(CharSequence charSequence) {
        this.currencyNameView.setText(charSequence);
    }

    private final void toggleErrorLabel(boolean z) {
        if ((this.errorLabel.getVisibility() == 0) == z) {
            return;
        }
        if (z) {
            View_CommonKt.forceMeasure(this.errorLabel);
        }
        this.errorLabel.getLayoutParams().height = z ? this.errorLabel.getMeasuredHeight() : 1;
        this.errorLabel.requestLayout();
        this.errorLabel.setVisibility(z ? 0 : 4);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void fillDetails(String str, CurrencyCode currencyCode, String displayName) {
        m.g(currencyCode, "currencyCode");
        m.g(displayName, "displayName");
        if (str != null) {
            ImageView_CommonKt.load$default(this.currencyIcon, str, 0, null, 6, null);
        } else {
            this.fallbackIcon.setText(CharSequence_CommonKt.buildTickerText(currencyCode.getRawValue()));
        }
        this.fallbackIcon.setVisibility(str == null ? 0 : 8);
        setCurrencyName(displayName);
        setCurrencyCode(currencyCode.getRawValue());
    }

    public final CharSequence getCryptoBalance() {
        CharSequence text = this.cryptoBalanceView.getText();
        m.f(text, "cryptoBalanceView.text");
        return text;
    }

    public final CharSequence getFiatBalance() {
        return this.fiatBalanceView.getText();
    }

    public final boolean getInsufficientBalance() {
        return this.insufficientBalance;
    }

    public final void setCoin(Wallet wallet) {
        m.g(wallet, "wallet");
        URL imageURL = wallet.getImageURL();
        fillDetails(imageURL == null ? null : imageURL.toString(), wallet.getCurrencyCode(), wallet.getDisplayName());
    }

    public final void setCryptoBalance(CharSequence value) {
        m.g(value, "value");
        this.cryptoBalanceView.setText(value);
    }

    public final void setFiatBalance(CharSequence charSequence) {
        this.fiatBalanceView.setVisibility(charSequence != null ? 0 : 8);
        this.fiatBalanceView.setText(charSequence);
    }

    public final void setInsufficientBalance(boolean z) {
        if (this.insufficientBalance == z) {
            return;
        }
        this.insufficientBalance = z;
        toggleErrorLabel(z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencyPickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        h.c.k0.a aVar = new h.c.k0.a();
        this.disposeBag = aVar;
        LayoutInflater.from(context).inflate(R.layout.view_currency_picker, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CurrencyPickerView, 0, 0);
        try {
            int color = obtainStyledAttributes.getColor(R.styleable.CurrencyPickerView_backgroundTint, -1);
            this.backgroundTint = color;
            int color2 = obtainStyledAttributes.getColor(R.styleable.CurrencyPickerView_errorBackgroundTint, -16777216);
            this.errorBackgroundTint = color2;
            int color3 = obtainStyledAttributes.getColor(R.styleable.CurrencyPickerView_currencyTextColor, -16777216);
            this.currencyTextColor = color3;
            obtainStyledAttributes.recycle();
            View findViewById = findViewById(R.id.container);
            m.f(findViewById, "findViewById(R.id.container)");
            this.container = findViewById;
            View findViewById2 = findViewById(R.id.errorLabel);
            m.f(findViewById2, "findViewById(R.id.errorLabel)");
            TextView textView = (TextView) findViewById2;
            this.errorLabel = textView;
            textView.setClipToOutline(true);
            h.c.k0.b subscribe = View_CommonKt.collapse$default(textView, false, 0L, 2, null).subscribeOn(h.c.j0.c.a.b()).subscribe();
            m.f(subscribe, "errorLabel.collapse(false).subscribeOn(AndroidSchedulers.mainThread()).subscribe()");
            h.c.t0.a.a(subscribe, aVar);
            textView.setBackgroundTintList(ColorStateList.valueOf(color2));
            findViewById.setBackgroundTintList(ColorStateList.valueOf(color));
            View findViewById3 = findViewById(R.id.currencyIcon);
            m.f(findViewById3, "findViewById(R.id.currencyIcon)");
            this.currencyIcon = (ImageView) findViewById3;
            View findViewById4 = findViewById(R.id.currencyName);
            m.f(findViewById4, "findViewById(R.id.currencyName)");
            TextView textView2 = (TextView) findViewById4;
            this.currencyNameView = textView2;
            textView2.setTextColor(color3);
            View findViewById5 = findViewById(R.id.currencyCode);
            m.f(findViewById5, "findViewById(R.id.currencyCode)");
            TextView textView3 = (TextView) findViewById5;
            this.currencyCodeView = textView3;
            textView3.setTextColor(color3);
            View findViewById6 = findViewById(R.id.fiatBalance);
            m.f(findViewById6, "findViewById(R.id.fiatBalance)");
            TextView textView4 = (TextView) findViewById6;
            this.fiatBalanceView = textView4;
            textView4.setTextColor(color3);
            View findViewById7 = findViewById(R.id.cryptoBalance);
            m.f(findViewById7, "findViewById(R.id.cryptoBalance)");
            TextView textView5 = (TextView) findViewById7;
            this.cryptoBalanceView = textView5;
            textView5.setTextColor(color3);
            View findViewById8 = findViewById(R.id.fallbackIcon);
            m.f(findViewById8, "findViewById(R.id.fallbackIcon)");
            this.fallbackIcon = (TextView) findViewById8;
            setClickable(true);
            setFocusable(true);
            setClipToOutline(true);
            setClipChildren(true);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}