import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Notebook[] nb = new Notebook[]{
                new Notebook("Lenovo", 12.8, 4, 128, "Windows-10"),
                new Notebook("Acer", 14.0, 16, 256, "Android"),
                new Notebook("Lenovo", 17.0, 4, 512, "macOS"),
                new Notebook("HP", 12.8, 8, 128, "Windows-10"),
                new Notebook("Acer", 15.6, 2, 256, "Linux"),
                new Notebook("Asus", 13.6, 8, 512, "macOS"),
                new Notebook("Acer", 14.6, 2, 256, "macOS"),
                new Notebook("HP", 15.6, 24, 512, "Linux"),
                new Notebook("Asus", 14.2, 16, 512, "Windows-10"),
                new Notebook("Acer", 15.6, 8, 128, "Linux")
        };

        Notebook myNotebook = Notebook.myNotebook();
        System.out.println("\tИщем: \n" + myNotebook);
        ArrayList<Notebook> likelyNotebooks = Notebook.likelyNotebooks(myNotebook, nb);
        System.out.println();
        Notebook.showMyNotebook(likelyNotebooks);
    }
}