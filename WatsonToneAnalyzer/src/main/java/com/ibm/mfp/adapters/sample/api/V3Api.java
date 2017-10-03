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
import com.ibm.mfp.adapters.sample.api.V3ApiService;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;
import com.ibm.mfp.adapters.sample.StringUtil;
import com.ibm.mfp.adapters.sample.model.*;
import java.lang.*;

import com.ibm.mfp.adapters.sample.model.ErrorModel;
import com.ibm.mfp.adapters.sample.model.ToneAnalysis;
import com.ibm.mfp.adapters.sample.model.ToneChatInput;
import com.ibm.mfp.adapters.sample.model.ToneInput;
import com.ibm.mfp.adapters.sample.model.UtteranceAnalyses;

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

@Path("/v3")


@io.swagger.annotations.Api(description = "the v3 API")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-10-03T17:26:51.394+05:30")
public class V3Api  {
	@Context
        ConfigurationAPI configurationApi;

    @GET
    
    @Path("/tone")
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Analyze general purpose tone", notes = "Uses the general purpose endpoint to analyze the tone of your input content. The service can analyze the input for several tones: emotion, language, and social. It derives various characteristics for each tone that it analyzes. The method always analyzes the tone of the full document; by default, it also analyzes the tone of each individual sentence of the input. You can submit a maximum of 128 KB of content in plain text format.   Per the HTTP specification, the default encoding for plain text is ISO-8859-1 (effectively, the ASCII character set). Include the `charset` parameter to indicate the character encoding of the input text; for example: `Content-Type: text/plain;charset=utf-8`.   Use the `GET` request method to analyze smaller quantities of plain text content. Use the `POST` request method to analyze larger amounts of content in any of the available formats.", response = ToneAnalysis.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Tone", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "**OK**. The request succeeded.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "**Bad Request**. A required input parameter is null or a specified input parameter or header value is invalid or not supported.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "**Unauthorized**. Access is denied due to invalid service credentials.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "**Not Found**. A requested item or parameter does not exist.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 429, message = "**Too Many Requests**. Your organization ID submitted more than 1200 requests per minute, so the service is throttling your calls.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "**Internal Server Error**. The service encountered an internal error.", response = ToneAnalysis.class) })
    public Response getTone(@ApiParam(value = "Plain text input that contains the content to be analyzed. You must URL-encode the input. Submit a maximum of 128 KB of content. Sentences with fewer than three words cannot be analyzed.",required=true) @QueryParam("text") String text,@ApiParam(value = "The requested version of the response format as a date in the form `YYYY-MM-DD`; for example, specify `2016-05-19` for May 19, 2016. The parameter allows the service to update its interface and response format for new versions without breaking existing clients.   The date that you specify does not need to match a version of the service exactly; the service replies with the response format whose version is no later than the date you provide. If you specify a date that is earlier than the initial release of version 3, the service returns the response format for that version. If you specify a date that is in the future or otherwise later than the most recent version, the service returns the response format for the latest version.",required=true) @QueryParam("version") String version,@ApiParam(value = "A comma-separated list of tones for which the service is to return its analysis of the input; the indicated tones apply both to the full document and to individual sentences of the document. You can specify one or more of the following values: `emotion`, `language`, and `social`. Omit the parameter to request results for all three tones.", allowableValues="emotion, language, social"
) @QueryParam("tones") List<String> tones,@ApiParam(value = "Indicates whether the service is to return an analysis of each individual sentence in addition to its analysis of the full document. If `true` (the default), the service returns results for each sentence. The service returns results only for the first 100 sentences of the input.", defaultValue="true") @DefaultValue("true") @QueryParam("sentences") Boolean sentences,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ToneClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ToneClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ToneAnalysis respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.getTone(text,version,tones,sentences);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V3Api#getTone");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V3Api#getTone");
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
    
    @Path("/tone")
    @Consumes({ "application/json", "text/plain", "text/html" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Analyze general purpose tone", notes = "Uses the general purpose endpoint to analyze the tone of your input content. The service can analyze the input for several tones: emotion, language, and social. It derives various characteristics for each tone that it analyzes. The method always analyzes the tone of the full document; by default, it also analyzes the tone of each individual sentence of the input. You can submit a maximum of 128 KB of content in JSON, plain text, or HTML format.   Per the JSON specification, the default character encoding for JSON content is effectively always UTF-8; per the HTTP specification, the default encoding for plain text and HTML is ISO-8859-1 (effectively, the ASCII character set). When specifying a content type of plain text or HTML, include the `charset` parameter to indicate the character encoding of the input text; for example: `Content-Type: text/plain;charset=utf-8`. For `text/html`, the service removes HTML tags and analyzes only the textual content.   Use the `POST` request method to analyze larger amounts of content in any of the available formats. Use the `GET` request method to analyze smaller quantities of plain text content.", response = ToneAnalysis.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Tone", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "**OK**. The request succeeded.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "**Bad Request**. A required input parameter is null or a specified input parameter or header value is invalid or not supported.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "**Unauthorized**. Access is denied due to invalid service credentials.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "**Not Found**. A requested item or parameter does not exist.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 429, message = "**Too Many Requests**. Your organization ID submitted more than 1200 requests per minute, so the service is throttling your calls.", response = ToneAnalysis.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "**Internal Server Error**. The service encountered an internal error.", response = ToneAnalysis.class) })
    public Response tone(@ApiParam(value = "JSON, plain text, or HTML input that contains the content to be analyzed. For JSON input, provide an object of type `ToneInput`. Submit a maximum of 128 KB of content. Sentences with fewer than three words cannot be analyzed." ,required=true) ToneInput toneInput,@ApiParam(value = "The requested version of the response format as a date in the form `YYYY-MM-DD`; for example, specify `2016-05-19` for May 19, 2016. The parameter allows the service to update its interface and response format for new versions without breaking existing clients.   The date that you specify does not need to match a version of the service exactly; the service replies with the response format whose version is no later than the date you provide. If you specify a date that is earlier than the initial release of version 3, the service returns the response format for that version. If you specify a date that is in the future or otherwise later than the most recent version, the service returns the response format for the latest version.",required=true) @QueryParam("version") String version,@ApiParam(value = "A comma-separated list of tones for which the service is to return its analysis of the input; the indicated tones apply both to the full document and to individual sentences of the document. You can specify one or more of the following values: `emotion`, `language`, and `social`. Omit the parameter to request results for all three tones.", allowableValues="emotion, language, social"
) @QueryParam("tones") List<String> tones,@ApiParam(value = "Indicates whether the service is to return an analysis of each individual sentence in addition to its analysis of the full document. If `true` (the default), the service returns results for each sentence. The service returns results only for the first 100 sentences of the input.", defaultValue="true") @DefaultValue("true") @QueryParam("sentences") Boolean sentences,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ToneClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ToneClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		ToneAnalysis respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.tone(toneInput,version,tones,sentences);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V3Api#tone");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V3Api#tone");
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
    
    @Path("/tone_chat")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Analyze customer engagement tone", notes = "Uses the customer engagement endpoint to analyze the tone of customer service and customer support conversations. For each utterance of a conversation, the method reports the most prevalent subset of the following seven tones: sad, frustrated, satisfied, excited, polite, impolite, and sympathetic. You can submit a maximum of 128 KB of JSON input. Per the JSON specification, the default character encoding for JSON content is effectively always UTF-8.", response = UtteranceAnalyses.class
    ,authorizations = {
    @io.swagger.annotations.Authorization(value = "basicAuth")
    },tags={ "Tone", })
    @io.swagger.annotations.ApiResponses(value = { 
    @io.swagger.annotations.ApiResponse(code = 200, message = "**OK**. The request succeeded.", response = UtteranceAnalyses.class),
    
    @io.swagger.annotations.ApiResponse(code = 400, message = "**Bad Request**. A required input parameter is null or a specified input parameter or header value is invalid or not supported.", response = UtteranceAnalyses.class),
    
    @io.swagger.annotations.ApiResponse(code = 401, message = "**Unauthorized**. Access is denied due to invalid service credentials.", response = UtteranceAnalyses.class),
    
    @io.swagger.annotations.ApiResponse(code = 404, message = "**Not Found**. A requested item or parameter does not exist.", response = UtteranceAnalyses.class),
    
    @io.swagger.annotations.ApiResponse(code = 429, message = "**Too Many Requests**. Your organization ID submitted more than 1200 requests per minute, so the service is throttling your calls.", response = UtteranceAnalyses.class),
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "**Internal Server Error**. The service encountered an internal error.", response = UtteranceAnalyses.class) })
    public Response toneChat(@ApiParam(value = "A JSON object that contains the content to be analyzed." ,required=true) ToneChatInput utterances,@ApiParam(value = "The requested version of the response format as a date in the form `YYYY-MM-DD`; for example, specify `2016-05-19` for May 19, 2016. The parameter allows the service to update its interface and response format for new versions without breaking existing clients.   The date that you specify does not need to match a version of the service exactly; the service replies with the response format whose version is no later than the date you provide. If you specify a date that is earlier than the initial release of version 3, the service returns the response format for that version. If you specify a date that is in the future or otherwise later than the most recent version, the service returns the response format for the latest version.",required=true) @QueryParam("version") String version,@Context SecurityContext securityContext)
    throws NotFoundException {
        com.ibm.mfp.adapters.sample.ApiClient apiAuthInstance = new com.ibm.mfp.adapters.sample.ApiClient();
        
	OkHttpClient client =  apiAuthInstance.getHttpClient();
	client.setConnectionSpecs(Arrays.asList(new ConnectionSpec[]{new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).allEnabledCipherSuites().build()}));

        com.ibm.mfp.adapters.sample.api.ToneClientApi apiInstance = new com.ibm.mfp.adapters.sample.api.ToneClientApi(apiAuthInstance);
        String retval = "NA";
        
         	
        		UtteranceAnalyses respResult = null;
        	
         	
         		apiAuthInstance.setUsername(configurationApi.getPropertyValue("username"));
         		apiAuthInstance.setPassword(configurationApi.getPropertyValue("password"));
         	
         	
          try {
            	System.out.println("Calling Node server.");
            	respResult = 	apiInstance.toneChat(utterances,version);
           		System.out.println(respResult);
           }
           catch (com.ibm.mfp.adapters.sample.ApiException e) {
            	System.err.println("Exception when calling V3Api#toneChat");
            	e.printStackTrace();
            	return Response.status(e.getCode()).entity(e.getResponseBody()).build();
           }  
           catch (java.lang.Exception e) {
            	System.err.println("Exception when calling V3Api#toneChat");
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
