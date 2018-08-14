import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Wyniki {
    public static void main(String[] args) throws IOException {

        List<Player> players = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        String userInput = "Imię nazwisko wynik";

        while(!userInput.equals("stop")){
            System.out.println("Podaj wynik punktowy gracza (lub stop):");
            userInput = scan.nextLine();
            if(userInput.equals("stop")){
                break;
            }
            String[] split = userInput.split(" ");
            double result = Double.valueOf(split[2]);
            players.add(new Player(split[0], split[1], result));
        }

        System.out.println("Wybierz algorytm sortowania (imię/nazwisko/punkty:)");
        String algorytmSortowania = scan.nextLine();

        if(algorytmSortowania.equals("punkty")){
            ResultComparator resultComparator = new ResultComparator();
            Collections.sort(players, resultComparator);
        } else if(algorytmSortowania.equals("nazwisko")){
            LastNameComparator lastNameComparator = new LastNameComparator();
            Collections.sort(players, lastNameComparator);
        } else
            Collections.sort(players);

        System.out.println(players);

        FileWriter fileWriter = new FileWriter("stats.csv");
        BufferedWriter bfw = new BufferedWriter(fileWriter);

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            String info = player.getFirstName() + " " + player.getLastName() + " " + player.getResult();
            bfw.write(info);
            bfw.newLine();
        }
        bfw.close();

        System.out.println("Zapisano dane w pliku stats.csv.");
    }
}
