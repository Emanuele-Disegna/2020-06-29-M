package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
	private ImdbDAO dao;
	private Map<Integer, Director> idMap;
	private Graph<Director, DefaultWeightedEdge> grafo;
	private List<Adiacenza> adiacenze;
	
	public Model() {
		dao = new ImdbDAO();
	}
	
	public void creaGrafo(int anno) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		idMap = new HashMap<>();
		
		dao.getVertici(idMap, anno);
		
		Graphs.addAllVertices(grafo, idMap.values());
		
		adiacenze = dao.getArchi(idMap, anno);
		
		for(Adiacenza a : adiacenze) {
			Graphs.addEdgeWithVertices(grafo, a.getD1(), a.getD2(), a.getPeso());
		}
		
		System.out.println(grafo.vertexSet().size());
		System.out.println(grafo.edgeSet().size());
	}
	
	public Set<Director> getVertici(){
		return grafo.vertexSet();
	}
	
	public List<RegistaAdiacente> getRegistiAdiacenti(Director d){
		List<RegistaAdiacente> ret = new ArrayList<>();
		
		for(Director vicino : Graphs.neighborListOf(grafo, d)) {
			ret.add(new RegistaAdiacente(vicino, (int) grafo.getEdgeWeight(grafo.getEdge(vicino, d))));
		}
		
		Collections.sort(ret, Comparator.comparing(RegistaAdiacente::getPeso));
		Collections.reverse(ret);
		
		System.out.println(ret);
		
		return ret;
	}
}
