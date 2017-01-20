package com.trendinfinal.trendinfinal;

import java.io.File;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;
import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session;

import static android.R.attr.data;

public class UploadFile extends AsyncTask<Void, Void, Boolean> {

    private DropboxAPI<AndroidAuthSession> dropbox;
    private String path;
    private Context context;

    public String file;

    public UploadFile(Context context, DropboxAPI<?> dropbox,String path,String file
                               ) {

        this.context = context.getApplicationContext();
        this.dropbox = MainCloudActivity.dropbox;
        this.path = path;
        this.file=file;

    }

    @Override
    protected Boolean doInBackground(Void... params) {


        try {



            FileInputStream fileInputStream = new FileInputStream(new File (file));
            dropbox.putFile( "B1/"+file, fileInputStream,
                    file.length(), null, null);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DropboxException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            Toast.makeText(context, "File Uploaded Sucesfully!",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Failed to upload file", Toast.LENGTH_LONG)
                    .show();
        }
    }
}
