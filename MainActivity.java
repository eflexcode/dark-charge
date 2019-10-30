package com.example.dackcharge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);

            TextView main = findViewById(R.id.per1_main);
            TextView full = findViewById(R.id.textFull);
            ImageView battery = findViewById(R.id.image_battery_main);

            int level =  intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);

            main.setText(String.valueOf(level)+"%");

            int extra = intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
            boolean isCharging = extra == BatteryManager.BATTERY_STATUS_CHARGING;
            boolean disCharging = extra == BatteryManager.BATTERY_STATUS_DISCHARGING;
            boolean notCharging = extra == BatteryManager.BATTERY_STATUS_NOT_CHARGING;
            boolean fullCharging = extra == BatteryManager.BATTERY_STATUS_FULL;
            boolean scale = status == intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);


            if (isCharging){
                full.setText("device charging");
               // battery.setImageResource(R.drawable.ic_battery_charging_full_black_24dp);
            }else if (disCharging){
                full.setText("device discharging");
                //battery.setImageResource(R.drawable.ic_battery_full_black_24dp);
            }else if (notCharging){
                full.setText("device not charging");
            }else if (fullCharging){
                full.setText("device fully charged");
            } else {
                full.setText("device charging state unknown");
            }

            if (isCharging && level<=20){
                battery.setImageResource(R.drawable.ic_battery_charging_20_black_24dp);
            } else if (isCharging && level<=30){
                battery.setImageResource(R.drawable.ic_battery_charging_30_black_24dp);
            } else if (isCharging && level<=50){
                battery.setImageResource(R.drawable.ic_battery_charging_50_black_24dp);
            }else if (isCharging && level<=60){
                battery.setImageResource(R.drawable.ic_battery_charging_60_black_24dp);
            }else if (isCharging && level<=80){
                battery.setImageResource(R.drawable.ic_battery_charging_80_black_24dp);
            }else if (isCharging && level<=90){
                battery.setImageResource(R.drawable.ic_battery_charging_90_black_24dp);
            }else if (isCharging || fullCharging && level <= 100){
                battery.setImageResource(R.drawable.ic_battery_charging_full_black_24dp);
            }

            if ( notCharging && level<=20){
                battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
            }else if ( notCharging && level<=30){
                battery.setImageResource(R.drawable.ic_battery_30_black_24dp);
            } else if ( notCharging && level<=50){
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
            }else if ( notCharging && level<=60){
                battery.setImageResource(R.drawable.ic_battery_60_black_24dp);
            }else if( notCharging && level<=80){
                battery.setImageResource(R.drawable.ic_battery_80_black_24dp);
            }else if ( notCharging && level<=90){
                battery.setImageResource(R.drawable.ic_battery_90_black_24dp);
            }else if (notCharging || fullCharging && level<=100){
                battery.setImageResource(R.drawable.ic_battery_full_black_24dp);
            }

            if (disCharging && level<=20){
                battery.setImageResource(R.drawable.ic_battery_20_black_24dp);
            }else if (disCharging && level<=30){
                battery.setImageResource(R.drawable.ic_battery_30_black_24dp);
            } else if ( disCharging && level<=50){
                battery.setImageResource(R.drawable.ic_battery_50_black_24dp);
            }else if (disCharging && level<=60){
                battery.setImageResource(R.drawable.ic_battery_60_black_24dp);
            }else if( disCharging && level<=80){
                battery.setImageResource(R.drawable.ic_battery_80_black_24dp);
            }else if ( disCharging && level<=90){
                battery.setImageResource(R.drawable.ic_battery_90_black_24dp);
            }else if (disCharging || fullCharging && level<=100){
                battery.setImageResource(R.drawable.ic_battery_full_black_24dp);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(broadcastReceiver);
    }
}
