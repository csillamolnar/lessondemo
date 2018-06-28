package com.myspring.lessondemo.service.LearnComposer;

import java.util.ArrayList;
import java.util.List;

import com.myspring.lessondemo.domain.ToLearn;

public class LearnComposer implements ToLearn {
	private List<ToLearn> toLearnList = new ArrayList<ToLearn>();

	@Override
	public void showLearnStatus() {
		for (ToLearn toLearn : toLearnList) {
			toLearn.showLearnStatus();
		}
	}

	public void addLesson(ToLearn toLearn) {
		toLearnList.add(toLearn);
	}

	public void removeLesson(ToLearn toLearn) {
		toLearnList.remove(toLearn);
	}

	public List<ToLearn> getToLearnList() {
		return toLearnList;
	}

	public void setToLearnList(List<ToLearn> toLearnList) {
		this.toLearnList = toLearnList;
	}
	

}
