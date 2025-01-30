package com.coinbase.wallet.bip44wallets.models;

import com.coinbase.ApiConstants;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: BIP44CoinSelection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ:\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0005R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\n¨\u0006!"}, d2 = {"Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "", "", "Lcom/coinbase/wallet/bip44wallets/models/BIP44UTXO;", "component1", "()Ljava/util/List;", "Lcom/coinbase/wallet/bip44wallets/models/BIP44Output;", "component2", "Ljava/math/BigInteger;", "component3", "()Ljava/math/BigInteger;", "inputs", "outputs", ApiConstants.FEE, "copy", "(Ljava/util/List;Ljava/util/List;Ljava/math/BigInteger;)Lcom/coinbase/wallet/bip44wallets/models/BIP44CoinSelection;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOutputs", "getInputs", "Ljava/math/BigInteger;", "getFee", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/math/BigInteger;)V", "bip44wallets_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BIP44CoinSelection {
    private final BigInteger fee;
    private final List<BIP44UTXO> inputs;
    private final List<BIP44Output> outputs;

    public BIP44CoinSelection(List<BIP44UTXO> inputs, List<BIP44Output> outputs, BigInteger fee) {
        m.g(inputs, "inputs");
        m.g(outputs, "outputs");
        m.g(fee, "fee");
        this.inputs = inputs;
        this.outputs = outputs;
        this.fee = fee;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BIP44CoinSelection copy$default(BIP44CoinSelection bIP44CoinSelection, List list, List list2, BigInteger bigInteger, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = bIP44CoinSelection.inputs;
        }
        if ((i2 & 2) != 0) {
            list2 = bIP44CoinSelection.outputs;
        }
        if ((i2 & 4) != 0) {
            bigInteger = bIP44CoinSelection.fee;
        }
        return bIP44CoinSelection.copy(list, list2, bigInteger);
    }

    public final List<BIP44UTXO> component1() {
        return this.inputs;
    }

    public final List<BIP44Output> component2() {
        return this.outputs;
    }

    public final BigInteger component3() {
        return this.fee;
    }

    public final BIP44CoinSelection copy(List<BIP44UTXO> inputs, List<BIP44Output> outputs, BigInteger fee) {
        m.g(inputs, "inputs");
        m.g(outputs, "outputs");
        m.g(fee, "fee");
        return new BIP44CoinSelection(inputs, outputs, fee);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BIP44CoinSelection) {
            BIP44CoinSelection bIP44CoinSelection = (BIP44CoinSelection) obj;
            return m.c(this.inputs, bIP44CoinSelection.inputs) && m.c(this.outputs, bIP44CoinSelection.outputs) && m.c(this.fee, bIP44CoinSelection.fee);
        }
        return false;
    }

    public final BigInteger getFee() {
        return this.fee;
    }

    public final List<BIP44UTXO> getInputs() {
        return this.inputs;
    }

    public final List<BIP44Output> getOutputs() {
        return this.outputs;
    }

    public int hashCode() {
        return (((this.inputs.hashCode() * 31) + this.outputs.hashCode()) * 31) + this.fee.hashCode();
    }

    public String toString() {
        return "BIP44CoinSelection(inputs=" + this.inputs + ", outputs=" + this.outputs + ", fee=" + this.fee + ')';
    }
}