package com.toshi.model.local.authentication;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AuthenticationMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/toshi/model/local/authentication/AuthenticationMethod;", "", "", "rawValue", "I", "getRawValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "BIOMETRIC", "PIN", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum AuthenticationMethod {
    BIOMETRIC(1),
    PIN(2);
    
    public static final Companion Companion = new Companion(null);
    private final int rawValue;

    /* compiled from: AuthenticationMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/toshi/model/local/authentication/AuthenticationMethod$Companion;", "", "", "rawValue", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "get", "(I)Lcom/toshi/model/local/authentication/AuthenticationMethod;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AuthenticationMethod get(int i2) {
            AuthenticationMethod authenticationMethod = AuthenticationMethod.BIOMETRIC;
            if (i2 == authenticationMethod.getRawValue()) {
                return authenticationMethod;
            }
            AuthenticationMethod authenticationMethod2 = AuthenticationMethod.PIN;
            if (i2 == authenticationMethod2.getRawValue()) {
                return authenticationMethod2;
            }
            return null;
        }
    }

    AuthenticationMethod(int i2) {
        this.rawValue = i2;
    }

    public final int getRawValue() {
        return this.rawValue;
    }
}