package com.coinbase.wallet.db;

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
import com.coinbase.wallet.blockchains.dbconverters.NetworkConverter;
import com.coinbase.wallet.blockchains.dbconverters.TxMetadataConverter;
import com.coinbase.wallet.blockchains.dbconverters.TxStateConverter;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.Transaction;
import com.coinbase.wallet.blockchains.models.TxMetadata;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import com.coinbase.wallet.libraries.databases.converters.DateConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public final class TxHistoryRoomDao_Impl implements TxHistoryRoomDao {
    private final j __db;
    private final b<Transaction> __deletionAdapterOfTransaction;
    private final c<Transaction> __insertionAdapterOfTransaction;
    private final c<Transaction> __insertionAdapterOfTransaction_1;
    private final b<Transaction> __updateAdapterOfTransaction;
    private final DateConverter __dateConverter = new DateConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();
    private final TxStateConverter __txStateConverter = new TxStateConverter();
    private final TxMetadataConverter __txMetadataConverter = new TxMetadataConverter();
    private final NetworkConverter __networkConverter = new NetworkConverter();

    public TxHistoryRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfTransaction = new c<Transaction>(jVar) { // from class: com.coinbase.wallet.db.TxHistoryRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `Transaction` (`id`,`createdAt`,`confirmedAt`,`blockchain`,`currencyCode`,`feeCurrencyCode`,`toAddress`,`fromAddress`,`amount`,`fee`,`lowerBoundFee`,`state`,`metadata`,`network`,`txHash`,`isSent`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Transaction transaction) {
                if (transaction.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, transaction.getId());
                }
                Long timestamp = TxHistoryRoomDao_Impl.this.__dateConverter.toTimestamp(transaction.getCreatedAt());
                if (timestamp == null) {
                    fVar.B0(2);
                } else {
                    fVar.b0(2, timestamp.longValue());
                }
                Long timestamp2 = TxHistoryRoomDao_Impl.this.__dateConverter.toTimestamp(transaction.getConfirmedAt());
                if (timestamp2 == null) {
                    fVar.B0(3);
                } else {
                    fVar.b0(3, timestamp2.longValue());
                }
                String blockchainConverter = TxHistoryRoomDao_Impl.this.__blockchainConverter.toString(transaction.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, blockchainConverter);
                }
                String currencyCodeConverter = TxHistoryRoomDao_Impl.this.__currencyCodeConverter.toString(transaction.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                String currencyCodeConverter2 = TxHistoryRoomDao_Impl.this.__currencyCodeConverter.toString(transaction.getFeeCurrencyCode());
                if (currencyCodeConverter2 == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter2);
                }
                if (transaction.getToAddress() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, transaction.getToAddress());
                }
                if (transaction.getFromAddress() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, transaction.getFromAddress());
                }
                String bigIntegerConverter = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getAmount());
                if (bigIntegerConverter == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter);
                }
                String bigIntegerConverter2 = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getFee());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, bigIntegerConverter2);
                }
                String bigIntegerConverter3 = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getLowerBoundFee());
                if (bigIntegerConverter3 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter3);
                }
                Integer num = TxHistoryRoomDao_Impl.this.__txStateConverter.toInt(transaction.getState());
                if (num == null) {
                    fVar.B0(12);
                } else {
                    fVar.b0(12, num.intValue());
                }
                String txMetadataConverter = TxHistoryRoomDao_Impl.this.__txMetadataConverter.toString(transaction.getMetadata());
                if (txMetadataConverter == null) {
                    fVar.B0(13);
                } else {
                    fVar.u(13, txMetadataConverter);
                }
                String networkConverter = TxHistoryRoomDao_Impl.this.__networkConverter.toString(transaction.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, networkConverter);
                }
                if (transaction.getTxHash() == null) {
                    fVar.B0(15);
                } else {
                    fVar.u(15, transaction.getTxHash());
                }
                fVar.b0(16, transaction.isSent() ? 1L : 0L);
            }
        };
        this.__insertionAdapterOfTransaction_1 = new c<Transaction>(jVar) { // from class: com.coinbase.wallet.db.TxHistoryRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Transaction` (`id`,`createdAt`,`confirmedAt`,`blockchain`,`currencyCode`,`feeCurrencyCode`,`toAddress`,`fromAddress`,`amount`,`fee`,`lowerBoundFee`,`state`,`metadata`,`network`,`txHash`,`isSent`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Transaction transaction) {
                if (transaction.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, transaction.getId());
                }
                Long timestamp = TxHistoryRoomDao_Impl.this.__dateConverter.toTimestamp(transaction.getCreatedAt());
                if (timestamp == null) {
                    fVar.B0(2);
                } else {
                    fVar.b0(2, timestamp.longValue());
                }
                Long timestamp2 = TxHistoryRoomDao_Impl.this.__dateConverter.toTimestamp(transaction.getConfirmedAt());
                if (timestamp2 == null) {
                    fVar.B0(3);
                } else {
                    fVar.b0(3, timestamp2.longValue());
                }
                String blockchainConverter = TxHistoryRoomDao_Impl.this.__blockchainConverter.toString(transaction.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, blockchainConverter);
                }
                String currencyCodeConverter = TxHistoryRoomDao_Impl.this.__currencyCodeConverter.toString(transaction.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                String currencyCodeConverter2 = TxHistoryRoomDao_Impl.this.__currencyCodeConverter.toString(transaction.getFeeCurrencyCode());
                if (currencyCodeConverter2 == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter2);
                }
                if (transaction.getToAddress() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, transaction.getToAddress());
                }
                if (transaction.getFromAddress() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, transaction.getFromAddress());
                }
                String bigIntegerConverter = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getAmount());
                if (bigIntegerConverter == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter);
                }
                String bigIntegerConverter2 = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getFee());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, bigIntegerConverter2);
                }
                String bigIntegerConverter3 = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getLowerBoundFee());
                if (bigIntegerConverter3 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter3);
                }
                Integer num = TxHistoryRoomDao_Impl.this.__txStateConverter.toInt(transaction.getState());
                if (num == null) {
                    fVar.B0(12);
                } else {
                    fVar.b0(12, num.intValue());
                }
                String txMetadataConverter = TxHistoryRoomDao_Impl.this.__txMetadataConverter.toString(transaction.getMetadata());
                if (txMetadataConverter == null) {
                    fVar.B0(13);
                } else {
                    fVar.u(13, txMetadataConverter);
                }
                String networkConverter = TxHistoryRoomDao_Impl.this.__networkConverter.toString(transaction.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, networkConverter);
                }
                if (transaction.getTxHash() == null) {
                    fVar.B0(15);
                } else {
                    fVar.u(15, transaction.getTxHash());
                }
                fVar.b0(16, transaction.isSent() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfTransaction = new b<Transaction>(jVar) { // from class: com.coinbase.wallet.db.TxHistoryRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `Transaction` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Transaction transaction) {
                if (transaction.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, transaction.getId());
                }
            }
        };
        this.__updateAdapterOfTransaction = new b<Transaction>(jVar) { // from class: com.coinbase.wallet.db.TxHistoryRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `Transaction` SET `id` = ?,`createdAt` = ?,`confirmedAt` = ?,`blockchain` = ?,`currencyCode` = ?,`feeCurrencyCode` = ?,`toAddress` = ?,`fromAddress` = ?,`amount` = ?,`fee` = ?,`lowerBoundFee` = ?,`state` = ?,`metadata` = ?,`network` = ?,`txHash` = ?,`isSent` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Transaction transaction) {
                if (transaction.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, transaction.getId());
                }
                Long timestamp = TxHistoryRoomDao_Impl.this.__dateConverter.toTimestamp(transaction.getCreatedAt());
                if (timestamp == null) {
                    fVar.B0(2);
                } else {
                    fVar.b0(2, timestamp.longValue());
                }
                Long timestamp2 = TxHistoryRoomDao_Impl.this.__dateConverter.toTimestamp(transaction.getConfirmedAt());
                if (timestamp2 == null) {
                    fVar.B0(3);
                } else {
                    fVar.b0(3, timestamp2.longValue());
                }
                String blockchainConverter = TxHistoryRoomDao_Impl.this.__blockchainConverter.toString(transaction.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, blockchainConverter);
                }
                String currencyCodeConverter = TxHistoryRoomDao_Impl.this.__currencyCodeConverter.toString(transaction.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                String currencyCodeConverter2 = TxHistoryRoomDao_Impl.this.__currencyCodeConverter.toString(transaction.getFeeCurrencyCode());
                if (currencyCodeConverter2 == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter2);
                }
                if (transaction.getToAddress() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, transaction.getToAddress());
                }
                if (transaction.getFromAddress() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, transaction.getFromAddress());
                }
                String bigIntegerConverter = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getAmount());
                if (bigIntegerConverter == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter);
                }
                String bigIntegerConverter2 = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getFee());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, bigIntegerConverter2);
                }
                String bigIntegerConverter3 = TxHistoryRoomDao_Impl.this.__bigIntegerConverter.toString(transaction.getLowerBoundFee());
                if (bigIntegerConverter3 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter3);
                }
                Integer num = TxHistoryRoomDao_Impl.this.__txStateConverter.toInt(transaction.getState());
                if (num == null) {
                    fVar.B0(12);
                } else {
                    fVar.b0(12, num.intValue());
                }
                String txMetadataConverter = TxHistoryRoomDao_Impl.this.__txMetadataConverter.toString(transaction.getMetadata());
                if (txMetadataConverter == null) {
                    fVar.B0(13);
                } else {
                    fVar.u(13, txMetadataConverter);
                }
                String networkConverter = TxHistoryRoomDao_Impl.this.__networkConverter.toString(transaction.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, networkConverter);
                }
                if (transaction.getTxHash() == null) {
                    fVar.B0(15);
                } else {
                    fVar.u(15, transaction.getTxHash());
                }
                fVar.b0(16, transaction.isSent() ? 1L : 0L);
                if (transaction.getId() == null) {
                    fVar.B0(17);
                } else {
                    fVar.u(17, transaction.getId());
                }
            }
        };
    }

    private Transaction __entityCursorConverter_comCoinbaseWalletBlockchainsModelsTransaction(Cursor cursor) {
        Date date;
        Date date2;
        TxState fromInt;
        TxMetadata fromString;
        int i2;
        Network fromString2;
        int i3;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("createdAt");
        int columnIndex3 = cursor.getColumnIndex("confirmedAt");
        int columnIndex4 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex5 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex6 = cursor.getColumnIndex("feeCurrencyCode");
        int columnIndex7 = cursor.getColumnIndex("toAddress");
        int columnIndex8 = cursor.getColumnIndex("fromAddress");
        int columnIndex9 = cursor.getColumnIndex("amount");
        int columnIndex10 = cursor.getColumnIndex(ApiConstants.FEE);
        int columnIndex11 = cursor.getColumnIndex("lowerBoundFee");
        int columnIndex12 = cursor.getColumnIndex(ApiConstants.STATE);
        int columnIndex13 = cursor.getColumnIndex(SendConfirmationArgs.metadataKey);
        int columnIndex14 = cursor.getColumnIndex("network");
        int columnIndex15 = cursor.getColumnIndex("txHash");
        int columnIndex16 = cursor.getColumnIndex("isSent");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        if (columnIndex2 == -1) {
            date = null;
        } else {
            date = this.__dateConverter.toDate(cursor.isNull(columnIndex2) ? null : Long.valueOf(cursor.getLong(columnIndex2)));
        }
        if (columnIndex3 == -1) {
            date2 = null;
        } else {
            date2 = this.__dateConverter.toDate(cursor.isNull(columnIndex3) ? null : Long.valueOf(cursor.getLong(columnIndex3)));
        }
        Blockchain fromString3 = columnIndex4 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex4));
        CurrencyCode fromString4 = columnIndex5 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex5));
        CurrencyCode fromString5 = columnIndex6 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex6));
        String string2 = columnIndex7 == -1 ? null : cursor.getString(columnIndex7);
        String string3 = columnIndex8 == -1 ? null : cursor.getString(columnIndex8);
        BigInteger fromString6 = columnIndex9 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex9));
        BigInteger fromString7 = columnIndex10 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex10));
        BigInteger fromString8 = columnIndex11 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex11));
        if (columnIndex12 == -1) {
            fromInt = null;
        } else {
            fromInt = this.__txStateConverter.fromInt(cursor.isNull(columnIndex12) ? null : Integer.valueOf(cursor.getInt(columnIndex12)));
        }
        if (columnIndex13 == -1) {
            i2 = columnIndex14;
            fromString = null;
        } else {
            fromString = this.__txMetadataConverter.fromString(cursor.getString(columnIndex13));
            i2 = columnIndex14;
        }
        if (i2 == -1) {
            i3 = columnIndex15;
            fromString2 = null;
        } else {
            fromString2 = this.__networkConverter.fromString(cursor.getString(i2));
            i3 = columnIndex15;
        }
        String string4 = i3 != -1 ? cursor.getString(i3) : null;
        boolean z = false;
        if (columnIndex16 != -1 && cursor.getInt(columnIndex16) != 0) {
            z = true;
        }
        return new Transaction(string, date, date2, fromString3, fromString4, fromString5, string2, string3, fromString6, fromString7, fromString8, fromInt, fromString, fromString2, string4, z);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends Transaction> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTransaction.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends Transaction> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTransaction_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<Transaction> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletBlockchainsModelsTransaction(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends Transaction> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfTransaction.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(Transaction transaction) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfTransaction.handle(transaction);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}