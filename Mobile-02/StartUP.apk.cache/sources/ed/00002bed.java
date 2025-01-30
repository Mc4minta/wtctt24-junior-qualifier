package com.coinbase.walletlink.models;

import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.j0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: RequestMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0080\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/walletlink/models/RequestMethod;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "ChildRequestEthereumAccounts", "RequestEthereumAccounts", "SwitchEthereumChain", "SignEthereumMessage", "SignEthereumTransaction", "SubmitEthereumTransaction", "RequestCanceled", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum RequestMethod {
    ChildRequestEthereumAccounts("childRequestEthereumAccounts"),
    RequestEthereumAccounts("requestEthereumAccounts"),
    SwitchEthereumChain("switchEthereumChain"),
    SignEthereumMessage("signEthereumMessage"),
    SignEthereumTransaction("signEthereumTransaction"),
    SubmitEthereumTransaction("submitEthereumTransaction"),
    RequestCanceled("requestCanceled");
    
    public static final Companion Companion = new Companion(null);
    private static final Map<String, RequestMethod> mapping;
    private final String rawValue;

    /* compiled from: RequestMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/walletlink/models/RequestMethod$Companion;", "", "", "rawValue", "Lcom/coinbase/walletlink/models/RequestMethod;", "fromRawValue", "(Ljava/lang/String;)Lcom/coinbase/walletlink/models/RequestMethod;", "", "mapping", "Ljava/util/Map;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RequestMethod fromRawValue(String rawValue) {
            m.g(rawValue, "rawValue");
            return (RequestMethod) RequestMethod.mapping.get(rawValue);
        }
    }

    static {
        RequestMethod[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (RequestMethod requestMethod : values) {
            arrayList.add(u.a(requestMethod.getRawValue(), requestMethod));
        }
        mapping = j0.r(arrayList);
    }

    RequestMethod(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}