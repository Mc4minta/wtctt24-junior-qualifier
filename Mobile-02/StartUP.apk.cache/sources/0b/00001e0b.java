package com.coinbase.wallet.features.collectibles;

import com.toshi.model.local.room.CollectibleType;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectibleTypesTabFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public /* synthetic */ class CollectibleTypesTabFragment$initAdapter$1 extends k implements l<CollectibleType, x> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CollectibleTypesTabFragment$initAdapter$1(CollectibleTypesTabFragment collectibleTypesTabFragment) {
        super(1, collectibleTypesTabFragment, CollectibleTypesTabFragment.class, "navigateToViewErc721TokensFragment", "navigateToViewErc721TokensFragment(Lcom/toshi/model/local/room/CollectibleType;)V", 0);
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(CollectibleType collectibleType) {
        invoke2(collectibleType);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(CollectibleType p0) {
        m.g(p0, "p0");
        ((CollectibleTypesTabFragment) this.receiver).navigateToViewErc721TokensFragment(p0);
    }
}