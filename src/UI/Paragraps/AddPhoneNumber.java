package UI.Paragraps;

import UI.Console;

public class AddPhoneNumber extends Paragraphs{

    public AddPhoneNumber(Console cons) {
        super(cons);
    }

    @Override
    public String description() {
        return "Добавление номера телефона";
    }

    @Override
    public void realization() {
        getCons().addPhone();

    }
}
