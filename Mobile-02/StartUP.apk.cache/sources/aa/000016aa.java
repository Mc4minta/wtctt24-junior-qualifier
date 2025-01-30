package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CreatingUserError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/consumer/models/CreatingUserError;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "id", "field", ApiConstants.MESSAGE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/CreatingUserError;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getField", "getId", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CreatingUserError {
    private final String field;
    private final String id;
    private final String message;

    public CreatingUserError(String id, String field, String message) {
        m.g(id, "id");
        m.g(field, "field");
        m.g(message, "message");
        this.id = id;
        this.field = field;
        this.message = message;
    }

    public static /* synthetic */ CreatingUserError copy$default(CreatingUserError creatingUserError, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = creatingUserError.id;
        }
        if ((i2 & 2) != 0) {
            str2 = creatingUserError.field;
        }
        if ((i2 & 4) != 0) {
            str3 = creatingUserError.message;
        }
        return creatingUserError.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.field;
    }

    public final String component3() {
        return this.message;
    }

    public final CreatingUserError copy(String id, String field, String message) {
        m.g(id, "id");
        m.g(field, "field");
        m.g(message, "message");
        return new CreatingUserError(id, field, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CreatingUserError) {
            CreatingUserError creatingUserError = (CreatingUserError) obj;
            return m.c(this.id, creatingUserError.id) && m.c(this.field, creatingUserError.field) && m.c(this.message, creatingUserError.message);
        }
        return false;
    }

    public final String getField() {
        return this.field;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.field.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "CreatingUserError(id=" + this.id + ", field=" + this.field + ", message=" + this.message + ')';
    }
}