package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        if(menu.getClass().getSimpleName()
                .equals("MenuBuilder")){
            try{
                Method m = menu.getClass()
                        .getDeclaredMethod (
                                "setOptionalIconsVisible",
                                Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            }
            catch(NoSuchMethodException e){
                System.err.println("onCreateOptionsMenu");
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public void onHelpClick(MenuItem item)
    {
        Toast.makeText(getApplicationContext(),
                "Помощь нажато", Toast.LENGTH_LONG).show();
    }

    public void onCartClick(MenuItem item) {
        String msg = "Корзина нажато";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onCallPhoneClick(MenuItem item) {
        String msg = "Звонок нажатo";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onCameraClick(MenuItem item) {
        item.setChecked(true);
        String msg = "Камера нажатo";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onVideoClick(MenuItem item) {
        item.setChecked(true);
        String msg = "Видео нaжaто";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onEmailClick(MenuItem item) {
        String msg = "Почта нажата";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onAddClick(MenuItem item) {
        String msg = "Добавить нажато";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onCopyClick(MenuItem item) {
        String msg = "Скопировть нажато";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void onPasteClick(MenuItem item) {
        String msg = "Вставить нажато";
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
