package br.dcc.ufba.wiser.smartufba.observer;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class Observer {
	private static String fname = "http://192.168.0.13:3030/sistemasweb/";

	
	public void observer(){
		
		   Model model = FileManager.get().loadModel(fname );
			 
		
		String queryString = 
				"PREFIX  j.1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
				"	PREFIX  j.0: <http://www.loa-cnr.it/ontologies/DUL.owl#>\n" +
				"	PREFIX xsd:   <http://www.w3.org/2001/XMLSchema#>\n" +
				"	PREFIX  j.1: <http://purl.oclc.org/NET/ssnx/ssn#>\n" +
				"	PREFIX  j.0: <http://www.loa-cnr.it/ontologies/DUL.owl#>\n" +

				
				"SELECT ?hasDataValue " +
				"  WHERE { <http://wiser.dcc.ufba.br/smartUFBA/devices/ufbaino#obsValue_14915308050001491530865086> " +
				"                   a                 j.1:ObservationValue ; " +
				"                   j.0:hasDataValue  '37'^^xsd:double ; " +
				"                   j.0:isSettingFor  false . }";

		
		
		Query query = QueryFactory.create(queryString);
		 
		
		
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		 
		
		if (results.hasNext()){
			
			System.out.println("Encontrou");
		}
		
	}
	
	public void getActuator(){
		
	}
	
	public static void main (String args[]){
		Observer observer = new Observer();
		observer.observer();
	}
	
}
