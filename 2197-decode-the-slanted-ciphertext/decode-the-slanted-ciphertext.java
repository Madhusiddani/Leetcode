class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int totalLength = encodedText.length();
        int columns = totalLength / rows;

        StringBuilder decodedText = new StringBuilder(totalLength);

        for (int startCol = 0; startCol < columns; startCol++) {
            int currentRow = 0;
            int currentCol = startCol;

            while (currentRow < rows && currentCol < columns) {
                decodedText.append(encodedText.charAt(currentRow * columns + currentCol));
                currentRow++;
                currentCol++;
            }
        }

        int lastIndex = decodedText.length() - 1;
        while (lastIndex >= 0 && decodedText.charAt(lastIndex) == ' ') {
            lastIndex--;
        }

        return decodedText.substring(0, lastIndex + 1);
    }
}