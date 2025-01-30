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
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.txhistory.dbconverters.RecipientTypeConverter;
import com.coinbase.wallet.txhistory.models.RecipientType;
import com.coinbase.wallet.txhistory.models.TxAddress;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.i18n.MessageBundle;

/* loaded from: classes.dex */
public final class TxAddressRoomDAO_Impl implements TxAddressRoomDAO {
    private final j __db;
    private final b<TxAddress> __deletionAdapterOfTxAddress;
    private final c<TxAddress> __insertionAdapterOfTxAddress;
    private final c<TxAddress> __insertionAdapterOfTxAddress_1;
    private final b<TxAddress> __updateAdapterOfTxAddress;
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final RecipientTypeConverter __recipientTypeConverter = new RecipientTypeConverter();
    private final TxMetadataKeyConverter __txMetadataKeyConverter = new TxMetadataKeyConverter();
    private final NetworkConverter __networkConverter = new NetworkConverter();

    public TxAddressRoomDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfTxAddress = new c<TxAddress>(jVar) { // from class: com.coinbase.wallet.db.TxAddressRoomDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `TxAddress` (`id`,`title`,`blockchain`,`currencyCode`,`address`,`recipientType`,`metadataKey`,`metadata`,`network`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, TxAddress txAddress) {
                if (txAddress.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, txAddress.getId());
                }
                if (txAddress.getTitle() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, txAddress.getTitle());
                }
                String blockchainConverter = TxAddressRoomDAO_Impl.this.__blockchainConverter.toString(txAddress.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, blockchainConverter);
                }
                String currencyCodeConverter = TxAddressRoomDAO_Impl.this.__currencyCodeConverter.toString(txAddress.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                if (txAddress.getAddress() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, txAddress.getAddress());
                }
                Integer num = TxAddressRoomDAO_Impl.this.__recipientTypeConverter.toInt(txAddress.getRecipientType());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                String txMetadataKeyConverter = TxAddressRoomDAO_Impl.this.__txMetadataKeyConverter.toString(txAddress.getMetadataKey());
                if (txMetadataKeyConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, txMetadataKeyConverter);
                }
                if (txAddress.getMetadata() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, txAddress.getMetadata());
                }
                String networkConverter = TxAddressRoomDAO_Impl.this.__networkConverter.toString(txAddress.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, networkConverter);
                }
            }
        };
        this.__insertionAdapterOfTxAddress_1 = new c<TxAddress>(jVar) { // from class: com.coinbase.wallet.db.TxAddressRoomDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `TxAddress` (`id`,`title`,`blockchain`,`currencyCode`,`address`,`recipientType`,`metadataKey`,`metadata`,`network`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, TxAddress txAddress) {
                if (txAddress.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, txAddress.getId());
                }
                if (txAddress.getTitle() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, txAddress.getTitle());
                }
                String blockchainConverter = TxAddressRoomDAO_Impl.this.__blockchainConverter.toString(txAddress.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, blockchainConverter);
                }
                String currencyCodeConverter = TxAddressRoomDAO_Impl.this.__currencyCodeConverter.toString(txAddress.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                if (txAddress.getAddress() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, txAddress.getAddress());
                }
                Integer num = TxAddressRoomDAO_Impl.this.__recipientTypeConverter.toInt(txAddress.getRecipientType());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                String txMetadataKeyConverter = TxAddressRoomDAO_Impl.this.__txMetadataKeyConverter.toString(txAddress.getMetadataKey());
                if (txMetadataKeyConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, txMetadataKeyConverter);
                }
                if (txAddress.getMetadata() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, txAddress.getMetadata());
                }
                String networkConverter = TxAddressRoomDAO_Impl.this.__networkConverter.toString(txAddress.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, networkConverter);
                }
            }
        };
        this.__deletionAdapterOfTxAddress = new b<TxAddress>(jVar) { // from class: com.coinbase.wallet.db.TxAddressRoomDAO_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `TxAddress` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, TxAddress txAddress) {
                if (txAddress.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, txAddress.getId());
                }
            }
        };
        this.__updateAdapterOfTxAddress = new b<TxAddress>(jVar) { // from class: com.coinbase.wallet.db.TxAddressRoomDAO_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `TxAddress` SET `id` = ?,`title` = ?,`blockchain` = ?,`currencyCode` = ?,`address` = ?,`recipientType` = ?,`metadataKey` = ?,`metadata` = ?,`network` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, TxAddress txAddress) {
                if (txAddress.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, txAddress.getId());
                }
                if (txAddress.getTitle() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, txAddress.getTitle());
                }
                String blockchainConverter = TxAddressRoomDAO_Impl.this.__blockchainConverter.toString(txAddress.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, blockchainConverter);
                }
                String currencyCodeConverter = TxAddressRoomDAO_Impl.this.__currencyCodeConverter.toString(txAddress.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                if (txAddress.getAddress() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, txAddress.getAddress());
                }
                Integer num = TxAddressRoomDAO_Impl.this.__recipientTypeConverter.toInt(txAddress.getRecipientType());
                if (num == null) {
                    fVar.B0(6);
                } else {
                    fVar.b0(6, num.intValue());
                }
                String txMetadataKeyConverter = TxAddressRoomDAO_Impl.this.__txMetadataKeyConverter.toString(txAddress.getMetadataKey());
                if (txMetadataKeyConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, txMetadataKeyConverter);
                }
                if (txAddress.getMetadata() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, txAddress.getMetadata());
                }
                String networkConverter = TxAddressRoomDAO_Impl.this.__networkConverter.toString(txAddress.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, networkConverter);
                }
                if (txAddress.getId() == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, txAddress.getId());
                }
            }
        };
    }

    private TxAddress __entityCursorConverter_comCoinbaseWalletTxhistoryModelsTxAddress(Cursor cursor) {
        RecipientType fromInt;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(MessageBundle.TITLE_ENTRY);
        int columnIndex3 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex4 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex5 = cursor.getColumnIndex("address");
        int columnIndex6 = cursor.getColumnIndex("recipientType");
        int columnIndex7 = cursor.getColumnIndex("metadataKey");
        int columnIndex8 = cursor.getColumnIndex(SendConfirmationArgs.metadataKey);
        int columnIndex9 = cursor.getColumnIndex("network");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        String string2 = columnIndex2 == -1 ? null : cursor.getString(columnIndex2);
        Blockchain fromString = columnIndex3 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex3));
        CurrencyCode fromString2 = columnIndex4 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex4));
        String string3 = columnIndex5 == -1 ? null : cursor.getString(columnIndex5);
        if (columnIndex6 == -1) {
            fromInt = null;
        } else {
            fromInt = this.__recipientTypeConverter.fromInt(cursor.isNull(columnIndex6) ? null : Integer.valueOf(cursor.getInt(columnIndex6)));
        }
        return new TxAddress(string, string2, fromString, fromString2, string3, fromInt, columnIndex7 == -1 ? null : this.__txMetadataKeyConverter.fromString(cursor.getString(columnIndex7)), columnIndex8 == -1 ? null : cursor.getString(columnIndex8), columnIndex9 != -1 ? this.__networkConverter.fromString(cursor.getString(columnIndex9)) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends TxAddress> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTxAddress.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends TxAddress> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTxAddress_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<TxAddress> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletTxhistoryModelsTxAddress(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends TxAddress> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfTxAddress.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(TxAddress txAddress) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfTxAddress.handle(txAddress);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}