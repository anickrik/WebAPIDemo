package com.example.webapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ClickedActivity extends AppCompatActivity {

    ListItem listItem;


    ImageView imageview2;
    TextView tvTitle1;
    TextView tvPromoCode;
    TextView tvStartDate;
    TextView tvEndDate;
    TextView tvCategory;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);






        Intent intent = getIntent();

        tvTitle1 = findViewById(R.id.tvTitle1);
        tvPromoCode = findViewById(R.id.tvPromoCode);
        tvStartDate = findViewById(R.id.tvStartDate);
        tvEndDate = findViewById(R.id.tvEndDate);
        tvCategory = findViewById(R.id.tvCategory);
        tvDescription = findViewById(R.id.tvDescription);
        imageview2 = findViewById(R.id.imageview2);


        if(intent.getExtras() != null){
            listItem = (ListItem) intent.getSerializableExtra("Title");
            tvTitle1.setText(listItem.getTitle());
            tvDescription.setText(listItem.getDescription());
            tvCategory.setText(listItem.getCategName());
            tvPromoCode.setText(listItem.getPromoCode());
            tvStartDate.setText(listItem.getValidityStart());
            tvEndDate.setText(listItem.getValidityEnd());



            Glide.with(this).load(listItem.getImage()).into(imageview2);

            getSupportActionBar().setTitle(listItem.getStoreName());



        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}