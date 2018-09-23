package com.example.manasatpc.recyclingfact;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.models.Search;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.SearchService;

import java.util.List;

import retrofit2.Response;

public class SearchableActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        listView = (ListView)findViewById(R.id.list_view);

        String query;
        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())){
            query = getIntent().getStringExtra(SearchManager.QUERY);
            searchTweets(query);
            Log.i("نص البحث ",query);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String query;
        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())){
            query = getIntent().getStringExtra(SearchManager.QUERY);
            searchTweets(query);
            Log.i("نص البحث ",query);
        }
    }
    public void searchTweets(final String tweet){
        TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
        SearchService searchService = twitterApiClient.getSearchService();
        retrofit2.Call<Search> tweets = searchService.tweets(tweet,null,null,null,null,null,null,null,null,null);
        tweets.enqueue(new retrofit2.Callback<Search>() {
            @Override
            public void onResponse(retrofit2.Call<Search> call, Response<Search> response) {
                listView.setAdapter(new SearchAdabter(response.body().tweets));
               /*for (Tweet tweet1 : response.body().tweets){
                    Log.i("نتيجة البحث",tweet1.user.screenName + " " +tweet1.text);

                }*/
            }

            @Override
            public void onFailure(retrofit2.Call<Search> call, Throwable t) {
                Log.i("فشل البحث",t.getMessage());

            }
        });
    }
    private class SearchAdabter extends BaseAdapter{
        private List<Tweet> tweets;
        public SearchAdabter(List<Tweet> tweets){
            this.tweets =tweets;
        }

        @Override
        public int getCount() {
            return tweets.size();
        }

        @Override
        public Object getItem(int i) {
            return tweets.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View item_view = view;
            if (item_view == null){
                item_view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_tweet,viewGroup,false);
            }
            ((TextView)item_view.findViewById(R.id.user_text_view))
                    .setText(tweets.get(i).user.screenName);
            ((TextView)item_view.findViewById(R.id.tweet_text_view))
                    .setText(tweets.get(i).text);
            return item_view;
        }
    }

}



























