package com.coinbase.wallet.lending.dtos;

import com.coinbase.wallet.lending.models.TxParams;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TxParamListDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/TxParamListResultDTO;", "", "", "Lcom/coinbase/wallet/lending/models/TxParams;", "txParamList", "Ljava/util/List;", "getTxParamList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TxParamListResultDTO {
    private final List<TxParams> txParamList;

    public TxParamListResultDTO(List<TxParams> txParamList) {
        m.g(txParamList, "txParamList");
        this.txParamList = txParamList;
    }

    public final List<TxParams> getTxParamList() {
        return this.txParamList;
    }
}