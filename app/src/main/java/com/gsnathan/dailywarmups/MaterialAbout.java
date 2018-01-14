package com.gsnathan.dailywarmups;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;



/**
 * Created by Gokul Swaminathan on 1/10/2018.
 */

public class MaterialAbout extends MaterialAboutActivity {

    @Override
    protected MaterialAboutList getMaterialAboutList(Context context) {


        return new MaterialAboutList.Builder()
                .addCard(main().build())
                .addCard(dev().build())
                .addCard(collab1().build())
                .addCard(collab2().build())
                .addCard(feed().build())
                .build();
    }

    private MaterialAboutCard.Builder main() {


        MaterialAboutCard.Builder main = new MaterialAboutCard.Builder();

        main.addItem(new MaterialAboutTitleItem.Builder()
                .text(R.string.app_name)
                .desc(getString(R.string.copyright))
                .icon(R.mipmap.ic_launcher)
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.version)
                .subText(BuildConfig.VERSION_NAME)
                .icon(R.drawable.versionicon)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.gsnathan.dailywarmups"));
                        startActivity(browserIntent);
                    }
                })
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.changelog)
                .subText("Telegram")
                .icon(R.drawable.telegram)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://telegram.me/dailywarmups"));
                        startActivity(browserIntent);
                    }
                })
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.source_code)
                .icon(R.drawable.sourcecode)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JavaCafe01/DailyWarmups"));
                        startActivity(browserIntent);
                    }
                })
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.myLicense)
                .subText("The MIT License")
                .icon(R.drawable.mylicense)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent licInent = new Intent(getApplicationContext(), MyLicenseActivity.class);
                        startActivity(licInent);
                    }
                })
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.openLicense)
                .icon(R.drawable.sourcelicenses)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        LibsBuilder builder = new LibsBuilder()
                                //provide a style (optional) (LIGHT, DARK, LIGHT_DARK_TOOLBAR)
                                .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR);
                        startActivity(builder.intent(getApplicationContext()));
                    }
                })
                .build());


        return main;
    }

    private MaterialAboutCard.Builder dev() {

        MaterialAboutCard.Builder main = new MaterialAboutCard.Builder();
        main.title(R.string.author);
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.author_name)
                .icon(R.drawable.user)
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.follow_on_github)
                .icon(R.drawable.about_icon_github)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JavaCafe01"));
                        startActivity(browserIntent);
                    }
                })
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.email)
                .subText(R.string.auth_email_address)
                .icon(R.drawable.mailicon)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("message/rfc822");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gsnathandev@outlook.com"});
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            Context context = getApplicationContext();
                            context.startActivity(Intent.createChooser(intent, context.getString(R.string.email)));
                        } catch (ActivityNotFoundException e) {

                        }
                    }
                })
                .build());


        return main;
    }

    private MaterialAboutCard.Builder collab1() {

        MaterialAboutCard.Builder main = new MaterialAboutCard.Builder();
        main.title(R.string.collab);
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.author2_name)
                .subText("For Knight's Tour")
                .icon(R.drawable.user)
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.follow_on_github)
                .icon(R.drawable.about_icon_github)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/andracmat"));
                        startActivity(browserIntent);
                    }
                })
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.email)
                .subText(R.string.auth_email_address2)
                .icon(R.drawable.mailicon)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("message/rfc822");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"andracmat@gmail.com"});
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            Context context = getApplicationContext();
                            context.startActivity(Intent.createChooser(intent, context.getString(R.string.email)));
                        } catch (ActivityNotFoundException e) {

                        }
                    }
                })
                .build());


        return main;
    }

    private MaterialAboutCard.Builder collab2() {

        MaterialAboutCard.Builder main = new MaterialAboutCard.Builder();
        main.title(R.string.collab);
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.author3_name)
                .subText("For App Icon")
                .icon(R.drawable.user)
                .build());
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.email)
                .subText(R.string.auth_email_address3)
                .icon(R.drawable.mailicon)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("message/rfc822");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"cdinh3507@gmail.com"});
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        try {
                            Context context = getApplicationContext();
                            context.startActivity(Intent.createChooser(intent, context.getString(R.string.email)));
                        } catch (ActivityNotFoundException e) {

                        }
                    }
                })
                .build());


        return main;
    }

    private MaterialAboutCard.Builder feed() {

        MaterialAboutCard.Builder main = new MaterialAboutCard.Builder();
        main.title(R.string.feedbacktitle);
        main.addItem(new MaterialAboutActionItem.Builder()
                .text(R.string.feedback)
                .icon(R.drawable.forum)
                .setOnClickAction(new MaterialAboutItemOnClickAction() {
                    @Override
                    public void onClick() {
                        Intent licInent = new Intent(getApplicationContext(), ForumActivity.class);
                        startActivity(licInent);
                    }
                })
                .build());


        return main;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //Call this method to let the scrollbar scroll off screen
        setScrollToolbar(true);
    }


    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.about);
    }

}