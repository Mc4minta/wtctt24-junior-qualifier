package com.coinbase.ciphercore;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;

/* compiled from: CipherCoreBridge.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/coinbase/ciphercore/ResultMessage;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "id", "value", "error", "copy", "(ILjava/lang/String;Ljava/lang/String;)Lcom/coinbase/ciphercore/ResultMessage;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getValue", "getError", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "cipher-core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ResultMessage {
    @Json(name = "error")
    private final String error;
    @Json(name = "id")
    private final int id;
    @Json(name = "value")
    private final String value;

    public ResultMessage(int i2, String value, String str) {
        kotlin.jvm.internal.m.g(value, "value");
        this.id = i2;
        this.value = value;
        this.error = str;
    }

    public static /* synthetic */ ResultMessage copy$default(ResultMessage resultMessage, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = resultMessage.id;
        }
        if ((i3 & 2) != 0) {
            str = resultMessage.value;
        }
        if ((i3 & 4) != 0) {
            str2 = resultMessage.error;
        }
        return resultMessage.copy(i2, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.error;
    }

    public final ResultMessage copy(int i2, String value, String str) {
        kotlin.jvm.internal.m.g(value, "value");
        return new ResultMessage(i2, value, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResultMessage) {
            ResultMessage resultMessage = (ResultMessage) obj;
            return this.id == resultMessage.id && kotlin.jvm.internal.m.c(this.value, resultMessage.value) && kotlin.jvm.internal.m.c(this.error, resultMessage.error);
        }
        return false;
    }

    public final String getError() {
        return this.error;
    }

    public final int getId() {
        return this.id;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = ((this.id * 31) + this.value.hashCode()) * 31;
        String str = this.error;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ResultMessage(id=" + this.id + ", value=" + this.value + ", error=" + ((Object) this.error) + ')';
    }
}