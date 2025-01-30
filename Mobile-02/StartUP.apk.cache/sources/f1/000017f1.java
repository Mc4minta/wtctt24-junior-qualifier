package com.coinbase.wallet.consumer.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.extensions.Context_ConsumerKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.spongycastle.i18n.TextBundle;

/* compiled from: AmountInputNumberView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\bR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/views/AmountInputNumberView;", "Landroid/widget/LinearLayout;", "Lkotlin/x;", "onFinishInflate", "()V", "", TextBundle.TEXT_ENTRY, "setLetters", "(Ljava/lang/CharSequence;)V", "setNumber", "", "value", "getShowLetters", "()Z", "setShowLetters", "(Z)V", "showLetters", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountInputNumberView extends LinearLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmountInputNumberView(Context context) {
        this(context, null, 2, null);
        kotlin.jvm.internal.m.g(context, "context");
    }

    public /* synthetic */ AmountInputNumberView(Context context, AttributeSet attributeSet, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getShowLetters() {
        return ((TextView) findViewById(R.id.letters)).getVisibility() == 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        kotlin.jvm.internal.m.f(context, "context");
        setBackground(Context_ConsumerKt.getAttrDrawable(context, R.attr.selectableItemBackground));
        setGravity(17);
        setOrientation(1);
        View.inflate(getContext(), R.layout.view_amount_input_number_inner, this);
    }

    public final void setLetters(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.letters);
        if (charSequence == null) {
            charSequence = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        textView.setText(charSequence);
    }

    public final void setNumber(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(R.id.number);
        if (charSequence == null) {
            charSequence = Strings_CoreKt.getEmpty(Strings.INSTANCE);
        }
        textView.setText(charSequence);
    }

    public final void setShowLetters(boolean z) {
        TextView letters = (TextView) findViewById(R.id.letters);
        kotlin.jvm.internal.m.f(letters, "letters");
        letters.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountInputNumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
    }
}