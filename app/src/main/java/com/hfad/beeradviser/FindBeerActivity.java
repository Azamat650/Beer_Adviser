package com.hfad.beeradviser;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;
public class FindBeerActivity extends Activity {
    private BeerExpert expert = new BeerExpert(); /* Для получения рекомендаций
    необходимо использовать класс BeerExpert*/
    @Override
    protected void onCreate(Bundle savedInstanceState) { /* Все активности также должны реализовать
    метод onCreate(). Метод onCreate() вызывается при создании объекта активности и используется
    для настройки основных параметров — например, выбора макета, с которым связывается активность.
    Это делается при помощи метода setContentView(). */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer); /*Метод setContentView сообщает Android,
        какой макет используется активностью. В данном случае это макет activity_find_beer.*/
    }

    //Вызывается при щелчке на кнопке
    public void onClickFindBeer(View view) {
        /*Чтобы получить ссылки на компоненты графического интерфейса TextView и Spinner, активность
вызывает метод findViewById(). Метод findViewById() получает идентификатор компонента в виде
параметра и возвращает объект View. Android использует R.java для отслеживания ресурсов,
используемых в приложении; среди прочего, этот класс позволяет получать ссылки на компоненты
графического интерфейса из кода активности.
Назначение текста в компоненте TextView: */
        TextView brands = (TextView) findViewById(R.id.brands); /*При выполнении этой строки кода
создается объект класса TextView с именем brands. После этого вы можете вызывать методы этого
объекта TextView.*/
        //Получить ссылку на Spinner:
        Spinner color = (Spinner) findViewById(R.id.color);
        //Получить вариант, выбранный в Spinner и преобразование его в String:
        String beerType = String.valueOf(color.getSelectedItem()); /* Конструкция
color.getSelectedItem() возвращает обобщенный объект Java.  Дело в том, что значения
раскрывающегося списка не обязаны быть объектами String — это могут быть, например, изображения.
В нашем случае известно, что значения представляют собой объекты String, поэтому мы используем
метод String.valueOf() для преобразования выбранного варианта из Object в String.*/
        //Получить рекомендации от класса BeerExpert:
        List<String> brandsList = expert.getBrands(beerType);//Получить контейнер List с сортами пива.
        StringBuilder brandsFormatted = new StringBuilder(); // Построить String по данным из List.
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n'); // Каждый сорт выводится с новой строки.
        }
        //Вывести сорта пива
        brands.setText(brandsFormatted); // Вывести результаты в надписи
    }
}