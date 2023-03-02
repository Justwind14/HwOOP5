package UI.Paragraps;

import UI.Console;

public class GetPhoneNumber extends Paragraphs{

    public GetPhoneNumber(Console cons) {
        super(cons);
    }

    @Override
    public String description() {
        return "Получить номер телефона";
    }

    @Override
    public void realization() {
        getCons().takePhone();
    }
}
