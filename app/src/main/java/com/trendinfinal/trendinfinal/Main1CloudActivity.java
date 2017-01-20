package com.trendinfinal.trendinfinal;

import java.io.File;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;


public class Main1CloudActivity extends Activity implements OnClickListener {

    private static final int REQUEST_PICK_FILE = 1;
    private DropboxAPI<AndroidAuthSession> dropbox;
    private Button uploadFile;
    private TextView filePath;
    private Button Browse;
    public File selectedFile;
    public String sendpath;


    public String filesend;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1cloud);
        uploadFile = (Button) findViewById(R.id.upload_file);
        uploadFile.setOnClickListener(this);
        filePath = (TextView)findViewById(R.id.file_path);
        Browse = (Button)findViewById(R.id.browse);
        Browse.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.browse:
                Intent intent = new Intent(this, FilePicker.class);
                startActivityForResult(intent, REQUEST_PICK_FILE);
                break;
            case R.id.upload_file:
                UploadFile uploadFile = new UploadFile(this, dropbox,
                        "B1/",filesend);

                uploadFile.execute();
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(resultCode == RESULT_OK) {

            switch(requestCode) {

                case REQUEST_PICK_FILE:

                    if(data.hasExtra(FilePicker.EXTRA_FILE_PATH)) {

                        selectedFile = new File(data.getStringExtra(FilePicker.EXTRA_FILE_PATH));
                        filePath.setText(selectedFile.getPath());
                        filesend=filePath.getText().toString();

                                            }
                    break;

            }




        }
    }


}