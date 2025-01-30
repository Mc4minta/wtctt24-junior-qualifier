package com.coinbase.wallet.consumer.di;

import android.app.Application;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.Coinbase;
import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.squareup.moshi.Moshi;
import kotlin.Metadata;

/* compiled from: ConsumerCoreComponent.kt */
@AppCoreScoped
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/coinbase/wallet/consumer/di/ConsumerCoreComponent;", "", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "consumerNetworkConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "consumerWebviewConfig", "()Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/wallet/consumer/db/ConsumerDatabase;", "consumerDatabase", "()Lcom/coinbase/wallet/libraries/databases/db/Database;", "Lcom/coinbase/Coinbase;", "coinbaseSdk", "()Lcom/coinbase/Coinbase;", "Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;", "consumerAccountsDAO", "()Lcom/coinbase/wallet/consumer/daos/ConsumerAccountsDAO;", "Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;", "consumerPaymentMethodsDAO", "()Lcom/coinbase/wallet/consumer/daos/ConsumerPaymentMethodsDAO;", "Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "consumerAvailablePaymentMethodsDAO", "()Lcom/coinbase/wallet/consumer/daos/ConsumerAvailablePaymentMethodsDAO;", "Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "consumerAPI", "()Lcom/coinbase/wallet/consumer/apis/ConsumerAPI;", "Factory", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface ConsumerCoreComponent {

    /* compiled from: ConsumerCoreComponent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JK\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/coinbase/wallet/consumer/di/ConsumerCoreComponent$Factory;", "", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Landroid/app/Application;", "app", "Lcom/squareup/moshi/Moshi;", "moshi", "Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;", "buildConfigWrapper", "Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;", "networkConfig", "Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;", "webviewConfig", "Lcom/coinbase/wallet/consumer/di/ConsumerCoreComponent;", "create", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;Landroid/app/Application;Lcom/squareup/moshi/Moshi;Lcom/coinbase/wallet/common/utilities/BuildConfigWrapper;Lcom/coinbase/wallet/consumer/models/ConsumerNetworkConfig;Lcom/coinbase/wallet/consumer/models/ConsumerWebViewConfig;)Lcom/coinbase/wallet/consumer/di/ConsumerCoreComponent;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public interface Factory {
        ConsumerCoreComponent create(StoreInterface storeInterface, Application application, Moshi moshi, BuildConfigWrapper buildConfigWrapper, ConsumerNetworkConfig consumerNetworkConfig, ConsumerWebViewConfig consumerWebViewConfig);
    }

    Coinbase coinbaseSdk();

    ConsumerAPI consumerAPI();

    ConsumerAccountsDAO consumerAccountsDAO();

    ConsumerAvailablePaymentMethodsDAO consumerAvailablePaymentMethodsDAO();

    Database<ConsumerDatabase> consumerDatabase();

    ConsumerNetworkConfig consumerNetworkConfig();

    ConsumerPaymentMethodsDAO consumerPaymentMethodsDAO();

    ConsumerWebViewConfig consumerWebviewConfig();
}