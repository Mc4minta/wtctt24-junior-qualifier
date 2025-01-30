package com.coinbase.cipherwebview.models.web3.json;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ScanQRCodeCallJson.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/json/ScanQRCodeCallParamsJson;", "", "", "component1", "()Ljava/lang/String;", "regExp", "copy", "(Ljava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/json/ScanQRCodeCallParamsJson;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRegExp", "<init>", "(Ljava/lang/String;)V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ScanQRCodeCallParamsJson {
    @Json(name = "regExp")
    private final String regExp;

    public ScanQRCodeCallParamsJson(String regExp) {
        m.g(regExp, "regExp");
        this.regExp = regExp;
    }

    public static /* synthetic */ ScanQRCodeCallParamsJson copy$default(ScanQRCodeCallParamsJson scanQRCodeCallParamsJson, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = scanQRCodeCallParamsJson.regExp;
        }
        return scanQRCodeCallParamsJson.copy(str);
    }

    public final String component1() {
        return this.regExp;
    }

    public final ScanQRCodeCallParamsJson copy(String regExp) {
        m.g(regExp, "regExp");
        return new ScanQRCodeCallParamsJson(regExp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScanQRCodeCallParamsJson) && m.c(this.regExp, ((ScanQRCodeCallParamsJson) obj).regExp);
    }

    public final String getRegExp() {
        return this.regExp;
    }

    public int hashCode() {
        return this.regExp.hashCode();
    }

    public String toString() {
        return "ScanQRCodeCallParamsJson(regExp=" + this.regExp + ')';
    }
}