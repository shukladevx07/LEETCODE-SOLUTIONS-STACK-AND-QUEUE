import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> rootSet = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(rootSet.contains(prefix) ? prefix : word);
        }
        return result.toString();
    }
}
