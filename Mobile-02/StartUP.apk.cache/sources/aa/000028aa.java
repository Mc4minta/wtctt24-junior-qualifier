package com.coinbase.wallet.wallets.db;

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
import com.coinbase.wallet.ethereum.models.ERC20;
import com.coinbase.wallet.libraries.databases.converters.UrlConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class ERC20RoomDao_Impl implements ERC20RoomDao {
    private final j __db;
    private final b<ERC20> __deletionAdapterOfERC20;
    private final c<ERC20> __insertionAdapterOfERC20;
    private final c<ERC20> __insertionAdapterOfERC20_1;
    private final b<ERC20> __updateAdapterOfERC20;
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final UrlConverter __urlConverter = new UrlConverter();

    public ERC20RoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfERC20 = new c<ERC20>(jVar) { // from class: com.coinbase.wallet.wallets.db.ERC20RoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `ERC20` (`id`,`name`,`decimals`,`contractAddress`,`chainId`,`currencyCode`,`blockchain`,`imageURL`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ERC20 erc20) {
                if (erc20.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, erc20.getId());
                }
                if (erc20.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, erc20.getName());
                }
                fVar.b0(3, erc20.getDecimals());
                if (erc20.getContractAddress() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, erc20.getContractAddress());
                }
                fVar.b0(5, erc20.getChainId());
                String currencyCodeConverter = ERC20RoomDao_Impl.this.__currencyCodeConverter.toString(erc20.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter);
                }
                String blockchainConverter = ERC20RoomDao_Impl.this.__blockchainConverter.toString(erc20.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, blockchainConverter);
                }
                String urlConverter = ERC20RoomDao_Impl.this.__urlConverter.toString(erc20.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, urlConverter);
                }
            }
        };
        this.__insertionAdapterOfERC20_1 = new c<ERC20>(jVar) { // from class: com.coinbase.wallet.wallets.db.ERC20RoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ERC20` (`id`,`name`,`decimals`,`contractAddress`,`chainId`,`currencyCode`,`blockchain`,`imageURL`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ERC20 erc20) {
                if (erc20.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, erc20.getId());
                }
                if (erc20.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, erc20.getName());
                }
                fVar.b0(3, erc20.getDecimals());
                if (erc20.getContractAddress() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, erc20.getContractAddress());
                }
                fVar.b0(5, erc20.getChainId());
                String currencyCodeConverter = ERC20RoomDao_Impl.this.__currencyCodeConverter.toString(erc20.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter);
                }
                String blockchainConverter = ERC20RoomDao_Impl.this.__blockchainConverter.toString(erc20.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, blockchainConverter);
                }
                String urlConverter = ERC20RoomDao_Impl.this.__urlConverter.toString(erc20.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, urlConverter);
                }
            }
        };
        this.__deletionAdapterOfERC20 = new b<ERC20>(jVar) { // from class: com.coinbase.wallet.wallets.db.ERC20RoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `ERC20` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ERC20 erc20) {
                if (erc20.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, erc20.getId());
                }
            }
        };
        this.__updateAdapterOfERC20 = new b<ERC20>(jVar) { // from class: com.coinbase.wallet.wallets.db.ERC20RoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `ERC20` SET `id` = ?,`name` = ?,`decimals` = ?,`contractAddress` = ?,`chainId` = ?,`currencyCode` = ?,`blockchain` = ?,`imageURL` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ERC20 erc20) {
                if (erc20.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, erc20.getId());
                }
                if (erc20.getName() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, erc20.getName());
                }
                fVar.b0(3, erc20.getDecimals());
                if (erc20.getContractAddress() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, erc20.getContractAddress());
                }
                fVar.b0(5, erc20.getChainId());
                String currencyCodeConverter = ERC20RoomDao_Impl.this.__currencyCodeConverter.toString(erc20.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, currencyCodeConverter);
                }
                String blockchainConverter = ERC20RoomDao_Impl.this.__blockchainConverter.toString(erc20.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, blockchainConverter);
                }
                String urlConverter = ERC20RoomDao_Impl.this.__urlConverter.toString(erc20.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, urlConverter);
                }
                if (erc20.getId() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, erc20.getId());
                }
            }
        };
    }

    private ERC20 __entityCursorConverter_comCoinbaseWalletEthereumModelsERC20(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex3 = cursor.getColumnIndex("decimals");
        int columnIndex4 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        int columnIndex5 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CHAIN_ID);
        int columnIndex6 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex7 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex8 = cursor.getColumnIndex("imageURL");
        return new ERC20(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : cursor.getString(columnIndex2), columnIndex3 == -1 ? 0 : cursor.getInt(columnIndex3), columnIndex4 == -1 ? null : cursor.getString(columnIndex4), columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 0, columnIndex6 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex6)), columnIndex7 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex7)), columnIndex8 != -1 ? this.__urlConverter.fromString(cursor.getString(columnIndex8)) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends ERC20> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfERC20.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends ERC20> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfERC20_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<ERC20> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletEthereumModelsERC20(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends ERC20> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfERC20.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(ERC20 erc20) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfERC20.handle(erc20);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}