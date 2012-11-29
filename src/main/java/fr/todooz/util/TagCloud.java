package fr.todooz.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TagCloud {

	private List<String> tags = new ArrayList<String>();
	
	public void add(String ... listetags) {
		if (listetags != null){
			for (String tag : listetags){
				if (!tags.contains(tag) && (tag!=null) && (tag != "")){

					tags.add(tag);
				}
			}
		}

	   }
	
	public void shuffle(){
		Collections.shuffle(tags);
		
	}
	
	public void top(int i){
		
		if (i<0) {i=0;}
		if ((i<tags.size())){
			tags = tags.subList(0, i);
		}
	}
	
	public int size() {
        return tags.size();
    }



	public boolean contains(String string) {
		// TODO Auto-generated method stub
		return tags.contains(string);
	}
	
}
