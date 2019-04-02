package wallet.raccoon.raccoonwallet.view.activity.profile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_select_mode_add_wallet.bottomCardButton
import kotlinx.android.synthetic.main.activity_select_mode_add_wallet.topCardButton
import wallet.raccoon.raccoonwallet.R
import wallet.raccoon.raccoonwallet.view.activity.BaseActivity

class SelectModeAddWalletActivity : BaseActivity() {
  override fun setLayout() = R.layout.activity_select_mode_add_wallet
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setupToolbar()
    setupButtons()
  }

  private fun setupToolbar() {
    setToolbarTitle(R.string.select_mode_add_wallet_title)
    setToolBarBackButton()
  }

  private fun setupButtons() {
    topCardButton.setOnClickListener {
      //      async(UI) {
//        val selectedWalletId = bg { WalletManager.getSelectedWalletId(this@SelectModeAddWalletActivity) }
//            .await()
//        if (selectedWalletId == 0L) {
//          this@SelectModeAddWalletActivity.showToast(R.string.select_mode_add_wallet_no_wallet)
//        } else {
//          val intent = Intent()
//          intent.putExtra(KEY_MODE, Mode.Wallet)
//          setResult(Activity.RESULT_OK, intent)
//          finish()
//        }
//      }
    }

    bottomCardButton.setOnClickListener {
      val intent = Intent()
      intent.putExtra(KEY_MODE, Mode.Direct)
      setResult(Activity.RESULT_OK, intent)
      finish()
    }
  }

  companion object {
    const val REQUEST_CODE = 2099
    const val KEY_MODE = "key_mode"
    fun createIntent(context: Context): Intent {
      val intent = Intent(context, SelectModeAddWalletActivity::class.java)
      return intent
    }
  }

  enum class Mode {
    Wallet,
    Direct
  }
}
