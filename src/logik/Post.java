package logik;

import otladka.LogerBitRespon;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Post {
    public static Integer getCount(String login) {
        String respone = "Exep";
        try {
            URL url = new URL("https://chatgptbot.ru/php/gpgetdbscore.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Origin", "https://chatgptbot.ru");
            conn.setRequestProperty("DNT", "1");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Referer", "https://chatgptbot.ru/register/gpintropage.php");
            conn.setRequestProperty("Cookie", "PHPSESSID=124d61b09322ace2e67115e7d40e09fb; _ga_19H1TD1QM2=GS1.1.1698950640.1.1.1698950660.0.0.0; _ga=GA1.1.2001856501.1698950641");
            conn.setRequestProperty("Sec-Fetch-Dest", "empty");
            conn.setRequestProperty("Sec-Fetch-Mode", "cors");
            conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
            conn.setRequestProperty("TE", "trailers");
            conn.setDoOutput(true);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            out.write("jsonData={\"useremail\":\"" + login + "\"}");
            out.flush();
            out.close();
            String text = new String(conn.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            Integer count = -1;
            if (text.length()>2){
                int start = text.lastIndexOf("\"tokens_paid\":\"") + 15;
                int stop = text.indexOf("\",\"datetime_close\"");
                if(start == 14 || stop == -1){
                    start = text.indexOf("\"tokens_paid\":") + 14;
                    stop = text.indexOf(",\"datetime_close\"");
                }
                count  = Integer.parseInt(text.substring(start,stop));
            }
            return count;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static String getQusteion(String text){
        String otvet = "Exep";
        try {
            URL url = new URL("https://chatgptbot.ru/gptbot.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(25000);

            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/119.0");
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Origin", "https://chatgptbot.ru");
            //conn.setRequestProperty("DNT", "1");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Referer", "https://chatgptbot.ru/chat/");
            conn.setRequestProperty("Cookie", "_ym_uid=1688735840962097004; _ym_d=1688735840; _ga_19H1TD1QM2=GS1.1.1699201276.36.1.1699201426.0.0.0; _ga=GA1.1.1349056680.1688735841; PHPSESSID=a108abc74c07a3daf10d123603775ffd");
            conn.setRequestProperty("Sec-Fetch-Dest", "empty");
            conn.setRequestProperty("Sec-Fetch-Mode", "cors");
            conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
            conn.setRequestProperty("TE", "trailers");
            conn.setDoOutput(true);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            out.write("engine=gpt-3.5-turbo&prompt=" + text + "&temperature=0.6&max_tokens=3174&top_p=1&frequency_penalty=0&presence_penalty=0.6&n=1&stop[]=Human:&messages[0][role]=assistant&messages[0][content]=Меня зовут OpenAI Assistant. Чем могу помочь?&messages[1][role]=user&messages[1][content]=" + text);
            out.flush();
            out.close();
            byte[] readArr  = conn.getInputStream().readAllBytes();
            otvet = new String(readArr,StandardCharsets.UTF_8);
            otvet = otvet.replace("\uFEFF", "");
            LogerBitRespon.saveResponeByte(readArr);
            return otvet;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return otvet;
    }
    public static String etQusteion111(String text) throws IOException {
        URL url = null;
        try {
            url = new URL("https://chatgptbot.ru/gptbot.php");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }

        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/119.0");
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setRequestProperty("Origin", "https://chatgptbot.ru");
            //conn.setRequestProperty("DNT", "1");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Referer", "https://chatgptbot.ru/chat/");
            conn.setRequestProperty("Cookie", "_ym_uid=1688735840962097004; _ym_d=1688735840; _ga_19H1TD1QM2=GS1.1.1699201276.36.1.1699201426.0.0.0; _ga=GA1.1.1349056680.1688735841; PHPSESSID=a108abc74c07a3daf10d123603775ffd");
            conn.setRequestProperty("Sec-Fetch-Dest", "empty");
            conn.setRequestProperty("Sec-Fetch-Mode", "cors");
            conn.setRequestProperty("Sec-Fetch-Site", "same-origin");
            conn.setRequestProperty("TE", "trailers");

// For POST only - START
            conn.setDoOutput(true);
        OutputStream os = null;
        try {
            os = conn.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String post = new String("engine=gpt-3.5-turbo&prompt=" + text + "&temperature=0.6&max_tokens=3174&top_p=1&frequency_penalty=0&presence_penalty=0.6&n=1&stop[]=Human:&messages[0][role]=assistant&messages[0][content]=Меня зовут OpenAI Assistant. Чем могу помочь?&messages[1][role]=user&messages[1][content]=" + text);
        try {
            os.write(post.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// For POST only - END

        int responseCode = 0;
        try {
            responseCode = conn.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuffer respBody = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
           in.lines().forEach(l -> respBody.append(l + "\r\n"));
                in.close();

                System.out.println(respBody.toString());
                return respBody.toString();
            } else {
                System.out.println("POST request did not work.");
                return "POST request did not work.";
            }


    }


}
