package com.coinbase.wallet.commonui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.R;
import com.coinbase.wallet.commonui.views.NumberKeyboardInputView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.a0.j;
import kotlin.a0.s;
import kotlin.e0.c.p;
import kotlin.h;
import kotlin.i0.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.k;
import kotlin.x;

/* compiled from: NumberKeyboardInputView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00041234B'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\r¢\u0006\u0004\b/\u00100J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010#\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010)\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00065"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "", "longPress", "Lkotlin/x;", "handleDigitClicked", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$OnDigitPressedListener;", "listener", "setOnDigitPressedListener", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$OnDigitPressedListener;)V", "", "value", "getTextColorResId", "()I", "setTextColorResId", "(I)V", "textColorResId", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$NumberKeyboardInputAdapter;", "digitAdapter$delegate", "Lkotlin/h;", "getDigitAdapter", "()Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$NumberKeyboardInputAdapter;", "digitAdapter", "getTextSizeResId", "setTextSizeResId", "textSizeResId", "onDigitPressedListener", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$OnDigitPressedListener;", "getHideDecimal", "()Z", "setHideDecimal", "(Z)V", "hideDecimal", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", ApiConstants.LOCALE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "NumberKeyboardInputAdapter", "OnDigitPressedListener", "ViewHolder", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class NumberKeyboardInputView extends RecyclerView {
    public static final Companion Companion = new Companion(null);
    private final h digitAdapter$delegate;
    private OnDigitPressedListener onDigitPressedListener;

    /* compiled from: NumberKeyboardInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$Companion;", "", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NumberKeyboardInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\u0004\b/\u00100J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00058\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010!R*\u0010\"\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010!R*\u0010%\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190+8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$NumberKeyboardInputAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$ViewHolder;", "getItemCount", "()I", "holder", "position", "Lkotlin/x;", "onBindViewHolder", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$ViewHolder;I)V", "Ljava/util/Locale;", "value", ApiConstants.LOCALE, "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "Lkotlin/Function2;", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "", "listener", "Lkotlin/e0/c/p;", "textColorResId", "I", "getTextColorResId", "setTextColorResId", "(I)V", "textSizeResId", "getTextSizeResId", "setTextSizeResId", "hideDecimal", "Z", "getHideDecimal", "()Z", "setHideDecimal", "(Z)V", "", "getKeys", "()[Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "keys", "<init>", "(Lkotlin/e0/c/p;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NumberKeyboardInputAdapter extends RecyclerView.g<ViewHolder> {
        private boolean hideDecimal;
        private final p<NumberKeyboardDigit, Boolean, x> listener;
        private Locale locale;
        private int textColorResId;
        private int textSizeResId;

        /* JADX WARN: Multi-variable type inference failed */
        public NumberKeyboardInputAdapter(p<? super NumberKeyboardDigit, ? super Boolean, x> listener) {
            m.g(listener, "listener");
            this.listener = listener;
            Locale locale = Locale.getDefault();
            m.f(locale, "getDefault()");
            this.locale = locale;
            this.textColorResId = R.color.white;
            this.textSizeResId = R.dimen.text_size_20;
        }

        private final NumberKeyboardDigit[] getKeys() {
            int r;
            kotlin.i0.c j2;
            NumberKeyboardDigit[] values = NumberKeyboardDigit.values();
            ArrayList<NumberKeyboardDigit> arrayList = new ArrayList(values.length);
            for (NumberKeyboardDigit numberKeyboardDigit : values) {
                arrayList.add(numberKeyboardDigit);
            }
            r = s.r(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(r);
            for (NumberKeyboardDigit numberKeyboardDigit2 : arrayList) {
                arrayList2.add(numberKeyboardDigit2);
            }
            Object[] array = arrayList2.toArray(new NumberKeyboardDigit[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            j2 = f.j(0, 12);
            return (NumberKeyboardDigit[]) j.U(array, j2);
        }

        public final boolean getHideDecimal() {
            return this.hideDecimal;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return getKeys().length;
        }

        public final Locale getLocale() {
            return this.locale;
        }

        public final int getTextColorResId() {
            return this.textColorResId;
        }

        public final int getTextSizeResId() {
            return this.textSizeResId;
        }

        public final void setHideDecimal(boolean z) {
            this.hideDecimal = z;
            notifyDataSetChanged();
        }

        public final void setLocale(Locale value) {
            m.g(value, "value");
            this.locale = value;
            notifyDataSetChanged();
        }

        public final void setTextColorResId(int i2) {
            this.textColorResId = i2;
            notifyDataSetChanged();
        }

        public final void setTextSizeResId(int i2) {
            this.textSizeResId = i2;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onBindViewHolder(ViewHolder holder, int i2) {
            m.g(holder, "holder");
            holder.bind(getKeys()[i2], this.listener, this.locale, this.textColorResId, this.hideDecimal);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
            m.g(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_keyboard_digit, parent, false);
            m.f(view, "view");
            return new ViewHolder(view, this.textSizeResId);
        }
    }

    /* compiled from: NumberKeyboardInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$OnDigitPressedListener;", "", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "", "longPress", "Lkotlin/x;", "onDigitPressed", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface OnDigitPressedListener {
        void onDigitPressed(NumberKeyboardDigit numberKeyboardDigit, boolean z);
    }

    /* compiled from: NumberKeyboardInputView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJG\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013¨\u0006 "}, d2 = {"Lcom/coinbase/wallet/commonui/views/NumberKeyboardInputView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "Lkotlin/Function2;", "", "Lkotlin/x;", "listener", "Ljava/util/Locale;", ApiConstants.LOCALE, "", "textColor", "hideDecimal", "bind", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Lkotlin/e0/c/p;Ljava/util/Locale;IZ)V", "", "regularTextSize$delegate", "Lkotlin/h;", "getRegularTextSize", "()F", "regularTextSize", "deleteTextSizeMultiplier$delegate", "getDeleteTextSizeMultiplier", "deleteTextSizeMultiplier", "deleteTextSize$delegate", "getDeleteTextSize", "deleteTextSize", "Landroid/view/View;", "itemView", "textSizeResId", "<init>", "(Landroid/view/View;I)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ViewHolder extends RecyclerView.e0 {
        private final h deleteTextSize$delegate;
        private final h deleteTextSizeMultiplier$delegate;
        private final h regularTextSize$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView, int i2) {
            super(itemView);
            h b2;
            h b3;
            h b4;
            m.g(itemView, "itemView");
            b2 = k.b(new NumberKeyboardInputView$ViewHolder$regularTextSize$2(itemView, i2));
            this.regularTextSize$delegate = b2;
            b3 = k.b(new NumberKeyboardInputView$ViewHolder$deleteTextSizeMultiplier$2(itemView));
            this.deleteTextSizeMultiplier$delegate = b3;
            b4 = k.b(new NumberKeyboardInputView$ViewHolder$deleteTextSize$2(this));
            this.deleteTextSize$delegate = b4;
        }

        public static /* synthetic */ void a(p pVar, NumberKeyboardDigit numberKeyboardDigit, Button button, View view) {
            m814bind$lambda2$lambda0(pVar, numberKeyboardDigit, button, view);
        }

        public static /* synthetic */ boolean b(p pVar, NumberKeyboardDigit numberKeyboardDigit, Button button, View view) {
            return m815bind$lambda2$lambda1(pVar, numberKeyboardDigit, button, view);
        }

        /* renamed from: bind$lambda-2$lambda-0 */
        public static final void m814bind$lambda2$lambda0(p listener, NumberKeyboardDigit digit, Button this_apply, View view) {
            m.g(listener, "$listener");
            m.g(digit, "$digit");
            m.g(this_apply, "$this_apply");
            listener.invoke(digit, Boolean.FALSE);
            this_apply.performHapticFeedback(3);
        }

        /* renamed from: bind$lambda-2$lambda-1 */
        public static final boolean m815bind$lambda2$lambda1(p listener, NumberKeyboardDigit digit, Button this_apply, View view) {
            m.g(listener, "$listener");
            m.g(digit, "$digit");
            m.g(this_apply, "$this_apply");
            listener.invoke(digit, Boolean.TRUE);
            return this_apply.performHapticFeedback(0);
        }

        private final float getDeleteTextSize() {
            return ((Number) this.deleteTextSize$delegate.getValue()).floatValue();
        }

        public final float getDeleteTextSizeMultiplier() {
            return ((Number) this.deleteTextSizeMultiplier$delegate.getValue()).floatValue();
        }

        public final float getRegularTextSize() {
            return ((Number) this.regularTextSize$delegate.getValue()).floatValue();
        }

        public final void bind(final NumberKeyboardDigit digit, final p<? super NumberKeyboardDigit, ? super Boolean, x> listener, Locale locale, int i2, boolean z) {
            m.g(digit, "digit");
            m.g(listener, "listener");
            m.g(locale, "locale");
            View view = this.itemView;
            final Button button = (Button) view;
            int d2 = androidx.core.content.a.d(((Button) view).getContext(), i2);
            button.setText(digit.localized(locale).getDescription());
            boolean z2 = true;
            button.setHapticFeedbackEnabled(true);
            button.setTextColor(d2);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.commonui.views.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NumberKeyboardInputView.ViewHolder.a(p.this, digit, button, view2);
                }
            });
            if (digit == NumberKeyboardDigit.Delete) {
                button.setTextSize(0, getDeleteTextSize());
                button.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coinbase.wallet.commonui.views.c
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return NumberKeyboardInputView.ViewHolder.b(p.this, digit, button, view2);
                    }
                });
            } else {
                button.setTextSize(0, getRegularTextSize());
                button.setOnLongClickListener(null);
            }
            if (!z || digit != NumberKeyboardDigit.DecimalSeparator) {
                z2 = false;
            }
            button.setVisibility(z2 ? 4 : 0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumberKeyboardInputView(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumberKeyboardInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ NumberKeyboardInputView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final NumberKeyboardInputAdapter getDigitAdapter() {
        return (NumberKeyboardInputAdapter) this.digitAdapter$delegate.getValue();
    }

    public final void handleDigitClicked(NumberKeyboardDigit numberKeyboardDigit, boolean z) {
        OnDigitPressedListener onDigitPressedListener = this.onDigitPressedListener;
        if (onDigitPressedListener == null) {
            return;
        }
        onDigitPressedListener.onDigitPressed(numberKeyboardDigit, z);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean getHideDecimal() {
        return getDigitAdapter().getHideDecimal();
    }

    public final Locale getLocale() {
        return getDigitAdapter().getLocale();
    }

    public final int getTextColorResId() {
        return getDigitAdapter().getTextColorResId();
    }

    public final int getTextSizeResId() {
        return getDigitAdapter().getTextSizeResId();
    }

    public final void setHideDecimal(boolean z) {
        getDigitAdapter().setHideDecimal(z);
    }

    public final void setLocale(Locale value) {
        m.g(value, "value");
        getDigitAdapter().setLocale(value);
    }

    public final void setOnDigitPressedListener(OnDigitPressedListener listener) {
        m.g(listener, "listener");
        this.onDigitPressedListener = listener;
    }

    public final void setTextColorResId(int i2) {
        getDigitAdapter().setTextColorResId(i2);
    }

    public final void setTextSizeResId(int i2) {
        getDigitAdapter().setTextSizeResId(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NumberKeyboardInputView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h b2;
        m.g(context, "context");
        b2 = k.b(new NumberKeyboardInputView$digitAdapter$2(this));
        this.digitAdapter$delegate = b2;
        setLayoutManager(new GridLayoutManager(context, 3));
        setAdapter(getDigitAdapter());
        setOverScrollMode(2);
    }
}