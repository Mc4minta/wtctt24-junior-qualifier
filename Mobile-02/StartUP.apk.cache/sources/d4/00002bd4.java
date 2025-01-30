package com.coinbase.walletlink.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.o;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: Strings+WalletLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "<anonymous>", "()Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class Strings_WalletLinkKt$destroySession$2 extends o implements kotlin.e0.c.a<String> {
    public static final Strings_WalletLinkKt$destroySession$2 INSTANCE = new Strings_WalletLinkKt$destroySession$2();

    Strings_WalletLinkKt$destroySession$2() {
        super(0);
    }

    @Override // kotlin.e0.c.a
    public final String invoke() {
        return DiskLruCache.VERSION_1;
    }
}