/*
1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
2) Реализовать в java.
3) Создать множество ноутбуков.
4) Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ = RAM
2 - Объем ЖД = HDD
3 - Операционная система = operSystem
4 - Цвет … = color
Далее нужно запросить минимальные значения для указанных критериев -
сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */

import java.util.*;
import java.util.Scanner;

public class Notebook {
    String model;
    Integer ram;
    String opSys;
    Double screen;
    Integer hdd;

    public Notebook(String model, Double screen, Integer ram,
                    Integer hdd, String opSys) {
        this.model = model;
        this.ram = ram;
        this.opSys = opSys;
        this.screen = screen;
        this.hdd = hdd;
    }
/*
    Метод вывода строки - характеристик ноутбука в виде:
   Модель: 'Asus';  Диагональ монитора: 12.0;  RAM: 2;  HDD: 128;  OS: 'Windows-10'
 */
    @Override
    public String toString() {
        String model = "Модель: " +
                (this.model == null ? "N/A" : String.format("'%s'", this.model));
        String ram = "RAM: " +
                (this.ram == null ? "N/A" : this.ram);
        String opSys = "OS: " +
                (this.opSys == null ? "N/A" : String.format("'%s'", this.opSys));
        String hdd = "HDD: " +
                (this.hdd == null ? "N/A" : this.hdd);
        String screen = "Диагональ монитора: " +
                (this.screen == null ? "N/A" : this.screen);

        return model + ";  " + screen + ";  " + ram + ";  " + hdd + ";  " + opSys;
    }

    static void showMyNotebook(ArrayList<Notebook> getResult) {
        if (getResult.size() == 0) {
            System.out.println("Нет подходящих ноутбуков с такими параметрами");
        } else {
            System.out.println("Подходящие модели:");
            for (int i = 0; i < getResult.size(); i++) {
                System.out.printf("%d. %s\n", i+1, getResult.get(i).toString());
            }
        }
    }
    /*
        Создание искомого ноутбука (возвращает строку)
     */
    static Notebook myNotebook() {
        return new Notebook(searchModel(), searchScreen(), searchRAM(), searchHDD(), searchOS());
    }

    /*
    Выбор подходящих ноутбуков
     */
    static ArrayList<Notebook> likelyNotebooks(Notebook myNotebook, Notebook[] notebooks) {
        ArrayList<Notebook> getResult = new ArrayList<>();
        for (Notebook notebook : notebooks) {
            if (notebook.compareTo(myNotebook)) {
                getResult.add(notebook);
            }
        }
        return getResult;
    }

    /*
     *   Правила сравнения ноутбуков по характеристекам
     */
    private boolean compareTo(Notebook myNotebook) {
        if (this.model != null && myNotebook.model != null &&
                !this.model.contains(myNotebook.model)) return false;
        if (this.ram != null && myNotebook.ram != null &&
                myNotebook.ram > this.hdd) return false;
        if (this.opSys != null && myNotebook.opSys != null &&
                !this.opSys.contains(myNotebook.opSys)) return false;
        if (this.screen != null && myNotebook.screen != null &&
                myNotebook.screen > this.screen) return false;
        if (this.hdd != null && myNotebook.hdd != null &&
                myNotebook.hdd > this.hdd) return false;
        return true;
    }

    /*
     * Ввод требуемых параметров
     */
    public static String searchModel() {
        String myModel = null;
        System.out.println("\nВыберите из списка данные для поиска.\n  Модель:\n" +
                "1 - 'Asus'\n2 - 'Acer'\n3 - 'HP'\n4 - 'Lenovo'\n5 - 'Всё равно'");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch (num) {
            case 1:
                myModel = "Asus";
                break;
            case 2:
                myModel = "Acer";
                break;
            case 3:
                myModel = "HP";
                break;
            case 4:
                myModel = "Lenovo";
                break;
            case 5:
                myModel = null;
                break;
            default:
                System.out.printf("Модель:\t 'Неверный ввод!'");
                break;
        }
        return myModel;
    }

    public static Integer searchRAM() {
        Integer myRAM = 0;
        System.out.println("\nОперативная память:\n" +
                "1 - 2 Гб\n2 - 4 Гб\n3 - 8 Гб\n4 - 16 Гб\n5 - 'Всё равно'");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch (num) {
            case 1:
                myRAM = 2;
                break;
            case 2:
                myRAM = 4;
                break;
            case 3:
                myRAM = 8;
                break;
            case 4:
                myRAM = 16;
                break;
            case 5:
                myRAM = null;
                break;
            default:
                System.out.printf("RAM:\t 'Неверный ввод!'");
                break;
        }
        return myRAM;
    }

    public static String searchOS() {
        String myOS = null;
        System.out.println("\nОперационная система:\n" +
                "1 - 'Windows 10'\n2 - 'Android'\n3 - 'macOS'\n4 - 'Linux'\n5 - 'Всё равно'");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch (num) {
            case 1:
                myOS = "Windows-10";
                break;
            case 2:
                myOS = "Android";
                break;
            case 3:
                myOS = "macOS";
                break;
            case 4:
                myOS = "Linux";
                break;
            case 5:
                myOS = null;
                break;
            default:
                System.out.printf("OS:\t 'Неверный ввод!'");
                break;
        }
        return myOS;
    }

    public static Double searchScreen() {
        Double myScreen = 0.0;
        System.out.println("\nДиагональ монитора:\n" +
                "1 - 12.0\n2 - 14.0\n3 - 15.0\n4 - 16.0\n5 - 'Всё равно'");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch (num) {
            case 1:
                myScreen = 12.0;
                break;
            case 2:
                myScreen = 14.0;
                break;
            case 3:
                myScreen = 15.0;
                break;
            case 4:
                myScreen = 16.0;
                break;
            case 5:
                myScreen = null;
                break;
            default:
                System.out.printf("Screen:\t 'Неверный ввод!'");
                break;
        }
        return myScreen;
    }

    public static Integer searchHDD() {
        Integer myHDD = 0;
        System.out.println("\nОперативная память:\n" +
                "1 - 128\n2 - 256\n3 - 512\n4 - 'Всё равно'");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        switch (num) {
            case 1:
                myHDD = 128;
                break;
            case 2:
                myHDD = 256;
                break;
            case 3:
                myHDD = 512;
                break;
            case 4:
                myHDD = null;
                break;
            default:
                System.out.printf("RAM:\t 'Неверный ввод!'");
                break;
        }
        return myHDD;
    }
}