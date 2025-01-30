package com.coinbase.wallet.features.signer.interfaces;

import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import h.c.s;
import kotlin.Metadata;

/* compiled from: RequestSigning.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/features/signer/interfaces/RequestSigning;", "", "Lh/c/s;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "getSigningSessionEvents", "()Lh/c/s;", "signingSessionEvents", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface RequestSigning {
    s<SigningSessionEvent> getSigningSessionEvents();
}