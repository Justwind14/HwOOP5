import Model.FileTypes.FileType;
import Presenter.Presenter;
import UI.Console;
import UI.View;

public class Main {
    public static void main(String[] args) {
//        Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах (txt, csv, xml, json).
//        под форматами понимаем структуру файлов, например: в файле на одной строке хранится одна часть записи, пустая строка - разделитель
        View view = new Console();
        Presenter presenter = new Presenter(view);
        view.start();
    }
}