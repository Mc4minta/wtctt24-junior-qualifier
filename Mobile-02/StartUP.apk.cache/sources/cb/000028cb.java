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
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import com.coinbase.wallet.ripple.models.XRPSignedTx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class XRPSignedTxRoomDao_Impl implements XRPSignedTxRoomDao {
    private final j __db;
    private final b<XRPSignedTx> __deletionAdapterOfXRPSignedTx;
    private final c<XRPSignedTx> __insertionAdapterOfXRPSignedTx;
    private final c<XRPSignedTx> __insertionAdapterOfXRPSignedTx_1;
    private final b<XRPSignedTx> __updateAdapterOfXRPSignedTx;
    private final NetworkConverter __networkConverter = new NetworkConverter();
    private final TxStateConverter __txStateConverter = new TxStateConverter();
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();

    public XRPSignedTxRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfXRPSignedTx = new c<XRPSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.XRPSignedTxRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `XRPSignedTx` (`id`,`signedTxData`,`network`,`maxLedgerVersion`,`state`,`transferValue`,`txHash`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, XRPSignedTx xRPSignedTx) {
                if (xRPSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, xRPSignedTx.getId());
                }
                if (xRPSignedTx.getSignedTxData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, xRPSignedTx.getSignedTxData());
                }
                String networkConverter = XRPSignedTxRoomDao_Impl.this.__networkConverter.toString(xRPSignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, networkConverter);
                }
                fVar.b0(4, xRPSignedTx.getMaxLedgerVersion());
                Integer num = XRPSignedTxRoomDao_Impl.this.__txStateConverter.toInt(xRPSignedTx.getState());
                if (num == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, num.intValue());
                }
                String bigIntegerConverter = XRPSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(xRPSignedTx.getTransferValue());
                if (bigIntegerConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, bigIntegerConverter);
                }
                if (xRPSignedTx.getTxHash() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, xRPSignedTx.getTxHash());
                }
            }
        };
        this.__insertionAdapterOfXRPSignedTx_1 = new c<XRPSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.XRPSignedTxRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `XRPSignedTx` (`id`,`signedTxData`,`network`,`maxLedgerVersion`,`state`,`transferValue`,`txHash`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, XRPSignedTx xRPSignedTx) {
                if (xRPSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, xRPSignedTx.getId());
                }
                if (xRPSignedTx.getSignedTxData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, xRPSignedTx.getSignedTxData());
                }
                String networkConverter = XRPSignedTxRoomDao_Impl.this.__networkConverter.toString(xRPSignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, networkConverter);
                }
                fVar.b0(4, xRPSignedTx.getMaxLedgerVersion());
                Integer num = XRPSignedTxRoomDao_Impl.this.__txStateConverter.toInt(xRPSignedTx.getState());
                if (num == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, num.intValue());
                }
                String bigIntegerConverter = XRPSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(xRPSignedTx.getTransferValue());
                if (bigIntegerConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, bigIntegerConverter);
                }
                if (xRPSignedTx.getTxHash() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, xRPSignedTx.getTxHash());
                }
            }
        };
        this.__deletionAdapterOfXRPSignedTx = new b<XRPSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.XRPSignedTxRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `XRPSignedTx` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, XRPSignedTx xRPSignedTx) {
                if (xRPSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, xRPSignedTx.getId());
                }
            }
        };
        this.__updateAdapterOfXRPSignedTx = new b<XRPSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.XRPSignedTxRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `XRPSignedTx` SET `id` = ?,`signedTxData` = ?,`network` = ?,`maxLedgerVersion` = ?,`state` = ?,`transferValue` = ?,`txHash` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, XRPSignedTx xRPSignedTx) {
                if (xRPSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, xRPSignedTx.getId());
                }
                if (xRPSignedTx.getSignedTxData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, xRPSignedTx.getSignedTxData());
                }
                String networkConverter = XRPSignedTxRoomDao_Impl.this.__networkConverter.toString(xRPSignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, networkConverter);
                }
                fVar.b0(4, xRPSignedTx.getMaxLedgerVersion());
                Integer num = XRPSignedTxRoomDao_Impl.this.__txStateConverter.toInt(xRPSignedTx.getState());
                if (num == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, num.intValue());
                }
                String bigIntegerConverter = XRPSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(xRPSignedTx.getTransferValue());
                if (bigIntegerConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, bigIntegerConverter);
                }
                if (xRPSignedTx.getTxHash() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, xRPSignedTx.getTxHash());
                }
                if (xRPSignedTx.getId() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, xRPSignedTx.getId());
                }
            }
        };
    }

    private XRPSignedTx __entityCursorConverter_comCoinbaseWalletRippleModelsXRPSignedTx(Cursor cursor) {
        TxState fromInt;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("signedTxData");
        int columnIndex3 = cursor.getColumnIndex("network");
        int columnIndex4 = cursor.getColumnIndex("maxLedgerVersion");
        int columnIndex5 = cursor.getColumnIndex(ApiConstants.STATE);
        int columnIndex6 = cursor.getColumnIndex("transferValue");
        int columnIndex7 = cursor.getColumnIndex("txHash");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        byte[] blob = columnIndex2 == -1 ? null : cursor.getBlob(columnIndex2);
        Network fromString = columnIndex3 == -1 ? null : this.__networkConverter.fromString(cursor.getString(columnIndex3));
        long j2 = columnIndex4 == -1 ? 0L : cursor.getLong(columnIndex4);
        if (columnIndex5 == -1) {
            fromInt = null;
        } else {
            fromInt = this.__txStateConverter.fromInt(cursor.isNull(columnIndex5) ? null : Integer.valueOf(cursor.getInt(columnIndex5)));
        }
        return new XRPSignedTx(string, blob, fromString, j2, fromInt, columnIndex6 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex6)), columnIndex7 != -1 ? cursor.getString(columnIndex7) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends XRPSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfXRPSignedTx.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends XRPSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfXRPSignedTx_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<XRPSignedTx> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletRippleModelsXRPSignedTx(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends XRPSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfXRPSignedTx.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(XRPSignedTx xRPSignedTx) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfXRPSignedTx.handle(xRPSignedTx);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}