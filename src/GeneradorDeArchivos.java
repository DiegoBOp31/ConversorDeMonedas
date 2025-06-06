import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivos {
    public void guardarJson(List<Moneda> moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("logsCambiosDeMonedas.json");
        escritura.write(gson.toJson(moneda));
        escritura.close();
    }
}
