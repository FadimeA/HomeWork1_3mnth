package com.example.a3mnth_homework3;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.a3mnth_homework3.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String imageUriString = getIntent().getStringExtra("imageUri");

    if (imageUriString != null) {
        Uri imageUri = Uri.parse(imageUriString);
        ImageView imageView = binding.ivImage;
        imageView.setImageURI(imageUri);
    } else {
        Toast.makeText(this, "Изображение не найдено", Toast.LENGTH_SHORT).show();
    }

    }


}