import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class RobloxScraper {
    public static void main(String[] args) {
        String gameUrl = "https://www.roblox.com/games/2753915549/Blox-Fruits"; // Substitua pelo link do jogo

        try {
            // Conectar e baixar o HTML da página
            Document doc = Jsoup.connect(gameUrl).get();

            // Ajuste este seletor CSS para garantir que está pegando o elemento certo!
            Element updateElement = doc.selectFirst(".game-update-date"); 

            if (updateElement != null) {
                String lastUpdate = updateElement.text();
                System.out.println("Última atualização do jogo: " + lastUpdate);
            } else {
                System.out.println("⚠️ Não foi possível encontrar a data de atualização. Verifique o seletor CSS.");
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao acessar a página do jogo.");
            e.printStackTrace();
        }
    }
}
