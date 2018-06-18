package com.example.admin.weekend3booksapiretrofitpicasso.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.weekend3booksapiretrofitpicasso.R;
import com.example.admin.weekend3booksapiretrofitpicasso.activity.adapter.BookAdapter;
import com.example.admin.weekend3booksapiretrofitpicasso.activity.model.Book;
import com.example.admin.weekend3booksapiretrofitpicasso.activity.model.BookList;
import com.example.admin.weekend3booksapiretrofitpicasso.activity.network.GetBookDataService;
import com.example.admin.weekend3booksapiretrofitpicasso.activity.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private EditText etBookSearch;
    BookAdapter adapter;
    private RecyclerView recyclerView;
    public static final String API_KEY = "AIzaSyD0L8TPOp5e3lYqNaXbCv5tqD0URpp0SPQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBookSearch = findViewById(R.id.etBookSearch);


    }

    public void onClickSearch(View view) {
//        Toast.makeText(MainActivity.this,"holaaaaaaaaaa",Toast.LENGTH_LONG).show();
//        System.out.println("que traes: " + etBookSearch.getText());
//        System.out.println("afuera ********" + etBookSearch.getText());
//        if (etBookSearch.getText().toString().equals("")) {
//            System.out.println("entro ********" + etBookSearch.getText());
//        }

        if (!etBookSearch.getText().toString().equals("")) {

//            Create handler for RetrofitInstance
            GetBookDataService service = RetrofitInstance.getRetrofitInstance().create(GetBookDataService.class);
//            Call the method with parameter in the interface to get the employee data
            Call<BookList> call = service.getBookData(etBookSearch.getText().toString(),API_KEY);

            Log.wtf("Url Called: ", call.request().url()+ "") ;

            call.enqueue(new Callback<BookList>() {
                @Override
                public void onResponse(Call<BookList> call, Response<BookList> response) {
                    generateBookList(response.body().getBookArrayList());
                }

                @Override
                public void onFailure(Call<BookList> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Something went wrong... Please try later!", Toast.LENGTH_LONG).show();
                }
            });

        } else {
            Toast.makeText(MainActivity.this,"Please enter search",Toast.LENGTH_LONG).show();
        }
    }

    private void generateBookList(ArrayList<Book> bookArrayList) {
        recyclerView = findViewById(R.id.recycler);
        adapter = new BookAdapter((bookArrayList));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
