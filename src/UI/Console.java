package UI;
import Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Scanner scan;
    private Presenter presenter;
    private Menu menu;
    boolean flag;
    String command;



    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        flag = true;
        while (flag) {
            menu.PrintMenu();
            System.out.println("Выберите из списка");
            command = scan.nextLine();
            menu.receiving(Integer.parseInt(command));
        }
    }

    public void end() {
        flag = false;
    }

    public void addPhone(){
        System.out.println("Введите ФИО и город через ЭНТЕР");
        StringBuilder sb = new StringBuilder();
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        System.out.println("Введите номер телефона");
        sb.append(scan.nextLine() + " ");
        System.out.println("Введите расширение для записи контакта в файл (txt/json/xml)");
        sb.append(scan.nextLine());
        presenter.toModel(sb.toString(), command);
    }

    public void delPhone(){
        System.out.println("Введите ФИО и город через ЭНТЕР для удаления контакта");
        StringBuilder sb = new StringBuilder();
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine());
        presenter.toModel(sb.toString(), command);
    }

    public void takePhone(){
        System.out.println("Введите ФИО и город через ЭНТЕР");
        StringBuilder sb = new StringBuilder();
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        sb.append(scan.nextLine() + " ");
        presenter.toModel(sb.toString(), command);
    }

    public void ShowContacts() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        presenter.toModel(sb.toString(), command);
    }
}
