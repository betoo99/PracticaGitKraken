import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Alberto Zamora Camacho
 */
public class Main {
    public static void main(String[] args) {
        String archivo = JOptionPane.showInputDialog("Introduce ruta del archivo");
        copy(archivo);
        copy(archivo);



    }
    public static String type(String nomArch){
        StringBuilder contenido =  new StringBuilder();
        int car;
        try (FileReader fl = new FileReader(nomArch)){
            car = fl.read();
            while (!(car == -1)){
                contenido.append((char)car);
                car = fl.read();
            }
        }catch (IOException e){
            System.out.println("Error en el archivo: "+e.getMessage());
        }

        return contenido.toString();
    }

    public static void copy(String nomArch){
        StringBuilder fl2Name = new StringBuilder();
        fl2Name.append(JOptionPane.showInputDialog("Enter the new filename."));
        try (FileReader fl1 = new FileReader(nomArch)){
            int car;
            if (fl2Name.toString().isBlank()){
                fl2Name.append(nomArch+"_copy");
            }
            FileWriter fl2 = new FileWriter(fl2Name.toString());
            car = fl1.read();
            while (!(car == -1)){
                fl2.write((char) car);
                car = fl1.read();
            }
            fl1.close();
            fl2.close();
        }catch (IOException e){
            System.out.printf(e.getMessage());
        }

    }

}