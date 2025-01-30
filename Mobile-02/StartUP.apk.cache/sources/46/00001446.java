package com.coinbase.wallet.common.exceptions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RPCException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001 B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J.\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001d\u0010\u0018\u001a\u00060\u0001j\u0002`\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0005R\u0019\u0010\n\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001d\u0010\u0005¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/common/exceptions/RPCException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "component1", "()Ljava/lang/String;", "component2", "component3", ApiConstants.MESSAGE, ApiConstants.DESCRIPTION, "code", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/common/exceptions/RPCException;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "exception", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "getMessage", "getCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ErrorCodes", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RPCException extends Exception {
    private final String code;
    private final String description;
    private final Exception exception;
    private final String message;

    /* compiled from: RPCException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/common/exceptions/RPCException$ErrorCodes;", "", "", ErrorCodes.invalidAddress, "Ljava/lang/String;", ErrorCodes.invalidParams, ErrorCodes.invalidAuthenticationToken, "<init>", "()V", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ErrorCodes {
        public static final ErrorCodes INSTANCE = new ErrorCodes();
        public static final String invalidAddress = "invalidAddress";
        public static final String invalidAuthenticationToken = "invalidAuthenticationToken";
        public static final String invalidParams = "invalidParams";

        private ErrorCodes() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RPCException(String message, String description, String code) {
        super(message);
        m.g(message, "message");
        m.g(description, "description");
        m.g(code, "code");
        this.message = message;
        this.description = description;
        this.code = code;
        this.exception = new Exception(getMessage());
    }

    public static /* synthetic */ RPCException copy$default(RPCException rPCException, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rPCException.getMessage();
        }
        if ((i2 & 2) != 0) {
            str2 = rPCException.description;
        }
        if ((i2 & 4) != 0) {
            str3 = rPCException.code;
        }
        return rPCException.copy(str, str2, str3);
    }

    public final String component1() {
        return getMessage();
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.code;
    }

    public final RPCException copy(String message, String description, String code) {
        m.g(message, "message");
        m.g(description, "description");
        m.g(code, "code");
        return new RPCException(message, description, code);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RPCException) {
            RPCException rPCException = (RPCException) obj;
            return m.c(getMessage(), rPCException.getMessage()) && m.c(this.description, rPCException.description) && m.c(this.code, rPCException.code);
        }
        return false;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Exception getException() {
        return this.exception;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((getMessage().hashCode() * 31) + this.description.hashCode()) * 31) + this.code.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "RPCException(message=" + getMessage() + ", description=" + this.description + ", code=" + this.code + ')';
    }
}