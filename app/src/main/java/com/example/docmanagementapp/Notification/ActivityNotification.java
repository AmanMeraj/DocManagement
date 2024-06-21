package com.example.docmanagementapp.Notification;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.docmanagementapp.Adapter.AdapterAmc;
import com.example.docmanagementapp.Adapter.AdapterNotification;
import com.example.docmanagementapp.Model.Amc;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.ActivityNotificationBinding;

import java.util.ArrayList;

public class ActivityNotification extends AppCompatActivity {
  ActivityNotificationBinding binding;
    AdapterNotification adapter;
    ArrayList<Amc> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding=ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Amc obj1 = new Amc("Master Refrigerator", "simply dummy text of the printing and typesetting \n" +
                    "industry. simply dummy text of the  typesetting industry.");
            arrayList.add(obj1);
            Amc obj2 = new Amc("Master A/C", "simply dummy text of the printing and typesetting \n" +
                    "industry. simply industry.");
            arrayList.add(obj2);
            Amc obj3 = new Amc("Master Oven", "simply dummy text of the printing and typesetting \n");
            arrayList.add(obj3);
        }

        adapter = new AdapterNotification(arrayList, getApplicationContext());
        binding.rcAmc.setAdapter(adapter);

    }
}