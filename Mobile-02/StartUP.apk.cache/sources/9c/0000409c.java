package com.toshi.model.local;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: DerivationPath.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/toshi/model/local/DerivationPath;", "", "", "get", "()Ljava/lang/String;", "", "index", "getWithIndex", "(I)Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "Companion", "IDENTITY_KEY_PATH", "PAYMENT_KEY_PATH", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum DerivationPath {
    IDENTITY_KEY_PATH,
    PAYMENT_KEY_PATH;
    
    public static final Companion Companion = new Companion(null);
    private static final String ID_PATH = "m/0'/1/0";
    private static final String PAYMENT_PATH = "m/44'/60'/0'/0/";

    /* compiled from: DerivationPath.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/toshi/model/local/DerivationPath$Companion;", "", "", "ID_PATH", "Ljava/lang/String;", "PAYMENT_PATH", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DerivationPath.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DerivationPath.values().length];
            iArr[DerivationPath.IDENTITY_KEY_PATH.ordinal()] = 1;
            iArr[DerivationPath.PAYMENT_KEY_PATH.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String get() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalStateException("You need to provide an index. Use getWithIndex(index) instead");
        }
        return ID_PATH;
    }

    public final String getWithIndex(int i2) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return m.o(PAYMENT_PATH, Integer.valueOf(i2));
            }
            throw new NoWhenBranchMatchedException();
        }
        return String.valueOf(IDENTITY_KEY_PATH);
    }
}