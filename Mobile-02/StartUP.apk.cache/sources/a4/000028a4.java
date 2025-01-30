package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.BlockchainConverter;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.libraries.databases.converters.UrlConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.wallets.models.CryptoCurrency;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class CryptoCurrencyRoomDao_Impl implements CryptoCurrencyRoomDao {
    private final j __db;
    private final b<CryptoCurrency> __deletionAdapterOfCryptoCurrency;
    private final c<CryptoCurrency> __insertionAdapterOfCryptoCurrency;
    private final c<CryptoCurrency> __insertionAdapterOfCryptoCurrency_1;
    private final b<CryptoCurrency> __updateAdapterOfCryptoCurrency;
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final UrlConverter __urlConverter = new UrlConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();

    public CryptoCurrencyRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfCryptoCurrency = new c<CryptoCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.CryptoCurrencyRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `CryptoCurrency` (`id`,`code`,`name`,`imageUrl`,`decimals`,`blockchain`,`sortIndex`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, CryptoCurrency cryptoCurrency) {
                if (cryptoCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, cryptoCurrency.getId());
                }
                String currencyCodeConverter = CryptoCurrencyRoomDao_Impl.this.__currencyCodeConverter.toString(cryptoCurrency.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                if (cryptoCurrency.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, cryptoCurrency.getName());
                }
                String urlConverter = CryptoCurrencyRoomDao_Impl.this.__urlConverter.toString(cryptoCurrency.getImageUrl());
                if (urlConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, urlConverter);
                }
                fVar.b0(5, cryptoCurrency.getDecimals());
                String blockchainConverter = CryptoCurrencyRoomDao_Impl.this.__blockchainConverter.toString(cryptoCurrency.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, blockchainConverter);
                }
                fVar.b0(7, cryptoCurrency.getSortIndex());
            }
        };
        this.__insertionAdapterOfCryptoCurrency_1 = new c<CryptoCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.CryptoCurrencyRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `CryptoCurrency` (`id`,`code`,`name`,`imageUrl`,`decimals`,`blockchain`,`sortIndex`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, CryptoCurrency cryptoCurrency) {
                if (cryptoCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, cryptoCurrency.getId());
                }
                String currencyCodeConverter = CryptoCurrencyRoomDao_Impl.this.__currencyCodeConverter.toString(cryptoCurrency.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                if (cryptoCurrency.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, cryptoCurrency.getName());
                }
                String urlConverter = CryptoCurrencyRoomDao_Impl.this.__urlConverter.toString(cryptoCurrency.getImageUrl());
                if (urlConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, urlConverter);
                }
                fVar.b0(5, cryptoCurrency.getDecimals());
                String blockchainConverter = CryptoCurrencyRoomDao_Impl.this.__blockchainConverter.toString(cryptoCurrency.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, blockchainConverter);
                }
                fVar.b0(7, cryptoCurrency.getSortIndex());
            }
        };
        this.__deletionAdapterOfCryptoCurrency = new b<CryptoCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.CryptoCurrencyRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `CryptoCurrency` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, CryptoCurrency cryptoCurrency) {
                if (cryptoCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, cryptoCurrency.getId());
                }
            }
        };
        this.__updateAdapterOfCryptoCurrency = new b<CryptoCurrency>(jVar) { // from class: com.coinbase.wallet.wallets.db.CryptoCurrencyRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `CryptoCurrency` SET `id` = ?,`code` = ?,`name` = ?,`imageUrl` = ?,`decimals` = ?,`blockchain` = ?,`sortIndex` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, CryptoCurrency cryptoCurrency) {
                if (cryptoCurrency.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, cryptoCurrency.getId());
                }
                String currencyCodeConverter = CryptoCurrencyRoomDao_Impl.this.__currencyCodeConverter.toString(cryptoCurrency.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, currencyCodeConverter);
                }
                if (cryptoCurrency.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, cryptoCurrency.getName());
                }
                String urlConverter = CryptoCurrencyRoomDao_Impl.this.__urlConverter.toString(cryptoCurrency.getImageUrl());
                if (urlConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, urlConverter);
                }
                fVar.b0(5, cryptoCurrency.getDecimals());
                String blockchainConverter = CryptoCurrencyRoomDao_Impl.this.__blockchainConverter.toString(cryptoCurrency.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, blockchainConverter);
                }
                fVar.b0(7, cryptoCurrency.getSortIndex());
                if (cryptoCurrency.getId() == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, cryptoCurrency.getId());
                }
            }
        };
    }

    private CryptoCurrency __entityCursorConverter_comCoinbaseWalletWalletsModelsCryptoCurrency(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("code");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex4 = cursor.getColumnIndex("imageUrl");
        int columnIndex5 = cursor.getColumnIndex("decimals");
        int columnIndex6 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex7 = cursor.getColumnIndex("sortIndex");
        return new CryptoCurrency(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex2)), columnIndex3 == -1 ? null : cursor.getString(columnIndex3), columnIndex4 == -1 ? null : this.__urlConverter.fromString(cursor.getString(columnIndex4)), columnIndex5 == -1 ? 0 : cursor.getInt(columnIndex5), columnIndex6 != -1 ? this.__blockchainConverter.fromString(cursor.getString(columnIndex6)) : null, columnIndex7 == -1 ? 0 : cursor.getInt(columnIndex7));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends CryptoCurrency> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCryptoCurrency.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends CryptoCurrency> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCryptoCurrency_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<CryptoCurrency> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletWalletsModelsCryptoCurrency(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends CryptoCurrency> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfCryptoCurrency.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(CryptoCurrency cryptoCurrency) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfCryptoCurrency.handle(cryptoCurrency);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}