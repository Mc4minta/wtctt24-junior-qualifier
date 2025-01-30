package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.compoundfinance.models.CompoundToken;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class CompoundTokenRoomDao_Impl implements CompoundTokenRoomDao {
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final j __db;
    private final b<CompoundToken> __deletionAdapterOfCompoundToken;
    private final c<CompoundToken> __insertionAdapterOfCompoundToken;
    private final c<CompoundToken> __insertionAdapterOfCompoundToken_1;
    private final b<CompoundToken> __updateAdapterOfCompoundToken;

    public CompoundTokenRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfCompoundToken = new c<CompoundToken>(jVar) { // from class: com.coinbase.wallet.wallets.db.CompoundTokenRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `CompoundToken` (`id`,`name`,`code`,`decimals`,`contractAddress`,`underlyingCode`,`underlyingContractAddress`,`underlyingDecimals`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, CompoundToken compoundToken) {
                if (compoundToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, compoundToken.getId());
                }
                if (compoundToken.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, compoundToken.getName());
                }
                String currencyCodeConverter = CompoundTokenRoomDao_Impl.this.__currencyCodeConverter.toString(compoundToken.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, currencyCodeConverter);
                }
                fVar.b0(4, compoundToken.getDecimals());
                if (compoundToken.getContractAddress() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, compoundToken.getContractAddress());
                }
                String currencyCodeConverter2 = CompoundTokenRoomDao_Impl.this.__currencyCodeConverter.toString(compoundToken.getUnderlyingCode());
                if (currencyCodeConverter2 == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter2);
                }
                if (compoundToken.getUnderlyingContractAddress() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, compoundToken.getUnderlyingContractAddress());
                }
                fVar.b0(8, compoundToken.getUnderlyingDecimals());
            }
        };
        this.__insertionAdapterOfCompoundToken_1 = new c<CompoundToken>(jVar) { // from class: com.coinbase.wallet.wallets.db.CompoundTokenRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `CompoundToken` (`id`,`name`,`code`,`decimals`,`contractAddress`,`underlyingCode`,`underlyingContractAddress`,`underlyingDecimals`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, CompoundToken compoundToken) {
                if (compoundToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, compoundToken.getId());
                }
                if (compoundToken.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, compoundToken.getName());
                }
                String currencyCodeConverter = CompoundTokenRoomDao_Impl.this.__currencyCodeConverter.toString(compoundToken.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, currencyCodeConverter);
                }
                fVar.b0(4, compoundToken.getDecimals());
                if (compoundToken.getContractAddress() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, compoundToken.getContractAddress());
                }
                String currencyCodeConverter2 = CompoundTokenRoomDao_Impl.this.__currencyCodeConverter.toString(compoundToken.getUnderlyingCode());
                if (currencyCodeConverter2 == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter2);
                }
                if (compoundToken.getUnderlyingContractAddress() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, compoundToken.getUnderlyingContractAddress());
                }
                fVar.b0(8, compoundToken.getUnderlyingDecimals());
            }
        };
        this.__deletionAdapterOfCompoundToken = new b<CompoundToken>(jVar) { // from class: com.coinbase.wallet.wallets.db.CompoundTokenRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `CompoundToken` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, CompoundToken compoundToken) {
                if (compoundToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, compoundToken.getId());
                }
            }
        };
        this.__updateAdapterOfCompoundToken = new b<CompoundToken>(jVar) { // from class: com.coinbase.wallet.wallets.db.CompoundTokenRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `CompoundToken` SET `id` = ?,`name` = ?,`code` = ?,`decimals` = ?,`contractAddress` = ?,`underlyingCode` = ?,`underlyingContractAddress` = ?,`underlyingDecimals` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, CompoundToken compoundToken) {
                if (compoundToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, compoundToken.getId());
                }
                if (compoundToken.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, compoundToken.getName());
                }
                String currencyCodeConverter = CompoundTokenRoomDao_Impl.this.__currencyCodeConverter.toString(compoundToken.getCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, currencyCodeConverter);
                }
                fVar.b0(4, compoundToken.getDecimals());
                if (compoundToken.getContractAddress() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, compoundToken.getContractAddress());
                }
                String currencyCodeConverter2 = CompoundTokenRoomDao_Impl.this.__currencyCodeConverter.toString(compoundToken.getUnderlyingCode());
                if (currencyCodeConverter2 == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter2);
                }
                if (compoundToken.getUnderlyingContractAddress() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, compoundToken.getUnderlyingContractAddress());
                }
                fVar.b0(8, compoundToken.getUnderlyingDecimals());
                if (compoundToken.getId() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, compoundToken.getId());
                }
            }
        };
    }

    private CompoundToken __entityCursorConverter_comCoinbaseWalletCompoundfinanceModelsCompoundToken(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex3 = cursor.getColumnIndex("code");
        int columnIndex4 = cursor.getColumnIndex("decimals");
        int columnIndex5 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        int columnIndex6 = cursor.getColumnIndex("underlyingCode");
        int columnIndex7 = cursor.getColumnIndex("underlyingContractAddress");
        int columnIndex8 = cursor.getColumnIndex("underlyingDecimals");
        return new CompoundToken(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : cursor.getString(columnIndex2), columnIndex3 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex3)), columnIndex4 == -1 ? 0 : cursor.getInt(columnIndex4), columnIndex5 == -1 ? null : cursor.getString(columnIndex5), columnIndex6 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex6)), columnIndex7 != -1 ? cursor.getString(columnIndex7) : null, columnIndex8 == -1 ? 0 : cursor.getInt(columnIndex8));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends CompoundToken> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCompoundToken.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends CompoundToken> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCompoundToken_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<CompoundToken> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletCompoundfinanceModelsCompoundToken(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends CompoundToken> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfCompoundToken.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(CompoundToken compoundToken) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfCompoundToken.handle(compoundToken);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}