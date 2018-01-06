package com.gsnathan.dailywarmups;

import android.content.Intent;
import android.content.res.Configuration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * Created by Gokul Swaminathan on 1/3/2018.
 */

public class AboutActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        materialAboutPage();
    }

    private void materialAboutPage(){
        LibsBuilder builder = new LibsBuilder()
                //provide a style (optional) (LIGHT, DARK, LIGHT_DARK_TOOLBAR)
                .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
        ;


        AboutView view = AboutBuilder.with(this)

                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setPhoto(R.drawable.profile)
                .setCover(R.drawable.profileback)
                .setName("Gokul Swaminathan")
                .setSubTitle("Mobile Developer")
                .setBrief("Special Thanks to Andrew da Cunha for Knight's Tour")
                .addGitHubLink("JavaCafe01")
                .addInstagramLink("gokul.swami")
                .addWhatsappLink("Gokul Swami", "+18584136030")
                .addEmailLink("gokulswami@live.com")
                .addSkypeLink("+18584136030")
                .setVersionNameAsAppSubTitle()
                .addAction(R.drawable.sourcecode, "Source Code", "https://github.com/JavaCafe01/DailyWarmups")
                .addShareAction(R.string.app_name)
                .addUpdateAction()
                //.addFeedbackAction("gsnathandev@outlook.com")
                .addAction(R.drawable.forum,"Feedback", navToForum())
                //.addLicenseAction("Licenses",)
                .addAction(R.drawable.sourcelicenses,"Open Source Licenses", /*new Intent(this, OssLicensesMenuActivity.class)*/ builder.intent(this))
                //.addAction(R.drawable.alpha, "Alpha test this app", "https://play.google.com/apps/testing/com.gsnathan.dailywarmups")
                .addFiveStarsAction()
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);
    }

    private Intent navToForum()
    {
        Intent feedIntent = new Intent(this, ForumActivity.class);
        return feedIntent;
    }


    private void aboutPage()
    {
        simulateDayNight(/* DAY */ 0);
        //smiley emoji
        int unicode = 0x1F60A;

        Element versionElement = new Element();
        versionElement.setTitle("Version 9.0");

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


    void simulateDayNight(int currentSetting) {
        final int DAY = 0;
        final int NIGHT = 1;
        final int FOLLOW_SYSTEM = 3;

        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;
        if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else if (currentSetting == FOLLOW_SYSTEM) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        }
    }


}