package com.coinbase.wallet.consumer.models;

import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerSignUpState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB1\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\f\u0010\u0004R%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSignUpState;", "", "", "component1", "()Z", "component2", "", "Lcom/coinbase/wallet/consumer/models/ConsumerSignUpState$SignupField;", "", "component3", "()Ljava/util/Map;", "isProgressLoading", "isNextButtonEnabled", "errorFields", "copy", "(ZZLjava/util/Map;)Lcom/coinbase/wallet/consumer/models/ConsumerSignUpState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/util/Map;", "getErrorFields", "<init>", "(ZZLjava/util/Map;)V", "SignupField", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSignUpState {
    private final Map<SignupField, String> errorFields;
    private final boolean isNextButtonEnabled;
    private final boolean isProgressLoading;

    /* compiled from: ConsumerSignUpState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSignUpState$SignupField;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_NAME", "LAST_NAME", "EMAIL", "PASSWORD", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum SignupField {
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        PASSWORD
    }

    public ConsumerSignUpState() {
        this(false, false, null, 7, null);
    }

    public ConsumerSignUpState(boolean z, boolean z2, Map<SignupField, String> errorFields) {
        m.g(errorFields, "errorFields");
        this.isProgressLoading = z;
        this.isNextButtonEnabled = z2;
        this.errorFields = errorFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsumerSignUpState copy$default(ConsumerSignUpState consumerSignUpState, boolean z, boolean z2, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = consumerSignUpState.isProgressLoading;
        }
        if ((i2 & 2) != 0) {
            z2 = consumerSignUpState.isNextButtonEnabled;
        }
        if ((i2 & 4) != 0) {
            map = consumerSignUpState.errorFields;
        }
        return consumerSignUpState.copy(z, z2, map);
    }

    public final boolean component1() {
        return this.isProgressLoading;
    }

    public final boolean component2() {
        return this.isNextButtonEnabled;
    }

    public final Map<SignupField, String> component3() {
        return this.errorFields;
    }

    public final ConsumerSignUpState copy(boolean z, boolean z2, Map<SignupField, String> errorFields) {
        m.g(errorFields, "errorFields");
        return new ConsumerSignUpState(z, z2, errorFields);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerSignUpState) {
            ConsumerSignUpState consumerSignUpState = (ConsumerSignUpState) obj;
            return this.isProgressLoading == consumerSignUpState.isProgressLoading && this.isNextButtonEnabled == consumerSignUpState.isNextButtonEnabled && m.c(this.errorFields, consumerSignUpState.errorFields);
        }
        return false;
    }

    public final Map<SignupField, String> getErrorFields() {
        return this.errorFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.isProgressLoading;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.isNextButtonEnabled;
        return ((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.errorFields.hashCode();
    }

    public final boolean isNextButtonEnabled() {
        return this.isNextButtonEnabled;
    }

    public final boolean isProgressLoading() {
        return this.isProgressLoading;
    }

    public String toString() {
        return "ConsumerSignUpState(isProgressLoading=" + this.isProgressLoading + ", isNextButtonEnabled=" + this.isNextButtonEnabled + ", errorFields=" + this.errorFields + ')';
    }

    public /* synthetic */ ConsumerSignUpState(boolean z, boolean z2, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? m0.i() : map);
    }
}