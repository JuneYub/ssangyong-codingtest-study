
import java.util.*;

class Solution {
	
	public void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
		if(index == bans.length) {
			banSet.add(new HashSet<>(banned));
			return;
		}
		
		for(String id : bans[index]) {
			if(banned.contains(id)) continue;
			else {
				banned.add(id);
				count(index+1, banned, bans, banSet);
				banned.remove(id);
			}
		}
	}
	
	
    public int solution(String[] user_id, String[] banned_id) {
        
    	String[][] bans = Arrays.stream(banned_id)
    			.map(banned -> banned.replace("*", "."))
    			.map(banned -> Arrays.stream(user_id)
    					.filter(id -> id.matches(banned))
    					.toArray(String[]::new))
    			.toArray(String[][]::new);
    	
    	Set<Set<String>> banSet = new HashSet<>();
    	count(0, new HashSet<String>(), bans, banSet);
    	
    	return banSet.size();
    	
    }
}