package com.coinbase.wallet.http.models;

import com.coinbase.ApiConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: QueryString.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/http/models/QueryString;", "", "", ApiConstants.NAME, "value", "Lkotlin/x;", "encode", "(Ljava/lang/String;Ljava/lang/String;)V", "add", "toString", "()Ljava/lang/String;", "query", "Ljava/lang/String;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class QueryString {
    private String query = "";

    private final void encode(String str, String str2) {
        try {
            String o = m.o(this.query, URLEncoder.encode(str, "UTF-8"));
            this.query = o;
            String o2 = m.o(o, "=");
            this.query = o2;
            this.query = m.o(o2, URLEncoder.encode(str2, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }

    public final void add(String name, String value) {
        m.g(name, "name");
        m.g(value, "value");
        this.query = m.o(this.query, "&");
        encode(name, value);
    }

    public String toString() {
        return this.query;
    }
}