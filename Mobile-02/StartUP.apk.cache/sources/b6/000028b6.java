package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.wallets.models.FiatCurrency;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class FiatCurrencyRoomDao_Impl implements FiatCurrencyRoomDao {
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final j __db;
    private final b<FiatCurrency> __deletionAdapterOfFiatCurrency;
    private final c<FiatCurrency> __insertionAdapterOfFiatCurrency;
    private final c<FiatCurrency> __insertionAdapterOfFiatCurrency_1;
    private final b<FiatCurrency> __updateAdapterOfFiatCurrency;

    public FiatCurrencyRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfFiatCurrency = new c<FiatCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatCurrencyRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `FiatCurrency` (`id`,`code`,`name`,`decimals`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, FiatCurrency fiatCurrency) {
                if (fiatCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, fiatCurrency.getId());
                }
                String currencyCodeConverter = FiatCurrencyRoomDao_Impl.this.__currencyCodeConverter.toString(fiatCurrency.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                if (fiatCurrency.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, fiatCurrency.getName());
                }
                fVar.b0(4, fiatCurrency.getDecimals());
            }
        };
        this.__insertionAdapterOfFiatCurrency_1 = new c<FiatCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatCurrencyRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `FiatCurrency` (`id`,`code`,`name`,`decimals`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, FiatCurrency fiatCurrency) {
                if (fiatCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, fiatCurrency.getId());
                }
                String currencyCodeConverter = FiatCurrencyRoomDao_Impl.this.__currencyCodeConverter.toString(fiatCurrency.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                if (fiatCurrency.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, fiatCurrency.getName());
                }
                fVar.b0(4, fiatCurrency.getDecimals());
            }
        };
        this.__deletionAdapterOfFiatCurrency = new b<FiatCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatCurrencyRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `FiatCurrency` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, FiatCurrency fiatCurrency) {
                if (fiatCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, fiatCurrency.getId());
                }
            }
        };
        this.__updateAdapterOfFiatCurrency = new b<FiatCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.FiatCurrencyRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `FiatCurrency` SET `id` = ?,`code` = ?,`name` = ?,`decimals` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, FiatCurrency fiatCurrency) {
                if (fiatCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, fiatCurrency.getId());
                }
                String currencyCodeConverter = FiatCurrencyRoomDao_Impl.this.__currencyCodeConverter.toString(fiatCurrency.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                if (fiatCurrency.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, fiatCurrency.getName());
                }
                fVar.b0(4, fiatCurrency.getDecimals());
                if (fiatCurrency.getId() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, fiatCurrency.getId());
                }
            }
        };
    }

    private FiatCurrency __entityCursorConverter_comCoinbaseWalletWalletsModelsFiatCurrency(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("code");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex4 = cursor.getColumnIndex("decimals");
        return new FiatCurrency(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex2)), columnIndex3 != -1 ? cursor.getString(columnIndex3) : null, columnIndex4 == -1 ? 0 : cursor.getInt(columnIndex4));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends FiatCurrency> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFiatCurrency.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends FiatCurrency> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFiatCurrency_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<FiatCurrency> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletWalletsModelsFiatCurrency(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends FiatCurrency> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfFiatCurrency.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(FiatCurrency fiatCurrency) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfFiatCurrency.handle(fiatCurrency);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}