package it.polito.tdp.imdb.model;

import java.util.ArrayList;

public abstract class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		
		model.creaGrafo(2005);
		
		model.getRegistiAdiacenti(new ArrayList<>(model.getVertici()).get(1));
	}

}
