package Presenter;

import Model.Model;
import UI.View;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void toModel(String line, String command) {
        if (command.equals("1")){
            model.SaveContact(line);
            System.out.println("Контакт записан!");
            System.out.println("===================================================================================");
        }
        if (command.equals("2")){
            model.Delete(line);
            System.out.println("Контакт удален!");
            System.out.println("===================================================================================");
        }
        if (command.equals("3")){
            System.out.println("Запрошенный контакт: "+ model.GetNumber(line)+"\n");
            System.out.println("===================================================================================");
        }
        if (command.equals("4")){
            System.out.println(model.readable());
            System.out.println("===================================================================================");
        }
    }

}
