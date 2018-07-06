package com.example.admin.w5d5testfriday.view;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
