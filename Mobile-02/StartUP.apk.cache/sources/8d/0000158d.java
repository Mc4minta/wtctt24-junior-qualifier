package com.coinbase.wallet.consumer.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.consumer.models.ConsumerAccount;
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ConsumerAccountsRoomDAO_Impl implements ConsumerAccountsRoomDAO {
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final j __db;
    private final b<ConsumerAccount> __deletionAdapterOfConsumerAccount;
    private final c<ConsumerAccount> __insertionAdapterOfConsumerAccount;
    private final c<ConsumerAccount> __insertionAdapterOfConsumerAccount_1;
    private final b<ConsumerAccount> __updateAdapterOfConsumerAccount;

    public ConsumerAccountsRoomDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfConsumerAccount = new c<ConsumerAccount>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAccountsRoomDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `accounts` (`id`,`name`,`balance`,`currencyCode`,`currencyName`,`decimals`,`type`,`imageUrl`,`destination_tag_name`,`asset_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ConsumerAccount consumerAccount) {
                if (consumerAccount.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAccount.getId());
                }
                if (consumerAccount.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerAccount.getName());
                }
                String bigIntegerConverter = ConsumerAccountsRoomDAO_Impl.this.__bigIntegerConverter.toString(consumerAccount.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bigIntegerConverter);
                }
                String currencyCodeConverter = ConsumerAccountsRoomDAO_Impl.this.__currencyCodeConverter.toString(consumerAccount.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                if (consumerAccount.getCurrencyName() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, consumerAccount.getCurrencyName());
                }
                fVar.b0(6, consumerAccount.getDecimals());
                if (consumerAccount.getType() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, consumerAccount.getType());
                }
                if (consumerAccount.getImageUrl() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, consumerAccount.getImageUrl());
                }
                if (consumerAccount.getDestinationTagName() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, consumerAccount.getDestinationTagName());
                }
                if (consumerAccount.getAssetId() == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, consumerAccount.getAssetId());
                }
            }
        };
        this.__insertionAdapterOfConsumerAccount_1 = new c<ConsumerAccount>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAccountsRoomDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `accounts` (`id`,`name`,`balance`,`currencyCode`,`currencyName`,`decimals`,`type`,`imageUrl`,`destination_tag_name`,`asset_id`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ConsumerAccount consumerAccount) {
                if (consumerAccount.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAccount.getId());
                }
                if (consumerAccount.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerAccount.getName());
                }
                String bigIntegerConverter = ConsumerAccountsRoomDAO_Impl.this.__bigIntegerConverter.toString(consumerAccount.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bigIntegerConverter);
                }
                String currencyCodeConverter = ConsumerAccountsRoomDAO_Impl.this.__currencyCodeConverter.toString(consumerAccount.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                if (consumerAccount.getCurrencyName() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, consumerAccount.getCurrencyName());
                }
                fVar.b0(6, consumerAccount.getDecimals());
                if (consumerAccount.getType() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, consumerAccount.getType());
                }
                if (consumerAccount.getImageUrl() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, consumerAccount.getImageUrl());
                }
                if (consumerAccount.getDestinationTagName() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, consumerAccount.getDestinationTagName());
                }
                if (consumerAccount.getAssetId() == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, consumerAccount.getAssetId());
                }
            }
        };
        this.__deletionAdapterOfConsumerAccount = new b<ConsumerAccount>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAccountsRoomDAO_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `accounts` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ConsumerAccount consumerAccount) {
                if (consumerAccount.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAccount.getId());
                }
            }
        };
        this.__updateAdapterOfConsumerAccount = new b<ConsumerAccount>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAccountsRoomDAO_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `accounts` SET `id` = ?,`name` = ?,`balance` = ?,`currencyCode` = ?,`currencyName` = ?,`decimals` = ?,`type` = ?,`imageUrl` = ?,`destination_tag_name` = ?,`asset_id` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ConsumerAccount consumerAccount) {
                if (consumerAccount.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAccount.getId());
                }
                if (consumerAccount.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerAccount.getName());
                }
                String bigIntegerConverter = ConsumerAccountsRoomDAO_Impl.this.__bigIntegerConverter.toString(consumerAccount.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bigIntegerConverter);
                }
                String currencyCodeConverter = ConsumerAccountsRoomDAO_Impl.this.__currencyCodeConverter.toString(consumerAccount.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                if (consumerAccount.getCurrencyName() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, consumerAccount.getCurrencyName());
                }
                fVar.b0(6, consumerAccount.getDecimals());
                if (consumerAccount.getType() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, consumerAccount.getType());
                }
                if (consumerAccount.getImageUrl() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, consumerAccount.getImageUrl());
                }
                if (consumerAccount.getDestinationTagName() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, consumerAccount.getDestinationTagName());
                }
                if (consumerAccount.getAssetId() == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, consumerAccount.getAssetId());
                }
                if (consumerAccount.getId() == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, consumerAccount.getId());
                }
            }
        };
    }

    private ConsumerAccount __entityCursorConverter_comCoinbaseWalletConsumerModelsConsumerAccount(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex3 = cursor.getColumnIndex("balance");
        int columnIndex4 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex5 = cursor.getColumnIndex("currencyName");
        int columnIndex6 = cursor.getColumnIndex("decimals");
        int columnIndex7 = cursor.getColumnIndex("type");
        int columnIndex8 = cursor.getColumnIndex("imageUrl");
        int columnIndex9 = cursor.getColumnIndex("destination_tag_name");
        int columnIndex10 = cursor.getColumnIndex("asset_id");
        return new ConsumerAccount(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : cursor.getString(columnIndex2), columnIndex3 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex3)), columnIndex4 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex4)), columnIndex5 == -1 ? null : cursor.getString(columnIndex5), columnIndex6 == -1 ? 0 : cursor.getInt(columnIndex6), columnIndex7 == -1 ? null : cursor.getString(columnIndex7), columnIndex8 == -1 ? null : cursor.getString(columnIndex8), columnIndex9 == -1 ? null : cursor.getString(columnIndex9), columnIndex10 != -1 ? cursor.getString(columnIndex10) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends ConsumerAccount> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfConsumerAccount.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends ConsumerAccount> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfConsumerAccount_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<ConsumerAccount> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletConsumerModelsConsumerAccount(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends ConsumerAccount> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfConsumerAccount.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(ConsumerAccount consumerAccount) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfConsumerAccount.handle(consumerAccount);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}