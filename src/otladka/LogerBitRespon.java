package otladka;

import gui.GlobalPanel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class LogerBitRespon {
    public static void saveResponeByte(byte [] bytearray){
        StringBuilder builder = new StringBuilder();
        for(byte b : bytearray) {
            builder.append(b + " ");
        }
        builder.append("-------------------------------------------------");
        File father = new File(new File(GlobalPanel.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent());
        File jarDir =  new File(father + File.separator +"log");
        if(!jarDir.exists()){
            try {
                jarDir.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jarDir, StandardCharsets.UTF_8,false))) {
            out.print(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
