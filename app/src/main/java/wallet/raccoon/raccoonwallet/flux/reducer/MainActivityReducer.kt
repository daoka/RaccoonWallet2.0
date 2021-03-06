package wallet.raccoon.raccoonwallet.flux.reducer

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import wallet.raccoon.raccoonwallet.flux.store.DisposableMapper
import wallet.raccoon.raccoonwallet.model.MyProfileEntity
import wallet.raccoon.raccoonwallet.flux.type.MainActivityActionType

class MainActivityReducer(actionType: Observable<MainActivityActionType>) : DisposableMapper() {
    private val mMyProfile: PublishSubject<MyProfileEntity> = PublishSubject.create()

    val myProfile: Observable<MyProfileEntity>
        get() = mMyProfile

    init {
        actionType.ofType(MainActivityActionType.MyProfile::class.java)
            .subscribe({
                mMyProfile.onNext(it.myProfileEntity)
            }, {
                it.printStackTrace()
            }).let { disposables.add(it) }
    }
}