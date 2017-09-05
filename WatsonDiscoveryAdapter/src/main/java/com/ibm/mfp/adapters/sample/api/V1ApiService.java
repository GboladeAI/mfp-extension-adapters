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

import com.ibm.mfp.adapters.sample.api.*;
import com.ibm.mfp.adapters.sample.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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

import java.util.List;
import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T17:22:26.527+05:30")
public abstract class V1ApiService {
    public abstract Response addDocument(String environmentId,String collectionId,String version,String configurationId,File file,String metadata,String _configuration,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createCollection(String environmentId,String version,CreateCollectionRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createConfiguration(String environmentId,String version,ModelConfiguration _configuration,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createEnvironment(String version,CreateEnvironmentRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCollection(String environmentId,String collectionId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteConfiguration(String environmentId,String configurationId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDocument(String environmentId,String collectionId,String documentId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteEnvironment(String environmentId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCollection(String environmentId,String collectionId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getConfiguration(String environmentId,String configurationId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getDocument(String environmentId,String collectionId,String documentId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getEnvironment(String environmentId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listCollectionFields(String environmentId,String collectionId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listCollections(String environmentId,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listConfigurations(String environmentId,String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listEnvironments(String version,String name,SecurityContext securityContext) throws NotFoundException;
    public abstract Response query(String environmentId,String collectionId,String version,String filter,String query,String naturalLanguageQuery,Boolean passages,String aggregation,Integer count,List<String> _return,Integer offset,String sort,SecurityContext securityContext) throws NotFoundException;
    public abstract Response queryNotices(String environmentId,String collectionId,String version,String filter,String query,String naturalLanguageQuery,Boolean passages,String aggregation,Integer count,List<String> _return,Integer offset,String sort,SecurityContext securityContext) throws NotFoundException;
    public abstract Response testConfigurationInEnvironment(String environmentId,String version,String _configuration,String step,String configurationId,File file,String metadata,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCollection(String environmentId,String collectionId,String version,UpdateCollectionRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateConfiguration(String environmentId,String configurationId,String version,ModelConfiguration _configuration,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDocument(String environmentId,String collectionId,String documentId,String version,String configurationId,File file,String metadata,String _configuration,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateEnvironment(String environmentId,String version,UpdateEnvironmentRequest body,SecurityContext securityContext) throws NotFoundException;
}
