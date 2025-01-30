package com.coinbase.wallet.txhistory.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.txhistory.R;
import com.coinbase.wallet.txhistory.models.RecipientType;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.x;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: RecipientImageView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/txhistory/views/RecipientImageView;", "Landroid/widget/FrameLayout;", "Lcom/coinbase/wallet/txhistory/models/RecipientType;", "recipientType", "", MessageBundle.TITLE_ENTRY, "Lkotlin/x;", "update", "(Lcom/coinbase/wallet/txhistory/models/RecipientType;Ljava/lang/String;)V", "Landroid/widget/ImageView;", "coinbaseView", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "userView", "Landroid/widget/TextView;", "addressView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "txhistory_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class RecipientImageView extends FrameLayout {
    private final ImageView addressView;
    private final ImageView coinbaseView;
    private final TextView userView;

    /* compiled from: RecipientImageView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipientType.values().length];
            iArr[RecipientType.Address.ordinal()] = 1;
            iArr[RecipientType.ENS.ordinal()] = 2;
            iArr[RecipientType.User.ordinal()] = 3;
            iArr[RecipientType.Coinbase.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecipientImageView(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecipientImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ RecipientImageView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void update(RecipientType recipientType, String str) {
        m.g(recipientType, "recipientType");
        int i2 = WhenMappings.$EnumSwitchMapping$0[recipientType.ordinal()];
        if (i2 == 1 || i2 == 2) {
            this.coinbaseView.setVisibility(8);
            this.addressView.setVisibility(0);
            this.userView.setVisibility(8);
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            this.coinbaseView.setVisibility(0);
            this.addressView.setVisibility(8);
            this.userView.setVisibility(8);
        } else {
            this.coinbaseView.setVisibility(8);
            this.addressView.setVisibility(8);
            this.userView.setVisibility(0);
            if (!(str == null || str.length() == 0) && (str.length() != 1 || !m.c(String.valueOf(str.charAt(0)), Strings_CoreKt.getAt(Strings.INSTANCE)))) {
                x.Q(str, Strings_CoreKt.getAt(Strings.INSTANCE), false, 2, null);
                char charAt = str.charAt(1);
                TextView textView = this.userView;
                String valueOf = String.valueOf(charAt);
                Locale US = Locale.US;
                m.f(US, "US");
                Objects.requireNonNull(valueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = valueOf.toUpperCase(US);
                m.f(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                textView.setText(upperCase);
                return;
            }
            this.userView.setText(Strings_CoreKt.getAt(Strings.INSTANCE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipientImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        LayoutInflater.from(context).inflate(R.layout.recipient_image_view, this);
        View findViewById = findViewById(R.id.monogram);
        m.f(findViewById, "findViewById(R.id.monogram)");
        TextView textView = (TextView) findViewById;
        this.userView = textView;
        View findViewById2 = findViewById(R.id.coinbaseIcon);
        m.f(findViewById2, "findViewById(R.id.coinbaseIcon)");
        ImageView imageView = (ImageView) findViewById2;
        this.coinbaseView = imageView;
        View findViewById3 = findViewById(R.id.walletIcon);
        m.f(findViewById3, "findViewById(R.id.walletIcon)");
        ImageView imageView2 = (ImageView) findViewById3;
        this.addressView = imageView2;
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecipientImageView);
        m.f(obtainStyledAttributes, "context.obtainStyledAttributes(it, R.styleable.RecipientImageView)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RecipientImageView_imagePadding, -1);
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize >= 0) {
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            int i3 = (int) (dimensionPixelSize * 1.5d);
            imageView.setPadding(i3, i3, i3, i3);
            imageView2.setPadding(i3, i3, i3, i3);
        }
    }
}