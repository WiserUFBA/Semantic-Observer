package br.dcc.ufba.wiser.smartufba.observer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		 
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		if (results.hasNext()){
			getActuator();
		}
		
	}
	
	public void getActuator(){
		Client client = ClientBuilder.newClient();
	
		try{
			Response resp = client.target("http://192.168.0.108:8181/cxf/lamp/devices/actuator/lamp").queryParam("status", false).request(MediaType.APPLICATION_JSON_TYPE).method("POST");
			Integer status = resp.getStatus();
			System.out.println(status);
		}catch (Exception e){
			e.printStackTrace();
			
		}finally{
			client.close();
		}
	}
	
	public static void main (String args[]){
		Observer observer = new Observer();
		observer.observer();
	}
	
}
