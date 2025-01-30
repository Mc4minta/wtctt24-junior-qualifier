package com.coinbase.wallet.common.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.exceptions.RPCException;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RPCError.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J.\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/coinbase/wallet/common/models/RPCError;", "", "Lcom/coinbase/wallet/common/exceptions/RPCException;", "asException", "()Lcom/coinbase/wallet/common/exceptions/RPCException;", "", "component1", "()Ljava/lang/String;", "component2", "component3", ApiConstants.MESSAGE, ApiConstants.DESCRIPTION, "code", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/common/models/RPCError;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "getDescription", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPCError {
    private final String code;
    private final String description;
    private final String message;

    public RPCError(String message, String description, String code) {
        m.g(message, "message");
        m.g(description, "description");
        m.g(code, "code");
        this.message = message;
        this.description = description;
        this.code = code;
    }

    public static /* synthetic */ RPCError copy$default(RPCError rPCError, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rPCError.message;
        }
        if ((i2 & 2) != 0) {
            str2 = rPCError.description;
        }
        if ((i2 & 4) != 0) {
            str3 = rPCError.code;
        }
        return rPCError.copy(str, str2, str3);
    }

    public final RPCException asException() {
        return new RPCException(this.message, this.description, this.code);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.code;
    }

    public final RPCError copy(String message, String description, String code) {
        m.g(message, "message");
        m.g(description, "description");
        m.g(code, "code");
        return new RPCError(message, description, code);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RPCError) {
            RPCError rPCError = (RPCError) obj;
            return m.c(this.message, rPCError.message) && m.c(this.description, rPCError.description) && m.c(this.code, rPCError.code);
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.description.hashCode()) * 31) + this.code.hashCode();
    }

    public String toString() {
        return "RPCError(message=" + this.message + ", description=" + this.description + ", code=" + this.code + ')';
    }
}