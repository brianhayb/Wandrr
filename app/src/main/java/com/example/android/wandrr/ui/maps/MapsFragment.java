package com.example.android.wandrr.ui.maps;

import static androidx.constraintlayout.motion.widget.Debug.getLocation;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

//import com.example.android.wandrr.PermissionUtils;
import com.example.android.wandrr.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean permissionDenied = false;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this::onMapReady);
        }
    }

    @Override
    public void onMapReady( GoogleMap googleMap) {

        //LatLng sydney = new LatLng(-44, 151);
        LatLng syracuse = new LatLng(43.037750,-76.130707);
        LatLng thompson = new LatLng(43.108013,-76.243515);
        LatLng winona = new LatLng(43.0594,-76.1663);
        LatLng rideau = new LatLng(41.29032, -74.8401);
        LatLng mtb = new LatLng(42.9926,-76.0933);
        LatLng collins = new LatLng(43.0932,-76.2341);
        LatLng mcintosh = new LatLng(43.0187,-76.1669);
        LatLng pleasant = new LatLng(42.9721,-76.2582);
        LatLng hiawatha = new LatLng( 43.0285,76.1627);
        googleMap.addMarker(new MarkerOptions()
                .position(syracuse).title("Current Location")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        googleMap.addMarker(new MarkerOptions().position(thompson).title("West Shore Trail"));
        googleMap.addMarker(new MarkerOptions().position(winona).title("Onondaga Creekwalk to Onondaga Lake"));
        googleMap.addMarker(new MarkerOptions().position(rideau).title("Cliff Trail to Pulpit Rock Trail Loop"));
        googleMap.addMarker(new MarkerOptions().position(mtb).title("Mildred Faust Trail"));
        googleMap.addMarker(new MarkerOptions().position(collins).title("Rand Tract Loop"));
        googleMap.addMarker(new MarkerOptions().position(mcintosh).title("UpperTree Hill"));
        googleMap.addMarker(new MarkerOptions().position(pleasant).title("Mount Pleasant"));
        googleMap.addMarker(new MarkerOptions().position(hiawatha).title("Hiawatha Trail"));
       // googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(syracuse )      // Sets the center of the map to Mountain View
                .zoom(12)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera to east
                //.tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(syracuse));
       // googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syracuse.getCenter(), 10))
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //mMap = googleMap;
        //enableMyLocation();

        }







//    @SuppressLint("MissingPermission")
//    public void enableMyLocation() {
//        // [START maps_check_location_permission]
//        // 1. Check if permissions are granted, if so, enable the my location layer
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            mMap.setMyLocationEnabled(true);
//            return;
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            return;
//        }
//
//        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
//                Manifest.permission.ACCESS_FINE_LOCATION) || PermissionUtils
//                .isPermissionGranted(permissions, grantResults,
//                        Manifest.permission.ACCESS_COARSE_LOCATION)) {
//            // Enable the my location layer if the permission has been granted.
//            enableMyLocation();
//        } else {
//            // Permission was denied. Display an error message
//            // [START_EXCLUDE]
//            // Display the missing permission error dialog when the fragments resume.
//            permissionDenied = true;
//            // [END_EXCLUDE]
//        }
//    }

//    @Override
//    protected void onResumeFragments() {
//        super.onResumeFragments();
//        if (permissionDenied) {
//            // Permission was not granted, display error dialog.
//            showMissingPermissionError();
//            permissionDenied = false;
//        }
//    }


        // 2. Otherwise, request location permissions from the user.
        //  PermissionUtils.requestLocationPermissions(this, LOCATION_PERMISSION_REQUEST_CODE, true);
        // [END maps_check_location_permission]
        //}


}

