package Persistencia_de_datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<Conversion> conversiones = new ArrayList<>();



    public void addToJson(Conversion conversion){
        conversiones.add(conversion);
    }


    public void generarJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("conversiones.json");
        writer.write(gson.toJson(conversiones));
        writer.close();
    }

}
