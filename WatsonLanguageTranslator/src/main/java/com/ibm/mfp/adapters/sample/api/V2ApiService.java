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

import com.ibm.mfp.adapters.sample.model.DeleteModelResult;
import com.ibm.mfp.adapters.sample.model.ErrorResponse;
import java.io.File;
import com.ibm.mfp.adapters.sample.model.IdentifiableLanguages;
import com.ibm.mfp.adapters.sample.model.IdentifiedLanguages;
import com.ibm.mfp.adapters.sample.model.TranslateRequest;
import com.ibm.mfp.adapters.sample.model.TranslationModel;
import com.ibm.mfp.adapters.sample.model.TranslationModels;
import com.ibm.mfp.adapters.sample.model.TranslationResult;

import java.util.List;
import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-10-03T18:29:51.729+05:30")
public abstract class V2ApiService {
    public abstract Response createModel(String baseModelId,String name,File forcedGlossary,File parallelCorpus,File monolingualCorpus,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteModel(String modelId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getModel(String modelId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response identify(String text,String accept,SecurityContext securityContext) throws NotFoundException;
    public abstract Response identifyGet(String text,String accept,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listIdentifiableLanguages(SecurityContext securityContext) throws NotFoundException;
    public abstract Response listModels(String source,String target,Boolean _default,SecurityContext securityContext) throws NotFoundException;
    public abstract Response translate(TranslateRequest body,String accept,SecurityContext securityContext) throws NotFoundException;
    public abstract Response translateGet(String text,String modelId,String source,String target,String accept,SecurityContext securityContext) throws NotFoundException;
}
