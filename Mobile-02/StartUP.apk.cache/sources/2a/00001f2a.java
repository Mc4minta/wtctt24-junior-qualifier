package com.coinbase.wallet.features.ofac.repositories;

import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.coinbase.wallet.features.ofac.apis.OFACApi;
import h.c.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: OFACRepository.kt */
@ApplicationScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/ofac/repositories/OFACRepository;", "", "Lh/c/b0;", "", "isBannedLocation", "()Lh/c/b0;", "Lcom/coinbase/wallet/features/ofac/apis/OFACApi;", "ofacApi", "Lcom/coinbase/wallet/features/ofac/apis/OFACApi;", "<init>", "(Lcom/coinbase/wallet/features/ofac/apis/OFACApi;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class OFACRepository {
    private final OFACApi ofacApi;

    public OFACRepository(OFACApi ofacApi) {
        m.g(ofacApi, "ofacApi");
        this.ofacApi = ofacApi;
    }

    public final b0<Boolean> isBannedLocation() {
        return this.ofacApi.checkIfOFACBanned();
    }
}