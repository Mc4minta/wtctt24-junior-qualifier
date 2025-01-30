package com.coinbase.cipherwebview.models;

import android.webkit.JsResult;
import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: JSConfirm.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/cipherwebview/models/JSConfirm;", "", "", "component1", "()Ljava/lang/String;", "Landroid/webkit/JsResult;", "component2", "()Landroid/webkit/JsResult;", ApiConstants.MESSAGE, "handler", "copy", "(Ljava/lang/String;Landroid/webkit/JsResult;)Lcom/coinbase/cipherwebview/models/JSConfirm;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/webkit/JsResult;", "getHandler", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;Landroid/webkit/JsResult;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class JSConfirm {
    private final JsResult handler;
    private final String message;

    public JSConfirm(String message, JsResult handler) {
        m.g(message, "message");
        m.g(handler, "handler");
        this.message = message;
        this.handler = handler;
    }

    public static /* synthetic */ JSConfirm copy$default(JSConfirm jSConfirm, String str, JsResult jsResult, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = jSConfirm.message;
        }
        if ((i2 & 2) != 0) {
            jsResult = jSConfirm.handler;
        }
        return jSConfirm.copy(str, jsResult);
    }

    public final String component1() {
        return this.message;
    }

    public final JsResult component2() {
        return this.handler;
    }

    public final JSConfirm copy(String message, JsResult handler) {
        m.g(message, "message");
        m.g(handler, "handler");
        return new JSConfirm(message, handler);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JSConfirm) {
            JSConfirm jSConfirm = (JSConfirm) obj;
            return m.c(this.message, jSConfirm.message) && m.c(this.handler, jSConfirm.handler);
        }
        return false;
    }

    public final JsResult getHandler() {
        return this.handler;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.handler.hashCode();
    }

    public String toString() {
        return "JSConfirm(message=" + this.message + ", handler=" + this.handler + ')';
    }
}