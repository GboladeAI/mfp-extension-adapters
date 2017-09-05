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

import java.util.List;
import com.ibm.mfp.adapters.sample.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-05T11:47:26.811+05:30")
public abstract class NamespacesApiService {
    public abstract Response deleteAction(String namespace,String actionName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePackage(String namespace,String packageName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteRule(String namespace,String ruleName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteTrigger(String namespace,String triggerName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response fireTrigger(String namespace,String triggerName,KeyValue payload,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getActionByName(String namespace,String actionName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getActivationById(String namespace,String activationid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getActivations(String namespace,String name,Integer limit,Integer skip,Integer since,Integer upto,Boolean docs,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAlPackages(String namespace,Boolean _public,Integer limit,Integer skip,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllActions(String namespace,Integer limit,Integer skip,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllEntitiesInNamespace(String namespace,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllNamespaces(SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllRules(String namespace,Integer limit,Integer skip,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getAllTriggers(String namespace,Integer limit,Integer skip,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPackageByName(String namespace,String packageName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getRuleByName(String namespace,String ruleName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getTriggerByName(String namespace,String triggerName,SecurityContext securityContext) throws NotFoundException;
    public abstract Response invokeAction(String namespace,String actionName,PayLoad payload,String blocking,Integer timeout,SecurityContext securityContext) throws NotFoundException;
    public abstract Response namespacesNamespaceActivationsActivationidLogsGet(String namespace,String activationid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response namespacesNamespaceActivationsActivationidResultGet(String namespace,String activationid,SecurityContext securityContext) throws NotFoundException;
    public abstract Response setState(String namespace,String ruleName,RuleSet state,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateAction(String namespace,String actionName,ActionPut action,String overwrite,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePackage(String namespace,String packageName,PackagePut _package,String overwrite,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateRule(String namespace,String ruleName,RulePut rule,String overwrite,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateTrigger(String namespace,String triggerName,TriggerPut trigger,String overwrite,SecurityContext securityContext) throws NotFoundException;
}
