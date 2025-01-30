package com.coinbase.walletlink.models;

import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ServerMessageType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\b\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/coinbase/walletlink/models/ServerMessageType;", "", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "", "isOK", "()Z", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "Event", Payload.RESPONSE_OK, "PublishEventOK", "SessionConfigUpdated", "GetSessionConfigOK", "Fail", "walletlink_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum ServerMessageType {
    Event("Event"),
    OK(Payload.RESPONSE_OK),
    PublishEventOK("PublishEventOK"),
    SessionConfigUpdated("SessionConfigUpdated"),
    GetSessionConfigOK("GetSessionConfigOK"),
    Fail("Fail");
    
    public static final Companion Companion = new Companion(null);
    private static final Map<String, ServerMessageType> mapping;
    private final String rawValue;

    /* compiled from: ServerMessageType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/coinbase/walletlink/models/ServerMessageType$Companion;", "", "", "rawValue", "Lcom/coinbase/walletlink/models/ServerMessageType;", "fromRawValue", "(Ljava/lang/String;)Lcom/coinbase/walletlink/models/ServerMessageType;", "", "mapping", "Ljava/util/Map;", "<init>", "()V", "walletlink_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServerMessageType fromRawValue(String rawValue) {
            m.g(rawValue, "rawValue");
            return (ServerMessageType) ServerMessageType.mapping.get(rawValue);
        }
    }

    /* compiled from: ServerMessageType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServerMessageType.values().length];
            iArr[ServerMessageType.OK.ordinal()] = 1;
            iArr[ServerMessageType.PublishEventOK.ordinal()] = 2;
            iArr[ServerMessageType.SessionConfigUpdated.ordinal()] = 3;
            iArr[ServerMessageType.GetSessionConfigOK.ordinal()] = 4;
            iArr[ServerMessageType.Fail.ordinal()] = 5;
            iArr[ServerMessageType.Event.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Map<String, ServerMessageType> r;
        ServerMessageType[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (ServerMessageType serverMessageType : values) {
            arrayList.add(u.a(serverMessageType.getRawValue(), serverMessageType));
        }
        r = m0.r(arrayList);
        mapping = r;
    }

    ServerMessageType(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public final boolean isOK() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}