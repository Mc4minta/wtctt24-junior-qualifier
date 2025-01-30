package com.coinbase.walletengine.services.btclike;

import com.coinbase.ApiConstants;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BTCLikeService.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/coinbase/walletengine/services/btclike/CoinSelection;", "", "", "Lcom/coinbase/walletengine/services/btclike/UTXO;", "component1", "()Ljava/util/List;", "Lcom/coinbase/walletengine/services/btclike/Output;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "inputs", "outputs", ApiConstants.FEE, "copy", "(Ljava/util/List;Ljava/util/List;Ljava/math/BigInteger;)Lcom/coinbase/walletengine/services/btclike/CoinSelection;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOutputs", "Ljava/math/BigInteger;", "getFee", "getInputs", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/math/BigInteger;)V", "wallet-engine_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CoinSelection {
    @Json(name = ApiConstants.FEE)
    private final BigInteger fee;
    @Json(name = "inputs")
    private final List<UTXO> inputs;
    @Json(name = "outputs")
    private final List<Output> outputs;

    public CoinSelection(List<UTXO> inputs, List<Output> outputs, BigInteger fee) {
        m.g(inputs, "inputs");
        m.g(outputs, "outputs");
        m.g(fee, "fee");
        this.inputs = inputs;
        this.outputs = outputs;
        this.fee = fee;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoinSelection copy$default(CoinSelection coinSelection, List list, List list2, BigInteger bigInteger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = coinSelection.inputs;
        }
        if ((i2 & 2) != 0) {
            list2 = coinSelection.outputs;
        }
        if ((i2 & 4) != 0) {
            bigInteger = coinSelection.fee;
        }
        return coinSelection.copy(list, list2, bigInteger);
    }

    public final List<UTXO> component1() {
        return this.inputs;
    }

    public final List<Output> component2() {
        return this.outputs;
    }

    public final BigInteger component3() {
        return this.fee;
    }

    public final CoinSelection copy(List<UTXO> inputs, List<Output> outputs, BigInteger fee) {
        m.g(inputs, "inputs");
        m.g(outputs, "outputs");
        m.g(fee, "fee");
        return new CoinSelection(inputs, outputs, fee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CoinSelection) {
            CoinSelection coinSelection = (CoinSelection) obj;
            return m.c(this.inputs, coinSelection.inputs) && m.c(this.outputs, coinSelection.outputs) && m.c(this.fee, coinSelection.fee);
        }
        return false;
    }

    public final BigInteger getFee() {
        return this.fee;
    }

    public final List<UTXO> getInputs() {
        return this.inputs;
    }

    public final List<Output> getOutputs() {
        return this.outputs;
    }

    public int hashCode() {
        return (((this.inputs.hashCode() * 31) + this.outputs.hashCode()) * 31) + this.fee.hashCode();
    }

    public String toString() {
        return "CoinSelection(inputs=" + this.inputs + ", outputs=" + this.outputs + ", fee=" + this.fee + ')';
    }
}