package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: LabelsEditText.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/LabelsEditText;", "Landroid/widget/RelativeLayout;", "", "value", "getLeftLabelText", "()Ljava/lang/CharSequence;", "setLeftLabelText", "(Ljava/lang/CharSequence;)V", "leftLabelText", "getRightLabelText", "setRightLabelText", "rightLabelText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LabelsEditText extends RelativeLayout {

    /* compiled from: LabelsEditText.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "Lkotlin/x;", "<anonymous>", "(Landroid/view/View;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.application.view.custom.LabelsEditText$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends o implements l<View, x> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View it) {
            m.g(it, "it");
            ((TextInputEditText) LabelsEditText.this.findViewById(e.j.a.edit_text)).requestFocus();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LabelsEditText(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LabelsEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ LabelsEditText(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final CharSequence getLeftLabelText() {
        return ((TextView) findViewById(e.j.a.leftLabel)).getText();
    }

    public final CharSequence getRightLabelText() {
        return ((TextView) findViewById(e.j.a.rightLabel)).getText();
    }

    public final void setLeftLabelText(CharSequence charSequence) {
        ((TextView) findViewById(e.j.a.leftLabel)).setText(charSequence);
    }

    public final void setRightLabelText(CharSequence charSequence) {
        int i2 = e.j.a.rightLabel;
        TextView rightLabel = (TextView) findViewById(i2);
        m.f(rightLabel, "rightLabel");
        rightLabel.setVisibility(true ^ (charSequence == null || charSequence.length() == 0) ? 0 : 8);
        ((TextView) findViewById(i2)).setText(charSequence);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelsEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        View.inflate(context, R.layout.view_labels_edit_text, this).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View_CommonKt.setOnSingleClickListener$default(this, 0L, new AnonymousClass1(), 1, null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.b.s0);
        CharSequence text = obtainStyledAttributes.getText(1);
        setLeftLabelText(text == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : text);
        CharSequence text2 = obtainStyledAttributes.getText(2);
        setRightLabelText(text2 == null ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : text2);
        ((TextInputEditText) findViewById(e.j.a.edit_text)).setInputType(obtainStyledAttributes.getInt(0, 1));
        obtainStyledAttributes.recycle();
    }
}