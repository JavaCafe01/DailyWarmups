package com.gsnathan.dailywarmups;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * Created by Gokul Swaminathan on 1/3/2018.
 */

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //smiley emoji
        int unicode = 0x1F60A;

        Element versionElement = new Element();
        versionElement.setTitle("Version 8.0");

        Element andrewHelp = new Element();
        andrewHelp.setTitle("Thanks to Andrew da Cunha for Knights Tour");
        andrewHelp.setIconDrawable(R.drawable.user);

        final View aboutPage = new AboutPage(this)
                .setImage(R.drawable.pencil_lowres)
                .setDescription("An app with simple code activities" + Utils.getEmojiByUnicode(unicode))
                .addItem(versionElement)
                .addEmail("gsnathandev@outlook.com", "Contact the Developer")
                .addPlayStore("com.gsnathan.dailywarmups", "Find this app on the Play Store")
                .addGitHub("JavaCafe01", "Source Code on GitHub")
                .addItem(andrewHelp)
                .addEmail("andracmat@gmail.com", "Contact Andrew")
                .create();

        setContentView(aboutPage);
    }


}