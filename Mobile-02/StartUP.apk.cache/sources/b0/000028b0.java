package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.BlockchainConverter;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.blockchains.dbconverters.TxStateConverter;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.ethereum.models.EthereumSignedTx;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class EthereumSignedTxRoomDao_Impl implements EthereumSignedTxRoomDao {
    private final j __db;
    private final b<EthereumSignedTx> __deletionAdapterOfEthereumSignedTx;
    private final c<EthereumSignedTx> __insertionAdapterOfEthereumSignedTx;
    private final c<EthereumSignedTx> __insertionAdapterOfEthereumSignedTx_1;
    private final b<EthereumSignedTx> __updateAdapterOfEthereumSignedTx;
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final TxStateConverter __txStateConverter = new TxStateConverter();

    public EthereumSignedTxRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfEthereumSignedTx = new c<EthereumSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.EthereumSignedTxRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `EthereumSignedTx` (`id`,`fromAddress`,`toAddress`,`nonce`,`chainId`,`signedTxData`,`txHash`,`weiValue`,`erc20Value`,`blockchain`,`currencyCode`,`state`,`notFoundCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, EthereumSignedTx ethereumSignedTx) {
                if (ethereumSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, ethereumSignedTx.getId());
                }
                if (ethereumSignedTx.getFromAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, ethereumSignedTx.getFromAddress());
                }
                if (ethereumSignedTx.getToAddress() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, ethereumSignedTx.getToAddress());
                }
                fVar.b0(4, ethereumSignedTx.getNonce());
                fVar.b0(5, ethereumSignedTx.getChainId());
                if (ethereumSignedTx.getSignedTxData() == null) {
                    fVar.B0(6);
                } else {
                    fVar.f0(6, ethereumSignedTx.getSignedTxData());
                }
                if (ethereumSignedTx.getTxHash() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, ethereumSignedTx.getTxHash());
                }
                String bigIntegerConverter = EthereumSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(ethereumSignedTx.getWeiValue());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                String bigIntegerConverter2 = EthereumSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(ethereumSignedTx.getErc20Value());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter2);
                }
                String blockchainConverter = EthereumSignedTxRoomDao_Impl.this.__blockchainConverter.toString(ethereumSignedTx.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, blockchainConverter);
                }
                String currencyCodeConverter = EthereumSignedTxRoomDao_Impl.this.__currencyCodeConverter.toString(ethereumSignedTx.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, currencyCodeConverter);
                }
                Integer num = EthereumSignedTxRoomDao_Impl.this.__txStateConverter.toInt(ethereumSignedTx.getState());
                if (num == null) {
                    fVar.B0(12);
                } else {
                    fVar.b0(12, num.intValue());
                }
                fVar.b0(13, ethereumSignedTx.getNotFoundCount());
            }
        };
        this.__insertionAdapterOfEthereumSignedTx_1 = new c<EthereumSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.EthereumSignedTxRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `EthereumSignedTx` (`id`,`fromAddress`,`toAddress`,`nonce`,`chainId`,`signedTxData`,`txHash`,`weiValue`,`erc20Value`,`blockchain`,`currencyCode`,`state`,`notFoundCount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, EthereumSignedTx ethereumSignedTx) {
                if (ethereumSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, ethereumSignedTx.getId());
                }
                if (ethereumSignedTx.getFromAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, ethereumSignedTx.getFromAddress());
                }
                if (ethereumSignedTx.getToAddress() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, ethereumSignedTx.getToAddress());
                }
                fVar.b0(4, ethereumSignedTx.getNonce());
                fVar.b0(5, ethereumSignedTx.getChainId());
                if (ethereumSignedTx.getSignedTxData() == null) {
                    fVar.B0(6);
                } else {
                    fVar.f0(6, ethereumSignedTx.getSignedTxData());
                }
                if (ethereumSignedTx.getTxHash() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, ethereumSignedTx.getTxHash());
                }
                String bigIntegerConverter = EthereumSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(ethereumSignedTx.getWeiValue());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                String bigIntegerConverter2 = EthereumSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(ethereumSignedTx.getErc20Value());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter2);
                }
                String blockchainConverter = EthereumSignedTxRoomDao_Impl.this.__blockchainConverter.toString(ethereumSignedTx.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, blockchainConverter);
                }
                String currencyCodeConverter = EthereumSignedTxRoomDao_Impl.this.__currencyCodeConverter.toString(ethereumSignedTx.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, currencyCodeConverter);
                }
                Integer num = EthereumSignedTxRoomDao_Impl.this.__txStateConverter.toInt(ethereumSignedTx.getState());
                if (num == null) {
                    fVar.B0(12);
                } else {
                    fVar.b0(12, num.intValue());
                }
                fVar.b0(13, ethereumSignedTx.getNotFoundCount());
            }
        };
        this.__deletionAdapterOfEthereumSignedTx = new b<EthereumSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.EthereumSignedTxRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `EthereumSignedTx` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, EthereumSignedTx ethereumSignedTx) {
                if (ethereumSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, ethereumSignedTx.getId());
                }
            }
        };
        this.__updateAdapterOfEthereumSignedTx = new b<EthereumSignedTx>(jVar) { // from class: com.coinbase.wallet.wallets.db.EthereumSignedTxRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `EthereumSignedTx` SET `id` = ?,`fromAddress` = ?,`toAddress` = ?,`nonce` = ?,`chainId` = ?,`signedTxData` = ?,`txHash` = ?,`weiValue` = ?,`erc20Value` = ?,`blockchain` = ?,`currencyCode` = ?,`state` = ?,`notFoundCount` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, EthereumSignedTx ethereumSignedTx) {
                if (ethereumSignedTx.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, ethereumSignedTx.getId());
                }
                if (ethereumSignedTx.getFromAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, ethereumSignedTx.getFromAddress());
                }
                if (ethereumSignedTx.getToAddress() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, ethereumSignedTx.getToAddress());
                }
                fVar.b0(4, ethereumSignedTx.getNonce());
                fVar.b0(5, ethereumSignedTx.getChainId());
                if (ethereumSignedTx.getSignedTxData() == null) {
                    fVar.B0(6);
                } else {
                    fVar.f0(6, ethereumSignedTx.getSignedTxData());
                }
                if (ethereumSignedTx.getTxHash() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, ethereumSignedTx.getTxHash());
                }
                String bigIntegerConverter = EthereumSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(ethereumSignedTx.getWeiValue());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                String bigIntegerConverter2 = EthereumSignedTxRoomDao_Impl.this.__bigIntegerConverter.toString(ethereumSignedTx.getErc20Value());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter2);
                }
                String blockchainConverter = EthereumSignedTxRoomDao_Impl.this.__blockchainConverter.toString(ethereumSignedTx.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, blockchainConverter);
                }
                String currencyCodeConverter = EthereumSignedTxRoomDao_Impl.this.__currencyCodeConverter.toString(ethereumSignedTx.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, currencyCodeConverter);
                }
                Integer num = EthereumSignedTxRoomDao_Impl.this.__txStateConverter.toInt(ethereumSignedTx.getState());
                if (num == null) {
                    fVar.B0(12);
                } else {
                    fVar.b0(12, num.intValue());
                }
                fVar.b0(13, ethereumSignedTx.getNotFoundCount());
                if (ethereumSignedTx.getId() == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, ethereumSignedTx.getId());
                }
            }
        };
    }

    private EthereumSignedTx __entityCursorConverter_comCoinbaseWalletEthereumModelsEthereumSignedTx(Cursor cursor) {
        TxState fromInt;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("fromAddress");
        int columnIndex3 = cursor.getColumnIndex("toAddress");
        int columnIndex4 = cursor.getColumnIndex(AdjustableMinerFeeArgs.NONCE);
        int columnIndex5 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CHAIN_ID);
        int columnIndex6 = cursor.getColumnIndex("signedTxData");
        int columnIndex7 = cursor.getColumnIndex("txHash");
        int columnIndex8 = cursor.getColumnIndex("weiValue");
        int columnIndex9 = cursor.getColumnIndex("erc20Value");
        int columnIndex10 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex11 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex12 = cursor.getColumnIndex(ApiConstants.STATE);
        int columnIndex13 = cursor.getColumnIndex("notFoundCount");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        String string2 = columnIndex2 == -1 ? null : cursor.getString(columnIndex2);
        String string3 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        int i2 = columnIndex4 == -1 ? 0 : cursor.getInt(columnIndex4);
        int i3 = columnIndex5 == -1 ? 0 : cursor.getInt(columnIndex5);
        byte[] blob = columnIndex6 == -1 ? null : cursor.getBlob(columnIndex6);
        String string4 = columnIndex7 == -1 ? null : cursor.getString(columnIndex7);
        BigInteger fromString = columnIndex8 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex8));
        BigInteger fromString2 = columnIndex9 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex9));
        Blockchain fromString3 = columnIndex10 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex10));
        CurrencyCode fromString4 = columnIndex11 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex11));
        if (columnIndex12 == -1) {
            fromInt = null;
        } else {
            fromInt = this.__txStateConverter.fromInt(cursor.isNull(columnIndex12) ? null : Integer.valueOf(cursor.getInt(columnIndex12)));
        }
        return new EthereumSignedTx(string, string2, string3, i2, i3, blob, string4, fromString, fromString2, fromString3, fromString4, fromInt, columnIndex13 == -1 ? 0 : cursor.getInt(columnIndex13));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends EthereumSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEthereumSignedTx.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends EthereumSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEthereumSignedTx_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<EthereumSignedTx> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletEthereumModelsEthereumSignedTx(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends EthereumSignedTx> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfEthereumSignedTx.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(EthereumSignedTx ethereumSignedTx) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfEthereumSignedTx.handle(ethereumSignedTx);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}