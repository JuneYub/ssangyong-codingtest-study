import java.util.*;
import java.util.stream.Collectors;

class Solution {
	
	private static class Course {
		public final String course;
		public final int occurrences;
		
		public Course(String course, int occuerences) {
			this.course = course;
			this.occurrences = occuerences;
		}
	}
	
	private void getCourse(char nextMenu, Set<String> selectedMenus, List<Set<String>> orderList, 
							Map<Integer, List<Course>> courses) {
		
		int occurences = (int) orderList.stream()
		.filter(order -> order.containsAll(selectedMenus))
		.count();
		
		if(occurences < 2) return;
		
		int size = selectedMenus.size();
		
		if(courses.containsKey(size)) {
			List<Course> courseList = courses.get(size); 
			
			Course course = new Course(selectedMenus.stream()
					.sorted()
					.collect(Collectors.joining("")), occurences);
					
			Course original = courseList.get(0);
			
			if(original.occurrences < occurences) {
				courseList.clear();
				courseList.add(course);
			} else if (original.occurrences == occurences) {
				courseList.add(course);
			}
		}
		
		if(size >= 10) return;
		
		for(char menuChar = nextMenu; menuChar <= 'Z'; menuChar++) {
			String menu = String.valueOf(menuChar);
			selectedMenus.add(menu);
			getCourse((char)(menuChar + 1), selectedMenus, orderList, courses);
			selectedMenus.remove(menu);
		}
		

		
	}
	
    public String[] solution(String[] orders, int[] course) {
        
    	List<Set<String>> orderList = Arrays.stream(orders)
		    	.map(String::chars)
		    	.map(charStream -> charStream
		    			.mapToObj(menu -> String.valueOf((char) menu))
		    			.collect(Collectors.toSet()))
		    	.collect(Collectors.toList());
    	
    	Map<Integer, List<Course>> courses = new HashMap<>();
    	for(int length : course) {
    		List<Course> list = new ArrayList<>();
    		list.add(new Course("", 0));
    		courses.put(length, list);
    	}
    	
    	getCourse('A', new HashSet<>(), orderList, courses);
    	
    	return courses.values().stream()
    	.filter(list -> list.get(0).occurrences > 0)
    	.flatMap(List::stream)
    	.map(c -> c.course)
    	.sorted()
    	.toArray(String[]::new);

    }
}