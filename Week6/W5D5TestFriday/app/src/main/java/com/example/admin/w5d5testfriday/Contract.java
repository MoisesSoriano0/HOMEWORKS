package com.example.admin.w5d5testfriday;

import com.example.admin.w5d5testfriday.model.datasource.Schools;
import com.example.admin.w5d5testfriday.view.BasePresenter;

import java.util.List;

public interface Contract {

    interface View {
        void showResult(List<Schools> schooolsResult);

        void showError();

        void navigateToDetail();
    }

    interface Presenter extends BasePresenter{
        void getResult();

        void onNaavigateToDetail();
    }
}
