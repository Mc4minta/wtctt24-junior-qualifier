package com.coinbase.cipherwebview.models;

import com.squareup.moshi.Moshi;
import kotlin.Metadata;

/* compiled from: moshi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\"$\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00008\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "cipher-webview_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MoshiKt {
    private static final Moshi moshi = new Moshi.Builder().build();

    public static final Moshi getMoshi() {
        return moshi;
    }
}