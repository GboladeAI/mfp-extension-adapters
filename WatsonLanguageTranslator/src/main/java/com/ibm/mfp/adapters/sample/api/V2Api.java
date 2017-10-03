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
import com.ibm.mfp.adapters.sample.api.V2ApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;
import com.ibm.mfp.adapters.sample.StringUtil;
import com.ibm.mfp.adapters.sample.model.*;
import java.lang.*;

import com.ibm.mfp.adapters.sample.model.DeleteModelResult;
import com.ibm.mfp.adapters.sample.model.ErrorResponse;
import java.io.File;
import com.ibm.mfp.adapters.sample.model.IdentifiableLanguages;
import com.ibm.mfp.adapters.sample.model.IdentifiedLanguages;
import com.ibm.mfp.adapters.sample.model.TranslateRequest;
import com.ibm.mfp.adapters.sample.model.TranslationModel;
import com.ibm.mfp.adapters.sample.model.TranslationModels;
import com.ibm.mfp.adapters.sample.model.TranslationResult;

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

@Path("/v2")


@io.swagger.annotations.Api(description = "the v2 API")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-10-03T18:29:51.729+05:30")
public class V2Api  {
	@Context
        ConfigurationAPI configurationApi;

    @POST
    
    @Path("/models")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Uploads a TMX glossary file on top of a domain to customize a translation model", notes = "", response = TranslationModel.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Models", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success: Training is successfully started", response = TranslationModel.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request: The base_model_id is not specified OR you've hit the maximum limit of customizations for this user", response = TranslationModel.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Not found: The base_model_id value is invalid", response = TranslationModel.class),
    
    @io.swagger.annotations.ApiResponse(code = 413, message = "File size exceeded: Payload body exceeded the limit", response = TranslationModel.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = TranslationModel.class) })
    public Response createModel(@ApiParam(value = "Specifies the domain model that is used as the base for the training. To see current supported domain models, use the GET /v2/models parameter.",required=true) @QueryParam("base_model_id") String baseModelId,@ApiParam(value = "The model name. Valid characters are letters, numbers, -, and _. No spaces.") @QueryParam("name") String name,
            @FormDataParam("forced_glossary") File forcedGlossary
            ,
            @FormDataParam("parallel_corpus") File parallelCorpus
            ,
            @FormDataParam("monolingual_corpus") File monolingualCorpus
            ,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ModelsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ModelsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		TranslationModel respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createModel(baseModelId,name,forcedGlossary,parallelCorpus,monolingualCorpus);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#createModel");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#createModel");
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
    
    @Path("/models/{model_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a custom translation model", notes = "", response = DeleteModelResult.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Models", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success: Model deleted", response = DeleteModelResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Unauthorized: This model was created by IBM", response = DeleteModelResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Not found: The specified model_id was not found", response = DeleteModelResult.class) })
    public Response deleteModel(@ApiParam(value = "The model identifier.",required=true) @PathParam("model_id") String modelId,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ModelsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ModelsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DeleteModelResult respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteModel(modelId);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#deleteModel");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#deleteModel");
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
    
    @Path("/models/{model_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get information about the given translation model, including training status.", notes = "", response = TranslationModel.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Models", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Status : OK", response = TranslationModel.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = TranslationModel.class) })
    public Response getModel(@ApiParam(value = "Model ID to use",required=true) @PathParam("model_id") String modelId,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ModelsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ModelsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		TranslationModel respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getModel(modelId);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#getModel");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#getModel");
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
    
    @Path("/identify")
    @Consumes({ "text/plain" })
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Identifies the language of the input text.", notes = "", response = IdentifiedLanguages.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Identify", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = IdentifiedLanguages.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request: missing required input text in request body", response = IdentifiedLanguages.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = IdentifiedLanguages.class) })
    public Response identify(@ApiParam(value = "Input text in UTF-8 format." ,required=true) String text,@ApiParam(value = "Describes the format of the return values. By default, the return type is `text/plain` and the return value is the two-letter language code for the identified language, for example, `en` for English or `es` for Spanish. To retrieve a JSON object that contains a ranking of identified languages with confidence scores, set the accept header parameter to `application/json`." , allowableValues="application/json, text/plain"
, defaultValue="text/plain")@HeaderParam("accept") String accept,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IdentifyClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IdentifyClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		IdentifiedLanguages respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.identify(text,accept);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#identify");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#identify");
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
    
    @Path("/identify")
    
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Identifies the language of the input text.", notes = "", response = IdentifiedLanguages.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Identify", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = IdentifiedLanguages.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request: missing required text parameter", response = IdentifiedLanguages.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = IdentifiedLanguages.class) })
    public Response identifyGet(@ApiParam(value = "Input text in UTF-8 format.",required=true) @QueryParam("text") String text,@ApiParam(value = "Describes the format of the return values. By default, the return type is `text/plain` and the return value is the two-letter language code for the identified language, for example, `en` for English or `es` for Spanish. To retrieve a JSON object containing a ranking of identified languages with confidence scores, set the accept header parameter to `application/json`." , allowableValues="application/json, text/plain"
, defaultValue="text/plain")@HeaderParam("accept") String accept,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IdentifyClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IdentifyClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		IdentifiedLanguages respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.identifyGet(text,accept);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#identifyGet");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#identifyGet");
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
    
    @Path("/identifiable_languages")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Lists all languages that can be identified by the API", notes = "Lists all languages that the service can identify. Returns the two-letter code (for example, `en` for English or `es` for Spanish) and name of each language.", response = IdentifiableLanguages.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Identify", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = IdentifiableLanguages.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = IdentifiableLanguages.class) })
    public Response listIdentifiableLanguages(@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.IdentifyClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.IdentifyClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		IdentifiableLanguages respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listIdentifiableLanguages();
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#listIdentifiableLanguages");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#listIdentifiableLanguages");
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
    
    @Path("/models")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Lists available standard and custom models by source or target language", notes = "", response = TranslationModels.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Models", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = TranslationModels.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = TranslationModels.class) })
    public Response listModels(@ApiParam(value = "Filter models by source language.") @QueryParam("source") String source,@ApiParam(value = "Filter models by target language.") @QueryParam("target") String target,@ApiParam(value = "Valid values are leaving it unset, `true`, and `false`. When `true`, it filters models to return the default model or models. When `false`, it returns the non-default model or models. If not set, it returns all models, default and non-default.") @QueryParam("default") Boolean _default,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ModelsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ModelsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		TranslationModels respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listModels(source,target,_default);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#listModels");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#listModels");
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
    
    @Path("/translate")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Translates the input text from the source language to the target language", notes = "", response = TranslationResult.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Translate", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = TranslationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request: missing required parameter(s)", response = TranslationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Model Not Found: the specified model_id does not exist or specified source - target language pair is not supported", response = TranslationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = TranslationResult.class) })
    public Response translate(@ApiParam(value = "The translate request containing the text, with optional source, target, and model_id." ,required=true) TranslateRequest body,@ApiParam(value = "Describes the format of the return values." , allowableValues="application/json, text/plain"
, defaultValue="text/plain")@HeaderParam("accept") String accept,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.TranslateClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.TranslateClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		TranslationResult respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.translate(body,accept);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#translate");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#translate");
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
    
    @Path("/translate")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Translates the input text from the source language to the target language", notes = "", response = TranslationResult.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Translate", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = TranslationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request: missing required parameter(s)", response = TranslationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Model Not Found: the specified model_id does not exist or specified source - target language pair is not supported", response = TranslationResult.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = TranslationResult.class) })
    public Response translateGet(@ApiParam(value = "Input text in UTF-8 encoding. Multiple text query parameters indicate multiple input paragraphs, and a single string is valid input.",required=true) @QueryParam("text") String text,@ApiParam(value = "The unique model_id of the translation model that is used to translate text. The model_id inherently specifies source language, target language, and domain. If the model_id is specified, there is no need for the source and target parameters, and the values are ignored.") @QueryParam("model_id") String modelId,@ApiParam(value = "Used in combination with target as an alternative way to select the model for translation. When target and source are set, and model_id is not set, the system chooses a default model with the right language pair to translate (usually the model based on the news domain).") @QueryParam("source") String source,@ApiParam(value = "Used in combination with source as an alternative way to select which model is used for translation. When target and source are set, and model_id is not set, the system chooses a default model with the right language pair to translate (usually the model based on the news domain).") @QueryParam("target") String target,@ApiParam(value = "Describes the format of the return values. Valid values are â€œtext/plainâ€ (default), or â€œapplication/jsonâ€." , allowableValues="application/json, text/plain"
, defaultValue="text/plain")@HeaderParam("accept") String accept,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.TranslateClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.TranslateClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		TranslationResult respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.translateGet(text,modelId,source,target,accept);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V2Api#translateGet");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V2Api#translateGet");
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
