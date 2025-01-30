package com.coinbase.walletlink.extensions;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: URI+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/net/Uri;", "", "getDomain", "(Landroid/net/Uri;)Ljava/lang/String;", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class URI_WalletLinkKt {
    public static final String getDomain(Uri uri) {
        m.g(uri, "<this>");
        String scheme = uri.getScheme();
        String host = uri.getHost();
        return ((Object) scheme) + "://" + ((Object) host);
    }
}