package com.toshi.db.i;

import android.database.Cursor;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import androidx.room.q;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.toshi.model.local.room.Erc721Token;
import h.c.b0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: Erc721TokenDao_Impl.java */
/* loaded from: classes2.dex */
public final class c implements com.toshi.db.i.a {
    private final j a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c<Erc721Token> f11101b;

    /* renamed from: c  reason: collision with root package name */
    private final q f11102c;

    /* compiled from: Erc721TokenDao_Impl.java */
    /* loaded from: classes2.dex */
    class a extends androidx.room.c<Erc721Token> {
        a(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.c
        /* renamed from: a */
        public void bind(f fVar, Erc721Token erc721Token) {
            if (erc721Token.getTokenId() == null) {
                fVar.B0(1);
            } else {
                fVar.u(1, erc721Token.getTokenId());
            }
            if (erc721Token.getName() == null) {
                fVar.B0(2);
            } else {
                fVar.u(2, erc721Token.getName());
            }
            if (erc721Token.getAddress() == null) {
                fVar.B0(3);
            } else {
                fVar.u(3, erc721Token.getAddress());
            }
            if (erc721Token.getContractAddress() == null) {
                fVar.B0(4);
            } else {
                fVar.u(4, erc721Token.getContractAddress());
            }
            fVar.b0(5, erc721Token.getChainId());
            if (erc721Token.getImage() == null) {
                fVar.B0(6);
            } else {
                fVar.u(6, erc721Token.getImage());
            }
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "INSERT OR REPLACE INTO `erc721_token` (`id`,`name`,`address`,`contract_address`,`chain_id`,`image`) VALUES (?,?,?,?,?,?)";
        }
    }

    /* compiled from: Erc721TokenDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends q {
        b(j jVar) {
            super(jVar);
        }

        @Override // androidx.room.q
        public String createQuery() {
            return "DELETE FROM erc721_token";
        }
    }

    /* compiled from: Erc721TokenDao_Impl.java */
    /* renamed from: com.toshi.db.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class CallableC0242c implements Callable<Void> {
        final /* synthetic */ List a;

        CallableC0242c(List list) {
            this.a = list;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            c.this.a.beginTransaction();
            try {
                c.this.f11101b.insert((Iterable) this.a);
                c.this.a.setTransactionSuccessful();
                return null;
            } finally {
                c.this.a.endTransaction();
            }
        }
    }

    /* compiled from: Erc721TokenDao_Impl.java */
    /* loaded from: classes2.dex */
    class d implements Callable<List<Erc721Token>> {
        final /* synthetic */ m a;

        d(m mVar) {
            this.a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public List<Erc721Token> call() throws Exception {
            Cursor b2 = androidx.room.t.c.b(c.this.a, this.a, false, null);
            try {
                int b3 = androidx.room.t.b.b(b2, "id");
                int b4 = androidx.room.t.b.b(b2, ApiConstants.NAME);
                int b5 = androidx.room.t.b.b(b2, "address");
                int b6 = androidx.room.t.b.b(b2, "contract_address");
                int b7 = androidx.room.t.b.b(b2, "chain_id");
                int b8 = androidx.room.t.b.b(b2, "image");
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    arrayList.add(new Erc721Token(b2.getString(b3), b2.getString(b4), b2.getString(b5), b2.getString(b6), b2.getInt(b7), b2.getString(b8)));
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
        this.f11101b = new a(jVar);
        this.f11102c = new b(jVar);
    }

    @Override // com.toshi.db.i.b
    public b0<List<Erc721Token>> a(String str, int i2) {
        m c2 = m.c("SELECT * FROM erc721_token WHERE address = ? AND chain_id = ?", 2);
        if (str == null) {
            c2.B0(1);
        } else {
            c2.u(1, str);
        }
        c2.b0(2, i2);
        return n.a(new d(c2));
    }

    @Override // com.toshi.db.i.b
    public h.c.c b(List<Erc721Token> list) {
        return h.c.c.r(new CallableC0242c(list));
    }

    @Override // com.toshi.db.i.b
    public void c() {
        this.a.assertNotSuspendingTransaction();
        f acquire = this.f11102c.acquire();
        this.a.beginTransaction();
        try {
            acquire.y();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f11102c.release(acquire);
        }
    }
}