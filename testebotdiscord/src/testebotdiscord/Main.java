import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class RobloxScraper {
    public static void main(String[] args) {
        String gameUrl = "https://www.roblox.com/games/2753915549/Blox-Fruits";

        try {
            
            Document doc = Jsoup.connect(gameUrl).get();

            
            Element updateElement = doc.selectFirst(".game-update-date"); 
            if (updateElement != null) {
                String lastUpdate = updateElement.text();
                System.out.println("Última atualização do jogo: " + lastUpdate);
            } else {
                System.out.println("⚠️ Não foi possível encontrar a data de atualização.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}