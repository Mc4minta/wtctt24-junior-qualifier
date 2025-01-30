package com.coinbase.cipherwebview.models.web3.call;

import com.coinbase.cipherwebview.models.web3.json.ScanQRCodeCallJson;
import com.coinbase.cipherwebview.models.web3.json.Web3CallResponse;
import com.coinbase.cipherwebview.util.Regex_CipherWebViewKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.k;

/* compiled from: ScanQRCodeCall.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\tJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\r\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\t¨\u0006 "}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/ScanQRCodeCall;", "Lcom/coinbase/cipherwebview/models/web3/call/Web3Call;", "", "scannedString", "Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "createResponse", "(Ljava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/json/Web3CallResponse;", "", "component1", "()I", "Lkotlin/l0/k;", "component2", "()Lkotlin/l0/k;", "id", "regExp", "copy", "(ILkotlin/l0/k;)Lcom/coinbase/cipherwebview/models/web3/call/ScanQRCodeCall;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/l0/k;", "getRegExp", "I", "getId", "<init>", "(ILkotlin/l0/k;)V", "Companion", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ScanQRCodeCall extends Web3Call {
    public static final Companion Companion = new Companion(null);
    private final int id;
    private final k regExp;

    /* compiled from: ScanQRCodeCall.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/call/ScanQRCodeCall$Companion;", "", "Lcom/coinbase/cipherwebview/models/web3/json/ScanQRCodeCallJson;", "json", "Lcom/coinbase/cipherwebview/models/web3/call/ScanQRCodeCall;", "fromJson$cipher_webview_release", "(Lcom/coinbase/cipherwebview/models/web3/json/ScanQRCodeCallJson;)Lcom/coinbase/cipherwebview/models/web3/call/ScanQRCodeCall;", "fromJson", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ScanQRCodeCall fromJson$cipher_webview_release(ScanQRCodeCallJson scanQRCodeCallJson) {
            k fromJSRegExp;
            if (scanQRCodeCallJson == null || (fromJSRegExp = Regex_CipherWebViewKt.fromJSRegExp(k.a, scanQRCodeCallJson.getParams().getRegExp())) == null) {
                return null;
            }
            return new ScanQRCodeCall(scanQRCodeCallJson.getId(), fromJSRegExp);
        }
    }

    public ScanQRCodeCall(int i2, k regExp) {
        m.g(regExp, "regExp");
        this.id = i2;
        this.regExp = regExp;
    }

    public static /* synthetic */ ScanQRCodeCall copy$default(ScanQRCodeCall scanQRCodeCall, int i2, k kVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = scanQRCodeCall.getId();
        }
        if ((i3 & 2) != 0) {
            kVar = scanQRCodeCall.regExp;
        }
        return scanQRCodeCall.copy(i2, kVar);
    }

    public final int component1() {
        return getId();
    }

    public final k component2() {
        return this.regExp;
    }

    public final ScanQRCodeCall copy(int i2, k regExp) {
        m.g(regExp, "regExp");
        return new ScanQRCodeCall(i2, regExp);
    }

    public final Web3CallResponse createResponse(String scannedString) {
        m.g(scannedString, "scannedString");
        return new Web3CallResponse(getId(), null, scannedString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScanQRCodeCall) {
            ScanQRCodeCall scanQRCodeCall = (ScanQRCodeCall) obj;
            return getId() == scanQRCodeCall.getId() && m.c(this.regExp, scanQRCodeCall.regExp);
        }
        return false;
    }

    @Override // com.coinbase.cipherwebview.models.web3.call.Web3Call
    public int getId() {
        return this.id;
    }

    public final k getRegExp() {
        return this.regExp;
    }

    public int hashCode() {
        return (getId() * 31) + this.regExp.hashCode();
    }

    public String toString() {
        return "ScanQRCodeCall(id=" + getId() + ", regExp=" + this.regExp + ')';
    }
}