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
 * Discovery
 * The IBM Watson&trade; Discovery Service is a cognitive search and content analytics engine that you can add to applications to identify patterns, trends and actionable insights to drive better decision-making. Securely unify structured and unstructured data with pre-enriched content, and use a simplified query language to eliminate the need for manual filtering of results. 
 *
 * OpenAPI spec version: 1.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * UpdateCollectionRequest
 */
@javax.annotation.Generated(value = "com.github.mfpdev.adapters.swagger.codegen.MfpAdapterCodegen", date = "2017-09-04T17:22:26.527+05:30")
public class UpdateCollectionRequest   {
  @JsonProperty("name")
  private String name = "";

  @JsonProperty("description")
  private String description = "";

  @JsonProperty("configuration_id")
  private String configurationId = "";

  public UpdateCollectionRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the collection
   * @return name
  **/
  @JsonProperty("name")
  @ApiModelProperty(required = true, value = "The name of the collection")
  @NotNull
 @Size(min=0,max=255)  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UpdateCollectionRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A description of the collection
   * @return description
  **/
  @JsonProperty("description")
  @ApiModelProperty(value = "A description of the collection")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UpdateCollectionRequest configurationId(String configurationId) {
    this.configurationId = configurationId;
    return this;
  }

   /**
   * The ID of the configuration in which the collection is to be updated
   * @return configurationId
  **/
  @JsonProperty("configuration_id")
  @ApiModelProperty(value = "The ID of the configuration in which the collection is to be updated")
  public String getConfigurationId() {
    return configurationId;
  }

  public void setConfigurationId(String configurationId) {
    this.configurationId = configurationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCollectionRequest updateCollectionRequest = (UpdateCollectionRequest) o;
    return Objects.equals(this.name, updateCollectionRequest.name) &&
        Objects.equals(this.description, updateCollectionRequest.description) &&
        Objects.equals(this.configurationId, updateCollectionRequest.configurationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, configurationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateCollectionRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    configurationId: ").append(toIndentedString(configurationId)).append("\n");
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

