package com.example.mercedesf1app;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserManager {

    public static List<User> loadUsers(Context context) {
        try {
            InputStream is = context.getAssets().open("users.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");

            return new Gson().fromJson(json, new TypeToken<List<User>>() {}.getType());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
