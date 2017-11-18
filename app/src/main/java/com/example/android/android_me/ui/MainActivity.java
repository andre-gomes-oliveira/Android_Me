/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public static final String HEAD_BUNDLE = "head";
    public static final String BODY_BUNDLE = "body";
    public static final String LEGS_BUNDLE = "legs";

    private int headIndex, bodyIndex, legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();
        int bodyPartSelected = position / 12;
        int imageIndex = position - (bodyPartSelected * 12);

        // COMPLETED (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        switch (bodyPartSelected) {
            case (0):
                headIndex = imageIndex;
                break;
            case (1):
                bodyIndex = imageIndex;
                break;
            case (2):
                legIndex = imageIndex;
                break;
        }

        // COMPLETED (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle bodyPartsBundle = new Bundle();
        bodyPartsBundle.putInt(HEAD_BUNDLE, headIndex);
        bodyPartsBundle.putInt(BODY_BUNDLE, headIndex);
        bodyPartsBundle.putInt(LEGS_BUNDLE, headIndex);

        final Intent bodyPartsIntent = new Intent(this, AndroidMeActivity.class);
        bodyPartsIntent.putExtras(bodyPartsBundle);

        // COMPLETED (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        Button nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(bodyPartsIntent);
            }
        });
    }
}
