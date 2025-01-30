package com.coinbase.walletlink;

import android.database.Cursor;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.libraries.databases.converters.UriConverter;
import com.coinbase.wallet.libraries.databases.converters.UrlConverter;
import com.coinbase.walletlink.models.Dapp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class DappRoomDao_Impl implements DappRoomDao {
    private final androidx.room.j __db;
    private final androidx.room.b<Dapp> __deletionAdapterOfDapp;
    private final androidx.room.c<Dapp> __insertionAdapterOfDapp;
    private final androidx.room.c<Dapp> __insertionAdapterOfDapp_1;
    private final androidx.room.b<Dapp> __updateAdapterOfDapp;
    private final UriConverter __uriConverter = new UriConverter();
    private final UrlConverter __urlConverter = new UrlConverter();

    public DappRoomDao_Impl(androidx.room.j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfDapp = new androidx.room.c<Dapp>(jVar) { // from class: com.coinbase.walletlink.DappRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `Dapp` (`id`,`url`,`name`,`logoURL`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(c.r.a.f fVar, Dapp dapp) {
                if (dapp.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, dapp.getId());
                }
                String uriConverter = DappRoomDao_Impl.this.__uriConverter.toString(dapp.getUrl());
                if (uriConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, uriConverter);
                }
                if (dapp.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, dapp.getName());
                }
                String urlConverter = DappRoomDao_Impl.this.__urlConverter.toString(dapp.getLogoURL());
                if (urlConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, urlConverter);
                }
            }
        };
        this.__insertionAdapterOfDapp_1 = new androidx.room.c<Dapp>(jVar) { // from class: com.coinbase.walletlink.DappRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Dapp` (`id`,`url`,`name`,`logoURL`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(c.r.a.f fVar, Dapp dapp) {
                if (dapp.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, dapp.getId());
                }
                String uriConverter = DappRoomDao_Impl.this.__uriConverter.toString(dapp.getUrl());
                if (uriConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, uriConverter);
                }
                if (dapp.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, dapp.getName());
                }
                String urlConverter = DappRoomDao_Impl.this.__urlConverter.toString(dapp.getLogoURL());
                if (urlConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, urlConverter);
                }
            }
        };
        this.__deletionAdapterOfDapp = new androidx.room.b<Dapp>(jVar) { // from class: com.coinbase.walletlink.DappRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `Dapp` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(c.r.a.f fVar, Dapp dapp) {
                if (dapp.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, dapp.getId());
                }
            }
        };
        this.__updateAdapterOfDapp = new androidx.room.b<Dapp>(jVar) { // from class: com.coinbase.walletlink.DappRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `Dapp` SET `id` = ?,`url` = ?,`name` = ?,`logoURL` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(c.r.a.f fVar, Dapp dapp) {
                if (dapp.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, dapp.getId());
                }
                String uriConverter = DappRoomDao_Impl.this.__uriConverter.toString(dapp.getUrl());
                if (uriConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, uriConverter);
                }
                if (dapp.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, dapp.getName());
                }
                String urlConverter = DappRoomDao_Impl.this.__urlConverter.toString(dapp.getLogoURL());
                if (urlConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, urlConverter);
                }
                if (dapp.getId() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, dapp.getId());
                }
            }
        };
    }

    private Dapp __entityCursorConverter_comCoinbaseWalletlinkModelsDapp(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("url");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex4 = cursor.getColumnIndex("logoURL");
        return new Dapp(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : this.__uriConverter.fromString(cursor.getString(columnIndex2)), columnIndex3 == -1 ? null : cursor.getString(columnIndex3), columnIndex4 != -1 ? this.__urlConverter.fromString(cursor.getString(columnIndex4)) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends Dapp> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDapp.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends Dapp> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDapp_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<Dapp> fetch(c.r.a.e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletlinkModelsDapp(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends Dapp> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfDapp.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(Dapp dapp) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfDapp.handle(dapp);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}