import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {

            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            while (true) {
                map.put(domain, map.getOrDefault(domain, 0) + count);

                int dot = domain.indexOf('.');

                if (dot == -1) {
                    break;
                }

                domain = domain.substring(dot + 1);
            }
        }

        List<String> result = new ArrayList<>();

        for (String domain : map.keySet()) {
            result.add(map.get(domain) + " " + domain);
        }

        return result;
    }
}