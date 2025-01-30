package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coinbase.wallet.consumer.R;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SimpleAmountInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001,B\u001d\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006-"}, d2 = {"Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/coinbase/wallet/consumer/views/AmountInputNumberView;", "view", "", "number", "", "letters", "Lkotlin/x;", "setViewAttributes", "(Lcom/coinbase/wallet/consumer/views/AmountInputNumberView;ILjava/lang/CharSequence;)V", "onFinishInflate", "()V", "", "show", "showDecimal", "(Z)V", "Ljava/text/NumberFormat;", "numberFormat$delegate", "Lkotlin/h;", "getNumberFormat", "()Ljava/text/NumberFormat;", "numberFormat", "showLetters", "Z", "showDecimalSeparator", "Ljava/text/DecimalFormatSymbols;", "decimalFormatSymbols$delegate", "getDecimalFormatSymbols", "()Ljava/text/DecimalFormatSymbols;", "decimalFormatSymbols", "Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView$Listeners;", "listeners", "Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView$Listeners;", "getListeners", "()Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView$Listeners;", "setListeners", "(Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView$Listeners;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Listeners", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SimpleAmountInputView extends ConstraintLayout {
    private final kotlin.h decimalFormatSymbols$delegate;
    private Listeners listeners;
    private final kotlin.h numberFormat$delegate;
    private final boolean showDecimalSeparator;
    private final boolean showLetters;

    /* compiled from: SimpleAmountInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/consumer/views/SimpleAmountInputView$Listeners;", "", "Lkotlin/x;", "onBackspaceClick", "()V", "onDecimalClick", "", "number", "onNumberClick", "(I)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Listeners {
        void onBackspaceClick();

        void onDecimalClick();

        void onNumberClick(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleAmountInputView(Context context) {
        this(context, null, 2, null);
        kotlin.jvm.internal.m.g(context, "context");
    }

    public /* synthetic */ SimpleAmountInputView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ void a(SimpleAmountInputView simpleAmountInputView, View view) {
        m1048onFinishInflate$lambda0(simpleAmountInputView, view);
    }

    public static /* synthetic */ void b(SimpleAmountInputView simpleAmountInputView, View view) {
        m1049onFinishInflate$lambda1(simpleAmountInputView, view);
    }

    public static /* synthetic */ void c(SimpleAmountInputView simpleAmountInputView, int i2, View view) {
        m1050setViewAttributes$lambda2(simpleAmountInputView, i2, view);
    }

    private final DecimalFormatSymbols getDecimalFormatSymbols() {
        return (DecimalFormatSymbols) this.decimalFormatSymbols$delegate.getValue();
    }

    private final NumberFormat getNumberFormat() {
        Object value = this.numberFormat$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-numberFormat>(...)");
        return (NumberFormat) value;
    }

    /* renamed from: onFinishInflate$lambda-0 */
    public static final void m1048onFinishInflate$lambda0(SimpleAmountInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Listeners listeners = this$0.getListeners();
        if (listeners == null) {
            return;
        }
        listeners.onDecimalClick();
    }

    /* renamed from: onFinishInflate$lambda-1 */
    public static final void m1049onFinishInflate$lambda1(SimpleAmountInputView this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Listeners listeners = this$0.getListeners();
        if (listeners == null) {
            return;
        }
        listeners.onBackspaceClick();
    }

    private final void setViewAttributes(AmountInputNumberView amountInputNumberView, final int i2, CharSequence charSequence) {
        amountInputNumberView.setNumber(getNumberFormat().format(Integer.valueOf(i2)));
        amountInputNumberView.setLetters(charSequence);
        amountInputNumberView.setShowLetters(this.showLetters);
        amountInputNumberView.setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.consumer.views.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleAmountInputView.c(SimpleAmountInputView.this, i2, view);
            }
        });
    }

    /* renamed from: setViewAttributes$lambda-2 */
    public static final void m1050setViewAttributes$lambda2(SimpleAmountInputView this$0, int i2, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Listeners listeners = this$0.getListeners();
        if (listeners == null) {
            return;
        }
        listeners.onNumberClick(i2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final Listeners getListeners() {
        return this.listeners;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.view_simple_amount_input_inner, this);
        AmountInputNumberView vOne = (AmountInputNumberView) findViewById(R.id.vOne);
        kotlin.jvm.internal.m.f(vOne, "vOne");
        setViewAttributes(vOne, 1, "abc");
        AmountInputNumberView vTwo = (AmountInputNumberView) findViewById(R.id.vTwo);
        kotlin.jvm.internal.m.f(vTwo, "vTwo");
        setViewAttributes(vTwo, 2, "def");
        AmountInputNumberView vThree = (AmountInputNumberView) findViewById(R.id.vThree);
        kotlin.jvm.internal.m.f(vThree, "vThree");
        setViewAttributes(vThree, 3, "ghi");
        AmountInputNumberView vFour = (AmountInputNumberView) findViewById(R.id.vFour);
        kotlin.jvm.internal.m.f(vFour, "vFour");
        setViewAttributes(vFour, 4, "jkl");
        AmountInputNumberView vFive = (AmountInputNumberView) findViewById(R.id.vFive);
        kotlin.jvm.internal.m.f(vFive, "vFive");
        setViewAttributes(vFive, 5, "mno");
        AmountInputNumberView vSix = (AmountInputNumberView) findViewById(R.id.vSix);
        kotlin.jvm.internal.m.f(vSix, "vSix");
        setViewAttributes(vSix, 6, "pqrs");
        AmountInputNumberView vSeven = (AmountInputNumberView) findViewById(R.id.vSeven);
        kotlin.jvm.internal.m.f(vSeven, "vSeven");
        setViewAttributes(vSeven, 7, "tuv");
        AmountInputNumberView vEight = (AmountInputNumberView) findViewById(R.id.vEight);
        kotlin.jvm.internal.m.f(vEight, "vEight");
        setViewAttributes(vEight, 8, "wxyz");
        AmountInputNumberView vNine = (AmountInputNumberView) findViewById(R.id.vNine);
        kotlin.jvm.internal.m.f(vNine, "vNine");
        setViewAttributes(vNine, 9, null);
        AmountInputNumberView vZero = (AmountInputNumberView) findViewById(R.id.vZero);
        kotlin.jvm.internal.m.f(vZero, "vZero");
        setViewAttributes(vZero, 0, null);
        int i2 = R.id.vDecimal;
        ((Button) findViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.consumer.views.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleAmountInputView.a(SimpleAmountInputView.this, view);
            }
        });
        ((Button) findViewById(i2)).setText(String.valueOf(getDecimalFormatSymbols().getMonetaryDecimalSeparator()));
        Button vDecimal = (Button) findViewById(i2);
        kotlin.jvm.internal.m.f(vDecimal, "vDecimal");
        vDecimal.setVisibility(true ^ this.showDecimalSeparator ? 4 : 0);
        ((ImageButton) findViewById(R.id.vBackspace)).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.consumer.views.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleAmountInputView.b(SimpleAmountInputView.this, view);
            }
        });
    }

    public final void setListeners(Listeners listeners) {
        this.listeners = listeners;
    }

    public final void showDecimal(boolean z) {
        Button vDecimal = (Button) findViewById(R.id.vDecimal);
        kotlin.jvm.internal.m.f(vDecimal, "vDecimal");
        vDecimal.setVisibility(z ^ true ? 4 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleAmountInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.h b2;
        kotlin.h b3;
        kotlin.jvm.internal.m.g(context, "context");
        b2 = kotlin.k.b(SimpleAmountInputView$decimalFormatSymbols$2.INSTANCE);
        this.decimalFormatSymbols$delegate = b2;
        b3 = kotlin.k.b(SimpleAmountInputView$numberFormat$2.INSTANCE);
        this.numberFormat$delegate = b3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SimpleAmountInputView);
        kotlin.jvm.internal.m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.SimpleAmountInputView)");
        this.showDecimalSeparator = obtainStyledAttributes.getBoolean(R.styleable.SimpleAmountInputView_show_decimal_separator, false);
        this.showLetters = obtainStyledAttributes.getBoolean(R.styleable.SimpleAmountInputView_show_letters, false);
        obtainStyledAttributes.recycle();
    }
}