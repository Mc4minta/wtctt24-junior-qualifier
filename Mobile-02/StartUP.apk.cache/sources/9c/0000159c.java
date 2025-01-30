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
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.consumer.models.ConsumerPaymentMethod;
import com.coinbase.wallet.libraries.databases.converters.BigDecimalConverter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ConsumerPaymentMethodsRoomDAO_Impl implements ConsumerPaymentMethodsRoomDAO {
    private final j __db;
    private final b<ConsumerPaymentMethod> __deletionAdapterOfConsumerPaymentMethod;
    private final c<ConsumerPaymentMethod> __insertionAdapterOfConsumerPaymentMethod;
    private final c<ConsumerPaymentMethod> __insertionAdapterOfConsumerPaymentMethod_1;
    private final b<ConsumerPaymentMethod> __updateAdapterOfConsumerPaymentMethod;
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final BigDecimalConverter __bigDecimalConverter = new BigDecimalConverter();

    public ConsumerPaymentMethodsRoomDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfConsumerPaymentMethod = new c<ConsumerPaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerPaymentMethodsRoomDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `paymentMethods` (`id`,`type`,`name`,`currencyCode`,`allow_buy`,`allow_sell`,`instant_buy`,`buy_limit`,`verified`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ConsumerPaymentMethod consumerPaymentMethod) {
                if (consumerPaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerPaymentMethod.getId());
                }
                if (consumerPaymentMethod.getType() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerPaymentMethod.getType());
                }
                if (consumerPaymentMethod.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, consumerPaymentMethod.getName());
                }
                String currencyCodeConverter = ConsumerPaymentMethodsRoomDAO_Impl.this.__currencyCodeConverter.toString(consumerPaymentMethod.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                fVar.b0(5, consumerPaymentMethod.getAllowBuy() ? 1L : 0L);
                fVar.b0(6, consumerPaymentMethod.getAllowSell() ? 1L : 0L);
                fVar.b0(7, consumerPaymentMethod.getInstantBuy() ? 1L : 0L);
                String bigDecimalConverter = ConsumerPaymentMethodsRoomDAO_Impl.this.__bigDecimalConverter.toString(consumerPaymentMethod.getBuyLimit());
                if (bigDecimalConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigDecimalConverter);
                }
                fVar.b0(9, consumerPaymentMethod.getVerified() ? 1L : 0L);
            }
        };
        this.__insertionAdapterOfConsumerPaymentMethod_1 = new c<ConsumerPaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerPaymentMethodsRoomDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `paymentMethods` (`id`,`type`,`name`,`currencyCode`,`allow_buy`,`allow_sell`,`instant_buy`,`buy_limit`,`verified`) VALUES (?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ConsumerPaymentMethod consumerPaymentMethod) {
                if (consumerPaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerPaymentMethod.getId());
                }
                if (consumerPaymentMethod.getType() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerPaymentMethod.getType());
                }
                if (consumerPaymentMethod.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, consumerPaymentMethod.getName());
                }
                String currencyCodeConverter = ConsumerPaymentMethodsRoomDAO_Impl.this.__currencyCodeConverter.toString(consumerPaymentMethod.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                fVar.b0(5, consumerPaymentMethod.getAllowBuy() ? 1L : 0L);
                fVar.b0(6, consumerPaymentMethod.getAllowSell() ? 1L : 0L);
                fVar.b0(7, consumerPaymentMethod.getInstantBuy() ? 1L : 0L);
                String bigDecimalConverter = ConsumerPaymentMethodsRoomDAO_Impl.this.__bigDecimalConverter.toString(consumerPaymentMethod.getBuyLimit());
                if (bigDecimalConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigDecimalConverter);
                }
                fVar.b0(9, consumerPaymentMethod.getVerified() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfConsumerPaymentMethod = new b<ConsumerPaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerPaymentMethodsRoomDAO_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `paymentMethods` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ConsumerPaymentMethod consumerPaymentMethod) {
                if (consumerPaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerPaymentMethod.getId());
                }
            }
        };
        this.__updateAdapterOfConsumerPaymentMethod = new b<ConsumerPaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerPaymentMethodsRoomDAO_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `paymentMethods` SET `id` = ?,`type` = ?,`name` = ?,`currencyCode` = ?,`allow_buy` = ?,`allow_sell` = ?,`instant_buy` = ?,`buy_limit` = ?,`verified` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ConsumerPaymentMethod consumerPaymentMethod) {
                if (consumerPaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerPaymentMethod.getId());
                }
                if (consumerPaymentMethod.getType() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerPaymentMethod.getType());
                }
                if (consumerPaymentMethod.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, consumerPaymentMethod.getName());
                }
                String currencyCodeConverter = ConsumerPaymentMethodsRoomDAO_Impl.this.__currencyCodeConverter.toString(consumerPaymentMethod.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                fVar.b0(5, consumerPaymentMethod.getAllowBuy() ? 1L : 0L);
                fVar.b0(6, consumerPaymentMethod.getAllowSell() ? 1L : 0L);
                fVar.b0(7, consumerPaymentMethod.getInstantBuy() ? 1L : 0L);
                String bigDecimalConverter = ConsumerPaymentMethodsRoomDAO_Impl.this.__bigDecimalConverter.toString(consumerPaymentMethod.getBuyLimit());
                if (bigDecimalConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigDecimalConverter);
                }
                fVar.b0(9, consumerPaymentMethod.getVerified() ? 1L : 0L);
                if (consumerPaymentMethod.getId() == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, consumerPaymentMethod.getId());
                }
            }
        };
    }

    private ConsumerPaymentMethod __entityCursorConverter_comCoinbaseWalletConsumerModelsConsumerPaymentMethod(Cursor cursor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("type");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex4 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex5 = cursor.getColumnIndex("allow_buy");
        int columnIndex6 = cursor.getColumnIndex("allow_sell");
        int columnIndex7 = cursor.getColumnIndex("instant_buy");
        int columnIndex8 = cursor.getColumnIndex("buy_limit");
        int columnIndex9 = cursor.getColumnIndex("verified");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        String string2 = columnIndex2 == -1 ? null : cursor.getString(columnIndex2);
        String string3 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        CurrencyCode fromString = columnIndex4 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex4));
        if (columnIndex5 == -1) {
            z = false;
        } else {
            z = cursor.getInt(columnIndex5) != 0;
        }
        if (columnIndex6 == -1) {
            z2 = false;
        } else {
            z2 = cursor.getInt(columnIndex6) != 0;
        }
        if (columnIndex7 == -1) {
            z3 = false;
        } else {
            z3 = cursor.getInt(columnIndex7) != 0;
        }
        BigDecimal fromString2 = columnIndex8 != -1 ? this.__bigDecimalConverter.fromString(cursor.getString(columnIndex8)) : null;
        if (columnIndex9 == -1) {
            z4 = false;
        } else {
            z4 = cursor.getInt(columnIndex9) != 0;
        }
        return new ConsumerPaymentMethod(string, string2, string3, fromString, z, z2, z3, fromString2, z4);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends ConsumerPaymentMethod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfConsumerPaymentMethod.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends ConsumerPaymentMethod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfConsumerPaymentMethod_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<ConsumerPaymentMethod> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletConsumerModelsConsumerPaymentMethod(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends ConsumerPaymentMethod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfConsumerPaymentMethod.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(ConsumerPaymentMethod consumerPaymentMethod) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfConsumerPaymentMethod.handle(consumerPaymentMethod);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}