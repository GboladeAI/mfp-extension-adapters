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


/*
 * OpenWhisk REST API
 * API for OpenWhisk
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.ibm.mfp.adapters.sample.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.ibm.mfp.adapters.sample.model.ActionExec;
import com.ibm.mfp.adapters.sample.model.ActionLimits;
import com.ibm.mfp.adapters.sample.model.KeyValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

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


/**
 * A restricted Action view that elides properties that are auto-assigned or derived from the URI (i.e., the namespace and name).
 */
@ApiModel(description = "A restricted Action view that elides properties that are auto-assigned or derived from the URI (i.e., the namespace and name).")
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-05T11:47:26.811+05:30")
public class ActionPut   {
  @JsonProperty("version")
  private String version = null;

  @JsonProperty("publish")
  private Boolean publish = null;

  @JsonProperty("exec")
  private ActionExec exec = null;

  @JsonProperty("annotations")
  private List<KeyValue> annotations = null;

  @JsonProperty("parameters")
  private List<KeyValue> parameters = null;

  @JsonProperty("limits")
  private ActionLimits limits = null;

  public ActionPut version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Semantic version of the item
   * @return version
  **/
  @JsonProperty("version")
  @ApiModelProperty(value = "Semantic version of the item")
 @Size(min=1)  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public ActionPut publish(Boolean publish) {
    this.publish = publish;
    return this;
  }

   /**
   * Whether to publish the item or not
   * @return publish
  **/
  @JsonProperty("publish")
  @ApiModelProperty(value = "Whether to publish the item or not")
  public Boolean getPublish() {
    return publish;
  }

  public void setPublish(Boolean publish) {
    this.publish = publish;
  }

  public ActionPut exec(ActionExec exec) {
    this.exec = exec;
    return this;
  }

   /**
   * Get exec
   * @return exec
  **/
  @JsonProperty("exec")
  @ApiModelProperty(value = "")
  public ActionExec getExec() {
    return exec;
  }

  public void setExec(ActionExec exec) {
    this.exec = exec;
  }

  public ActionPut annotations(List<KeyValue> annotations) {
    this.annotations = annotations;
    return this;
  }

  public ActionPut addAnnotationsItem(KeyValue annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<KeyValue>();
    }
    this.annotations.add(annotationsItem);
    return this;
  }

   /**
   * annotations on the item
   * @return annotations
  **/
  @JsonProperty("annotations")
  @ApiModelProperty(value = "annotations on the item")
  public List<KeyValue> getAnnotations() {
    return annotations;
  }

  public void setAnnotations(List<KeyValue> annotations) {
    this.annotations = annotations;
  }

  public ActionPut parameters(List<KeyValue> parameters) {
    this.parameters = parameters;
    return this;
  }

  public ActionPut addParametersItem(KeyValue parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<KeyValue>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

   /**
   * parameter bindings included in the context passed to the action
   * @return parameters
  **/
  @JsonProperty("parameters")
  @ApiModelProperty(value = "parameter bindings included in the context passed to the action")
  public List<KeyValue> getParameters() {
    return parameters;
  }

  public void setParameters(List<KeyValue> parameters) {
    this.parameters = parameters;
  }

  public ActionPut limits(ActionLimits limits) {
    this.limits = limits;
    return this;
  }

   /**
   * Get limits
   * @return limits
  **/
  @JsonProperty("limits")
  @ApiModelProperty(value = "")
  public ActionLimits getLimits() {
    return limits;
  }

  public void setLimits(ActionLimits limits) {
    this.limits = limits;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionPut actionPut = (ActionPut) o;
    return Objects.equals(this.version, actionPut.version) &&
        Objects.equals(this.publish, actionPut.publish) &&
        Objects.equals(this.exec, actionPut.exec) &&
        Objects.equals(this.annotations, actionPut.annotations) &&
        Objects.equals(this.parameters, actionPut.parameters) &&
        Objects.equals(this.limits, actionPut.limits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(version, publish, exec, annotations, parameters, limits);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionPut {\n");
    
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    publish: ").append(toIndentedString(publish)).append("\n");
    sb.append("    exec: ").append(toIndentedString(exec)).append("\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    limits: ").append(toIndentedString(limits)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

