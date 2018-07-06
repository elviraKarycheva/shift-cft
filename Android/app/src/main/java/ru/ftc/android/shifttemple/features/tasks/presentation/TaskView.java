package ru.ftc.android.shifttemple.features.tasks.presentation;


import java.util.List;

import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Bid;

interface TaskView extends MvpView {

    void showProgress();

    void hideProgress();

    void showBidList(List<Bid> list);

    void showError(String message);

    void showLoginForm();


}
