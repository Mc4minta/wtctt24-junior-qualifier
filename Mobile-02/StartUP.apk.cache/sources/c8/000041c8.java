package com.toshi.view.activity.webView;

import com.appsflyer.share.Constants;
import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CbWalletJavascriptInterface.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0003\u0010\fR\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\n\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/toshi/view/activity/webView/Message;", "", "", "a", "I", "b", "()I", "id", "", "", Constants.URL_CAMPAIGN, "Ljava/util/List;", "()Ljava/util/List;", "data", "Ljava/lang/String;", "()Ljava/lang/String;", ApiConstants.NAME, "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Message {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11145b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f11146c;

    public Message(int i2, String name, List<String> data) {
        m.g(name, "name");
        m.g(data, "data");
        this.a = i2;
        this.f11145b = name;
        this.f11146c = data;
    }

    public final List<String> a() {
        return this.f11146c;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.f11145b;
    }
}