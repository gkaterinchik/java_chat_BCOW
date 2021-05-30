package client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class History {
    public static List<String> showHistory(String nickname) throws IOException {
        String Path = "History_" + nickname + ".txt";
        File dir = new File(Path);
        if (!dir.exists())
            dir.createNewFile();
        List<String> HistMessage = Files.readAllLines(Paths.get(Path));
        return HistMessage;
    }

    public static void Add(String nickname, String message) throws IOException {
        String Path = "History_" + nickname + ".txt";

        try (FileWriter writer = new FileWriter(Path, true)) {
            writer.write(message);
            writer.append('\n');
            //writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


}
