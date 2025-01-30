package com.coinbase.wallet.lending.db;

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
import com.coinbase.wallet.ethereum.dbconverters.ContractAddressConverter;
import com.coinbase.wallet.ethereum.models.ContractAddress;
import com.coinbase.wallet.lending.dbconverters.LendProviderIDConverter;
import com.coinbase.wallet.lending.models.LendProviderID;
import com.coinbase.wallet.lending.models.LendToken;
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import com.coinbase.wallet.libraries.databases.converters.UrlConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class LendTokenRoomDAO_Impl implements LendTokenRoomDAO {
    private final j __db;
    private final b<LendToken> __deletionAdapterOfLendToken;
    private final c<LendToken> __insertionAdapterOfLendToken;
    private final c<LendToken> __insertionAdapterOfLendToken_1;
    private final b<LendToken> __updateAdapterOfLendToken;
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final UrlConverter __urlConverter = new UrlConverter();
    private final ContractAddressConverter __contractAddressConverter = new ContractAddressConverter();
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();
    private final LendProviderIDConverter __lendProviderIDConverter = new LendProviderIDConverter();

    public LendTokenRoomDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfLendToken = new c<LendToken>(jVar) { // from class: com.coinbase.wallet.lending.db.LendTokenRoomDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `LendToken` (`id`,`walletAddress`,`name`,`currencyCode`,`decimals`,`imageURL`,`contractAddress`,`supplyBalance`,`supplyInterestRate`,`globalSuppliedAmount`,`utilizationRate`,`collateralRate`,`isCollateralRateApplicable`,`providerID`,`providerName`,`providerWebsiteURL`,`providerImageURL`,`rateDecimals`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, LendToken lendToken) {
                if (lendToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, lendToken.getId());
                }
                if (lendToken.getWalletAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, lendToken.getWalletAddress());
                }
                if (lendToken.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, lendToken.getName());
                }
                String currencyCodeConverter = LendTokenRoomDAO_Impl.this.__currencyCodeConverter.toString(lendToken.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                fVar.b0(5, lendToken.getDecimals());
                String urlConverter = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, urlConverter);
                }
                String contractAddressConverter = LendTokenRoomDAO_Impl.this.__contractAddressConverter.toString(lendToken.getContractAddress());
                if (contractAddressConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, contractAddressConverter);
                }
                String bigIntegerConverter = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getSupplyBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                String bigIntegerConverter2 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getSupplyInterestRate());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter2);
                }
                String bigIntegerConverter3 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getGlobalSuppliedAmount());
                if (bigIntegerConverter3 == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, bigIntegerConverter3);
                }
                String bigIntegerConverter4 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getUtilizationRate());
                if (bigIntegerConverter4 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter4);
                }
                String bigIntegerConverter5 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getCollateralRate());
                if (bigIntegerConverter5 == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, bigIntegerConverter5);
                }
                fVar.b0(13, lendToken.isCollateralRateApplicable() ? 1L : 0L);
                String lendProviderIDConverter = LendTokenRoomDAO_Impl.this.__lendProviderIDConverter.toString(lendToken.getProviderID());
                if (lendProviderIDConverter == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, lendProviderIDConverter);
                }
                if (lendToken.getProviderName() == null) {
                    fVar.B0(15);
                } else {
                    fVar.u(15, lendToken.getProviderName());
                }
                String urlConverter2 = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getProviderWebsiteURL());
                if (urlConverter2 == null) {
                    fVar.B0(16);
                } else {
                    fVar.u(16, urlConverter2);
                }
                String urlConverter3 = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getProviderImageURL());
                if (urlConverter3 == null) {
                    fVar.B0(17);
                } else {
                    fVar.u(17, urlConverter3);
                }
                fVar.b0(18, lendToken.getRateDecimals());
            }
        };
        this.__insertionAdapterOfLendToken_1 = new c<LendToken>(jVar) { // from class: com.coinbase.wallet.lending.db.LendTokenRoomDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `LendToken` (`id`,`walletAddress`,`name`,`currencyCode`,`decimals`,`imageURL`,`contractAddress`,`supplyBalance`,`supplyInterestRate`,`globalSuppliedAmount`,`utilizationRate`,`collateralRate`,`isCollateralRateApplicable`,`providerID`,`providerName`,`providerWebsiteURL`,`providerImageURL`,`rateDecimals`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, LendToken lendToken) {
                if (lendToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, lendToken.getId());
                }
                if (lendToken.getWalletAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, lendToken.getWalletAddress());
                }
                if (lendToken.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, lendToken.getName());
                }
                String currencyCodeConverter = LendTokenRoomDAO_Impl.this.__currencyCodeConverter.toString(lendToken.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                fVar.b0(5, lendToken.getDecimals());
                String urlConverter = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, urlConverter);
                }
                String contractAddressConverter = LendTokenRoomDAO_Impl.this.__contractAddressConverter.toString(lendToken.getContractAddress());
                if (contractAddressConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, contractAddressConverter);
                }
                String bigIntegerConverter = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getSupplyBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                String bigIntegerConverter2 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getSupplyInterestRate());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter2);
                }
                String bigIntegerConverter3 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getGlobalSuppliedAmount());
                if (bigIntegerConverter3 == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, bigIntegerConverter3);
                }
                String bigIntegerConverter4 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getUtilizationRate());
                if (bigIntegerConverter4 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter4);
                }
                String bigIntegerConverter5 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getCollateralRate());
                if (bigIntegerConverter5 == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, bigIntegerConverter5);
                }
                fVar.b0(13, lendToken.isCollateralRateApplicable() ? 1L : 0L);
                String lendProviderIDConverter = LendTokenRoomDAO_Impl.this.__lendProviderIDConverter.toString(lendToken.getProviderID());
                if (lendProviderIDConverter == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, lendProviderIDConverter);
                }
                if (lendToken.getProviderName() == null) {
                    fVar.B0(15);
                } else {
                    fVar.u(15, lendToken.getProviderName());
                }
                String urlConverter2 = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getProviderWebsiteURL());
                if (urlConverter2 == null) {
                    fVar.B0(16);
                } else {
                    fVar.u(16, urlConverter2);
                }
                String urlConverter3 = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getProviderImageURL());
                if (urlConverter3 == null) {
                    fVar.B0(17);
                } else {
                    fVar.u(17, urlConverter3);
                }
                fVar.b0(18, lendToken.getRateDecimals());
            }
        };
        this.__deletionAdapterOfLendToken = new b<LendToken>(jVar) { // from class: com.coinbase.wallet.lending.db.LendTokenRoomDAO_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `LendToken` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, LendToken lendToken) {
                if (lendToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, lendToken.getId());
                }
            }
        };
        this.__updateAdapterOfLendToken = new b<LendToken>(jVar) { // from class: com.coinbase.wallet.lending.db.LendTokenRoomDAO_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `LendToken` SET `id` = ?,`walletAddress` = ?,`name` = ?,`currencyCode` = ?,`decimals` = ?,`imageURL` = ?,`contractAddress` = ?,`supplyBalance` = ?,`supplyInterestRate` = ?,`globalSuppliedAmount` = ?,`utilizationRate` = ?,`collateralRate` = ?,`isCollateralRateApplicable` = ?,`providerID` = ?,`providerName` = ?,`providerWebsiteURL` = ?,`providerImageURL` = ?,`rateDecimals` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, LendToken lendToken) {
                if (lendToken.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, lendToken.getId());
                }
                if (lendToken.getWalletAddress() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, lendToken.getWalletAddress());
                }
                if (lendToken.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, lendToken.getName());
                }
                String currencyCodeConverter = LendTokenRoomDAO_Impl.this.__currencyCodeConverter.toString(lendToken.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, currencyCodeConverter);
                }
                fVar.b0(5, lendToken.getDecimals());
                String urlConverter = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getImageURL());
                if (urlConverter == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, urlConverter);
                }
                String contractAddressConverter = LendTokenRoomDAO_Impl.this.__contractAddressConverter.toString(lendToken.getContractAddress());
                if (contractAddressConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, contractAddressConverter);
                }
                String bigIntegerConverter = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getSupplyBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, bigIntegerConverter);
                }
                String bigIntegerConverter2 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getSupplyInterestRate());
                if (bigIntegerConverter2 == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, bigIntegerConverter2);
                }
                String bigIntegerConverter3 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getGlobalSuppliedAmount());
                if (bigIntegerConverter3 == null) {
                    fVar.B0(10);
                } else {
                    fVar.u(10, bigIntegerConverter3);
                }
                String bigIntegerConverter4 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getUtilizationRate());
                if (bigIntegerConverter4 == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, bigIntegerConverter4);
                }
                String bigIntegerConverter5 = LendTokenRoomDAO_Impl.this.__bigIntegerConverter.toString(lendToken.getCollateralRate());
                if (bigIntegerConverter5 == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, bigIntegerConverter5);
                }
                fVar.b0(13, lendToken.isCollateralRateApplicable() ? 1L : 0L);
                String lendProviderIDConverter = LendTokenRoomDAO_Impl.this.__lendProviderIDConverter.toString(lendToken.getProviderID());
                if (lendProviderIDConverter == null) {
                    fVar.B0(14);
                } else {
                    fVar.u(14, lendProviderIDConverter);
                }
                if (lendToken.getProviderName() == null) {
                    fVar.B0(15);
                } else {
                    fVar.u(15, lendToken.getProviderName());
                }
                String urlConverter2 = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getProviderWebsiteURL());
                if (urlConverter2 == null) {
                    fVar.B0(16);
                } else {
                    fVar.u(16, urlConverter2);
                }
                String urlConverter3 = LendTokenRoomDAO_Impl.this.__urlConverter.toString(lendToken.getProviderImageURL());
                if (urlConverter3 == null) {
                    fVar.B0(17);
                } else {
                    fVar.u(17, urlConverter3);
                }
                fVar.b0(18, lendToken.getRateDecimals());
                if (lendToken.getId() == null) {
                    fVar.B0(19);
                } else {
                    fVar.u(19, lendToken.getId());
                }
            }
        };
    }

    private LendToken __entityCursorConverter_comCoinbaseWalletLendingModelsLendToken(Cursor cursor) {
        boolean z;
        LendProviderID fromString;
        int i2;
        String string;
        int i3;
        URL fromString2;
        int i4;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("walletAddress");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex4 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex5 = cursor.getColumnIndex("decimals");
        int columnIndex6 = cursor.getColumnIndex("imageURL");
        int columnIndex7 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        int columnIndex8 = cursor.getColumnIndex("supplyBalance");
        int columnIndex9 = cursor.getColumnIndex("supplyInterestRate");
        int columnIndex10 = cursor.getColumnIndex("globalSuppliedAmount");
        int columnIndex11 = cursor.getColumnIndex("utilizationRate");
        int columnIndex12 = cursor.getColumnIndex("collateralRate");
        int columnIndex13 = cursor.getColumnIndex("isCollateralRateApplicable");
        int columnIndex14 = cursor.getColumnIndex("providerID");
        int columnIndex15 = cursor.getColumnIndex("providerName");
        int columnIndex16 = cursor.getColumnIndex("providerWebsiteURL");
        int columnIndex17 = cursor.getColumnIndex("providerImageURL");
        int columnIndex18 = cursor.getColumnIndex("rateDecimals");
        String string2 = columnIndex == -1 ? null : cursor.getString(columnIndex);
        String string3 = columnIndex2 == -1 ? null : cursor.getString(columnIndex2);
        String string4 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        CurrencyCode fromString3 = columnIndex4 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex4));
        int i5 = columnIndex5 == -1 ? 0 : cursor.getInt(columnIndex5);
        URL fromString4 = columnIndex6 == -1 ? null : this.__urlConverter.fromString(cursor.getString(columnIndex6));
        ContractAddress fromString5 = columnIndex7 == -1 ? null : this.__contractAddressConverter.fromString(cursor.getString(columnIndex7));
        BigInteger fromString6 = columnIndex8 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex8));
        BigInteger fromString7 = columnIndex9 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex9));
        BigInteger fromString8 = columnIndex10 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex10));
        BigInteger fromString9 = columnIndex11 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex11));
        BigInteger fromString10 = columnIndex12 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex12));
        if (columnIndex13 == -1) {
            z = false;
        } else {
            z = cursor.getInt(columnIndex13) != 0;
        }
        if (columnIndex14 == -1) {
            i2 = columnIndex15;
            fromString = null;
        } else {
            fromString = this.__lendProviderIDConverter.fromString(cursor.getString(columnIndex14));
            i2 = columnIndex15;
        }
        if (i2 == -1) {
            i3 = columnIndex16;
            string = null;
        } else {
            string = cursor.getString(i2);
            i3 = columnIndex16;
        }
        if (i3 == -1) {
            i4 = columnIndex17;
            fromString2 = null;
        } else {
            fromString2 = this.__urlConverter.fromString(cursor.getString(i3));
            i4 = columnIndex17;
        }
        return new LendToken(string2, string3, string4, fromString3, i5, fromString4, fromString5, fromString6, fromString7, fromString8, fromString9, fromString10, z, fromString, string, fromString2, i4 != -1 ? this.__urlConverter.fromString(cursor.getString(i4)) : null, columnIndex18 == -1 ? 0 : cursor.getInt(columnIndex18));
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends LendToken> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfLendToken.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends LendToken> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfLendToken_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<LendToken> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletLendingModelsLendToken(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends LendToken> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfLendToken.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(LendToken lendToken) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfLendToken.handle(lendToken);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}