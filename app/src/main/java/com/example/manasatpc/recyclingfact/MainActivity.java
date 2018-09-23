package com.example.manasatpc.recyclingfact;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;
import com.twitter.sdk.android.core.services.StatusesService;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String FACT_KEY = "fact_key";
    TextView factTextView;
    Button factButton,move_button,save_me_data,sent_twitter;
    TwitterLoginButton login_button;
    private String fact;
    private SearchView searchView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for void rotate screen
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
getIntent().getStringExtra("");
        factTextView = (TextView)findViewById(R.id.facttextView);
        factButton = (Button)findViewById(R.id.factButton);
        move_button = (Button)findViewById(R.id.move_button);
        save_me_data= (Button)findViewById(R.id.save_me_data);
        final RecyclingFatsGenerator recyclingFatsGenerator = new RecyclingFatsGenerator(this);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fact = recyclingFatsGenerator.getFact();

                factTextView.setText(fact);

            }
        };
        View.OnClickListener onClickListener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SaveMyData.class);
                startActivity(intent);
            }
        };
        factButton.setOnClickListener(onClickListener);
        move_button.setOnClickListener(onClickListener1);
        save_me_data.setOnClickListener(onClickListener2);

        if (TwitterCore.getInstance().getSessionManager().getActiveSession() != null){
            login_button.setVisibility(View.GONE);
            sent_twitter.setVisibility(View.VISIBLE);
        }
        searchTweets("إعادة التدوير");
        searchView = (SearchView)findViewById(R.id.search_view);
        searchView.setSearchableInfo(((SearchManager)getSystemService(Context.SEARCH_SERVICE))
        .getSearchableInfo(getComponentName()));


        login_button = (TwitterLoginButton) findViewById(R.id.login_twitter);
        sent_twitter = (Button)findViewById(R.id.sent_twitter);
        sent_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
                StatusesService statusesService = twitterApiClient.getStatusesService();
                retrofit2.Call<Tweet> tweetCall = statusesService.update(fact,null,null,null,null,null,null,null,null);
                tweetCall.enqueue(new retrofit2.Callback<Tweet>() {
                    @Override
                    public void onResponse(retrofit2.Call<Tweet> call, Response<Tweet> response) {
                        Toast.makeText(getApplicationContext(),"تم إرسال الحقيقة" ,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(retrofit2.Call<Tweet> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "لم يتم إرسال الحقيقة بسبب حدوث خطأ",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


        login_button.setEnabled(true);
        login_button.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                login_button.setVisibility(View.GONE);
                sent_twitter.setVisibility(View.VISIBLE);
            }

            @Override
            public void failure(TwitterException exception) {

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        login_button.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FACT_KEY,fact);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fact = savedInstanceState.getString(FACT_KEY);
        factTextView.setText(fact);


    }
    public void searchTweets(final String tweet){
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        SearchService searchService = twitterApiClient.getSearchService();
        retrofit2.Call<Search> tweets = searchService.tweets(tweet,null,null,null,null,null,null,null,null,null);
        tweets.enqueue(new retrofit2.Callback<Search>() {
            @Override
            public void onResponse(retrofit2.Call<Search> call, Response<Search> response) {
                for (Tweet tweet1 : response.body().tweets){
                    Log.i("نتيجة البحث",tweet1.user.screenName + " " +tweet1.text);

                }
            }

            @Override
            public void onFailure(retrofit2.Call<Search> call, Throwable t) {
                Log.i("فشل البحث",t.getMessage());

            }
        });
    }































}
