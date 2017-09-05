/*
 *  IBM Confidential OCO Source Materials
 *                                                                 
 *  5725-I43 Copyright IBM Corp. 2011, 2017
 *                                                                   
 *  The source code for this program is not published or otherwise
 *  divested of its trade secrets, irrespective of what has
 *  been deposited with the U.S. Copyright Office.
 *                   
 */


package com.ibm.mfp.adapters.sample.api;

import com.ibm.mfp.adapters.sample.*;
import com.ibm.mfp.adapters.sample.api.V1ApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;
import com.ibm.mfp.adapters.sample.StringUtil;
import com.ibm.mfp.adapters.sample.model.*;
import java.lang.*;

import com.ibm.mfp.adapters.sample.model.Counterexample;
import com.ibm.mfp.adapters.sample.model.CounterexampleCollection;
import com.ibm.mfp.adapters.sample.model.CreateCounterexample;
import com.ibm.mfp.adapters.sample.model.CreateDialogNode;
import com.ibm.mfp.adapters.sample.model.CreateEntity;
import com.ibm.mfp.adapters.sample.model.CreateExample;
import com.ibm.mfp.adapters.sample.model.CreateIntent;
import com.ibm.mfp.adapters.sample.model.CreateSynonym;
import com.ibm.mfp.adapters.sample.model.CreateValue;
import com.ibm.mfp.adapters.sample.model.CreateWorkspace;
import com.ibm.mfp.adapters.sample.model.DialogNode;
import com.ibm.mfp.adapters.sample.model.DialogNodeCollection;
import com.ibm.mfp.adapters.sample.model.Entity;
import com.ibm.mfp.adapters.sample.model.EntityCollection;
import com.ibm.mfp.adapters.sample.model.EntityExport;
import com.ibm.mfp.adapters.sample.model.ErrorResponse;
import com.ibm.mfp.adapters.sample.model.Example;
import com.ibm.mfp.adapters.sample.model.ExampleCollection;
import com.ibm.mfp.adapters.sample.model.Intent;
import com.ibm.mfp.adapters.sample.model.IntentCollection;
import com.ibm.mfp.adapters.sample.model.IntentExport;
import com.ibm.mfp.adapters.sample.model.LogCollection;
import com.ibm.mfp.adapters.sample.model.MessageRequest;
import com.ibm.mfp.adapters.sample.model.MessageResponse;
import com.ibm.mfp.adapters.sample.model.Synonym;
import com.ibm.mfp.adapters.sample.model.SynonymCollection;
import com.ibm.mfp.adapters.sample.model.UpdateCounterexample;
import com.ibm.mfp.adapters.sample.model.UpdateDialogNode;
import com.ibm.mfp.adapters.sample.model.UpdateEntity;
import com.ibm.mfp.adapters.sample.model.UpdateExample;
import com.ibm.mfp.adapters.sample.model.UpdateIntent;
import com.ibm.mfp.adapters.sample.model.UpdateSynonym;
import com.ibm.mfp.adapters.sample.model.UpdateValue;
import com.ibm.mfp.adapters.sample.model.UpdateWorkspace;
import com.ibm.mfp.adapters.sample.model.Value;
import com.ibm.mfp.adapters.sample.model.ValueCollection;
import com.ibm.mfp.adapters.sample.model.ValueExport;
import com.ibm.mfp.adapters.sample.model.Workspace;
import com.ibm.mfp.adapters.sample.model.WorkspaceCollection;
import com.ibm.mfp.adapters.sample.model.WorkspaceExport;

import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.util.*;
import java.io.InputStream;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import com.ibm.mfp.adapter.api.OAuthSecurity;
import com.ibm.mfp.adapter.api.ConfigurationAPI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.ConnectionSpec;

@Path("/v1")


@io.swagger.annotations.Api(description = "the v1 API")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T16:39:33.075+05:30")
public class V1Api  {
	@Context
        ConfigurationAPI configurationApi;

    @POST
    
    @Path("/workspaces/{workspace_id}/counterexamples")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create counterexample", notes = "Add a new counterexample to a workspace. Counterexamples are examples that have been marked as irrelevant input.", response = Counterexample.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Counterexamples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Counterexample.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Counterexample.class) })
    public Response createCounterexample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An object defining the content of the new user input counterexample." ,required=true) CreateCounterexample body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Counterexample respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createCounterexample(workspaceId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createCounterexample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createCounterexample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/dialog_nodes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create dialog node", notes = "Create a dialog node.", response = DialogNode.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "DialogNodes", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request", response = DialogNode.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = DialogNode.class) })
    public Response createDialogNode(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "A CreateDialogNode object defining the content of the new dialog node." ,required=true) CreateDialogNode body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DialogNodesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DialogNodesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DialogNode respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createDialogNode(workspaceId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createDialogNode");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createDialogNode");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/entities")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create entity", notes = "Create a new entity.", response = Entity.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Entities", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Entity.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Entity.class) })
    public Response createEntity(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "A CreateEntity object defining the content of the new entity." ,required=true) CreateEntity body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EntitiesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EntitiesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Entity respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createEntity(workspaceId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createEntity");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createEntity");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/intents/{intent}/examples")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create user input example", notes = "Add a new user input example to an intent.", response = Example.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Examples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Example.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Example.class) })
    public Response createExample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "A CreateExample object defining the content of the new user input example." ,required=true) CreateExample body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ExamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ExamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Example respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createExample(workspaceId,intent,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createExample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createExample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/intents")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create intent", notes = "Create a new intent.", response = Intent.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Intents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Intent.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Intent.class) })
    public Response createIntent(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "A CreateIntent object defining the content of the new intent." ,required=true) CreateIntent body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IntentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IntentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Intent respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createIntent(workspaceId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createIntent");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createIntent");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add entity value synonym", notes = "Add a new synonym to an entity value.", response = Synonym.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Synonyms", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Synonym.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Synonym.class) })
    public Response createSynonym(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "A CreateSynonym object defining the new synonym for the entity value." ,required=true) CreateSynonym body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.SynonymsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.SynonymsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Synonym respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createSynonym(workspaceId,entity,value,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createSynonym");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createSynonym");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add entity value", notes = "Create a new value for an entity.", response = Value.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Values", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Value.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Value.class) })
    public Response createValue(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "A CreateValue object defining the content of the new value for the entity." ,required=true) CreateValue body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ValuesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ValuesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Value respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createValue(workspaceId,entity,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createValue");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createValue");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create workspace", notes = "Create a workspace based on component objects. You must provide workspace components defining the content of the new workspace.", response = Workspace.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Workspaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Successful request.", response = Workspace.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Workspace.class) })
    public Response createWorkspace(@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Valid data defining the content of the new workspace." ) CreateWorkspace body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.WorkspacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.WorkspacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Workspace respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createWorkspace(version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createWorkspace");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createWorkspace");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/counterexamples/{text}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete counterexample", notes = "Delete a counterexample from a workspace. Counterexamples are examples that have been marked as irrelevant input.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Counterexamples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Object.class) })
    public Response deleteCounterexample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The text of a user input counterexample (for example, `What are you wearing?`).",required=true) @PathParam("text") String text,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteCounterexample(workspaceId,text,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteCounterexample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteCounterexample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/dialog_nodes/{dialog_node}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete dialog node", notes = "Delete a dialog node from the workspace.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "DialogNodes", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = Object.class) })
    public Response deleteDialogNode(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The dialog node ID (for example, `get_order`).",required=true) @PathParam("dialog_node") String dialogNode,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DialogNodesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DialogNodesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteDialogNode(workspaceId,dialogNode,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteDialogNode");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteDialogNode");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/entities/{entity}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete entity", notes = "Delete an entity from a workspace.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Entities", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Object.class) })
    public Response deleteEntity(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EntitiesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EntitiesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteEntity(workspaceId,entity,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteEntity");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteEntity");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/intents/{intent}/examples/{text}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete user input example", notes = "Delete a user input example from an intent.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Examples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = Object.class) })
    public Response deleteExample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "The text of the user input example.",required=true) @PathParam("text") String text,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ExamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ExamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteExample(workspaceId,intent,text,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteExample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteExample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/intents/{intent}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete intent", notes = "Delete an intent from a workspace.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Intents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Object.class) })
    public Response deleteIntent(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IntentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IntentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteIntent(workspaceId,intent,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteIntent");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteIntent");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms/{synonym}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete entity value synonym", notes = "Delete a synonym for an entity value.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Synonyms", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Object.class) })
    public Response deleteSynonym(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "The text of the synonym.",required=true) @PathParam("synonym") String synonym,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.SynonymsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.SynonymsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteSynonym(workspaceId,entity,value,synonym,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteSynonym");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteSynonym");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete entity value", notes = "Delete a value for an entity.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Values", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Object.class) })
    public Response deleteValue(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ValuesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ValuesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteValue(workspaceId,entity,value,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteValue");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteValue");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @DELETE
    
    @Path("/workspaces/{workspace_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete workspace", notes = "Delete a workspace from the service instance.", response = Object.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Workspaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Object.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Object.class) })
    public Response deleteWorkspace(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.WorkspacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.WorkspacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Object respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteWorkspace(workspaceId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteWorkspace");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteWorkspace");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/counterexamples/{text}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get counterexample", notes = "Get information about a counterexample. Counterexamples are examples that have been marked as irrelevant input.", response = Counterexample.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Counterexamples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Counterexample.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Counterexample.class) })
    public Response getCounterexample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The text of a user input counterexample (for example, `What are you wearing?`).",required=true) @PathParam("text") String text,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Counterexample respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getCounterexample(workspaceId,text,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getCounterexample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getCounterexample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/dialog_nodes/{dialog_node}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get dialog node", notes = "Get information about a dialog node.", response = DialogNode.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "DialogNodes", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request", response = DialogNode.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = DialogNode.class) })
    public Response getDialogNode(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The dialog node ID (for example, `get_order`).",required=true) @PathParam("dialog_node") String dialogNode,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DialogNodesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DialogNodesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DialogNode respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getDialogNode(workspaceId,dialogNode,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getDialogNode");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getDialogNode");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/entities/{entity}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get entity", notes = "Get information about an entity, optionally including all entity content.", response = EntityExport.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Entities", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = EntityExport.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = EntityExport.class) })
    public Response getEntity(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EntitiesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EntitiesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		EntityExport respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getEntity(workspaceId,entity,version,export);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getEntity");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getEntity");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/intents/{intent}/examples/{text}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get user input example", notes = "Get information about a user input example.", response = Example.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Examples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Example.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Example.class) })
    public Response getExample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "The text of the user input example.",required=true) @PathParam("text") String text,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ExamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ExamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Example respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getExample(workspaceId,intent,text,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getExample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getExample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/intents/{intent}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get intent", notes = "Get information about an intent, optionally including all intent content.", response = IntentExport.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Intents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = IntentExport.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = IntentExport.class) })
    public Response getIntent(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IntentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IntentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		IntentExport respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getIntent(workspaceId,intent,version,export);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getIntent");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getIntent");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms/{synonym}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get entity value synonym", notes = "Get information about a synonym for an entity value.", response = Synonym.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Synonyms", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Synonym.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Synonym.class) })
    public Response getSynonym(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "The text of the synonym.",required=true) @PathParam("synonym") String synonym,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.SynonymsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.SynonymsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Synonym respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getSynonym(workspaceId,entity,value,synonym,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getSynonym");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getSynonym");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get entity value", notes = "Get information about an entity value.", response = ValueExport.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Values", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = ValueExport.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = ValueExport.class) })
    public Response getValue(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ValuesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ValuesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ValueExport respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getValue(workspaceId,entity,value,version,export);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getValue");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getValue");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get information about a workspace", notes = "Get information about a workspace, optionally including all workspace content.", response = WorkspaceExport.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Workspaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = WorkspaceExport.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = WorkspaceExport.class) })
    public Response getWorkspace(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.WorkspacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.WorkspacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		WorkspaceExport respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getWorkspace(workspaceId,version,export);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getWorkspace");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getWorkspace");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/counterexamples")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List counterexamples", notes = "List the counterexamples for a workspace. Counterexamples are examples that have been marked as irrelevant input.", response = CounterexampleCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Counterexamples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = CounterexampleCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = CounterexampleCollection.class) })
    public Response listCounterexamples(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		CounterexampleCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listCounterexamples(workspaceId,version,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listCounterexamples");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listCounterexamples");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/dialog_nodes")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List dialog nodes", notes = "List the dialog nodes in the workspace.", response = DialogNodeCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "DialogNodes", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request", response = DialogNodeCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = DialogNodeCollection.class) })
    public Response listDialogNodes(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DialogNodesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DialogNodesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DialogNodeCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listDialogNodes(workspaceId,version,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listDialogNodes");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listDialogNodes");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/entities")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List entities", notes = "List the entities for a workspace.", response = EntityCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Entities", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = EntityCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = EntityCollection.class) })
    public Response listEntities(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EntitiesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EntitiesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		EntityCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listEntities(workspaceId,version,export,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listEntities");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listEntities");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/intents/{intent}/examples")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List user input examples", notes = "List the user input examples for an intent.", response = ExampleCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Examples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = ExampleCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = ExampleCollection.class) })
    public Response listExamples(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ExamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ExamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ExampleCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listExamples(workspaceId,intent,version,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listExamples");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listExamples");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/intents")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List intents", notes = "List the intents for a workspace.", response = IntentCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Intents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = IntentCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = IntentCollection.class) })
    public Response listIntents(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IntentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IntentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		IntentCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listIntents(workspaceId,version,export,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listIntents");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listIntents");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/logs")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List log events", notes = "", response = LogCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Logs", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = LogCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = LogCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal server error.", response = LogCollection.class) })
    public Response listLogs(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A cacheable parameter that limits the results to those matching the specified filter. For more information, see the [documentation](https://console.bluemix.net/docs/services/conversation/filter-reference.html#filter-query-syntax).") @QueryParam("filter") String filter,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.LogsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.LogsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		LogCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listLogs(workspaceId,version,sort,filter,pageLimit,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listLogs");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listLogs");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List entity value synonyms", notes = "List the synonyms for an entity value.", response = SynonymCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Synonyms", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = SynonymCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = SynonymCollection.class) })
    public Response listSynonyms(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.SynonymsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.SynonymsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		SynonymCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listSynonyms(workspaceId,entity,value,version,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listSynonyms");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listSynonyms");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List entity values", notes = "List the values for an entity.", response = ValueCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Values", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = ValueCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = ValueCollection.class) })
    public Response listValues(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Whether to include all element content in the returned data. If export=`false`, the returned data includes only information about the element itself. If export=`true`, all content, including subelements, is included. The default value is `false`.", defaultValue="false") @DefaultValue("false") @QueryParam("export") Boolean export,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ValuesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ValuesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ValueCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listValues(workspaceId,entity,version,export,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listValues");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listValues");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @GET
    
    @Path("/workspaces")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List workspaces", notes = "List the workspaces associated with a Conversation service instance.", response = WorkspaceCollection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Workspaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = WorkspaceCollection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = WorkspaceCollection.class) })
    public Response listWorkspaces(@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "The number of records to return in each page of results. The default page limit is 100.") @QueryParam("page_limit") Integer pageLimit,@ApiParam(value = "Whether to include information about the number of records returned.", defaultValue="false") @DefaultValue("false") @QueryParam("include_count") Boolean includeCount,@ApiParam(value = "Sorts the response according to the value of the specified property, in ascending or descending order.") @QueryParam("sort") String sort,@ApiParam(value = "A token identifying the last value from the previous page of results.") @QueryParam("cursor") String cursor,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.WorkspacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.WorkspacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		WorkspaceCollection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listWorkspaces(version,pageLimit,includeCount,sort,cursor);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listWorkspaces");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listWorkspaces");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/message")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get a response to a user's input", notes = "", response = MessageResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Message", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = MessageResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = MessageResponse.class) })
    public Response message(@ApiParam(value = "Unique identifier of the workspace.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "The user's input, with optional intents, entities, and other properties from the response." ) MessageRequest body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.MessageClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.MessageClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		MessageResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.message(workspaceId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#message");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#message");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/counterexamples/{text}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update counterexample", notes = "Update the text of a counterexample. Counterexamples are examples that have been marked as irrelevant input.", response = Counterexample.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Counterexamples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Counterexample.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Counterexample.class) })
    public Response updateCounterexample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The text of a user input counterexample (for example, `What are you wearing?`).",required=true) @PathParam("text") String text,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An object defining the new text for the counterexample." ,required=true) UpdateCounterexample body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CounterexamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Counterexample respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateCounterexample(workspaceId,text,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateCounterexample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateCounterexample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/dialog_nodes/{dialog_node}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update dialog node", notes = "Update information for a dialog node.", response = DialogNode.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "DialogNodes", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request", response = DialogNode.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request", response = DialogNode.class) })
    public Response updateDialogNode(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The dialog node ID (for example, `get_order`).",required=true) @PathParam("dialog_node") String dialogNode,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An UpdateDialogNode object defining the new contents of the dialog node." ,required=true) UpdateDialogNode body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DialogNodesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DialogNodesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DialogNode respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateDialogNode(workspaceId,dialogNode,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateDialogNode");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateDialogNode");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/entities/{entity}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update entity", notes = "Update an existing entity with new or modified data.", response = Entity.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Entities", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Entity.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Entity.class) })
    public Response updateEntity(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An UpdateEntity object defining the updated content of the entity." ,required=true) UpdateEntity body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EntitiesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EntitiesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Entity respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateEntity(workspaceId,entity,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateEntity");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateEntity");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/intents/{intent}/examples/{text}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update user input example", notes = "Update the text of a user input example.", response = Example.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Examples", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Example.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Example.class) })
    public Response updateExample(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "The text of the user input example.",required=true) @PathParam("text") String text,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An UpdateExample object defining the new text for the user input example." ,required=true) UpdateExample body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ExamplesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ExamplesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Example respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateExample(workspaceId,intent,text,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateExample");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateExample");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/intents/{intent}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update intent", notes = "Update an existing intent with new or modified data. You must provide data defining the content of the updated intent.", response = Intent.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Intents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Intent.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Intent.class) })
    public Response updateIntent(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The intent name (for example, `pizza_order`).",required=true) @PathParam("intent") String intent,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An UpdateIntent object defining the updated content of the intent." ,required=true) UpdateIntent body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IntentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IntentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Intent respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateIntent(workspaceId,intent,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateIntent");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateIntent");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}/synonyms/{synonym}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update entity value synonym", notes = "Update the information about a synonym for an entity value.", response = Synonym.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Synonyms", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Synonym.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Synonym.class) })
    public Response updateSynonym(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "The text of the synonym.",required=true) @PathParam("synonym") String synonym,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An UpdateSynonym object defining the new information for an entity value synonym." ,required=true) UpdateSynonym body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.SynonymsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.SynonymsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Synonym respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateSynonym(workspaceId,entity,value,synonym,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateSynonym");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateSynonym");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}/entities/{entity}/values/{value}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update entity value", notes = "Update the content of a value for an entity.", response = Value.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Values", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Value.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Value.class) })
    public Response updateValue(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "The name of the entity.",required=true) @PathParam("entity") String entity,@ApiParam(value = "The text of the entity value.",required=true) @PathParam("value") String value,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "An UpdateValue object defining the new content for value for the entity." ,required=true) UpdateValue body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ValuesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ValuesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Value respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateValue(workspaceId,entity,value,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateValue");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateValue");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @POST
    
    @Path("/workspaces/{workspace_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update workspace", notes = "Update an existing workspace with new or modified data. You must provide component objects defining the content of the updated workspace.", response = Workspace.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Workspaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful request.", response = Workspace.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid request.", response = Workspace.class) })
    public Response updateWorkspace(@ApiParam(value = "The workspace ID.",required=true) @PathParam("workspace_id") String workspaceId,@ApiParam(value = "Release date of the API version in YYYY-MM-DD format.",required=true, defaultValue="2017-05-26") @DefaultValue("2017-05-26") @QueryParam("version") String version,@ApiParam(value = "Valid data defining the new workspace content. Any elements included in the new data will completely replace the existing elements, including all subelements. Previously existing subelements are not retained unless they are included in the new data." ) UpdateWorkspace body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.WorkspacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.WorkspacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Workspace respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateWorkspace(workspaceId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateWorkspace");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateWorkspace");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
}
