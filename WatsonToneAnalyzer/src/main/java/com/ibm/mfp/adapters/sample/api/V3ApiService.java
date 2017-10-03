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

import com.ibm.mfp.adapters.sample.model.ErrorModel;
import com.ibm.mfp.adapters.sample.model.ToneAnalysis;
import com.ibm.mfp.adapters.sample.model.ToneChatInput;
import com.ibm.mfp.adapters.sample.model.ToneInput;
import com.ibm.mfp.adapters.sample.model.UtteranceAnalyses;

import java.util.List;
import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-10-03T17:26:51.394+05:30")
public abstract class V3ApiService {
    public abstract Response getTone(String text,String version,List<String> tones,Boolean sentences,SecurityContext securityContext) throws NotFoundException;
    public abstract Response tone(ToneInput toneInput,String version,List<String> tones,Boolean sentences,SecurityContext securityContext) throws NotFoundException;
    public abstract Response toneChat(ToneChatInput utterances,String version,SecurityContext securityContext) throws NotFoundException;
}
