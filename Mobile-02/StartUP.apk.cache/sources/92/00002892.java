package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.bip44wallets.models.BIP44SignedTx;
import com.coinbase.wallet.blockchains.dbconverters.BlockchainConverter;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.blockchains.dbconverters.NetworkConverter;
import com.coinbase.wallet.blockchains.dbconverters.TxStateConverter;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class BIP44SignedTxRoomDao_Impl implements BIP44SignedTxRoomDao {
    private final j __db;
    private final b<BIP44SignedTx> __deletionAdapterOfBIP44SignedTx;
    private final c<BIP44SignedTx> __insertionAdapterOfBIP44SignedTx;
    private final c<BIP44SignedTx> __insertionAdapterOfBIP44SignedTx_1;
    private final b<BIP44SignedTx> __updateAdapterOfBIP44SignedTx;
    private final NetworkConverter __networkConverter = new NetworkConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final TxStateConverter __txStateConverter = new TxStateConverter();

    public BIP44SignedTxRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfBIP44SignedTx = new c<BIP44SignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.BIP44SignedTxRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `BIP44SignedTx` (`id`,`signedTxData`,`txHash`,`network`,`currencyCode`,`blockchain`,`state`,`notFoundCount`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, BIP44SignedTx bIP44SignedTx) {
                if (bIP44SignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, bIP44SignedTx.getId());
                }
                if (bIP44SignedTx.getSignedTransactionData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, bIP44SignedTx.getSignedTransactionData());
                }
                if (bIP44SignedTx.getTxHash() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bIP44SignedTx.getTxHash());
                }
                String networkConverter = BIP44SignedTxRoomDao_Impl.this.__networkConverter.toString(bIP44SignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, networkConverter);
                }
                String currencyCodeConverter = BIP44SignedTxRoomDao_Impl.this.__currencyCodeConverter.toString(bIP44SignedTx.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                String blockchainConverter = BIP44SignedTxRoomDao_Impl.this.__blockchainConverter.toString(bIP44SignedTx.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, blockchainConverter);
                }
                Integer num = BIP44SignedTxRoomDao_Impl.this.__txStateConverter.toInt(bIP44SignedTx.getState());
                if (num == null) {
                    fVar.B0(7);
                } else {
                    fVar.b0(7, num.intValue());
                }
                fVar.b0(8, bIP44SignedTx.getNotFoundCount());
            }
        };
        this.__insertionAdapterOfBIP44SignedTx_1 = new c<BIP44SignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.BIP44SignedTxRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `BIP44SignedTx` (`id`,`signedTxData`,`txHash`,`network`,`currencyCode`,`blockchain`,`state`,`notFoundCount`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, BIP44SignedTx bIP44SignedTx) {
                if (bIP44SignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, bIP44SignedTx.getId());
                }
                if (bIP44SignedTx.getSignedTransactionData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, bIP44SignedTx.getSignedTransactionData());
                }
                if (bIP44SignedTx.getTxHash() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bIP44SignedTx.getTxHash());
                }
                String networkConverter = BIP44SignedTxRoomDao_Impl.this.__networkConverter.toString(bIP44SignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, networkConverter);
                }
                String currencyCodeConverter = BIP44SignedTxRoomDao_Impl.this.__currencyCodeConverter.toString(bIP44SignedTx.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                String blockchainConverter = BIP44SignedTxRoomDao_Impl.this.__blockchainConverter.toString(bIP44SignedTx.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, blockchainConverter);
                }
                Integer num = BIP44SignedTxRoomDao_Impl.this.__txStateConverter.toInt(bIP44SignedTx.getState());
                if (num == null) {
                    fVar.B0(7);
                } else {
                    fVar.b0(7, num.intValue());
                }
                fVar.b0(8, bIP44SignedTx.getNotFoundCount());
            }
        };
        this.__deletionAdapterOfBIP44SignedTx = new b<BIP44SignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.BIP44SignedTxRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `BIP44SignedTx` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, BIP44SignedTx bIP44SignedTx) {
                if (bIP44SignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, bIP44SignedTx.getId());
                }
            }
        };
        this.__updateAdapterOfBIP44SignedTx = new b<BIP44SignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.BIP44SignedTxRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `BIP44SignedTx` SET `id` = ?,`signedTxData` = ?,`txHash` = ?,`network` = ?,`currencyCode` = ?,`blockchain` = ?,`state` = ?,`notFoundCount` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, BIP44SignedTx bIP44SignedTx) {
                if (bIP44SignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, bIP44SignedTx.getId());
                }
                if (bIP44SignedTx.getSignedTransactionData() == null) {
                    fVar.B0(2);
                } else {
                    fVar.f0(2, bIP44SignedTx.getSignedTransactionData());
                }
                if (bIP44SignedTx.getTxHash() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bIP44SignedTx.getTxHash());
                }
                String networkConverter = BIP44SignedTxRoomDao_Impl.this.__networkConverter.toString(bIP44SignedTx.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, networkConverter);
                }
                String currencyCodeConverter = BIP44SignedTxRoomDao_Impl.this.__currencyCodeConverter.toString(bIP44SignedTx.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                String blockchainConverter = BIP44SignedTxRoomDao_Impl.this.__blockchainConverter.toString(bIP44SignedTx.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, blockchainConverter);
                }
                Integer num = BIP44SignedTxRoomDao_Impl.this.__txStateConverter.toInt(bIP44SignedTx.getState());
                if (num == null) {
                    fVar.B0(7);
                } else {
                    fVar.b0(7, num.intValue());
                }
                fVar.b0(8, bIP44SignedTx.getNotFoundCount());
                if (bIP44SignedTx.getId() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bIP44SignedTx.getId());
                }
            }
        };
    }

    private BIP44SignedTx __entityCursorConverter_comCoinbaseWalletBip44walletsModelsBIP44SignedTx(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("signedTxData");
        int columnIndex3 = cursor.getColumnIndex("txHash");
        int columnIndex4 = cursor.getColumnIndex("network");
        int columnIndex5 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex6 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex7 = cursor.getColumnIndex(ApiConstants.STATE);
        int columnIndex8 = cursor.getColumnIndex("notFoundCount");
        TxState txState = null;
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        byte[] blob = columnIndex2 == -1 ? null : cursor.getBlob(columnIndex2);
        String string2 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        Network fromString = columnIndex4 == -1 ? null : this.__networkConverter.fromString(cursor.getString(columnIndex4));
        CurrencyCode fromString2 = columnIndex5 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex5));
        Blockchain fromString3 = columnIndex6 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex6));
        if (columnIndex7 != -1) {
            txState = this.__txStateConverter.fromInt(cursor.isNull(columnIndex7) ? null : Integer.valueOf(cursor.getInt(columnIndex7)));
        }
        return new BIP44SignedTx(string, blob, string2, fromString, fromString2, fromString3, txState, columnIndex8 == -1 ? 0 : cursor.getInt(columnIndex8));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends BIP44SignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBIP44SignedTx.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends BIP44SignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfBIP44SignedTx_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<BIP44SignedTx> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletBip44walletsModelsBIP44SignedTx(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends BIP44SignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfBIP44SignedTx.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(BIP44SignedTx bIP44SignedTx) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfBIP44SignedTx.handle(bIP44SignedTx);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}