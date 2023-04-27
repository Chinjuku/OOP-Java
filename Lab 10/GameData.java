// import java.io.*;

// public class GameData implements Serializable {
//     private static final long serialVersionUID = 1L;
//     private int score;
//     private int level;

//     public GameData(int score, int level) {
//         this.score = score;
//         this.level = level;
//     }

//     public void save(String fileName) throws IOException {
//         try (ObjectOutputStream out = new ObjectOutputStream(
//                 new FileOutputStream(fileName))) {
//             out.writeObject(this);
//         }
//     }
// }
import java.util.*;

public class GameData {
    private Map<String, Object> data;

    public GameData() {
        data = new HashMap<>();
    }

    public void saveScore(int score) {
        data.put("score", score);
    }

    public int getScore() {
        return (int) data.getOrDefault("score", 0);
    }

    public void saveLevel(int level) {
        data.put("level", level);
    }

    public int getLevel() {
        return (int) data.getOrDefault("level", 1);
    }

    public void savePosition(double x, double y) {
        data.put("position", new double[] { x, y });
    }

    public double[] getPosition() {
        return (double[]) data.getOrDefault("position", new double[] { 0, 0 });
    }
}

