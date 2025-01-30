package com.coinbase.wallet.features.signer.interfaces;

import androidx.lifecycle.b0;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import h.c.s;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: StackedRequestItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0013\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00148F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "R", "Landroidx/lifecycle/b0;", "getViewState", "()Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "setViewState", "(Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;)V", "viewState", "Lh/c/v0/b;", "Lcom/coinbase/wallet/features/signer/models/SigningSessionEvent;", "kotlin.jvm.PlatformType", "signatureRequestEventSubject", "Lh/c/v0/b;", "getSignatureRequestEventSubject", "()Lh/c/v0/b;", "", "getUuid", "()Ljava/lang/String;", "uuid", "Lh/c/s;", "signatureRequestEvents$delegate", "Lkotlin/h;", "getSignatureRequestEvents", "()Lh/c/s;", "signatureRequestEvents", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class StackedRequestItem<R extends SignatureRequestViewState> extends b0 {
    private final b<SigningSessionEvent> signatureRequestEventSubject;
    private final h signatureRequestEvents$delegate;

    public StackedRequestItem() {
        h b2;
        b<SigningSessionEvent> d2 = b.d();
        m.f(d2, "create<SigningSessionEvent>()");
        this.signatureRequestEventSubject = d2;
        b2 = k.b(new StackedRequestItem$signatureRequestEvents$2(this));
        this.signatureRequestEvents$delegate = b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b<SigningSessionEvent> getSignatureRequestEventSubject() {
        return this.signatureRequestEventSubject;
    }

    public final s<SigningSessionEvent> getSignatureRequestEvents() {
        Object value = this.signatureRequestEvents$delegate.getValue();
        m.f(value, "<get-signatureRequestEvents>(...)");
        return (s) value;
    }

    public final String getUuid() {
        return getViewState().getUuid();
    }

    public abstract R getViewState();

    public abstract void setViewState(R r);
}