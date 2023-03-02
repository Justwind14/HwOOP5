package UI.Paragraps;

import UI.Console;

public class DeletePhoneNumber extends Paragraphs{

    public DeletePhoneNumber(Console cons) {
        super(cons);
    }

    @Override
    public String description() {
        return "Удалить телефонный номер из исписка контактов.";
    }

    @Override
    public void realization() {
        getCons().delPhone();
    }
}
