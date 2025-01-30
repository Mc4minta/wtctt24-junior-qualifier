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
import com.coinbase.wallet.blockchains.dbconverters.NetworkConverter;
import com.coinbase.wallet.blockchains.dbconverters.WalletAddressConverter;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import com.coinbase.wallet.libraries.databases.converters.UrlConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class CoinRoomDao_Impl implements CoinRoomDao {
    private final j __db;
    private final b<Wallet> __deletionAdapterOfWallet;
    private final c<Wallet> __insertionAdapterOfWallet;
    private final c<Wallet> __insertionAdapterOfWallet_1;
    private final b<Wallet> __updateAdapterOfWallet;
    private final WalletAddressConverter __walletAddressConverter = new WalletAddressConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final UrlConverter __urlConverter = new UrlConverter();
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();
    private final NetworkConverter __networkConverter = new NetworkConverter();

    public CoinRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfWallet = new c<Wallet>(jVar) { // from class: com.coinbase.wallet.wallets.db.CoinRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `Wallet` (`id`,`primaryAddress`,`addresses`,`displayName`,`currencyCode`,`contractAddress`,`imageURL`,`balance`,`decimals`,`blockchain`,`minimumBalance`,`network`,`selectedIndex`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Wallet wallet) {
                if (wallet.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, wallet.getId());
                }
                if (wallet.getPrimaryAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, wallet.getPrimaryAddress());
                }
                String stringFromList = CoinRoomDao_Impl.this.__walletAddressConverter.toStringFromList(wallet.getAddresses());
                if (stringFromList == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, stringFromList);
                }
                if (wallet.getDisplayName() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, wallet.getDisplayName());
                }
                String currencyCodeConverter = CoinRoomDao_Impl.this.__currencyCodeConverter.toString(wallet.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                if (wallet.getContractAddress() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, wallet.getContractAddress());
                }
                String urlConverter = CoinRoomDao_Impl.this.__urlConverter.toString(wallet.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, urlConverter);
                }
                String bigIntegerConverter = CoinRoomDao_Impl.this.__bigIntegerConverter.toString(wallet.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                fVar.b0(9, wallet.getDecimals());
                String blockchainConverter = CoinRoomDao_Impl.this.__blockchainConverter.toString(wallet.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, blockchainConverter);
                }
                String bigIntegerConverter2 = CoinRoomDao_Impl.this.__bigIntegerConverter.toString(wallet.getMinimumBalance());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter2);
                }
                String networkConverter = CoinRoomDao_Impl.this.__networkConverter.toString(wallet.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, networkConverter);
                }
                if (wallet.getSelectedIndex() == null) {
                    fVar.B0(13);
                } else {
                    fVar.b0(13, wallet.getSelectedIndex().intValue());
                }
            }
        };
        this.__insertionAdapterOfWallet_1 = new c<Wallet>(jVar) { // from class: com.coinbase.wallet.wallets.db.CoinRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Wallet` (`id`,`primaryAddress`,`addresses`,`displayName`,`currencyCode`,`contractAddress`,`imageURL`,`balance`,`decimals`,`blockchain`,`minimumBalance`,`network`,`selectedIndex`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Wallet wallet) {
                if (wallet.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, wallet.getId());
                }
                if (wallet.getPrimaryAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, wallet.getPrimaryAddress());
                }
                String stringFromList = CoinRoomDao_Impl.this.__walletAddressConverter.toStringFromList(wallet.getAddresses());
                if (stringFromList == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, stringFromList);
                }
                if (wallet.getDisplayName() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, wallet.getDisplayName());
                }
                String currencyCodeConverter = CoinRoomDao_Impl.this.__currencyCodeConverter.toString(wallet.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                if (wallet.getContractAddress() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, wallet.getContractAddress());
                }
                String urlConverter = CoinRoomDao_Impl.this.__urlConverter.toString(wallet.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, urlConverter);
                }
                String bigIntegerConverter = CoinRoomDao_Impl.this.__bigIntegerConverter.toString(wallet.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                fVar.b0(9, wallet.getDecimals());
                String blockchainConverter = CoinRoomDao_Impl.this.__blockchainConverter.toString(wallet.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, blockchainConverter);
                }
                String bigIntegerConverter2 = CoinRoomDao_Impl.this.__bigIntegerConverter.toString(wallet.getMinimumBalance());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter2);
                }
                String networkConverter = CoinRoomDao_Impl.this.__networkConverter.toString(wallet.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, networkConverter);
                }
                if (wallet.getSelectedIndex() == null) {
                    fVar.B0(13);
                } else {
                    fVar.b0(13, wallet.getSelectedIndex().intValue());
                }
            }
        };
        this.__deletionAdapterOfWallet = new b<Wallet>(jVar) { // from class: com.coinbase.wallet.wallets.db.CoinRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `Wallet` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Wallet wallet) {
                if (wallet.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, wallet.getId());
                }
            }
        };
        this.__updateAdapterOfWallet = new b<Wallet>(jVar) { // from class: com.coinbase.wallet.wallets.db.CoinRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `Wallet` SET `id` = ?,`primaryAddress` = ?,`addresses` = ?,`displayName` = ?,`currencyCode` = ?,`contractAddress` = ?,`imageURL` = ?,`balance` = ?,`decimals` = ?,`blockchain` = ?,`minimumBalance` = ?,`network` = ?,`selectedIndex` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Wallet wallet) {
                if (wallet.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, wallet.getId());
                }
                if (wallet.getPrimaryAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, wallet.getPrimaryAddress());
                }
                String stringFromList = CoinRoomDao_Impl.this.__walletAddressConverter.toStringFromList(wallet.getAddresses());
                if (stringFromList == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, stringFromList);
                }
                if (wallet.getDisplayName() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, wallet.getDisplayName());
                }
                String currencyCodeConverter = CoinRoomDao_Impl.this.__currencyCodeConverter.toString(wallet.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                if (wallet.getContractAddress() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, wallet.getContractAddress());
                }
                String urlConverter = CoinRoomDao_Impl.this.__urlConverter.toString(wallet.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, urlConverter);
                }
                String bigIntegerConverter = CoinRoomDao_Impl.this.__bigIntegerConverter.toString(wallet.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                fVar.b0(9, wallet.getDecimals());
                String blockchainConverter = CoinRoomDao_Impl.this.__blockchainConverter.toString(wallet.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, blockchainConverter);
                }
                String bigIntegerConverter2 = CoinRoomDao_Impl.this.__bigIntegerConverter.toString(wallet.getMinimumBalance());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter2);
                }
                String networkConverter = CoinRoomDao_Impl.this.__networkConverter.toString(wallet.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, networkConverter);
                }
                if (wallet.getSelectedIndex() == null) {
                    fVar.B0(13);
                } else {
                    fVar.b0(13, wallet.getSelectedIndex().intValue());
                }
                if (wallet.getId() == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, wallet.getId());
                }
            }
        };
    }

    private Wallet __entityCursorConverter_comCoinbaseWalletBlockchainsModelsWallet(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("primaryAddress");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.ADDRESSES);
        int columnIndex4 = cursor.getColumnIndex("displayName");
        int columnIndex5 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex6 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        int columnIndex7 = cursor.getColumnIndex("imageURL");
        int columnIndex8 = cursor.getColumnIndex("balance");
        int columnIndex9 = cursor.getColumnIndex("decimals");
        int columnIndex10 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex11 = cursor.getColumnIndex("minimumBalance");
        int columnIndex12 = cursor.getColumnIndex("network");
        int columnIndex13 = cursor.getColumnIndex("selectedIndex");
        return new Wallet(columnIndex == -1 ? null : cursor.getString(columnIndex), columnIndex2 == -1 ? null : cursor.getString(columnIndex2), columnIndex3 == -1 ? null : this.__walletAddressConverter.fromStringToList(cursor.getString(columnIndex3)), columnIndex4 == -1 ? null : cursor.getString(columnIndex4), columnIndex5 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex5)), columnIndex6 == -1 ? null : cursor.getString(columnIndex6), columnIndex7 == -1 ? null : this.__urlConverter.fromString(cursor.getString(columnIndex7)), columnIndex8 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex8)), columnIndex9 == -1 ? 0 : cursor.getInt(columnIndex9), columnIndex10 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex10)), columnIndex11 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex11)), columnIndex12 == -1 ? null : this.__networkConverter.fromString(cursor.getString(columnIndex12)), (columnIndex13 == -1 || cursor.isNull(columnIndex13)) ? null : Integer.valueOf(cursor.getInt(columnIndex13)));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends Wallet> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWallet.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends Wallet> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWallet_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<Wallet> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletBlockchainsModelsWallet(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends Wallet> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWallet.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(Wallet wallet) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfWallet.handle(wallet);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}