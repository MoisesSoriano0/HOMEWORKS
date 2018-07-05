package com.example.admin.w5d4geocodingdaggermvp.view.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
