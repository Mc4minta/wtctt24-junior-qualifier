package com.coinbase.wallet.features.commonui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: TokenAvatarView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eB#\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\n\u0010\u0011J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/features/commonui/views/TokenAvatarView;", "Landroid/widget/FrameLayout;", "", "symbol", "url", "Lkotlin/x;", "load", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TokenAvatarView extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenAvatarView(Context context) {
        super(context);
        m.g(context, "context");
        FrameLayout.inflate(getContext(), R.layout.view_coin_avatar, this);
    }

    public static /* synthetic */ void load$default(TokenAvatarView tokenAvatarView, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        tokenAvatarView.load(str, str2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void load(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            if (r8 == 0) goto Lc
            boolean r1 = kotlin.l0.o.D(r8)
            if (r1 == 0) goto La
            goto Lc
        La:
            r1 = r0
            goto Ld
        Lc:
            r1 = 1
        Ld:
            r2 = 4
            if (r1 == 0) goto L34
            int r8 = e.j.a.avatarImageView
            android.view.View r8 = r6.findViewById(r8)
            de.hdodenhof.circleimageview.CircleImageView r8 = (de.hdodenhof.circleimageview.CircleImageView) r8
            r8.setVisibility(r2)
            int r8 = e.j.a.defaultTokenAvatar
            android.view.View r1 = r6.findViewById(r8)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setVisibility(r0)
            android.view.View r8 = r6.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.CharSequence r7 = com.coinbase.wallet.commonui.extensions.CharSequence_CommonKt.buildTickerText(r7)
            r8.setText(r7)
            goto L5e
        L34:
            int r7 = e.j.a.avatarImageView
            android.view.View r1 = r6.findViewById(r7)
            de.hdodenhof.circleimageview.CircleImageView r1 = (de.hdodenhof.circleimageview.CircleImageView) r1
            r1.setVisibility(r0)
            int r0 = e.j.a.defaultTokenAvatar
            android.view.View r0 = r6.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r0.setVisibility(r2)
            android.view.View r7 = r6.findViewById(r7)
            r0 = r7
            de.hdodenhof.circleimageview.CircleImageView r0 = (de.hdodenhof.circleimageview.CircleImageView) r0
            java.lang.String r7 = "avatarImageView"
            kotlin.jvm.internal.m.f(r0, r7)
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r1 = r8
            com.coinbase.wallet.commonui.extensions.ImageView_CommonKt.load$default(r0, r1, r2, r3, r4, r5)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.commonui.views.TokenAvatarView.load(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenAvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m.g(context, "context");
        m.g(attrs, "attrs");
        FrameLayout.inflate(getContext(), R.layout.view_coin_avatar, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenAvatarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        FrameLayout.inflate(getContext(), R.layout.view_coin_avatar, this);
    }
}