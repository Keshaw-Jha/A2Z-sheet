
public class Main {
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int color = 2;
        int sr = 1;
        int sc = 1;

        System.out.printf("Image before fill with color %s at [%d,%d]%n", color,sr,sc);
        displayImage(image);
        Solution.floodFill(image, sr, sc, color);
        System.out.println("Image after fill with color : " + color);
        displayImage(image);

    }

    static void displayImage(int[][] image) {
        for (int[] i : image) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int initial = image[sr][sc];
        if (initial == color)
            return image;
        fill(sr, sc, image, m, n, initial, color);
        return image;
    }

    static void fill(int r, int c, int[][] image, int m, int n, int initial, int color) {
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != initial)
            return;
        image[r][c] = color;
        fill(r + 1, c, image, m, n, initial, color);
        fill(r - 1, c, image, m, n, initial, color);
        fill(r, c + 1, image, m, n, initial, color);
        fill(r, c - 1, image, m, n, initial, color);
        return;
    }
}
