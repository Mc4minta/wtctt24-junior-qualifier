package com.coinbase.wallet.ethereum.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ETHCallDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/ethereum/dtos/ETHCallDTO;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "jsonrpc", "id", "result", "copy", "(Ljava/lang/String;ILjava/lang/String;)Lcom/coinbase/wallet/ethereum/dtos/ETHCallDTO;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "Ljava/lang/String;", "getResult", "getJsonrpc", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ETHCallDTO {
    private final int id;
    private final String jsonrpc;
    private final String result;

    public ETHCallDTO(String jsonrpc, int i2, String result) {
        m.g(jsonrpc, "jsonrpc");
        m.g(result, "result");
        this.jsonrpc = jsonrpc;
        this.id = i2;
        this.result = result;
    }

    public static /* synthetic */ ETHCallDTO copy$default(ETHCallDTO eTHCallDTO, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = eTHCallDTO.jsonrpc;
        }
        if ((i3 & 2) != 0) {
            i2 = eTHCallDTO.id;
        }
        if ((i3 & 4) != 0) {
            str2 = eTHCallDTO.result;
        }
        return eTHCallDTO.copy(str, i2, str2);
    }

    public final String component1() {
        return this.jsonrpc;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.result;
    }

    public final ETHCallDTO copy(String jsonrpc, int i2, String result) {
        m.g(jsonrpc, "jsonrpc");
        m.g(result, "result");
        return new ETHCallDTO(jsonrpc, i2, result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ETHCallDTO) {
            ETHCallDTO eTHCallDTO = (ETHCallDTO) obj;
            return m.c(this.jsonrpc, eTHCallDTO.jsonrpc) && this.id == eTHCallDTO.id && m.c(this.result, eTHCallDTO.result);
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final String getJsonrpc() {
        return this.jsonrpc;
    }

    public final String getResult() {
        return this.result;
    }

    public int hashCode() {
        return (((this.jsonrpc.hashCode() * 31) + this.id) * 31) + this.result.hashCode();
    }

    public String toString() {
        return "ETHCallDTO(jsonrpc=" + this.jsonrpc + ", id=" + this.id + ", result=" + this.result + ')';
    }
}