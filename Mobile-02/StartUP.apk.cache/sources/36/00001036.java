package com.coinbase.cipherwebview.models.web3;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.l0;
import kotlin.i0.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Web3CallMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/Web3CallMethod;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "SignEthereumMessage", "SignEthereumTransaction", "SubmitEthereumTransaction", "EthereumAddressFromSignedMessage", "MakeEthereumJSONRPCRequest", "ScanQRCode", "SwitchEthereumChain", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum Web3CallMethod {
    SignEthereumMessage("signEthereumMessage"),
    SignEthereumTransaction("signEthereumTransaction"),
    SubmitEthereumTransaction("submitEthereumTransaction"),
    EthereumAddressFromSignedMessage("ethereumAddressFromSignedMessage"),
    MakeEthereumJSONRPCRequest("makeEthereumJSONRPCRequest"),
    ScanQRCode("scanQRCode"),
    SwitchEthereumChain("switchEthereumChain");
    
    public static final Companion Companion = new Companion(null);
    private static final Map<String, Web3CallMethod> map;
    private final String value;

    /* compiled from: Web3CallMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/cipherwebview/models/web3/Web3CallMethod$Companion;", "", "", "v", "Lcom/coinbase/cipherwebview/models/web3/Web3CallMethod;", "fromValue", "(Ljava/lang/String;)Lcom/coinbase/cipherwebview/models/web3/Web3CallMethod;", "", "map", "Ljava/util/Map;", "<init>", "()V", "cipher-webview_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Web3CallMethod fromValue(String v) {
            m.g(v, "v");
            return (Web3CallMethod) Web3CallMethod.map.get(v);
        }
    }

    static {
        int d2;
        int b2;
        Web3CallMethod[] values = values();
        d2 = l0.d(values.length);
        b2 = f.b(d2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (Web3CallMethod web3CallMethod : values) {
            linkedHashMap.put(web3CallMethod.getValue(), web3CallMethod);
        }
        map = linkedHashMap;
    }

    Web3CallMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}