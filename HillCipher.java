class HillCipher {
    static int[][] keyMatrix = new int[3][3];
    static int[][] b = new int[3][3];
    static int[][] messageVector = new int[3][1];
    static int[][] cipherMatrix = new int[3][1];

    static void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    static void encrypt(int cipherMatrix[][],
            int keyMatrix[][],
            int messageVector[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;
                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }

    public static void main(String[] args) {
        String message = "ACT";
        String key = "GYBNQKURP";

        getKeyMatrix(key, keyMatrix);

        for (int i = 0; i < 3; i++)
            messageVector[i][0] = (message.charAt(i)) % 65;

        encrypt(cipherMatrix, keyMatrix, messageVector);
        String CipherText = "";
        for (int i = 0; i < 3; i++)
            CipherText += (char) (cipherMatrix[i][0] + 65);
        System.out.print(" Ciphertext:" + CipherText);

    }
}
