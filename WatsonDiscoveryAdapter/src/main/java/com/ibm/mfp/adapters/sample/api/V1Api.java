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

import com.ibm.mfp.adapters.sample.model.Collection;
import com.ibm.mfp.adapters.sample.model.CreateCollectionRequest;
import com.ibm.mfp.adapters.sample.model.CreateEnvironmentRequest;
import com.ibm.mfp.adapters.sample.model.DeleteCollectionResponse;
import com.ibm.mfp.adapters.sample.model.DeleteConfigurationResponse;
import com.ibm.mfp.adapters.sample.model.DeleteDocumentResponse;
import com.ibm.mfp.adapters.sample.model.DeleteEnvironmentResponse;
import com.ibm.mfp.adapters.sample.model.DocumentAccepted;
import com.ibm.mfp.adapters.sample.model.DocumentStatus;
import com.ibm.mfp.adapters.sample.model.Environment;
import com.ibm.mfp.adapters.sample.model.ErrorResponse;
import java.io.File;
import com.ibm.mfp.adapters.sample.model.ListCollectionFieldsResponse;
import com.ibm.mfp.adapters.sample.model.ListCollectionsResponse;
import com.ibm.mfp.adapters.sample.model.ListConfigurationsResponse;
import com.ibm.mfp.adapters.sample.model.ListEnvironmentsResponse;
import com.ibm.mfp.adapters.sample.model.ModelConfiguration;
import com.ibm.mfp.adapters.sample.model.NoticeQueryResponse;
import com.ibm.mfp.adapters.sample.model.QueryResponse;
import com.ibm.mfp.adapters.sample.model.TestDocument;
import com.ibm.mfp.adapters.sample.model.UpdateCollectionRequest;
import com.ibm.mfp.adapters.sample.model.UpdateEnvironmentRequest;

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
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T17:22:26.527+05:30")
public class V1Api  {
	@Context
        ConfigurationAPI configurationApi;

    @POST
    
    @Path("/environments/{environment_id}/collections/{collection_id}/documents")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add a document", notes = "Add a document to a collection with optional metadata and optional configuration.   Set the `Content-Type` header on the request to indicate the media type of the document. If the `Content-Type` header is missing or is one of the generic media types (for example,  `application/octet-stream`), then the service attempts to automatically detect the document's media type.       * The configuration to use to process the document can be provided by using the `configuration_id` query parameter.       * The `version` query parameter is still required.    * Returns immediately after the system has accepted the document for processing.    * The user must provide document content, metadata, or both. If the request is missing both document content and metadata, it is  rejected.       * The user can set the `Content-Type` parameter on the `file` part to indicate the media type of the document. If the `Content-Type` parameter is missing or is one of the generic media types (for example, `application/octet-stream`), then the service attempts to automatically detect the document's media type.", response = DocumentAccepted.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Documents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 202, message = "The document has been accepted and will be processed.", response = DocumentAccepted.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request if:   * The request is incorrectly formatted   * The `configuration_id` parameter refers to a non-existent configuration.   * The default `configuration_id` of the collection refers to a non-existent configuration and no override has been provided. The error message contains details about what caused the request to be rejected.", response = DocumentAccepted.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to add a document to a collection in a read-only environment.", response = DocumentAccepted.class) })
    public Response addDocument(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.") @QueryParam("configuration_id") String configurationId,
            @FormDataParam("file") File file
            ,@ApiParam(value = "If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   \"Creator\": \"Johnny Appleseed\",   \"Subject\": \"Apples\" } ```")@FormDataParam("metadata")  String metadata,@ApiParam(value = "The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.")@FormDataParam("configuration")  String _configuration,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DocumentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DocumentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DocumentAccepted respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.addDocument(environmentId,collectionId,version,configurationId,file,metadata,_configuration);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#addDocument");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#addDocument");
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
    
    @Path("/environments/{environment_id}/collections")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Create a collection", notes = "", response = Collection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Collections", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Collection successfuly created", response = Collection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request if the collection body does not match the expected format or if the `configuration_id` references a configuration that does not exist. The error string will describe why the request was rejected.", response = Collection.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to add a collection to a read-only environment.", response = Collection.class) })
    public Response createCollection(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Input a JSON object that allows you to add a collection." ) CreateCollectionRequest body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CollectionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CollectionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Collection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createCollection(environmentId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createCollection");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createCollection");
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
    
    @Path("/environments/{environment_id}/configurations")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add configuration", notes = "Creates a new configuration.  If the input configuration contains the `configuration_id`, `created`, or `updated` properties, then they are ignored and overridden by the system, and an error is not returned so that the overridden fields do not need to be removed when copying a configuration.  The configuration can contain unrecognized JSON fields. Any such fields are ignored and do not generate an error. This makes it easier to use newer configuration files with older versions of the API and the service. It also makes it possible for the tooling to add additional metadata and information to the configuration.", response = ModelConfiguration.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Configurations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Configuration successfuly created", response = ModelConfiguration.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ModelConfiguration.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to add a configuration to a read-only environment.", response = ModelConfiguration.class) })
    public Response createConfiguration(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Input a JSON object that enables you to customize how your content is ingested and what enrichments are added to your data.   `name` is required and must be unique within the current `environment`. All other properties are optional.  If the input configuration contains the `configuration_id`, `created`, or `updated` properties, then they will be ignored and overridden by the system (an error is not returned so that the overridden fields do not need to be removed when copying a configuration).   The configuration can contain unrecognized JSON fields. Any such fields will be ignored and will not generate an error. This makes it easier to use newer configuration files with older versions of the API and the service. It also makes it possible for the tooling to add additional metadata and information to the configuration." ,required=true) ModelConfiguration _configuration,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ModelConfiguration respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createConfiguration(environmentId,version,_configuration);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createConfiguration");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createConfiguration");
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
    
    @Path("/environments")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add an environment", notes = "Creates a new environment.  You can create only one environment per service instance. An attempt to create another environment will result in an error.  The size of the new environment can be controlled by specifying the `size` parameter. Use the table below to map size values to the size of the environment which is created:  | Size | Disk (GB)  | RAM (GB) | Included Standard Enrichments | Notes | | ---:  | -----------: | -----------: | --------------------------------------------: | -------- | | 0  | 2              | 1              | n/a (effectively unlimited)   | Free Plan only, no HA (single node in elastic.co)| | 1     | 48             | 2              | 4,000    | | | 2     | 192            | 8              | 16,000   | | | 3     | 384            | 16             | 32,000   | |  **Note:** you cannot set the size property when using the free plan.", response = Environment.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Environments", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Environment successfuly added", response = Environment.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request.", response = Environment.class) })
    public Response createEnvironment(@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "A JSON object where you define an environment name, description, and size." ,required=true) CreateEnvironmentRequest body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Environment respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.createEnvironment(version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#createEnvironment");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#createEnvironment");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a collection", notes = "", response = DeleteCollectionResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Collections", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Collection successfully deleted", response = DeleteCollectionResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request.  A bad request is returned any time there is a problem with the request itself.  Example error messages:  * `Could not find listed collection` - if the ID is incorrectly formatted.", response = DeleteCollectionResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to delete a collection in a read-only environment.", response = DeleteCollectionResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Returned any time the collection is not found (even immediately after the collection was successfully deleted).  Example error message:  `A collection with ID '2cd8bc72-d737-46e3-b26b-05a585111111' was not found.`", response = DeleteCollectionResponse.class) })
    public Response deleteCollection(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CollectionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CollectionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DeleteCollectionResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteCollection(environmentId,collectionId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteCollection");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteCollection");
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
    
    @Path("/environments/{environment_id}/configurations/{configuration_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a configuration", notes = "The deletion is performed unconditionally. A configuration deletion request succeeds even if the configuration is referenced by a collection or document ingestion. However, documents that have already been submitted for processing continue to use the deleted configuration. Documents are always processed with a snapshot of the configuration as it existed at the time the document was submitted.", response = DeleteConfigurationResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Configurations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Configuration successfully deleted. The response contains a warning if the configuration was referenced by at least one collection.", response = DeleteConfigurationResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request.  A bad request is returned any time there is a problem with the request itself.  Example error messages:  * `Invalid Configuration ID` - if the configuration ID is not correctly formatted. * `Invalid configurationId: 2c3a981b-dade-488c-b8c6-01ae8d111111` - if the configuration is not found.", response = DeleteConfigurationResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to delete a read-only configuration, or if you attempt to delete a configuration from a read-only environment.", response = DeleteConfigurationResponse.class) })
    public Response deleteConfiguration(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your configuration",required=true) @PathParam("configuration_id") String configurationId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DeleteConfigurationResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteConfiguration(environmentId,configurationId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteConfiguration");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteConfiguration");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}/documents/{document_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Delete a document", notes = "If the given document id is invalid, or if the document is not found, then the a success response is returned (HTTP status code `200`) with the status set to 'deleted'.", response = DeleteDocumentResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Documents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "the document was successfuly deleted.", response = DeleteDocumentResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request.  A bad request is returned any time there is a problem with the request itself.", response = DeleteDocumentResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to delete a document in a collection in a read-only environment.", response = DeleteDocumentResponse.class) })
    public Response deleteDocument(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "the ID of your document",required=true) @PathParam("document_id") String documentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DocumentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DocumentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DeleteDocumentResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteDocument(environmentId,collectionId,documentId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteDocument");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteDocument");
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
    
    @Path("/environments/{environment_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete environment", notes = "", response = DeleteEnvironmentResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Environments", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Environment successfully deleted", response = DeleteEnvironmentResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request. Example error messages:  * `Invalid environment id. Please check if the format is correct.`", response = DeleteEnvironmentResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to delete a read-only environment.", response = DeleteEnvironmentResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "Returned any time the environment is not found (even immediately after the environment was successfully deleted).  Example error message:  `An environment with ID '2cd8bc72-d737-46e3-b26b-05a585111111' was not found.`", response = DeleteEnvironmentResponse.class) })
    public Response deleteEnvironment(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DeleteEnvironmentResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.deleteEnvironment(environmentId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#deleteEnvironment");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#deleteEnvironment");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get collection details", notes = "", response = Collection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Collections", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Collection fetched", response = Collection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Collection.class) })
    public Response getCollection(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CollectionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CollectionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Collection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getCollection(environmentId,collectionId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getCollection");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getCollection");
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
    
    @Path("/environments/{environment_id}/configurations/{configuration_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get configuration details", notes = "", response = ModelConfiguration.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Configurations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Configuration successfully fetched", response = ModelConfiguration.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ModelConfiguration.class) })
    public Response getConfiguration(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your configuration",required=true) @PathParam("configuration_id") String configurationId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ModelConfiguration respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getConfiguration(environmentId,configurationId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getConfiguration");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getConfiguration");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}/documents/{document_id}")
    
    
    @io.swagger.annotations.ApiOperation(value = "Get document details", notes = "Fetch status details about a submitted document. **Note:** this operation does not return the document itself. Instead, it returns only the document's processing status and any notices (warnings or errors) that were generated when the document was ingested. Use the query API to retrieve the actual document content.", response = DocumentStatus.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Documents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully fetched document details.", response = DocumentStatus.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = DocumentStatus.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to get the status of a document in a collection in a read-only environment.", response = DocumentStatus.class) })
    public Response getDocument(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "the ID of your document",required=true) @PathParam("document_id") String documentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DocumentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DocumentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DocumentStatus respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getDocument(environmentId,collectionId,documentId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getDocument");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getDocument");
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
    
    @Path("/environments/{environment_id}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get environment info", notes = "", response = Environment.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Environments", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Environment fetched", response = Environment.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = Environment.class) })
    public Response getEnvironment(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Environment respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getEnvironment(environmentId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#getEnvironment");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#getEnvironment");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}/fields")
    
    
    @io.swagger.annotations.ApiOperation(value = "List unique fields", notes = "Gets a list of the the unique fields (and their types) stored in the index.", response = ListCollectionFieldsResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Collections", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "The list of fetched fields.  The fields are returned using a fully-qualified name format, however, the format differs slightly from that used by the query operations. Specifically:      * fields which contain nested JSON objects are assigned a type of \"nested\".      * fields which belong to a nested object are prefixed with `.properties` (e.g., `warnings.properties.severity` means that the `warnings` object has a property called `severity`).      * fields returned from the News collection are prefixed with `v[N]-fullnews-t3-[YEAR].mappings` (e.g., `v5-fullnews-t3-2016.mappings.text.properties.author`).", response = ListCollectionFieldsResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ListCollectionFieldsResponse.class) })
    public Response listCollectionFields(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CollectionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CollectionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ListCollectionFieldsResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listCollectionFields(environmentId,collectionId,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listCollectionFields");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listCollectionFields");
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
    
    @Path("/environments/{environment_id}/collections")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List collections", notes = "Lists existing collections for the service instance.", response = ListCollectionsResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Collections", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = ListCollectionsResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ListCollectionsResponse.class) })
    public Response listCollections(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Find collections with the given name.") @QueryParam("name") String name,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CollectionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CollectionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ListCollectionsResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listCollections(environmentId,version,name);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listCollections");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listCollections");
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
    
    @Path("/environments/{environment_id}/configurations")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List configurations", notes = "Lists existing configurations for the service instance.", response = ListConfigurationsResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Configurations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = ListConfigurationsResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ListConfigurationsResponse.class) })
    public Response listConfigurations(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Find configurations with the given name.") @QueryParam("name") String name,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ListConfigurationsResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listConfigurations(environmentId,version,name);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listConfigurations");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listConfigurations");
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
    
    @Path("/environments")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "List environments", notes = "List existing environments for the service instance.", response = ListEnvironmentsResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Environments", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Successful response", response = ListEnvironmentsResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ListEnvironmentsResponse.class) })
    public Response listEnvironments(@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Show only the environment with the given name.") @QueryParam("name") String name,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ListEnvironmentsResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.listEnvironments(version,name);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#listEnvironments");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#listEnvironments");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}/query")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Query documents", notes = "See the [Discovery service documentation](https://www.ibm.com/watson/developercloud/doc/discovery/using.html) for more details.", response = QueryResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Queries", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Query executed successfully.", response = QueryResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = QueryResponse.class) })
    public Response query(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "A cacheable query that limits the documents returned to exclude any documents that don't mention the query content. Filter searches are better for metadata type searches and when you are trying to get a sense of concepts in the data set.") @QueryParam("filter") String filter,@ApiParam(value = "A query search returns all documents in your data set with full enrichments and full text, but with the most relevant documents listed first. Use a query search when you want to find the most relevant search results. You cannot use `natural_language_query` and `query` at the same time.") @QueryParam("query") String query,@ApiParam(value = "A natural language query that returns relevant documents by utilizing training data and natural language understanding. You cannot use `natural_language_query` and `query` at the same time.") @QueryParam("natural_language_query") String naturalLanguageQuery,@ApiParam(value = "A passages query that returns the most relevant passages from the document.") @QueryParam("passages") Boolean passages,@ApiParam(value = "An aggregation search uses combinations of filters and query search to return an exact answer. Aggregations are useful for building applications, because you can use them to build lists, tables, and time series. For a full list of possible aggregrations, see the Query reference.") @QueryParam("aggregation") String aggregation,@ApiParam(value = "Number of documents to return", defaultValue="10") @DefaultValue("10") @QueryParam("count") Integer count,@ApiParam(value = "A comma separated list of the portion of the document hierarchy to return.") @QueryParam("return") List<String> _return,@ApiParam(value = "The number of query results to skip at the beginning. For example, if the total number of results that are returned is 10, and the offset is 8, it returns the last two results.") @QueryParam("offset") Integer offset,@ApiParam(value = "A comma separated list of fields in the document to sort on. You can optionally specify a sort direction by prefixing the field with `-` for descending or `+` for ascending. Ascending is the default sort direction if no prefix is specified.") @QueryParam("sort") String sort,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.QueriesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.QueriesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		QueryResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.query(environmentId,collectionId,version,filter,query,naturalLanguageQuery,passages,aggregation,count,_return,offset,sort);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#query");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#query");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}/notices")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Queries for notices (errors or warnings) that may have been generated by the system. Currently, notices are only generated when ingesting documents. See the [Discovery service documentation](https://www.ibm.com/watson/developercloud/doc/discovery/using.html) for more details on the query language.", response = NoticeQueryResponse.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Queries", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Query for notices executed successfully.", response = NoticeQueryResponse.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = NoticeQueryResponse.class) })
    public Response queryNotices(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "A cacheable query that limits the documents returned to exclude any documents that don't mention the query content. Filter searches are better for metadata type searches and when you are trying to get a sense of concepts in the data set.") @QueryParam("filter") String filter,@ApiParam(value = "A query search returns all documents in your data set with full enrichments and full text, but with the most relevant documents listed first. Use a query search when you want to find the most relevant search results. You cannot use `natural_language_query` and `query` at the same time.") @QueryParam("query") String query,@ApiParam(value = "A natural language query that returns relevant documents by utilizing training data and natural language understanding. You cannot use `natural_language_query` and `query` at the same time.") @QueryParam("natural_language_query") String naturalLanguageQuery,@ApiParam(value = "A passages query that returns the most relevant passages from the document.") @QueryParam("passages") Boolean passages,@ApiParam(value = "An aggregation search uses combinations of filters and query search to return an exact answer. Aggregations are useful for building applications, because you can use them to build lists, tables, and time series. For a full list of possible aggregrations, see the Query reference.") @QueryParam("aggregation") String aggregation,@ApiParam(value = "Number of documents to return", defaultValue="10") @DefaultValue("10") @QueryParam("count") Integer count,@ApiParam(value = "A comma separated list of the portion of the document hierarchy to return.") @QueryParam("return") List<String> _return,@ApiParam(value = "The number of query results to skip at the beginning. For example, if the total number of results that are returned is 10, and the offset is 8, it returns the last two results.") @QueryParam("offset") Integer offset,@ApiParam(value = "A comma separated list of fields in the document to sort on. You can optionally specify a sort direction by prefixing the field with `-` for descending or `+` for ascending. Ascending is the default sort direction if no prefix is specified.") @QueryParam("sort") String sort,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.QueriesClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.QueriesClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		NoticeQueryResponse respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.queryNotices(environmentId,collectionId,version,filter,query,naturalLanguageQuery,passages,aggregation,count,_return,offset,sort);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#queryNotices");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#queryNotices");
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
    
    @Path("/environments/{environment_id}/preview")
    @Consumes({ "multipart/form-data" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Test configuration", notes = "Runs a sample document through the default or your configuration and returns diagnostic information designed to help you understand how the document was processed. The document is not added to the index.", response = TestDocument.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "TestConfigurationInEnvironment", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "The document was successfully processed.", response = TestDocument.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request if:   * The request is incorrectly formatted   * The `configuration_id` parameter refers to a non-existent configuration   * The default `configuration_id` of the collection refers to a non-existent configuration (and no override has been provided). The error message contains details about what caused the request to be rejected.", response = TestDocument.class) })
    public Response testConfigurationInEnvironment(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.")@FormDataParam("configuration")  String _configuration,@ApiParam(value = "Specify to only run the input document through the given step instead of running the input document through the entire ingestion workflow. Valid values are `convert`, `enrich`, and `normalize`.", allowableValues="html_input, html_output, json_output, json_normalizations_output, enrichments_output, normalizations_output"
) @QueryParam("step") String step,@ApiParam(value = "The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.") @QueryParam("configuration_id") String configurationId,
            @FormDataParam("file") File file
            ,@ApiParam(value = "If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   \"Creator\": \"Johnny Appleseed\",   \"Subject\": \"Apples\" } ```")@FormDataParam("metadata")  String metadata,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.TestConfigurationInEnvironmentClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.TestConfigurationInEnvironmentClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		TestDocument respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.testConfigurationInEnvironment(environmentId,version,_configuration,step,configurationId,file,metadata);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#testConfigurationInEnvironment");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#testConfigurationInEnvironment");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a collection", notes = "", response = Collection.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Collections", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 201, message = "Collection successfuly updated", response = Collection.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request if the collection body does not match the expected format or if the `configuration_id` references a configuration that does not exist. The error string will describe why the request was rejected.", response = Collection.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to update a collection in a read-only environment.", response = Collection.class) })
    public Response updateCollection(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Input a JSON object that allows you to update a collection." ) UpdateCollectionRequest body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.CollectionsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.CollectionsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Collection respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateCollection(environmentId,collectionId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateCollection");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateCollection");
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
    
    @Path("/environments/{environment_id}/configurations/{configuration_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a configuration", notes = "Replaces an existing configuration.   * Completely replaces the original configuration.   * The `configuration_id`, `updated`, and `created` fields are accepted in the request, but they are ignored, and an error is not generated. It is also acceptable for users to submit an updated configuration with none of the three properties.   * Documents are processed with a snapshot of the configuration as it was at the time the document was submitted to be ingested. This means that already submitted documents will not see any updates made to the configuration.", response = ModelConfiguration.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Configurations", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Configuration successfully updated", response = ModelConfiguration.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request", response = ModelConfiguration.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to update a read-only configuration or if you attempt to update a configuration in a read-only environment.", response = ModelConfiguration.class) })
    public Response updateConfiguration(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your configuration",required=true) @PathParam("configuration_id") String configurationId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "Input a JSON object that enables you to update and customize how your data is ingested and what enrichments are added to your data.  The `name` parameter is required and must be unique within the current `environment`. All other properties are optional, but if they are omitted  the default values replace the current value of each omitted property.  If the input configuration contains the `configuration_id`, `created`, or `updated` properties, they are ignored and overridden by the system, and an error is not returned so that the overridden fields do not need to be removed when updating a configuration.   The configuration can contain unrecognized JSON fields. Any such fields are ignored and do not generate an error. This makes it easier to use newer configuration files with older versions of the API and the service. It also makes it possible for the tooling to add additional metadata and information to the configuration." ,required=true) ModelConfiguration _configuration,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ConfigurationsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ModelConfiguration respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateConfiguration(environmentId,configurationId,version,_configuration);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateConfiguration");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateConfiguration");
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
    
    @Path("/environments/{environment_id}/collections/{collection_id}/documents/{document_id}")
    @Consumes({ "multipart/form-data" })
    
    @io.swagger.annotations.ApiOperation(value = "Update a document", notes = "Replace an existing document. Starts ingesting a document with optional metadata and optional configurations.", response = DocumentAccepted.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Documents", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 202, message = "The document has been accepted and it will be processed.", response = DocumentAccepted.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request if:   * the request is incorrectly formatted   * the configuration_id query parameter refers to a non-existant configuration.   * the default configuration_id of the collection refers to a non-existent configuration (and no override has been povided). The error message will contain details about what caused the request to be rejected.", response = DocumentAccepted.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to add or update a document in a collection in a read-only environment.", response = DocumentAccepted.class) })
    public Response updateDocument(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "the ID of your collection",required=true) @PathParam("collection_id") String collectionId,@ApiParam(value = "the ID of your document",required=true) @PathParam("document_id") String documentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "The ID of the configuration to use to process the document. If the `configuration` form part is also provided (both are present at the same time), then request will be rejected.") @QueryParam("configuration_id") String configurationId,
            @FormDataParam("file") File file
            ,@ApiParam(value = "If you're using the Data Crawler to upload your documents, you can test a document against the type of metadata that the Data Crawler might send. The maximum supported metadata file size is 1 MB. Metadata parts larger than 1 MB are rejected. Example:  ``` {   \"Creator\": \"Johnny Appleseed\",   \"Subject\": \"Apples\" } ```")@FormDataParam("metadata")  String metadata,@ApiParam(value = "The configuration to use to process the document. If this part is provided, then the provided configuration is used to process the document. If the `configuration_id` is also provided (both are present at the same time), then request is rejected. The maximum supported configuration size is 1 MB. Configuration parts larger than 1 MB are rejected. See the `GET /configurations/{configuration_id}` operation for an example configuration.")@FormDataParam("configuration")  String _configuration,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.DocumentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.DocumentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		DocumentAccepted respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateDocument(environmentId,collectionId,documentId,version,configurationId,file,metadata,_configuration);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateDocument");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateDocument");
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
    
    @Path("/environments/{environment_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update an environment", notes = "Updates an environment. The environment's `name` and  `description` parameters can be changed. You can increase the value of the `size` parameter. If you need to decrease an environment's size, contact IBM Support.", response = Environment.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Environments", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "Environment successfully updated", response = Environment.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request.", response = Environment.class),
    
    @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden. Returned if you attempt to update a read-only environment.", response = Environment.class) })
    public Response updateEnvironment(@ApiParam(value = "the ID of your environment",required=true) @PathParam("environment_id") String environmentId,@ApiParam(value = "a date (`YYYY-MM-DD`) that identifies the specific version of the API to use when processing the request",required=true, defaultValue="2016-12-01") @DefaultValue("2016-12-01") @QueryParam("version") String version,@ApiParam(value = "" ,required=true) UpdateEnvironmentRequest body,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.EnvironmentsClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		Environment respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.updateEnvironment(environmentId,version,body);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V1Api#updateEnvironment");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V1Api#updateEnvironment");
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
