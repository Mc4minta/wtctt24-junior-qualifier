package com.toshi.db.h;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.q;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.toshi.model.local.room.CollectibleType;
import h.c.b0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: CollectibleTypeDao_Impl.java */
/* loaded from: classes2.dex */
public final class c implements com.toshi.db.h.a {
    private final j a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c<CollectibleType> f11097b;

    /* renamed from: c  reason: collision with root package name */
    private final q f11098c;

    /* compiled from: CollectibleTypeDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends androidx.room.c<CollectibleType> {
        a(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* renamed from: a */
        public void bind(f fVar, CollectibleType collectibleType) {
            if (collectibleType.getName() == null) {
                fVar.B0(1);
            } else {
                fVar.u(1, collectibleType.getName());
            }
            if (collectibleType.getContractAddress() == null) {
                fVar.B0(2);
            } else {
                fVar.u(2, collectibleType.getContractAddress());
            }
            if (collectibleType.getAddress() == null) {
                fVar.B0(3);
            } else {
                fVar.u(3, collectibleType.getAddress());
            }
            fVar.b0(4, collectibleType.getCount());
            if (collectibleType.getImage() == null) {
                fVar.B0(5);
            } else {
                fVar.u(5, collectibleType.getImage());
            }
            fVar.b0(6, collectibleType.getChainId());
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR REPLACE INTO `collectible_types` (`name`,`contract_address`,`address`,`count`,`image`,`chain_id`) VALUES (?,?,?,?,?,?)";
        }
    }

    /* compiled from: CollectibleTypeDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends q {
        b(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM collectible_types";
        }
    }

    /* compiled from: CollectibleTypeDao_Impl.java */
    /* renamed from: com.toshi.db.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class CallableC0241c implements Callable<Void> {
        final /* synthetic */ List a;

        CallableC0241c(List list) {
            this.a = list;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            c.this.a.beginTransaction();
            try {
                c.this.f11097b.insert((Iterable) this.a);
                c.this.a.setTransactionSuccessful();
                return null;
            } finally {
                c.this.a.endTransaction();
            }
        }
    }

    /* compiled from: CollectibleTypeDao_Impl.java */
    /* loaded from: classes2.dex */
    class d implements Callable<List<CollectibleType>> {
        final /* synthetic */ m a;

        d(m mVar) {
            this.a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<CollectibleType> call() throws Exception {
            Cursor b2 = androidx.room.t.c.b(c.this.a, this.a, false, null);
            try {
                int b3 = androidx.room.t.b.b(b2, ApiConstants.NAME);
                int b4 = androidx.room.t.b.b(b2, "contract_address");
                int b5 = androidx.room.t.b.b(b2, "address");
                int b6 = androidx.room.t.b.b(b2, "count");
                int b7 = androidx.room.t.b.b(b2, "image");
                int b8 = androidx.room.t.b.b(b2, "chain_id");
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(new CollectibleType(b2.getString(b3), b2.getString(b4), b2.getString(b5), b2.getInt(b6), b2.getString(b7), b2.getInt(b8)));
                }
                return arrayList;
            } finally {
                b2.close();
            }
        }

        protected void finalize() {
            this.a.f();
        }
    }

    public c(j jVar) {
        this.a = jVar;
        this.f11097b = new a(jVar);
        this.f11098c = new b(jVar);
    }

    @Override // com.toshi.db.h.b
    public b0<List<CollectibleType>> a(String str, int i2) {
        m c2 = m.c("SELECT * FROM collectible_types WHERE address = ? AND chain_id = ?", 2);
        if (str == null) {
            c2.B0(1);
        } else {
            c2.u(1, str);
        }
        c2.b0(2, i2);
        return n.a(new d(c2));
    }

    @Override // com.toshi.db.h.b
    public h.c.c b(List<CollectibleType> list) {
        return h.c.c.r(new CallableC0241c(list));
    }

    @Override // com.toshi.db.h.b
    public void c() {
        this.a.assertNotSuspendingTransaction();
        f acquire = this.f11098c.acquire();
        this.a.beginTransaction();
        try {
            acquire.y();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f11098c.release(acquire);
        }
    }
}