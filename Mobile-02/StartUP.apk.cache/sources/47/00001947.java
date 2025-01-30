package com.coinbase.wallet.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.dbconverters.BlockchainConverter;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.blockchains.dbconverters.NetworkConverter;
import com.coinbase.wallet.blockchains.dbconverters.TxMetadataKeyConverter;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.features.send.models.Recipient;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.libraries.databases.converters.DateConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.dbconverters.RecipientTypeConverter;
import com.coinbase.wallet.txhistory.models.RecipientType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public final class SuggestedRoomRecipientDao_Impl implements SuggestedRoomRecipientDao {
    private final j __db;
    private final b<Recipient> __deletionAdapterOfRecipient;
    private final c<Recipient> __insertionAdapterOfRecipient;
    private final c<Recipient> __insertionAdapterOfRecipient_1;
    private final b<Recipient> __updateAdapterOfRecipient;
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final DateConverter __dateConverter = new DateConverter();
    private final RecipientTypeConverter __recipientTypeConverter = new RecipientTypeConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final TxMetadataKeyConverter __txMetadataKeyConverter = new TxMetadataKeyConverter();
    private final NetworkConverter __networkConverter = new NetworkConverter();

    public SuggestedRoomRecipientDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfRecipient = new c<Recipient>(jVar) { // from class: com.coinbase.wallet.db.SuggestedRoomRecipientDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `Recipient` (`id`,`destination`,`blockchain`,`sendCount`,`lastUsed`,`recipientType`,`currencyCode`,`metadataKey`,`metadata`,`network`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Recipient recipient) {
                if (recipient.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, recipient.getId());
                }
                if (recipient.getDestination() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, recipient.getDestination());
                }
                String blockchainConverter = SuggestedRoomRecipientDao_Impl.this.__blockchainConverter.toString(recipient.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, blockchainConverter);
                }
                fVar.b0(4, recipient.getSendCount());
                Long timestamp = SuggestedRoomRecipientDao_Impl.this.__dateConverter.toTimestamp(recipient.getLastUsed());
                if (timestamp == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, timestamp.longValue());
                }
                Integer num = SuggestedRoomRecipientDao_Impl.this.__recipientTypeConverter.toInt(recipient.getRecipientType());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                String currencyCodeConverter = SuggestedRoomRecipientDao_Impl.this.__currencyCodeConverter.toString(recipient.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, currencyCodeConverter);
                }
                String txMetadataKeyConverter = SuggestedRoomRecipientDao_Impl.this.__txMetadataKeyConverter.toString(recipient.getMetadataKey());
                if (txMetadataKeyConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, txMetadataKeyConverter);
                }
                if (recipient.getMetadata() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, recipient.getMetadata());
                }
                String networkConverter = SuggestedRoomRecipientDao_Impl.this.__networkConverter.toString(recipient.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, networkConverter);
                }
            }
        };
        this.__insertionAdapterOfRecipient_1 = new c<Recipient>(jVar) { // from class: com.coinbase.wallet.db.SuggestedRoomRecipientDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Recipient` (`id`,`destination`,`blockchain`,`sendCount`,`lastUsed`,`recipientType`,`currencyCode`,`metadataKey`,`metadata`,`network`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Recipient recipient) {
                if (recipient.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, recipient.getId());
                }
                if (recipient.getDestination() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, recipient.getDestination());
                }
                String blockchainConverter = SuggestedRoomRecipientDao_Impl.this.__blockchainConverter.toString(recipient.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, blockchainConverter);
                }
                fVar.b0(4, recipient.getSendCount());
                Long timestamp = SuggestedRoomRecipientDao_Impl.this.__dateConverter.toTimestamp(recipient.getLastUsed());
                if (timestamp == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, timestamp.longValue());
                }
                Integer num = SuggestedRoomRecipientDao_Impl.this.__recipientTypeConverter.toInt(recipient.getRecipientType());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                String currencyCodeConverter = SuggestedRoomRecipientDao_Impl.this.__currencyCodeConverter.toString(recipient.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, currencyCodeConverter);
                }
                String txMetadataKeyConverter = SuggestedRoomRecipientDao_Impl.this.__txMetadataKeyConverter.toString(recipient.getMetadataKey());
                if (txMetadataKeyConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, txMetadataKeyConverter);
                }
                if (recipient.getMetadata() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, recipient.getMetadata());
                }
                String networkConverter = SuggestedRoomRecipientDao_Impl.this.__networkConverter.toString(recipient.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, networkConverter);
                }
            }
        };
        this.__deletionAdapterOfRecipient = new b<Recipient>(jVar) { // from class: com.coinbase.wallet.db.SuggestedRoomRecipientDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `Recipient` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Recipient recipient) {
                if (recipient.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, recipient.getId());
                }
            }
        };
        this.__updateAdapterOfRecipient = new b<Recipient>(jVar) { // from class: com.coinbase.wallet.db.SuggestedRoomRecipientDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `Recipient` SET `id` = ?,`destination` = ?,`blockchain` = ?,`sendCount` = ?,`lastUsed` = ?,`recipientType` = ?,`currencyCode` = ?,`metadataKey` = ?,`metadata` = ?,`network` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Recipient recipient) {
                if (recipient.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, recipient.getId());
                }
                if (recipient.getDestination() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, recipient.getDestination());
                }
                String blockchainConverter = SuggestedRoomRecipientDao_Impl.this.__blockchainConverter.toString(recipient.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, blockchainConverter);
                }
                fVar.b0(4, recipient.getSendCount());
                Long timestamp = SuggestedRoomRecipientDao_Impl.this.__dateConverter.toTimestamp(recipient.getLastUsed());
                if (timestamp == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, timestamp.longValue());
                }
                Integer num = SuggestedRoomRecipientDao_Impl.this.__recipientTypeConverter.toInt(recipient.getRecipientType());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                String currencyCodeConverter = SuggestedRoomRecipientDao_Impl.this.__currencyCodeConverter.toString(recipient.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, currencyCodeConverter);
                }
                String txMetadataKeyConverter = SuggestedRoomRecipientDao_Impl.this.__txMetadataKeyConverter.toString(recipient.getMetadataKey());
                if (txMetadataKeyConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, txMetadataKeyConverter);
                }
                if (recipient.getMetadata() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, recipient.getMetadata());
                }
                String networkConverter = SuggestedRoomRecipientDao_Impl.this.__networkConverter.toString(recipient.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, networkConverter);
                }
                if (recipient.getId() == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, recipient.getId());
                }
            }
        };
    }

    private Recipient __entityCursorConverter_comCoinbaseWalletFeaturesSendModelsRecipient(Cursor cursor) {
        Date date;
        RecipientType fromInt;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("destination");
        int columnIndex3 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex4 = cursor.getColumnIndex("sendCount");
        int columnIndex5 = cursor.getColumnIndex("lastUsed");
        int columnIndex6 = cursor.getColumnIndex("recipientType");
        int columnIndex7 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex8 = cursor.getColumnIndex("metadataKey");
        int columnIndex9 = cursor.getColumnIndex(SendConfirmationArgs.metadataKey);
        int columnIndex10 = cursor.getColumnIndex("network");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        String string2 = columnIndex2 == -1 ? null : cursor.getString(columnIndex2);
        Blockchain fromString = columnIndex3 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex3));
        int i2 = columnIndex4 == -1 ? 0 : cursor.getInt(columnIndex4);
        if (columnIndex5 == -1) {
            date = null;
        } else {
            date = this.__dateConverter.toDate(cursor.isNull(columnIndex5) ? null : Long.valueOf(cursor.getLong(columnIndex5)));
        }
        if (columnIndex6 == -1) {
            fromInt = null;
        } else {
            fromInt = this.__recipientTypeConverter.fromInt(cursor.isNull(columnIndex6) ? null : Integer.valueOf(cursor.getInt(columnIndex6)));
        }
        return new Recipient(string, string2, fromString, i2, date, fromInt, columnIndex7 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex7)), columnIndex8 == -1 ? null : this.__txMetadataKeyConverter.fromString(cursor.getString(columnIndex8)), columnIndex9 == -1 ? null : cursor.getString(columnIndex9), columnIndex10 != -1 ? this.__networkConverter.fromString(cursor.getString(columnIndex10)) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends Recipient> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecipient.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends Recipient> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRecipient_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<Recipient> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletFeaturesSendModelsRecipient(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends Recipient> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfRecipient.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(Recipient recipient) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfRecipient.handle(recipient);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}