package com.example.pedidef;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class WifiDirectBroadcastReceiver extends BroadcastReceiver {
    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private instructorHome mActivity;

    public WifiDirectBroadcastReceiver(WifiP2pManager mManager, WifiP2pManager.Channel mChannel, instructorHome mActivity) {
        this.mManager = mManager;
        this.mChannel = mChannel;
        this.mActivity = mActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);

            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
                Toast.makeText(context, "Wifi is on", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Wifi is off", Toast.LENGTH_SHORT).show();
            }
        } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals((action))) {
            if (mManager != null) {
                if (ActivityCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Toast.makeText(context, "בעיה ACCESS_FINE_LOCATION", Toast.LENGTH_SHORT).show();
                    return;
                }
                mManager.requestPeers(mChannel, mActivity.peerListListener);
            }
        } else if(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {

            //if (mManager==null) {
                //    Toast.makeText(context, "בעיה בחיבור", Toast.LENGTH_SHORT).show();
                //    return;
                //}
            //
            //NetworkInfo networkInfo = intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_STATE);
            //
            //if(networkInfo.isConnected()) {
                //    mManager.requestConnectionInfo(mChannel, mActivity.connectionInfoListener);
                //} else {
                //    Toast.makeText(context, "מכשיר התנתק", Toast.LENGTH_SHORT).show();
                //}
        }
    }
}



