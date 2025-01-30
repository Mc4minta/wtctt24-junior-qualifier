package e.j.n;

import com.toshi.model.local.room.CollectibleType;
import com.toshi.model.local.room.Erc721Token;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewErc721TokensViewModel.kt */
/* loaded from: classes2.dex */
public final class k3 extends androidx.lifecycle.b0 {
    private final e.j.i.y1 a;

    /* renamed from: b */
    private CollectibleType f13884b;

    /* renamed from: c */
    private final h.c.s<List<Erc721Token>> f13885c;

    public k3(e.j.i.y1 erc721Repository) {
        kotlin.jvm.internal.m.g(erc721Repository, "erc721Repository");
        this.a = erc721Repository;
        h.c.s map = erc721Repository.g().map(new h.c.m0.n() { // from class: e.j.n.p1
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return k3.e(k3.this, (List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "erc721Repository.collectiblesObservable\n        .map { tokens ->\n            tokens.filter {\n                it.contractAddress == collectibleType?.contractAddress\n            }\n        }");
        this.f13885c = map;
    }

    public static final List a(k3 this$0, List tokens) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(tokens, "tokens");
        ArrayList arrayList = new ArrayList();
        for (Object obj : tokens) {
            String contractAddress = ((Erc721Token) obj).getContractAddress();
            CollectibleType b2 = this$0.b();
            if (kotlin.jvm.internal.m.c(contractAddress, b2 == null ? null : b2.getContractAddress())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List e(k3 k3Var, List list) {
        return a(k3Var, list);
    }

    public final CollectibleType b() {
        return this.f13884b;
    }

    public final void c() {
        List<CollectibleType> b2;
        CollectibleType collectibleType = this.f13884b;
        if (collectibleType != null) {
            e.j.i.y1 y1Var = this.a;
            b2 = kotlin.a0.q.b(collectibleType);
            y1Var.v(b2).subscribe();
            return;
        }
        throw new IllegalStateException("Collectible Type is null.");
    }

    public final h.c.s<List<Erc721Token>> d() {
        return this.f13885c;
    }

    public final void f(CollectibleType collectibleType) {
        if (this.f13884b != null || collectibleType == null) {
            return;
        }
        this.f13884b = collectibleType;
        c();
    }
}