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
import com.ibm.mfp.adapters.sample.api.NamespacesApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;
import com.ibm.mfp.adapters.sample.StringUtil;
import com.ibm.mfp.adapters.sample.model.*;
import java.lang.*;

import com.ibm.mfp.adapters.sample.model.Action;
import com.ibm.mfp.adapters.sample.model.ActionPut;
import com.ibm.mfp.adapters.sample.model.Activation;
import com.ibm.mfp.adapters.sample.model.ActivationItemId;
import com.ibm.mfp.adapters.sample.model.ActivationLogs;
import com.ibm.mfp.adapters.sample.model.ActivationResult;
import com.ibm.mfp.adapters.sample.model.EntityBrief;
import com.ibm.mfp.adapters.sample.model.ErrorMessage;
import com.ibm.mfp.adapters.sample.model.InlineResponse200;
import com.ibm.mfp.adapters.sample.model.KeyValue;
import com.ibm.mfp.adapters.sample.model.ModelPackage;
import com.ibm.mfp.adapters.sample.model.PackagePut;
import com.ibm.mfp.adapters.sample.model.PayLoad;
import com.ibm.mfp.adapters.sample.model.Rule;
import com.ibm.mfp.adapters.sample.model.RulePut;
import com.ibm.mfp.adapters.sample.model.RuleSet;
import com.ibm.mfp.adapters.sample.model.Trigger;
import com.ibm.mfp.adapters.sample.model.TriggerPut;

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

@Path("/namespaces")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the namespaces API")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-05T11:47:26.811+05:30")
public class NamespacesApi  {
	@Context
        ConfigurationAPI configurationApi;

    @DELETE
    
    @Path("/{namespace}/actions/{actionName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete an action", notes = "Delete an action", response = Action.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActions", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Deleted Action Item", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Action.class) })
    public Response deleteAction(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of action",required=true) @PathParam("actionName") String actionName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Action respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteAction(namespace,actionName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#deleteAction");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#deleteAction");
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
    
    @Path("/{namespace}/packages/{packageName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a package", notes = "Delete a package", response = ModelPackage.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskPackages", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Deleted Package Item", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = ModelPackage.class) })
    public Response deletePackage(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of package",required=true) @PathParam("packageName") String packageName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ModelPackage respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deletePackage(namespace,packageName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#deletePackage");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#deletePackage");
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
    
    @Path("/{namespace}/rules/{ruleName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a rule", notes = "Delete a rule", response = Rule.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskRules", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Deleted Rule Item", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Rule.class) })
    public Response deleteRule(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of rule to delete",required=true) @PathParam("ruleName") String ruleName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Rule respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteRule(namespace,ruleName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#deleteRule");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#deleteRule");
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
    
    @Path("/{namespace}/triggers/{triggerName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a trigger", notes = "Delete a trigger", response = Trigger.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskTriggers", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Deleted Trigger Item", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Trigger.class) })
    public Response deleteTrigger(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of trigger to delete",required=true) @PathParam("triggerName") String triggerName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Trigger respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteTrigger(namespace,triggerName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#deleteTrigger");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#deleteTrigger");
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
    
    @Path("/{namespace}/triggers/{triggerName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Fire a trigger", notes = "Fire a trigger", response = ActivationItemId.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskTriggers", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Activation id", response = ActivationItemId.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = ActivationItemId.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = ActivationItemId.class),
    
    @io.swagger.annotations.ApiResponse(code = 408, message = "Request timed out", response = ActivationItemId.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = ActivationItemId.class) })
    public Response fireTrigger(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of trigger being fired",required=true) @PathParam("triggerName") String triggerName,@ApiParam(value = "The trigger payload" ,required=true) KeyValue payload,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ActivationItemId respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.fireTrigger(namespace,triggerName,payload);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#fireTrigger");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#fireTrigger");
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
    
    @Path("/{namespace}/actions/{actionName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get action information", notes = "Get action information.", response = Action.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActions", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Returned action", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Action.class) })
    public Response getActionByName(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of action to fetch",required=true) @PathParam("actionName") String actionName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Action respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getActionByName(namespace,actionName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getActionByName");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getActionByName");
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
    
    @Path("/{namespace}/activations/{activationid}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get activation information", notes = "Get activation information.", response = Activation.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActivations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Return output", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Activation.class) })
    public Response getActivationById(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of activation to fetch",required=true) @PathParam("activationid") String activationid,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Activation respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getActivationById(namespace,activationid);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getActivationById");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getActivationById");
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
    
    @Path("/{namespace}/activations")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get activation ids", notes = "Get activation ids.", response = Activation.class, responseContainer = "List"
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActivations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Activations response", response = Activation.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Activation.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Activation.class, responseContainer = "List") })
    public Response getActivations(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of item") @QueryParam("name") String name,@ApiParam(value = "Number of entities to include in the result.") @QueryParam("limit") Integer limit,@ApiParam(value = "Number of entities to skip in the result.") @QueryParam("skip") Integer skip,@ApiParam(value = "Only include entities later than this timestamp (measured in milliseconds since Thu, 01 Jan 1970)") @QueryParam("since") Integer since,@ApiParam(value = "Only include entities earlier than this timestamp (measured in milliseconds since Thu, 01 Jan 1970)") @QueryParam("upto") Integer upto,@ApiParam(value = "Whether to include full entity description.") @QueryParam("docs") Boolean docs,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		java.util.List<Activation> respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getActivations(namespace,name,limit,skip,since,upto,docs);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getActivations");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getActivations");
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
    
    @Path("/{namespace}/packages")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all packages", notes = "Get all packages", response = EntityBrief.class, responseContainer = "List"
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskPackages", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Packages response", response = EntityBrief.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = EntityBrief.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = EntityBrief.class, responseContainer = "List") })
    public Response getAlPackages(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Include publicly shared entitles in the result.") @QueryParam("public") Boolean _public,@ApiParam(value = "Number of entities to include in the result.") @QueryParam("limit") Integer limit,@ApiParam(value = "Number of entities to skip in the result.") @QueryParam("skip") Integer skip,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		java.util.List<EntityBrief> respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getAlPackages(namespace,_public,limit,skip);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getAlPackages");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getAlPackages");
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
    
    @Path("/{namespace}/actions")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all actions", notes = "Get all actions", response = Action.class, responseContainer = "List"
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActions", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Actions response", response = Action.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Action.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Action.class, responseContainer = "List") })
    public Response getAllActions(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Number of entities to include in the result.") @QueryParam("limit") Integer limit,@ApiParam(value = "Number of entities to skip in the result.") @QueryParam("skip") Integer skip,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		java.util.List<Action> respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getAllActions(namespace,limit,skip);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getAllActions");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getAllActions");
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
    
    @Path("/{namespace}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all entities in a namespace", notes = "Get all entities in a namespace", response = InlineResponse200.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskNamespaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "All entities", response = InlineResponse200.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = InlineResponse200.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = InlineResponse200.class) })
    public Response getAllEntitiesInNamespace(@ApiParam(value = "The namespace",required=true) @PathParam("namespace") String namespace,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskNamespacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskNamespacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		InlineResponse200 respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getAllEntitiesInNamespace(namespace);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getAllEntitiesInNamespace");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getAllEntitiesInNamespace");
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
    
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all namespaces for authenticated user", notes = "Get all namespaces for authenticated user", response = String.class, responseContainer = "List"
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskNamespaces", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Array of namespaces", response = String.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = String.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = String.class, responseContainer = "List") })
    public Response getAllNamespaces(@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskNamespacesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskNamespacesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		java.util.List<String> respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getAllNamespaces();
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getAllNamespaces");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getAllNamespaces");
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
    
    @Path("/{namespace}/rules")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all rules", notes = "Get all rules", response = EntityBrief.class, responseContainer = "List"
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskRules", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Rules response", response = EntityBrief.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = EntityBrief.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = EntityBrief.class, responseContainer = "List") })
    public Response getAllRules(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Number of entities to include in the result.") @QueryParam("limit") Integer limit,@ApiParam(value = "Number of entities to skip in the result.") @QueryParam("skip") Integer skip,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		java.util.List<EntityBrief> respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getAllRules(namespace,limit,skip);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getAllRules");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getAllRules");
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
    
    @Path("/{namespace}/triggers")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get all triggers", notes = "Get all triggers", response = EntityBrief.class, responseContainer = "List"
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskTriggers", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Triggers response", response = EntityBrief.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = EntityBrief.class, responseContainer = "List"),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = EntityBrief.class, responseContainer = "List") })
    public Response getAllTriggers(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Number of entities to include in the result.") @QueryParam("limit") Integer limit,@ApiParam(value = "Number of entities to skip in the result.") @QueryParam("skip") Integer skip,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		java.util.List<EntityBrief> respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getAllTriggers(namespace,limit,skip);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getAllTriggers");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getAllTriggers");
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
    
    @Path("/{namespace}/packages/{packageName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get package information", notes = "Get package information.", response = ModelPackage.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskPackages", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Returned package", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = ModelPackage.class) })
    public Response getPackageByName(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of package to fetch",required=true) @PathParam("packageName") String packageName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ModelPackage respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getPackageByName(namespace,packageName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getPackageByName");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getPackageByName");
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
    
    @Path("/{namespace}/rules/{ruleName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get rule information", notes = "Get rule information", response = Rule.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskRules", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Returned rule", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Rule.class) })
    public Response getRuleByName(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of rule to fetch",required=true) @PathParam("ruleName") String ruleName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Rule respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getRuleByName(namespace,ruleName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getRuleByName");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getRuleByName");
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
    
    @Path("/{namespace}/triggers/{triggerName}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get trigger information", notes = "Get trigger information", response = Trigger.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskTriggers", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Returned trigger", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Trigger.class) })
    public Response getTriggerByName(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of trigger to fetch",required=true) @PathParam("triggerName") String triggerName,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Trigger respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getTriggerByName(namespace,triggerName);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#getTriggerByName");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#getTriggerByName");
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
    
    @Path("/{namespace}/actions/{actionName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Invoke an action", notes = "Invoke an action", response = Activation.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActions", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful activation", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 202, message = "Accepted activation request", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 408, message = "Request timed out", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Activation.class),
    
    @io.swagger.annotations.ApiResponse(code = 502, message = "Activation produced an application error", response = Activation.class) })
    public Response invokeAction(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of action",required=true) @PathParam("actionName") String actionName,@ApiParam(value = "The parameters for the action being invoked. eg: { \"payload\": { \"name\" : \"aaa\",\"id\" : \"1111\" }} )" ,required=true) PayLoad payload,@ApiParam(value = "Blocking or non-blocking invocation. Default is non-blocking.", allowableValues="true, false"
) @QueryParam("blocking") String blocking,@ApiParam(value = "Wait no more than specified duration in milliseconds for a blocking response. Default value and max allowed timeout are 60000.") @QueryParam("timeout") Integer timeout,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Activation respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.invokeAction(namespace,actionName,payload,blocking,timeout);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#invokeAction");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#invokeAction");
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
    
    @Path("/{namespace}/activations/{activationid}/logs")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the logs for an activation", notes = "Get activation logs information.", response = ActivationLogs.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActivations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Return output", response = ActivationLogs.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = ActivationLogs.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = ActivationLogs.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = ActivationLogs.class) })
    public Response namespacesNamespaceActivationsActivationidLogsGet(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of activation to fetch",required=true) @PathParam("activationid") String activationid,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ActivationLogs respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.namespacesNamespaceActivationsActivationidLogsGet(namespace,activationid);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#namespacesNamespaceActivationsActivationidLogsGet");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#namespacesNamespaceActivationsActivationidLogsGet");
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
    
    @Path("/{namespace}/activations/{activationid}/result")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the result of an activation", notes = "Get activation result.", response = ActivationResult.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActivations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Return output", response = ActivationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = ActivationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Item not found", response = ActivationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = ActivationResult.class) })
    public Response namespacesNamespaceActivationsActivationidResultGet(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of activation to fetch",required=true) @PathParam("activationid") String activationid,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActivationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ActivationResult respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.namespacesNamespaceActivationsActivationidResultGet(namespace,activationid);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#namespacesNamespaceActivationsActivationidResultGet");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#namespacesNamespaceActivationsActivationidResultGet");
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
    
    @Path("/{namespace}/rules/{ruleName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Enable or disable a rule", notes = "Enable or disable a rule", response = void.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskRules", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Rule has been enabled or disabled", response = void.class),
    
    @io.swagger.annotations.ApiResponse(code = 202, message = "Rule has been enabled or disabled", response = void.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = void.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = void.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = void.class) })
    public Response setState(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of rule to update",required=true) @PathParam("ruleName") String ruleName,@ApiParam(value = "Set state to active or inactive" ,required=true) RuleSet state,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	try {
           		 	System.out.println("Calling Node server.");
         			apiInstance.setState(namespace,ruleName,state);
        		}
         	catch (com.ibm.mfp.adapters.sample.ApiException e) {
            		System.err.println("Exception when calling NamespacesApi#setState");
           			 e.printStackTrace();
            		return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }
          	catch (java.lang.Exception e) {
           	 		System.err.println("Exception when calling NamespacesApi#setState");
            		e.printStackTrace();
	    			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        	}
         return Response.ok().entity("").build();
         	
    }
    @PUT
    
    @Path("/{namespace}/actions/{actionName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create or update an action", notes = "Create or update an action", response = Action.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskActions", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 409, message = "Conflicting item already exists", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 413, message = "Request entity too large", response = Action.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Action.class) })
    public Response updateAction(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of action",required=true) @PathParam("actionName") String actionName,@ApiParam(value = "The action being updated" ,required=true) ActionPut action,@ApiParam(value = "Overwrite item if it exists. Default is false.", allowableValues="true, false"
) @QueryParam("overwrite") String overwrite,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskActionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Action respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateAction(namespace,actionName,action,overwrite);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#updateAction");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#updateAction");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @PUT
    
    @Path("/{namespace}/packages/{packageName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create or update a package", notes = "Create or update a package", response = ModelPackage.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskPackages", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 409, message = "Conflicting item already exists", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 413, message = "Request entity too large", response = ModelPackage.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = ModelPackage.class) })
    public Response updatePackage(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of package",required=true) @PathParam("packageName") String packageName,@ApiParam(value = "The package being updated" ,required=true) PackagePut _package,@ApiParam(value = "Overwrite item if it exists. Default is false.", allowableValues="true, false"
) @QueryParam("overwrite") String overwrite,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskPackagesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ModelPackage respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updatePackage(namespace,packageName,_package,overwrite);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#updatePackage");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#updatePackage");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @PUT
    
    @Path("/{namespace}/rules/{ruleName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a rule", notes = "Update a rule", response = Rule.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskRules", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 409, message = "Conflicting item already exists", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 413, message = "Request entity too large", response = Rule.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Rule.class) })
    public Response updateRule(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of rule to update",required=true) @PathParam("ruleName") String ruleName,@ApiParam(value = "The rule being updated" ,required=true) RulePut rule,@ApiParam(value = "Overwrite item if it exists. Default is false.", allowableValues="true, false"
) @QueryParam("overwrite") String overwrite,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskRulesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Rule respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateRule(namespace,ruleName,rule,overwrite);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#updateRule");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#updateRule");
            	e.printStackTrace();
            	return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        	System.out.println("Return from Node server: "+ respResult);
        	if (respResult != null){
            retval = respResult.toString();
        	}
        	return Response.ok().entity(respResult).build();
    }
    @PUT
    
    @Path("/{namespace}/triggers/{triggerName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a trigger", notes = "Update a trigger", response = Trigger.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "OpenWhiskTriggers", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized request", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 409, message = "Conflicting item already exists", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 413, message = "Request entity too large", response = Trigger.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Server error", response = Trigger.class) })
    public Response updateTrigger(@ApiParam(value = "The entity namespace",required=true) @PathParam("namespace") String namespace,@ApiParam(value = "Name of trigger to update",required=true) @PathParam("triggerName") String triggerName,@ApiParam(value = "The trigger being updated" ,required=true) TriggerPut trigger,@ApiParam(value = "Overwrite item if it exists. Default is false.", allowableValues="true, false"
) @QueryParam("overwrite") String overwrite,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.OpenWhiskTriggersClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Trigger respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateTrigger(namespace,triggerName,trigger,overwrite);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling NamespacesApi#updateTrigger");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling NamespacesApi#updateTrigger");
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
