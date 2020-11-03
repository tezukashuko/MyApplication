package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*for (int i = 1; i < 11; i++) {
            String ref = "Lap" + String.valueOf(i);
            final DatabaseReference dtb_ref = FirebaseDatabase.getInstance().getReference("Products").child("Laptop").child(ref);
            dtb_ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String abc = (String) dataSnapshot.child("name").getValue();
                    abc = "Laptop " + abc;
                    dtb_ref.child("name").setValue(abc);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }*/

        final DatabaseReference[] dtb_ref = {FirebaseDatabase.getInstance().getReference("Products").child("Laptop")};
        dtb_ref[0].addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 long num_child =dataSnapshot.getChildrenCount();

                long a = num_child +1;
                String ref= "Lap" + a;
                dtb_ref[0] = FirebaseDatabase.getInstance().getReference("Products").child("Laptop").child(ref);


                String name = "Laptop Apple MacBook Pro 16\" 2019";

                String price = "69.990.000đ";
                price = price.replace(".","");
                price = price.replace(",","");
                price = price.replace("đ","");


                String desc = "Core i9/16GB/1TB SSD/AMD Radeon Pro 5500M/macOS/2kg";

                String detail = "- CPU: Intel Core i9\n" +
                        "- Màn hình: 16\" IPS (3072 x 1920)\n" +
                        "- RAM: 16GB Onboard\n" +
                        "- Đồ họa: AMD Radeon Pro 5500M 4GB GDDR6 / Intel UHD Graphics 630\n" +
                        "- Lưu trữ: 1TB SSD /\n" +
                        "- Hệ điều hành: macOS\n" +
                        "- 100 Wh Pin liền\n" +
                        "- Khối lượng: 2 kg";


                dtb_ref[0].child("detail").setValue(detail);
                dtb_ref[0].child("desc").setValue(desc);
                dtb_ref[0].child("name").setValue(name);
                dtb_ref[0].child("price").setValue(Integer.valueOf(price));
                dtb_ref[0].child("avatarURL").setValue("");
                dtb_ref[0].child("avatarURL1").setValue("");
                dtb_ref[0].child("avatarURL2").setValue("");
                dtb_ref[0].child("avatarURL3").setValue("");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}