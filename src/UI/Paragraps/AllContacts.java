package UI.Paragraps;

import UI.Console;

public class AllContacts extends Paragraphs{

    public AllContacts(Console cons) {
        super(cons);
    }

    @Override
    public String description() {
        return "Показать весь список контактов";
    }

    @Override
    public void realization() {
        getCons().ShowContacts();
    }
}
