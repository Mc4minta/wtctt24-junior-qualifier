package com.coinbase.wallet.swap.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.dbconverters.BlockchainConverter;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.ethereum.dbconverters.ContractAddressConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.swap.models.SwapAssetStats;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class SwapAssetStatsRoomDAO_Impl implements SwapAssetStatsRoomDAO {
    private final j __db;
    private final b<SwapAssetStats> __deletionAdapterOfSwapAssetStats;
    private final c<SwapAssetStats> __insertionAdapterOfSwapAssetStats;
    private final c<SwapAssetStats> __insertionAdapterOfSwapAssetStats_1;
    private final b<SwapAssetStats> __updateAdapterOfSwapAssetStats;
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final ContractAddressConverter __contractAddressConverter = new ContractAddressConverter();

    public SwapAssetStatsRoomDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfSwapAssetStats = new c<SwapAssetStats>(jVar) { // from class: com.coinbase.wallet.swap.db.SwapAssetStatsRoomDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `SwapAssetStats` (`id`,`blockchain`,`currencyCode`,`contractAddress`,`selectedCount`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, SwapAssetStats swapAssetStats) {
                if (swapAssetStats.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, swapAssetStats.getId());
                }
                String blockchainConverter = SwapAssetStatsRoomDAO_Impl.this.__blockchainConverter.toString(swapAssetStats.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, blockchainConverter);
                }
                String currencyCodeConverter = SwapAssetStatsRoomDAO_Impl.this.__currencyCodeConverter.toString(swapAssetStats.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, currencyCodeConverter);
                }
                String contractAddressConverter = SwapAssetStatsRoomDAO_Impl.this.__contractAddressConverter.toString(swapAssetStats.getContractAddress());
                if (contractAddressConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, contractAddressConverter);
                }
                fVar.b0(5, swapAssetStats.getSelectedCount());
            }
        };
        this.__insertionAdapterOfSwapAssetStats_1 = new c<SwapAssetStats>(jVar) { // from class: com.coinbase.wallet.swap.db.SwapAssetStatsRoomDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SwapAssetStats` (`id`,`blockchain`,`currencyCode`,`contractAddress`,`selectedCount`) VALUES (?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, SwapAssetStats swapAssetStats) {
                if (swapAssetStats.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, swapAssetStats.getId());
                }
                String blockchainConverter = SwapAssetStatsRoomDAO_Impl.this.__blockchainConverter.toString(swapAssetStats.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, blockchainConverter);
                }
                String currencyCodeConverter = SwapAssetStatsRoomDAO_Impl.this.__currencyCodeConverter.toString(swapAssetStats.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, currencyCodeConverter);
                }
                String contractAddressConverter = SwapAssetStatsRoomDAO_Impl.this.__contractAddressConverter.toString(swapAssetStats.getContractAddress());
                if (contractAddressConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, contractAddressConverter);
                }
                fVar.b0(5, swapAssetStats.getSelectedCount());
            }
        };
        this.__deletionAdapterOfSwapAssetStats = new b<SwapAssetStats>(jVar) { // from class: com.coinbase.wallet.swap.db.SwapAssetStatsRoomDAO_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `SwapAssetStats` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, SwapAssetStats swapAssetStats) {
                if (swapAssetStats.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, swapAssetStats.getId());
                }
            }
        };
        this.__updateAdapterOfSwapAssetStats = new b<SwapAssetStats>(jVar) { // from class: com.coinbase.wallet.swap.db.SwapAssetStatsRoomDAO_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `SwapAssetStats` SET `id` = ?,`blockchain` = ?,`currencyCode` = ?,`contractAddress` = ?,`selectedCount` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, SwapAssetStats swapAssetStats) {
                if (swapAssetStats.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, swapAssetStats.getId());
                }
                String blockchainConverter = SwapAssetStatsRoomDAO_Impl.this.__blockchainConverter.toString(swapAssetStats.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, blockchainConverter);
                }
                String currencyCodeConverter = SwapAssetStatsRoomDAO_Impl.this.__currencyCodeConverter.toString(swapAssetStats.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, currencyCodeConverter);
                }
                String contractAddressConverter = SwapAssetStatsRoomDAO_Impl.this.__contractAddressConverter.toString(swapAssetStats.getContractAddress());
                if (contractAddressConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, contractAddressConverter);
                }
                fVar.b0(5, swapAssetStats.getSelectedCount());
                if (swapAssetStats.getId() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, swapAssetStats.getId());
                }
            }
        };
    }

    private SwapAssetStats __entityCursorConverter_comCoinbaseWalletSwapModelsSwapAssetStats(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex3 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex4 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        int columnIndex5 = cursor.getColumnIndex("selectedCount");
        return new SwapAssetStats(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex2)), columnIndex3 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex3)), columnIndex4 != -1 ? this.__contractAddressConverter.fromString(cursor.getString(columnIndex4)) : null, columnIndex5 == -1 ? 0 : cursor.getInt(columnIndex5));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends SwapAssetStats> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSwapAssetStats.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends SwapAssetStats> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSwapAssetStats_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<SwapAssetStats> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletSwapModelsSwapAssetStats(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends SwapAssetStats> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfSwapAssetStats.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(SwapAssetStats swapAssetStats) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfSwapAssetStats.handle(swapAssetStats);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}