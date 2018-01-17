package com.gsnathan.dailywarmups;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;


import me.drakeet.multitype.Items;
import me.drakeet.support.about.AbsAboutActivity;
import me.drakeet.support.about.Card;
import me.drakeet.support.about.Category;
import me.drakeet.support.about.Contributor;
import me.drakeet.support.about.License;

/**
 * Created by Gokul Swaminathan on 1/14/2018.
 */

public class AboutActivity extends AbsAboutActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onCreateHeader(@NonNull ImageView icon, @NonNull TextView slogan, @NonNull TextView version) {
        icon.setImageResource(R.mipmap.ic_launcher);
        slogan.setText(R.string.slogan);
        version.setText("Version " + BuildConfig.VERSION_NAME);


    }

    @Override
    protected void onItemsCreated(@NonNull Items items) {
        items.add(new Category("About"));
        items.add(new Card(getString(R.string.mitLicense)));
        items.add(new Contributor(R.drawable.code_tags, "Source Code", "Github", "https://github.com/JavaCafe01/DailyWarmups"));
        items.add(new Contributor(R.drawable.telegram_new, "Change Log", "Telegram", "https://telegram.me/dailywarmups"));
        items.add(new Contributor(R.drawable.test_tube, "You are already an alpha tester!", ";)", "https://play.google.com/store/apps/details?id=com.gsnathan.dailywarmups"));


        items.add(new Category("Developers"));
        items.add(new Contributor(R.drawable.myprofile, "Gokul Swaminathan", "App Developer", "https://github.com/JavaCafe01"));
        items.add(new Contributor(R.drawable.andracmat, "Andrew da Cunha", "Knight's Tour Developer", "https://github.com/andracmat"));
        items.add(new Contributor(R.drawable.account_circle, "Chrislynn Dinh", "Icon Designer"));

        items.add(new Category("Open Source Licenses"));
        items.add(new License("about-page", "Android Links", License.APACHE_2, "https://github.com/android-links/about-page"));
        items.add(new License("Retrofit", "Square, Inc.", License.APACHE_2, "https://square.github.io/retrofit/"));
        items.add(new License("Material Design", "Templarian", License.APACHE_2, "https://github.com/Templarian/MaterialDesign"));
    }
}