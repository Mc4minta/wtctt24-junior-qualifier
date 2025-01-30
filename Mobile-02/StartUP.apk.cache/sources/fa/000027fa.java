package com.coinbase.wallet.user.daos;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import c.r.a.f;
import com.coinbase.wallet.user.models.LegacyUser;
import h.c.b0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class UserDao_Impl implements UserDao {
    private final j __db;
    private final b<LegacyUser> __deletionAdapterOfLegacyUser;
    private final c<LegacyUser> __insertionAdapterOfLegacyUser;

    public UserDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfLegacyUser = new c<LegacyUser>(jVar) { // from class: com.coinbase.wallet.user.daos.UserDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `user` (`toshi_id`,`payment_address`,`avatar`,`username`,`display_name`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, LegacyUser legacyUser) {
                if (legacyUser.getToshiId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, legacyUser.getToshiId());
                }
                if (legacyUser.getPaymentAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, legacyUser.getPaymentAddress());
                }
                if (legacyUser.getAvatar() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, legacyUser.getAvatar());
                }
                if (legacyUser.getUsername() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, legacyUser.getUsername());
                }
                if (legacyUser.getDisplayName() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, legacyUser.getDisplayName());
                }
            }
        };
        this.__deletionAdapterOfLegacyUser = new b<LegacyUser>(jVar) { // from class: com.coinbase.wallet.user.daos.UserDao_Impl.2
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `user` WHERE `toshi_id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, LegacyUser legacyUser) {
                if (legacyUser.getToshiId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, legacyUser.getToshiId());
                }
            }
        };
    }

    @Override // com.coinbase.wallet.user.daos.UserDao, com.coinbase.wallet.user.interfaces.UserDaoInterface
    public h.c.c delete(final LegacyUser legacyUser) {
        return h.c.c.r(new Callable<Void>() { // from class: com.coinbase.wallet.user.daos.UserDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                UserDao_Impl.this.__db.beginTransaction();
                try {
                    UserDao_Impl.this.__deletionAdapterOfLegacyUser.handle(legacyUser);
                    UserDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    UserDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }

    @Override // com.coinbase.wallet.user.daos.UserDao, com.coinbase.wallet.user.interfaces.UserDaoInterface
    public b0<List<LegacyUser>> get() {
        final m c2 = m.c("SELECT * FROM user", 0);
        return n.a(new Callable<List<LegacyUser>>() { // from class: com.coinbase.wallet.user.daos.UserDao_Impl.5
            protected void finalize() {
                c2.f();
            }

            @Override // java.util.concurrent.Callable
            public List<LegacyUser> call() throws Exception {
                Cursor b2 = androidx.room.t.c.b(UserDao_Impl.this.__db, c2, false, null);
                try {
                    int b3 = androidx.room.t.b.b(b2, "toshi_id");
                    int b4 = androidx.room.t.b.b(b2, "payment_address");
                    int b5 = androidx.room.t.b.b(b2, "avatar");
                    int b6 = androidx.room.t.b.b(b2, "username");
                    int b7 = androidx.room.t.b.b(b2, "display_name");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        arrayList.add(new LegacyUser(b2.getString(b3), b2.getString(b4), b2.getString(b5), b2.getString(b6), b2.getString(b7)));
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        });
    }

    @Override // com.coinbase.wallet.user.daos.UserDao, com.coinbase.wallet.user.interfaces.UserDaoInterface
    public h.c.c insert(final LegacyUser legacyUser) {
        return h.c.c.r(new Callable<Void>() { // from class: com.coinbase.wallet.user.daos.UserDao_Impl.3
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                UserDao_Impl.this.__db.beginTransaction();
                try {
                    UserDao_Impl.this.__insertionAdapterOfLegacyUser.insert((c) legacyUser);
                    UserDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    UserDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }
}