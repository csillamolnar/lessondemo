package com.myspring.lessondemo.config;


import java.net.InetAddress;
import java.net.InetSocketAddress;

import javax.sql.DataSource;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.dozer.DozerBeanMapper;

import org.dozer.Mapper;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class LessondemoConfig {
	 private final ElasticSearchProperties esProperties;
	 

	    @Autowired
	    public LessondemoConfig(ElasticSearchProperties esProperties) {

	        this.esProperties = esProperties;

	    }
	    
	    private static void printResponse(String description, Client client) {
		      try {
		         GetResponse response = client.prepareGet("store", "productinfo", "1").get();
		         System.out.println(description + ": " + response);
		      } catch (NoNodeAvailableException e) {
		         System.out.println(description + ": " + e);
		      }
		   }
		 
/*	@Bean

	public DataSource dataSource() {

		HikariDataSource hikariDataSource = new HikariDataSource();

		hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/lessons?verifyServerCertificate?=false&useSSL=false");
		hikariDataSource.setUsername("cmolnar");
		hikariDataSource.setPassword("cmlonar");
		//hikariDataSource.setUsername("jdbc:mysql://localhost:3306/lessons?autoReconnect=true&useSSL=false");

		return hikariDataSource;

	}*/
	
	 @Bean
	    @Primary
	    public DataSource dataSource() {
	        return DataSourceBuilder
	                .create()
	                .username("cmolnar")
	                .password("cmolnar")
	               // .url("jdbc:mysql://localhost:3306/lessons?verifyServerCertificate?=false&useSSL=false")
	               .url("jdbc:mysql://localhost:3306/lessons?autoReconnect=true&useSSL=false")
	                .driverClassName("com.mysql.jdbc.Driver")
	                .build();
	}
	 
	 @Bean

	    public Client client() throws Exception {



	        Settings esSettings = Settings.builder()

	                .put("cluster.name", esProperties.getClusterName())

	                .build();



	     /*   TransportClient client = new PreBuiltTransportClient(esSettings);
	        client.addTransportAddress(
                    new InetSocketTransportAddress(new InetSocketAddress(esProperties.getHost(), esProperties.getPort())));*/
	        
	        TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300);

	        TransportClient client = new PreBuiltTransportClient(esSettings).addTransportAddress(address);
	        
	      /*  GetResponse response = client.prepareGet("company", "employeeinfo", "1").get();
	        System.out.println(response);*/
	       // printResponse("getByAddress(new byte[] {127, 0, 0, 1})", client);
	        printResponse("getByAddress(new byte[] {127, 0, 0, 1})", client);
	        return client;

	    }



	    @Bean
	    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
	        return new ElasticsearchTemplate(client());
	    }
	    
	    @Bean
	    public Mapper mapper() {
	        return new DozerBeanMapper();
	    }



}
