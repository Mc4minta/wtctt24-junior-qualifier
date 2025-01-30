package com.coinbase.cipherwebview;

import android.webkit.WebResourceRequest;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.o;

/* compiled from: CipherWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/webkit/WebResourceRequest;", "<anonymous parameter 0>", "", "<anonymous>", "(Landroid/webkit/WebResourceRequest;)Z"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class CipherWebView$shouldOverrideUrlLoading$1 extends o implements l<WebResourceRequest, Boolean> {
    public static final CipherWebView$shouldOverrideUrlLoading$1 INSTANCE = new CipherWebView$shouldOverrideUrlLoading$1();

    CipherWebView$shouldOverrideUrlLoading$1() {
        super(1);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ Boolean invoke(WebResourceRequest webResourceRequest) {
        return Boolean.valueOf(invoke2(webResourceRequest));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(WebResourceRequest webResourceRequest) {
        return false;
    }
}