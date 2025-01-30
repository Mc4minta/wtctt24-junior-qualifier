package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.libraries.databases.converters.BigDecimalConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.ExchangeRate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class FiatExchangeRateRoomDao_Impl implements FiatExchangeRateRoomDao {
    private final j __db;
    private final b<ExchangeRate> __deletionAdapterOfExchangeRate;
    private final c<ExchangeRate> __insertionAdapterOfExchangeRate;
    private final c<ExchangeRate> __insertionAdapterOfExchangeRate_1;
    private final b<ExchangeRate> __updateAdapterOfExchangeRate;
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final BigDecimalConverter __bigDecimalConverter = new BigDecimalConverter();

    public FiatExchangeRateRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfExchangeRate = new c<ExchangeRate>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatExchangeRateRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `ExchangeRate` (`id`,`currencyCode`,`rate`,`contractAddress`,`chainId`,`name`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ExchangeRate exchangeRate) {
                if (exchangeRate.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, exchangeRate.getId());
                }
                String currencyCodeConverter = FiatExchangeRateRoomDao_Impl.this.__currencyCodeConverter.toString(exchangeRate.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                String bigDecimalConverter = FiatExchangeRateRoomDao_Impl.this.__bigDecimalConverter.toString(exchangeRate.getRate());
                if (bigDecimalConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bigDecimalConverter);
                }
                if (exchangeRate.getContractAddress() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, exchangeRate.getContractAddress());
                }
                if (exchangeRate.getChainId() == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, exchangeRate.getChainId().intValue());
                }
                if (exchangeRate.getName() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, exchangeRate.getName());
                }
            }
        };
        this.__insertionAdapterOfExchangeRate_1 = new c<ExchangeRate>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatExchangeRateRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ExchangeRate` (`id`,`currencyCode`,`rate`,`contractAddress`,`chainId`,`name`) VALUES (?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ExchangeRate exchangeRate) {
                if (exchangeRate.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, exchangeRate.getId());
                }
                String currencyCodeConverter = FiatExchangeRateRoomDao_Impl.this.__currencyCodeConverter.toString(exchangeRate.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                String bigDecimalConverter = FiatExchangeRateRoomDao_Impl.this.__bigDecimalConverter.toString(exchangeRate.getRate());
                if (bigDecimalConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bigDecimalConverter);
                }
                if (exchangeRate.getContractAddress() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, exchangeRate.getContractAddress());
                }
                if (exchangeRate.getChainId() == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, exchangeRate.getChainId().intValue());
                }
                if (exchangeRate.getName() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, exchangeRate.getName());
                }
            }
        };
        this.__deletionAdapterOfExchangeRate = new b<ExchangeRate>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatExchangeRateRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `ExchangeRate` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ExchangeRate exchangeRate) {
                if (exchangeRate.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, exchangeRate.getId());
                }
            }
        };
        this.__updateAdapterOfExchangeRate = new b<ExchangeRate>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatExchangeRateRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `ExchangeRate` SET `id` = ?,`currencyCode` = ?,`rate` = ?,`contractAddress` = ?,`chainId` = ?,`name` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ExchangeRate exchangeRate) {
                if (exchangeRate.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, exchangeRate.getId());
                }
                String currencyCodeConverter = FiatExchangeRateRoomDao_Impl.this.__currencyCodeConverter.toString(exchangeRate.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                String bigDecimalConverter = FiatExchangeRateRoomDao_Impl.this.__bigDecimalConverter.toString(exchangeRate.getRate());
                if (bigDecimalConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, bigDecimalConverter);
                }
                if (exchangeRate.getContractAddress() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, exchangeRate.getContractAddress());
                }
                if (exchangeRate.getChainId() == null) {
                    fVar.B0(5);
                } else {
                    fVar.b0(5, exchangeRate.getChainId().intValue());
                }
                if (exchangeRate.getName() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, exchangeRate.getName());
                }
                if (exchangeRate.getId() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, exchangeRate.getId());
                }
            }
        };
    }

    private ExchangeRate __entityCursorConverter_comCoinbaseWalletWalletsModelsExchangeRate(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex3 = cursor.getColumnIndex("rate");
        int columnIndex4 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        int columnIndex5 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CHAIN_ID);
        int columnIndex6 = cursor.getColumnIndex(ApiConstants.NAME);
        return new ExchangeRate(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex2)), columnIndex3 == -1 ? null : this.__bigDecimalConverter.fromString(cursor.getString(columnIndex3)), columnIndex4 == -1 ? null : cursor.getString(columnIndex4), (columnIndex5 == -1 || cursor.isNull(columnIndex5)) ? null : Integer.valueOf(cursor.getInt(columnIndex5)), columnIndex6 != -1 ? cursor.getString(columnIndex6) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends ExchangeRate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfExchangeRate.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends ExchangeRate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfExchangeRate_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<ExchangeRate> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletWalletsModelsExchangeRate(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends ExchangeRate> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfExchangeRate.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(ExchangeRate exchangeRate) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfExchangeRate.handle(exchangeRate);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}