package com.example.a3mnth_homework3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a3mnth_homework3.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final int SELECT_IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    binding.btnSecond.setOnClickListener(view -> {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Выбрать изображение"), SELECT_IMAGE);

    });

   binding.btnGmail.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           sendEmail();
       }
   });

    }



    public void sendEmail(){
        String recipient = binding.edtEmail.getText().toString();
        String message = binding.edtMessage.getText().toString();

        if (recipient.isEmpty()|| message.isEmpty()){
            Toast.makeText(this,"Заполните поля!", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{recipient});
        intent.setType("message/rfc822");
        intent.setPackage("com.google.android.gm");
        startActivity(intent);

    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    Uri imageUri = data.getData();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("imageUri", imageUri.toString());
                    startActivity(intent);
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Отменено", Toast.LENGTH_SHORT).show();
            }
        }
    }

}