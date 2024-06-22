package com.example.docmanagementapp.AddAssetDetail;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.docmanagementapp.AllAssets.FragmentAllAssets;
import com.example.docmanagementapp.R;
import com.example.docmanagementapp.databinding.FragmentAddAssetDetailBinding;

import java.io.IOException;
import java.util.Calendar;

public class FragmentAddAssetDetail extends Fragment {

    FragmentAddAssetDetailBinding binding;
    Bitmap image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddAssetDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAllAssets frag = new FragmentAllAssets();
                getParentFragmentManager().beginTransaction().replace(R.id.frame_layout, frag).addToBackStack(null).commit();
            }
        });

        binding.yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.yesBtn.setBackgroundResource(R.drawable.blue_bg);
                binding.yes.setTextColor(getResources().getColor(R.color.white));
                binding.no.setTextColor(getResources().getColor(R.color.black));
                binding.noBtn.setBackgroundResource(R.drawable.inactive_btn);
            }
        });

        binding.noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.yesBtn.setBackgroundResource(R.drawable.inactive_btn);
                binding.yes.setTextColor(getResources().getColor(R.color.black));
                binding.no.setTextColor(getResources().getColor(R.color.white));
                binding.noBtn.setBackgroundResource(R.drawable.blue_bg);
            }
        });

        binding.plusRel.setOnClickListener(new View.OnClickListener() {  // Assuming you have a button to select the image
            @Override
            public void onClick(View v) {
                verifyPermissions();
            }
        });

        binding.purchaseDateRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        return root;
    }

    private static final int REQUEST_CODE = 2;

    private boolean verifyPermissions() {
        String[] permissions = new String[]{
                Manifest.permission.CAMERA};

        if (ContextCompat.checkSelfPermission(requireContext(), permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            selectImage();
        } else {
            Log.e("pers", "mission");
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(),
                    Manifest.permission.CAMERA)) {
                Log.e("pers", "ifff");
                showExplanation("Permission Needed", "Rationale", Manifest.permission.CAMERA, REQUEST_CODE);
            } else {
                Log.e("pers", "elseeee");
                ActivityCompat.requestPermissions(requireActivity(), permissions, REQUEST_CODE);
            }

            return false;
        }
        return true;
    }

    private void showExplanation(String title,
                                 String message,
                                 final String permission,
                                 final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        requestPermission(permission, permissionRequestCode);
                    }
                });
        builder.create().show();
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        ActivityCompat.requestPermissions(requireActivity(),
                new String[]{permissionName}, permissionRequestCode);
    }

    private void selectImage() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    someActivityCameraLauncher.launch(cameraIntent);
                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    someActivityGalleryLauncher.launch(intent);
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    ActivityResultLauncher<Intent> someActivityGalleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Log.e("imageeeeee", data.toString());
                        Uri uri = data.getData();
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), uri);
                            // Assuming you have a method compressImage() that returns a Bitmap
                            Bitmap compressedImage = compressImage(bitmap);
                            image = compressedImage;  // Assuming you want to store the compressed image
                            binding.plusIcon.setImageBitmap(compressedImage);  // Assuming you have an ImageView with id img
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

    ActivityResultLauncher<Intent> someActivityCameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Bitmap photo = (Bitmap) data.getExtras().get("data");
                        image = photo;
                        binding.plusIcon.setImageBitmap(photo);  // Assuming you have an ImageView with id img
                    }
                }
            });

    // Assuming you have a method compressImage() that takes a Bitmap and returns a Bitmap
    private Bitmap compressImage(Bitmap original) {
        // Implement your image compression logic here
        return original; // Return the compressed image
    }
    private void showDatePickerDialog() {
        // Get current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create DatePickerDialog and show it
        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Set selected date in TextView
                        binding.purchaseDateTv.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
