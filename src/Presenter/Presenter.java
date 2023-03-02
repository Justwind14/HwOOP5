package Presenter;

import Model.Model;
import UI.Option;
import UI.View;

public class Presenter {
    private View view;
    private Model model = new Model();

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void toModel(String line, String command) {
        if (command.equals("1")){
            model.SaveAs(line);
            System.out.println("Контакт записан!");
        }
        if (command.equals("2")){
            model.Delete(line);
        }
        if (command.equals("3")){
            System.out.println(model.GetNumber(line)+"\n");

        }
    }

}
