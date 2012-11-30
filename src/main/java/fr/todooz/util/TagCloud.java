package fr.todooz.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class TagCloud {

	private List<String> tags = new ArrayList<String>();
	
	public void add(String ... listetags) {
		if (listetags != null){
			for (String tag : listetags){
				if (!tags.contains(tag) && !StringUtils.isEmpty(tag)){
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
	
	public List<String> getTags() {
	    return tags;
	}
	
}
