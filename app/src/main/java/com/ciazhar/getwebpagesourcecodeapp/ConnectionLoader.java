package com.ciazhar.getwebpagesourcecodeapp;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ciazhar on 10/21/17.
 * <p>
 * [ Documentation Here]
 */

public class ConnectionLoader extends AsyncTaskLoader<String> {

    private String url_link;

    public ConnectionLoader(Context context, String url_link) {
        super(context);
        this.url_link = url_link;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        InputStream in;

        try {
            URL url = new URL(url_link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(20000);
            connection.setRequestMethod("GET");
            connection.connect();

            in = connection.getInputStream();

            BufferedReader buff = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = "";

            while ((line = buff.readLine()) != null) {
                sb.append(line + "\n");
            }

            buff.close();
            in.close();

            return sb.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Errors, try change protocol to http or https";
    }

}
