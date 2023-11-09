package logik;

import gui.GlobalPanel;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class ChatHistori {
    public static boolean saveChat(String text,String who) {
        StringBuffer bf = new StringBuffer();
        bf.append(who + " - " + LocalDateTime.now() + " : ");
        bf.append(System.lineSeparator());
        bf.append(text);
        bf.append(System.lineSeparator());
        File father = new File(new File(GlobalPanel.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent());
        File jarDir =  new File(father + File.separator +"chat");
        if(!jarDir.exists()){
            try {
                jarDir.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jarDir, StandardCharsets.UTF_8,true))) {
            out.print(bf);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean loadChat(){
        boolean isEmpathy = true;
        StringBuffer sb = new StringBuffer();
        File father = new File(new File(GlobalPanel.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent());
        File file = new File(father + File.separator +"chat");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = br.readLine()) != null) {
                isEmpathy = false;
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            if(isEmpathy){
                sb.append("Тут будет переписка с ботом");
            }
            GlobalPanel.getChat().getChatArea().setText(sb.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean clearChat(){
        File jarDir = new File(ClassLoader.getSystemClassLoader().getResource("Main.class").getPath() + "chat");
        if(!jarDir.exists()){
            try {
                jarDir.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jarDir, StandardCharsets.UTF_8,false))) {
            out.print("");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
