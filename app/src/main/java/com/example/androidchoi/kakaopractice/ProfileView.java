package com.example.androidchoi.kakaopractice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Choi on 2015-10-09.
 */
public class ProfileView extends FrameLayout {

    public ProfileView(Context context) {
        super(context);
        init();
    }

    ImageView profileImage;
    TextView name;
    TextView message;
    Profile mProfile;

    private void init() {
        inflate(getContext(), R.layout.item_profile, this);
        profileImage = (ImageView)findViewById(R.id.image_profile);
        name = (TextView)findViewById(R.id.text_name);
        message = (TextView)findViewById(R.id.text_message);
    }

    public void setProfileData(Profile profile) {
        mProfile = profile;

        name.setText(mProfile.name);
        message.setText(mProfile.message);
//        profileImage.setImageResource(mProfile.profileImage);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), mProfile.profileImage);
        RoundedAvatarDrawable tmpRoundedAvatarDrawable = new RoundedAvatarDrawable(bm);
        profileImage.setBackground(tmpRoundedAvatarDrawable);

//            Drawable d = getResources().getDrawable(profileImage.getResourceId(i, -1));



//        profileImage.setImageResource(mProfile.profileImage);
//        if (profile.profileImage != null) {
//            profileImage.setImageDrawable(profile.profileImage);
//        }
    }

}
