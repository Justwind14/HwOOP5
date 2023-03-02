package Model;


import Model.FileTypes.FileType;
import Model.FileTypes.JsonFile;
import Model.FileTypes.TxtFile;
import Model.FileTypes.XmlFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String> PhoneNumbers = new ArrayList<>();
    private FileType filetype;
    public void SaveAs (String some){
        this.filetype = ChoiseWriter(GetFormat(some));
        filetype.SaveAs(some);
    }
    public void Delete (String some){
        System.out.println("ololo");
    }
    public String GetNumber(String some){
        this.PhoneNumbers.addAll(readable());
        return findPhone(some);
    }
    private String GetFormat(String some){
        String[] s = some.split(" ");
        return s[5];
    }
    private FileType ChoiseWriter(String format){
        if (format.equals("txt")){
            return new TxtFile();
        }
        else if (format.equals("xml")){
            return new XmlFile();
        }
        else if (format.equals("json")){
            return new JsonFile();
        }
        else return null;
    }
    public List<String> readable(){
        try (BufferedReader br = new BufferedReader(new FileReader("PhoneNumbers.txt")))
        {
            String line;
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                PhoneNumbers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("PhoneNumbers.xml")))
        {
            String line;
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                PhoneNumbers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader("PhoneNumbers.json")))
        {
            String line;
            while (true) {
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                PhoneNumbers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PhoneNumbers;
    }
    public String findPhone (String some) {
        for (String someContact: PhoneNumbers
        ) {
            if (someContact.contains(some)){
                return someContact;
            }
        }
        return "Такого контакта не существует";
    }
}
