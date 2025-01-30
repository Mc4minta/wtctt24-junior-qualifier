package com.toshi.model.local;

import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.toshi.model.local.authentication.AuthenticationMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppLockSettingsViewState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/toshi/model/local/AppLockSettingsViewState;", "", "Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "component1", "()Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "component2", "()Lcom/toshi/model/local/authentication/AuthenticationMethod;", "biometricsProtectionType", "authenticationMethod", "copy", "(Lcom/coinbase/wallet/application/model/BiometricsProtectionType;Lcom/toshi/model/local/authentication/AuthenticationMethod;)Lcom/toshi/model/local/AppLockSettingsViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "getBiometricsProtectionType", "Lcom/toshi/model/local/authentication/AuthenticationMethod;", "getAuthenticationMethod", "<init>", "(Lcom/coinbase/wallet/application/model/BiometricsProtectionType;Lcom/toshi/model/local/authentication/AuthenticationMethod;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class AppLockSettingsViewState {
    private final AuthenticationMethod authenticationMethod;
    private final BiometricsProtectionType biometricsProtectionType;

    public AppLockSettingsViewState() {
        this(null, null, 3, null);
    }

    public AppLockSettingsViewState(BiometricsProtectionType biometricsProtectionType, AuthenticationMethod authenticationMethod) {
        this.biometricsProtectionType = biometricsProtectionType;
        this.authenticationMethod = authenticationMethod;
    }

    public static /* synthetic */ AppLockSettingsViewState copy$default(AppLockSettingsViewState appLockSettingsViewState, BiometricsProtectionType biometricsProtectionType, AuthenticationMethod authenticationMethod, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            biometricsProtectionType = appLockSettingsViewState.biometricsProtectionType;
        }
        if ((i2 & 2) != 0) {
            authenticationMethod = appLockSettingsViewState.authenticationMethod;
        }
        return appLockSettingsViewState.copy(biometricsProtectionType, authenticationMethod);
    }

    public final BiometricsProtectionType component1() {
        return this.biometricsProtectionType;
    }

    public final AuthenticationMethod component2() {
        return this.authenticationMethod;
    }

    public final AppLockSettingsViewState copy(BiometricsProtectionType biometricsProtectionType, AuthenticationMethod authenticationMethod) {
        return new AppLockSettingsViewState(biometricsProtectionType, authenticationMethod);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppLockSettingsViewState) {
            AppLockSettingsViewState appLockSettingsViewState = (AppLockSettingsViewState) obj;
            return this.biometricsProtectionType == appLockSettingsViewState.biometricsProtectionType && this.authenticationMethod == appLockSettingsViewState.authenticationMethod;
        }
        return false;
    }

    public final AuthenticationMethod getAuthenticationMethod() {
        return this.authenticationMethod;
    }

    public final BiometricsProtectionType getBiometricsProtectionType() {
        return this.biometricsProtectionType;
    }

    public int hashCode() {
        BiometricsProtectionType biometricsProtectionType = this.biometricsProtectionType;
        int hashCode = (biometricsProtectionType == null ? 0 : biometricsProtectionType.hashCode()) * 31;
        AuthenticationMethod authenticationMethod = this.authenticationMethod;
        return hashCode + (authenticationMethod != null ? authenticationMethod.hashCode() : 0);
    }

    public String toString() {
        return "AppLockSettingsViewState(biometricsProtectionType=" + this.biometricsProtectionType + ", authenticationMethod=" + this.authenticationMethod + ')';
    }

    public /* synthetic */ AppLockSettingsViewState(BiometricsProtectionType biometricsProtectionType, AuthenticationMethod authenticationMethod, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : biometricsProtectionType, (i2 & 2) != 0 ? null : authenticationMethod);
    }
}