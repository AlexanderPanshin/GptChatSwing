package logik;

import gui.GlobalPanel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class LoginHistori implements WindowListener {
    public static File JAR_OUT_DIR_LOGIN_WIN =  new File(new File(GlobalPanel.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent()
            + File.separator + "login");
    public static File JAR_OUT_DIR_LOGIN_LINUX = new File(System.getProperty("user.home") + File.separator + ".ChatGptConfig" + File.separator + "login");

    public static void SaveLogin() {
        String login = GlobalPanel.getHeader().getLogin().getText() != null ? GlobalPanel.getHeader().getLogin().getText() : "";
        String password = GlobalPanel.getHeader().getPass().getPassword() != null ? new String(GlobalPanel.getHeader().getPass().getPassword()) : "";
        File curentJar = JAR_OUT_DIR_LOGIN_WIN;

        if (!JAR_OUT_DIR_LOGIN_WIN.exists()) {
            try {
                JAR_OUT_DIR_LOGIN_WIN.createNewFile();
            } catch (IOException e) {
                File tempJarDir = new File(JAR_OUT_DIR_LOGIN_LINUX.getParent());
                tempJarDir.mkdirs();
                if (!JAR_OUT_DIR_LOGIN_LINUX.exists()) {
                    try {
                        JAR_OUT_DIR_LOGIN_LINUX.createNewFile();
                        curentJar = JAR_OUT_DIR_LOGIN_LINUX;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(curentJar, StandardCharsets.UTF_8,false))) {
            out.print("Login:" + login + System.lineSeparator() + "Password:" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void clear(){
        if (JAR_OUT_DIR_LOGIN_WIN.exists()) {
            try (PrintWriter out = new PrintWriter(new FileWriter(JAR_OUT_DIR_LOGIN_WIN, StandardCharsets.UTF_8,false))) {
                out.print("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (JAR_OUT_DIR_LOGIN_LINUX.exists()) {
            try (PrintWriter out = new PrintWriter(new FileWriter(JAR_OUT_DIR_LOGIN_LINUX, StandardCharsets.UTF_8,false))) {
                out.print("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void loadLogin(){
        if (JAR_OUT_DIR_LOGIN_WIN.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(JAR_OUT_DIR_LOGIN_WIN));
                String line = reader.readLine();
                while (line != null) {
                    parseLogin(line);
                    line = reader.readLine();

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (JAR_OUT_DIR_LOGIN_LINUX.exists()) {

        }
    }
    public static void parseLogin(String stroka){
        if (stroka != null && stroka.contains("Login:")){
            if(stroka.length()>6){
                String [] temp = stroka.split(":");
                GlobalPanel.getHeader().getLogin().setText(temp[1]);
                GlobalPanel.getHeader().getjCheckBox().setSelected(true);
            }
        }else if(stroka != null && stroka.contains("Password")){
            if(stroka.length()>9){
                String [] temp = stroka.split(":");
                GlobalPanel.getHeader().getPass().setText(temp[1]);
                GlobalPanel.getHeader().getjCheckBox().setSelected(true);
                GlobalPanel.getOutArea().getTextArea().requestFocus();
            }
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {
        LoginHistori.loadLogin();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (GlobalPanel.getHeader().isSavePassword()){
            LoginHistori.SaveLogin();
        }else{
            LoginHistori.clear();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
