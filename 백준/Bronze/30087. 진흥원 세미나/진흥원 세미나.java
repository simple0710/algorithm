import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String seminar = br.readLine();
            String room;
            switch (seminar) {
                case "Algorithm":
                    room = "204";
                    break;
                case "DataAnalysis":
                    room = "207";
                    break;
                case "ArtificialIntelligence":
                    room = "302";
                    break;
                case "CyberSecurity":
                    room = "B101";
                    break;
                case "Network":
                    room = "303";
                    break;
                case "Startup":
                    room = "501";
                    break;
                case "TestStrategy":
                    room = "105";
                    break;
                default:
                    room = "Unknown";
                    break;
            }
            System.out.println(room);
        }
    }
}