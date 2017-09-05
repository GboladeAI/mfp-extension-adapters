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

import java.util.List;
import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T16:39:33.075+05:30")
public abstract class V1ApiService {
    public abstract Response createCounterexample(String workspaceId,String version,CreateCounterexample body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createDialogNode(String workspaceId,String version,CreateDialogNode body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createEntity(String workspaceId,String version,CreateEntity body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createExample(String workspaceId,String intent,String version,CreateExample body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createIntent(String workspaceId,String version,CreateIntent body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createSynonym(String workspaceId,String entity,String value,String version,CreateSynonym body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createValue(String workspaceId,String entity,String version,CreateValue body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createWorkspace(String version,CreateWorkspace body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteCounterexample(String workspaceId,String text,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDialogNode(String workspaceId,String dialogNode,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteEntity(String workspaceId,String entity,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteExample(String workspaceId,String intent,String text,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteIntent(String workspaceId,String intent,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteSynonym(String workspaceId,String entity,String value,String synonym,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteValue(String workspaceId,String entity,String value,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteWorkspace(String workspaceId,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getCounterexample(String workspaceId,String text,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getDialogNode(String workspaceId,String dialogNode,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getEntity(String workspaceId,String entity,String version,Boolean export,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getExample(String workspaceId,String intent,String text,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getIntent(String workspaceId,String intent,String version,Boolean export,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getSynonym(String workspaceId,String entity,String value,String synonym,String version,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getValue(String workspaceId,String entity,String value,String version,Boolean export,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getWorkspace(String workspaceId,String version,Boolean export,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listCounterexamples(String workspaceId,String version,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listDialogNodes(String workspaceId,String version,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listEntities(String workspaceId,String version,Boolean export,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listExamples(String workspaceId,String intent,String version,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listIntents(String workspaceId,String version,Boolean export,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listLogs(String workspaceId,String version,String sort,String filter,Integer pageLimit,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listSynonyms(String workspaceId,String entity,String value,String version,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listValues(String workspaceId,String entity,String version,Boolean export,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response listWorkspaces(String version,Integer pageLimit,Boolean includeCount,String sort,String cursor,SecurityContext securityContext) throws NotFoundException;
    public abstract Response message(String workspaceId,String version,MessageRequest body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateCounterexample(String workspaceId,String text,String version,UpdateCounterexample body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDialogNode(String workspaceId,String dialogNode,String version,UpdateDialogNode body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateEntity(String workspaceId,String entity,String version,UpdateEntity body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateExample(String workspaceId,String intent,String text,String version,UpdateExample body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateIntent(String workspaceId,String intent,String version,UpdateIntent body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateSynonym(String workspaceId,String entity,String value,String synonym,String version,UpdateSynonym body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateValue(String workspaceId,String entity,String value,String version,UpdateValue body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateWorkspace(String workspaceId,String version,UpdateWorkspace body,SecurityContext securityContext) throws NotFoundException;
}
