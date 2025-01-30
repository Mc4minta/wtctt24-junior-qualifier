package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.NetworkConverter;
import com.coinbase.wallet.blockchains.dbconverters.TxStateConverter;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.stellar.models.StellarSignedTx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class StellarSignedTxRoomDao_Impl implements StellarSignedTxRoomDao {
    private final j __db;
    private final b<StellarSignedTx> __deletionAdapterOfStellarSignedTx;
    private final c<StellarSignedTx> __insertionAdapterOfStellarSignedTx;
    private final c<StellarSignedTx> __insertionAdapterOfStellarSignedTx_1;
    private final NetworkConverter __networkConverter = new NetworkConverter();
    private final TxStateConverter __txStateConverter = new TxStateConverter();
    private final b<StellarSignedTx> __updateAdapterOfStellarSignedTx;

    public StellarSignedTxRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfStellarSignedTx = new c<StellarSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.StellarSignedTxRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `StellarSignedTx` (`id`,`signedTransactionData`,`txHash`,`network`,`validBefore`,`state`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, StellarSignedTx stellarSignedTx) {
                if (stellarSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, stellarSignedTx.getId());
                }
                if (stellarSignedTx.getSignedTransactionData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, stellarSignedTx.getSignedTransactionData());
                }
                if (stellarSignedTx.getTxHash() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, stellarSignedTx.getTxHash());
                }
                String networkConverter = StellarSignedTxRoomDao_Impl.this.__networkConverter.toString(stellarSignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, networkConverter);
                }
                fVar.b0(5, stellarSignedTx.getValidBefore());
                Integer num = StellarSignedTxRoomDao_Impl.this.__txStateConverter.toInt(stellarSignedTx.getState());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
            }
        };
        this.__insertionAdapterOfStellarSignedTx_1 = new c<StellarSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.StellarSignedTxRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `StellarSignedTx` (`id`,`signedTransactionData`,`txHash`,`network`,`validBefore`,`state`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, StellarSignedTx stellarSignedTx) {
                if (stellarSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, stellarSignedTx.getId());
                }
                if (stellarSignedTx.getSignedTransactionData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, stellarSignedTx.getSignedTransactionData());
                }
                if (stellarSignedTx.getTxHash() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, stellarSignedTx.getTxHash());
                }
                String networkConverter = StellarSignedTxRoomDao_Impl.this.__networkConverter.toString(stellarSignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, networkConverter);
                }
                fVar.b0(5, stellarSignedTx.getValidBefore());
                Integer num = StellarSignedTxRoomDao_Impl.this.__txStateConverter.toInt(stellarSignedTx.getState());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
            }
        };
        this.__deletionAdapterOfStellarSignedTx = new b<StellarSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.StellarSignedTxRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `StellarSignedTx` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, StellarSignedTx stellarSignedTx) {
                if (stellarSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, stellarSignedTx.getId());
                }
            }
        };
        this.__updateAdapterOfStellarSignedTx = new b<StellarSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.StellarSignedTxRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `StellarSignedTx` SET `id` = ?,`signedTransactionData` = ?,`txHash` = ?,`network` = ?,`validBefore` = ?,`state` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, StellarSignedTx stellarSignedTx) {
                if (stellarSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, stellarSignedTx.getId());
                }
                if (stellarSignedTx.getSignedTransactionData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, stellarSignedTx.getSignedTransactionData());
                }
                if (stellarSignedTx.getTxHash() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, stellarSignedTx.getTxHash());
                }
                String networkConverter = StellarSignedTxRoomDao_Impl.this.__networkConverter.toString(stellarSignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, networkConverter);
                }
                fVar.b0(5, stellarSignedTx.getValidBefore());
                Integer num = StellarSignedTxRoomDao_Impl.this.__txStateConverter.toInt(stellarSignedTx.getState());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                if (stellarSignedTx.getId() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, stellarSignedTx.getId());
                }
            }
        };
    }

    private StellarSignedTx __entityCursorConverter_comCoinbaseWalletStellarModelsStellarSignedTx(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("signedTransactionData");
        int columnIndex3 = cursor.getColumnIndex("txHash");
        int columnIndex4 = cursor.getColumnIndex("network");
        int columnIndex5 = cursor.getColumnIndex("validBefore");
        int columnIndex6 = cursor.getColumnIndex(ApiConstants.STATE);
        TxState txState = null;
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        byte[] blob = columnIndex2 == -1 ? null : cursor.getBlob(columnIndex2);
        String string2 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        Network fromString = columnIndex4 == -1 ? null : this.__networkConverter.fromString(cursor.getString(columnIndex4));
        long j2 = columnIndex5 == -1 ? 0L : cursor.getLong(columnIndex5);
        if (columnIndex6 != -1) {
            txState = this.__txStateConverter.fromInt(cursor.isNull(columnIndex6) ? null : Integer.valueOf(cursor.getInt(columnIndex6)));
        }
        return new StellarSignedTx(string, blob, string2, fromString, j2, txState);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends StellarSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfStellarSignedTx.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends StellarSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfStellarSignedTx_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<StellarSignedTx> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletStellarModelsStellarSignedTx(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends StellarSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfStellarSignedTx.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(StellarSignedTx stellarSignedTx) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfStellarSignedTx.handle(stellarSignedTx);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}