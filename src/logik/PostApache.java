package logik;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.IOException;

public class PostApache {

    public static String liteTest(String text) {
        Connection.Response response = null;
        try {
            response = Jsoup.connect("https://chatgptbot.ru/gptbot.php")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/119.0")
                    .header("Accept", "*/*")
                    .header("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .header("X-Requested-With", "XMLHttpRequest")
                    .header("Origin", "https://chatgptbot.ru")
                    .header("Connection", "keep-alive")
                    .header("Referer", "https://chatgptbot.ru/chat/")
                    .cookie("_ym_uid", "1688735840962097004")
                    .cookie("_ym_d", "1688735840")
                    .cookie("_ga_19H1TD1QM2", "GS1.1.1699201276.36.1.1699201426.0.0.0")
                    .cookie("_ga", "GA1.1.1349056680.1688735841")
                    .cookie("PHPSESSID", "a108abc74c07a3daf10d123603775ffd")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Site", "same-origin")
                    .header("TE", "trailers")
                    .requestBody("engine=gpt-3.5-turbo&prompt="+ text +"&temperature=0.6&max_tokens=3174&top_p=1&frequency_penalty=0&presence_penalty=0.6&n=1&stop[]=Human:&messages[0][role]=assistant&messages[0][content]=Меня зовут OpenAI Assistant. Чем могу помочь?&messages[1][role]=user&messages[1][content]="+ text)
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String otvet = "";
        try {
            otvet = response.parse().text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return otvet;


    }
}
