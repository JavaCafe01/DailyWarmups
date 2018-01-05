package com.gsnathan.dailywarmups;

/**
 * Created by Gokul Swaminathan on 1/5/2018.
 */

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ForumSpreadsheetWebService {


    @POST("e/1FAIpQLSdQhVJt6H6Q9T9EHswBEXSMhLcOZvQoz3TMQWJ2L9jTnm3nnA/formResponse")
    @FormUrlEncoded
    Call<Void> completeQuestionnaire(
            @Field("entry.2033570645") String ideas,
            @Field("entry.1702379870") String why,
            @Field("entry.1649014686") String comments
    );

}