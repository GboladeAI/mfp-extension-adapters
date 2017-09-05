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

import com.ibm.mfp.adapters.sample.model.AnalysisResults;
import com.ibm.mfp.adapters.sample.model.ErrorResponse;
import com.ibm.mfp.adapters.sample.model.InlineResponse200;
import com.ibm.mfp.adapters.sample.model.ListModelsResults;
import com.ibm.mfp.adapters.sample.model.Parameters;

import java.util.List;
import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T17:58:15.838+05:30")
public abstract class V1ApiService {
    public abstract Response analyze(String version,Parameters parameters,SecurityContext securityContext) throws NotFoundException;
    public abstract Response analyzeGet(String version,List<String> features,String text,String html,String url,Boolean returnAnalyzedText,Boolean clean,String xpath,Boolean fallbackToRaw,String language,Integer conceptsLimit,Boolean emotionDocument,List<String> emotionTargets,Integer entitiesLimit,String entitiesModel,Boolean entitiesEmotion,Boolean entitiesSentiment,Integer keywordsLimit,Boolean keywordsEmotion,Boolean keywordsSentiment,String relationsModel,Integer semanticRolesLimit,Boolean semanticRolesEntities,Boolean semanticRolesKeywords,Boolean sentimentDocument,List<String> sentimentTargets,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteModel(String version,String modelId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getModels(String version,SecurityContext securityContext) throws NotFoundException;
}
