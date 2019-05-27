package com.omelchenkoaleks.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            getSharedPreferences() будет создан xml файл, который будет доступен
            на уровне всего приложения
            getPreferences() xml файл будет доступен на уровне только активити
         */

        SharedPreferences sharedPreferences = this.getSharedPreferences(
                "mySharedPreferences", Context.MODE_PRIVATE);
        /*
            чтобы получить доступ к созданному объекту sharedPreferences - нужен еще объект
            SharedPreferences.Editor
         */

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("newHelloText", "Hello StaredPreferences");
        editor.apply();


        /*
            теперь можем использовать данные где угодно в приложении
         */

        TextView textView = findViewById(R.id.text_view);
        textView.setText(sharedPreferences.getString("newHelloText", "Default text"));


        /*
            ЕСЛИ НУЖНО УДАЛИТЬ:

        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString("newHelloText", "Hello StaredPreferences");

        // удаляем только данные в этом файле (editor) по ключу
        editor.remove("newHelloText");

        // удаляем все данные в этом файле (editor)
        editor.clear();

        editor.apply();

         */
    }
}
