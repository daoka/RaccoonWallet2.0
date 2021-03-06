package wallet.raccoon.raccoonwallet.flux.type

import com.ryuta46.nemkotlin.model.AccountMetaDataPair

sealed class HomeSendFragmentActionType {
    class AccountInfo(val accountMetaDataPair: AccountMetaDataPair) : HomeSendFragmentActionType()
}